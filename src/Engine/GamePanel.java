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
import SkillTrees.DairySkillTree;
import SkillTrees.FruitSkillTree;
import SkillTrees.GrainSkillTree;
import SkillTrees.ProteinSkillTree;
import SkillTrees.SkillTreeNode;
import SkillTrees.VeggieSkillTree;
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

	private SpriteFont treeSelecterV;
	private SpriteFont treeSelecterP;
	private SpriteFont treeSelecterG;
	private SpriteFont treeSelecterF;
	private SpriteFont treeSelecterD;

	private DairySkillTree dairy = new DairySkillTree();
	private GrainSkillTree grain = new GrainSkillTree();
	private VeggieSkillTree veggie = new VeggieSkillTree();
	private FruitSkillTree fruit = new FruitSkillTree();
	private ProteinSkillTree protein = new ProteinSkillTree();
	SkillTreeNode dairySelection = dairy.getCurrentNode();
	SkillTreeNode fruitSelection = fruit.getCurrentNode();
	SkillTreeNode grainSelection = grain.getCurrentNode();
	SkillTreeNode veggieSelection = veggie.getCurrentNode();
	SkillTreeNode proteinSelection = protein.getCurrentNode();


	//Creates arrays to store the sprites for the empty heart and full heart, can be modified by replacing # of sprites in setup
	private Sprite[] fullHearts = {new Sprite(ImageLoader.load("HeartFull.png"), 30, 9),
		new Sprite(ImageLoader.load("HeartFull.png"), 59, 9),
		new Sprite(ImageLoader.load("HeartFull.png"), 88, 9),
		new Sprite(ImageLoader.load("HeartFull.png"), 117, 9),
	 	new Sprite(ImageLoader.load("HeartFull.png"), 146, 9),
};
	//Initializes array of emptyheart sprites, can be modified by replacing # of sprites in setup
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

		treeSelecterV = new SpriteFont("Vegetable Tree", 100,100,"Comic Sans", 25, Color. WHITE);
		treeSelecterP = new SpriteFont("Protein Tree", 200,200,"Comic Sans", 25, Color. WHITE);
		treeSelecterG = new SpriteFont("Grain Tree", 300,300,"Comic Sans", 25, Color. WHITE);
		treeSelecterF = new SpriteFont("Fruit Tree",400,400,"Comic Sans", 25, Color. WHITE);
		treeSelecterD = new SpriteFont("Dairy Tree", 500,500,"Comic Sans", 25, Color. WHITE);

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
		//checks the health each frame and updates it accordingly when health changes
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
			displaySkillTree();
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

	int currentTree = 0;
	int timer = 0;
	boolean select = false;

	private void displaySkillTree(){
		if(select){
			switch(currentTree){
				case 0 : displayVeggieTree();
				break;
				case 1 : displayProteinTree();
				break;
				case 2 : displayGrainTree();
				break;
				case 3 : displayFruitTree();
				break;
				case 4 : displayDairyTree();
			}
		}
		else{
			treeSelecterV.draw(graphicsHandler);
			treeSelecterP.draw(graphicsHandler);
			treeSelecterG.draw(graphicsHandler);
			treeSelecterF.draw(graphicsHandler);
			treeSelecterD.draw(graphicsHandler);
			
			switch(currentTree){
				case 0 : treeSelecterV.setColor(Color.RED);
						treeSelecterP.setColor(Color.WHITE);
						treeSelecterG.setColor(Color.WHITE);
						treeSelecterF.setColor(Color.WHITE);
						treeSelecterD.setColor(Color.WHITE);
					break;
				case 1 : treeSelecterP.setColor(Color.RED);
						treeSelecterV.setColor(Color.WHITE);
						treeSelecterG.setColor(Color.WHITE);
						treeSelecterF.setColor(Color.WHITE);
						treeSelecterD.setColor(Color.WHITE);
					break;
				case 2 : treeSelecterG.setColor(Color.RED);
						treeSelecterV.setColor(Color.WHITE);
						treeSelecterP.setColor(Color.WHITE);
						treeSelecterF.setColor(Color.WHITE);
						treeSelecterD.setColor(Color.WHITE);
					break;
				case 3 : treeSelecterF.setColor(Color.RED);
						treeSelecterV.setColor(Color.WHITE);
						treeSelecterP.setColor(Color.WHITE);
						treeSelecterG.setColor(Color.WHITE);
						treeSelecterD.setColor(Color.WHITE);
					break;
				case 4 : treeSelecterD.setColor(Color.RED);
						treeSelecterV.setColor(Color.WHITE);
						treeSelecterP.setColor(Color.WHITE);
						treeSelecterG.setColor(Color.WHITE);
						treeSelecterF.setColor(Color.WHITE);
					break;
			}
			if(skillTreeActivated && Keyboard.isKeyDown(Key.DOWN) && timer > 10){
				currentTree++;
				if(currentTree > 4){
					currentTree = 0;
				}
				timer = 0;
			}
			else if(skillTreeActivated && Keyboard.isKeyDown(Key.UP) && timer > 10){
				currentTree--;
				if(currentTree < 0){
					currentTree = 4;
				}
				timer = 0;
			}
			timer++;

			if(skillTreeActivated && Keyboard.isKeyDown(Key.ENTER) && timer > 10){
				select = true;
			}
		}
		
	}
	int veggieTimer = 0;
	private void displayVeggieTree() {
		if(Keyboard.isKeyDown(Key.ESC)){
			select = false;
		}
		treeSelecterV.draw(graphicsHandler);
	}
	int proteinTimer = 0;
	private void displayProteinTree(){
		treeSelecterP.draw(graphicsHandler);
		if(Keyboard.isKeyDown(Key.ESC)){
			select = false;
		}
	}
	int grainTimer = 0;
	private void displayGrainTree(){
		try{
			int xLoc = 50;
			int count = 0;
			int yLoc = 50;
			for(SkillTreeNode skill : grain.array){
				if(skill.getId() == grainSelection.getId()){
					graphicsHandler.drawFilledRectangleWithBorder(xLoc, yLoc, 50, 50, Color.RED, Color.YELLOW, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(xLoc, yLoc, 50, 50, Color.RED, Color.BLACK, 2);
				}
				xLoc+= 200;
				count++;
				if(count > 3){
					count = 0;
					yLoc += 200;
					xLoc = 50;
				}
			}
			grainTimer++;
				if(Keyboard.isKeyDown(Key.RIGHT) && grainTimer > 20){
					grainTimer = 0;
					grainSelection = grainSelection.getRightSkill();
				}
				else if(Keyboard.isKeyDown(Key.LEFT) && grainTimer > 20){
					grainTimer = 0;
					grainSelection = grainSelection.getParent();
				}
			}
		catch(NullPointerException e){
			System.out.println("Can't Go Any Further!!!");
			grain.resetCurrentNode();
			grainSelection = grain.getCurrentNode();
		}
		if(Keyboard.isKeyDown(Key.ESC)){
			select = false;
		}
	}
	int fruitTimer = 0;
	private void displayFruitTree(){
		treeSelecterF.draw(graphicsHandler);
		if(Keyboard.isKeyDown(Key.ESC)){
			select = false;
		}
	}
	int dairyTimer = 0;
	private void displayDairyTree(){
		try{
			int xLoc = 50;
			int count = 0;
			int yLoc = 50;
			for(SkillTreeNode skill : dairy.array1){
				if(skill.getId() == dairySelection.getId()){
					graphicsHandler.drawFilledRectangleWithBorder(xLoc, yLoc, 50, 50, Color.RED, Color.YELLOW, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(xLoc, yLoc, 50, 50, Color.RED, Color.BLACK, 2);
				}
				xLoc += 200;
				count++;
				if(count > 3){
					count = 0; 
					yLoc+= 200;
					xLoc = 50;
				}
			}
			dairyTimer++;
			if(Keyboard.isKeyDown(Key.RIGHT) && dairyTimer > 20){
				dairyTimer = 0;
				dairySelection = dairySelection.getRightSkill();
			}
			else if(Keyboard.isKeyDown(Key.LEFT) && dairyTimer > 20){
				dairyTimer = 0;
				dairySelection = dairySelection.getParent();
			}
		}
		catch(NullPointerException e){
			System.out.println("Can't Go Any Further!!!");
			dairy.resetCurrentNode();
			dairySelection = dairy.getCurrentNode();
		}
		if(Keyboard.isKeyDown(Key.ESC)){
			select = false;
		}
	}
}
