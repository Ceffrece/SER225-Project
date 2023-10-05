package Engine;
import Engine.ImageLoader;
import GameObject.Rectangle;
import GameObject.Sprite;
import SpriteFont.SpriteFont;
import Utils.Colors;

import javax.swing.*;

import Builders.FrameBuilder;

import java.awt.*;
import Level.Player;
import Players.Cat;

import Screens.MenuScreen;
/*
 * This is where the game loop process and render back buffer is setup
 */
public class GamePanel extends JPanel {
	// loads Screens on to the JPanel
	// each screen has its own update and draw methods defined to handle a "section" of the game.
	private ScreenManager screenManager;

	// used to draw graphics to the panel
	private GraphicsHandler graphicsHandler;

	private boolean isGamePaused = false;
	private SpriteFont pauseLabel;
	private KeyLocker keyLocker = new KeyLocker();
	private final Key pauseKey = Key.P;
	private Thread gameLoopProcess;
	private SpriteFont healthBar;
	private Key showFPSKey = Key.G;
	private SpriteFont fpsDisplayLabel;
	private boolean showFPS = false;
	private int currentFPS;

	//Creates arrays to store the sprites for the empty heart and full heart
	private Sprite[] fullHearts = {new Sprite(ImageLoader.load("HeartFull.png"), 30, 9),
		new Sprite(ImageLoader.load("HeartFull.png"), 59, 9),
		new Sprite(ImageLoader.load("HeartFull.png"), 88, 9),
		new Sprite(ImageLoader.load("HeartFull.png"), 117, 9),
	 	new Sprite(ImageLoader.load("HeartFull.png"), 146, 9),
};
	private Sprite[] emptyHearts = {new Sprite(ImageLoader.load("HeartEmpty.png"), 30, 9),
		new Sprite(ImageLoader.load("HeartEmpty.png"), 59, 9),
		new Sprite(ImageLoader.load("HeartEmpty.png"), 88, 9),
		new Sprite(ImageLoader.load("HeartEmpty.png"), 117, 9),
	 	new Sprite(ImageLoader.load("HeartEmpty.png"), 146, 9),
};
	private boolean gameStart;
	private final Key skillTreeKey = Key.T;
	private boolean skillTreeActivated = false;
	// The JPanel and various important class instances are setup here
	public GamePanel() {
		super();
		this.setDoubleBuffered(true);
		for(int i = 0; i <= fullHearts.length-1; i++){
			fullHearts[i].setScale(3);
		}
		for(int i = 0; i <= emptyHearts.length-1; i++){
			emptyHearts[i].setScale(3);
		}
		// attaches Keyboard class's keyListener to this JPanel
		this.addKeyListener(Keyboard.getKeyListener());

		graphicsHandler = new GraphicsHandler();

		screenManager = new ScreenManager();

		pauseLabel = new SpriteFont("PAUSE", 365, 280, "Comic Sans", 24, Color.white);
		pauseLabel.setOutlineColor(Color.black);
		pauseLabel.setOutlineThickness(2.0f);

		fpsDisplayLabel = new SpriteFont("FPS", 4, 3, "Comic Sans", 12, Color.black);

		//Initializes healthbar, doesn't draw it
		healthBar = new SpriteFont("Health: " + Player.playerHealth, 20, 20, "COMIC SANS", 30, Color.red);
		healthBar.setOutlineColor(Color.black);
		healthBar.setOutlineThickness(2.0f);
		

		currentFPS = Config.TARGET_FPS;

		// this game loop code will run in a separate thread from the rest of the program
		// will continually update the game's logic and repaint the game's graphics
		GameLoop gameLoop = new GameLoop(this);
		gameLoopProcess = new Thread(gameLoop.getGameLoopProcess());
	}

	// this is called later after instantiation, and will initialize screenManager
	// this had to be done outside of the constructor because it needed to know the JPanel's width and height, which aren't available in the constructor
	public void setupGame() {
		setBackground(Colors.CORNFLOWER_BLUE);
		screenManager.initialize(new Rectangle(getX(), getY(), getWidth(), getHeight()));
	}

	// this starts the timer (the game loop is started here
	public void startGame() {
		gameLoopProcess.start();
	}

	public ScreenManager getScreenManager() {
		return screenManager;
	}

	public void setCurrentFPS(int currentFPS) {
		this.currentFPS = currentFPS;
	}

	public void update() {
		updatePauseState();
		updateShowFPSState();
		updateSkillTreeState();

		if(isGamePaused || skillTreeActivated){

		}
		else{
			screenManager.update();
		}
		/*if (!isGamePaused) {
			screenManager.update();
		}
		if(!skillTreeActivated){
			screenManager.update();
		}*/
	}

	private void updatePauseState() {
		if (Keyboard.isKeyDown(pauseKey) && !keyLocker.isKeyLocked(pauseKey)) {
			isGamePaused = !isGamePaused;
			keyLocker.lockKey(pauseKey);
		}

		if (Keyboard.isKeyUp(pauseKey)) {
			keyLocker.unlockKey(pauseKey);
		}
	}

	private void updateSkillTreeState() {
		if (Keyboard.isKeyDown(skillTreeKey) && !keyLocker.isKeyLocked(skillTreeKey)) {
			skillTreeActivated = !skillTreeActivated;
			keyLocker.lockKey(skillTreeKey);
		}

		if (Keyboard.isKeyUp(skillTreeKey)) {
			keyLocker.unlockKey(skillTreeKey);
		}
	}

	private void updateShowFPSState() {
		if (Keyboard.isKeyDown(showFPSKey) && !keyLocker.isKeyLocked(showFPSKey)) {
			showFPS = !showFPS;
			keyLocker.lockKey(showFPSKey);
		}

		if (Keyboard.isKeyUp(showFPSKey)) {
			keyLocker.unlockKey(showFPSKey);
		}

		fpsDisplayLabel.setText("FPS: " + currentFPS);
	}

	public void draw() {
		screenManager.draw(graphicsHandler);
		
		//draws the healthbar and updates it accordingly after the game start button is clicked
		if(MenuScreen.getGameStarted()){
		for(int i = 0; i <= Player.playerHealth-1; i++){
			fullHearts[i].draw(graphicsHandler);
		}
		for(int i = Player.playerHealth; i < 5 ; i++){
			emptyHearts[i].draw(graphicsHandler);
		}
		}
		// if game is paused, draw pause gfx over Screen gfx
		if (isGamePaused) {
			pauseLabel.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 100));
		}

		if(skillTreeActivated){
			pauseLabel.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(100,100,100,255));
		}

		if (showFPS) {
			fpsDisplayLabel.draw(graphicsHandler);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// every repaint call will schedule this method to be called
		// when called, it will setup the graphics handler and then call this class's draw method
		graphicsHandler.setGraphics((Graphics2D) g);
		draw();
	}
}
