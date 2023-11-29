package Engine;
import Game.Game;
import Game.GameState;
import GameObject.Rectangle;
import GameObject.Sprite;
import SpriteFont.SpriteFont;
import Utils.Colors;

import javax.swing.*;

import Builders.FrameBuilder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

import Level.Currency;
import Level.Map;
import Level.Player;
import Level.Enemy;
import Maps.Floor1.Floor1Boss;
import Maps.Floor2.Floor2Boss;
import Maps.Floor3.Floor3Boss;
import Players.Cat;

import Screens.MenuScreen;
import Screens.PlayLevelScreen;
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
	private boolean isInventoryActivated = false;

	private SpriteFont readyToFire;

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

	private SpriteFont currentProjectile;
	private SpriteFont currentItems;
	private SpriteFont playerStats;

	private SpriteFont drawPlayerStat;
	private SpriteFont drawPlayerStatString;
	private SpriteFont expBar;



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

	//Pictures for the Skill Tree
	//Background
	BufferedImage skilltreeImg = ImageLoader.load("SkillTreePics/background.jpg");
	//Dairy
	BufferedImage diQing = ImageLoader.load("SkillTreePics/diqing.png");
	BufferedImage mars = ImageLoader.load("SkillTreePics/mars.png");
	BufferedImage laran = ImageLoader.load("SkillTreePics/laran.png");
	BufferedImage tyr = ImageLoader.load("SkillTreePics/tyr.png");
	BufferedImage bia = ImageLoader.load("SkillTreePics/bia.png");
	BufferedImage satis = ImageLoader.load("SkillTreePics/satis.png");
	BufferedImage chiyou = ImageLoader.load("SkillTreePics/chiyou1.png");
	BufferedImage perseus = ImageLoader.load("SkillTreePics/perseus.png");
	//Fruit
	BufferedImage orange = ImageLoader.load("SkillTreePics/orange.jpg");
	BufferedImage horn = ImageLoader.load("SkillTreePics/horn.jpg");
	BufferedImage basket = ImageLoader.load("SkillTreePics/basket.jpg");
	BufferedImage momotaro = ImageLoader.load("SkillTreePics/momotaro.png");
	BufferedImage maui = ImageLoader.load("SkillTreePics/maui.png");
	BufferedImage ulu = ImageLoader.load("SkillTreePics/ulu.png");
	BufferedImage pomegranate = ImageLoader.load("SkillTreePics/pomegranate.png");
	BufferedImage idun = ImageLoader.load("SkillTreePics/idun.jpg");
	//Grain
	BufferedImage flour = ImageLoader.load("SkillTreePics/flour.jpg");
	BufferedImage ceres = ImageLoader.load("SkillTreePics/ceres.png");
	BufferedImage radegast = ImageLoader.load("SkillTreePics/radegast.png");
	BufferedImage freyr = ImageLoader.load("SkillTreePics/freyr.png");
	BufferedImage demeter = ImageLoader.load("SkillTreePics/demeter.png");
	BufferedImage gaea = ImageLoader.load("SkillTreePics/gaea.png");
	//Protein
	BufferedImage pantheon = ImageLoader.load("SkillTreePics/pantheon.png");
	BufferedImage ares = ImageLoader.load("SkillTreePics/ares.png");
	BufferedImage bellona = ImageLoader.load("SkillTreePics/bellona.png");
	BufferedImage set = ImageLoader.load("SkillTreePics/freyr.png");
	BufferedImage sobek = ImageLoader.load("SkillTreePics/sobek.png");
	BufferedImage bast = ImageLoader.load("SkillTreePics/bast.png");
	BufferedImage odin = ImageLoader.load("SkillTreePics/odin.png");
	BufferedImage thor = ImageLoader.load("SkillTreePics/thor.png");
	//Veggie
	BufferedImage victoria = ImageLoader.load("SkillTreePics/victoria.png");
	BufferedImage caolo = ImageLoader.load("SkillTreePics/caolo.png");
	BufferedImage lijing = ImageLoader.load("SkillTreePics/lijing.png");
	BufferedImage phobos = ImageLoader.load("SkillTreePics/phobos.png");
	BufferedImage bulub = ImageLoader.load("SkillTreePics/bulub.png");
	BufferedImage gloves = ImageLoader.load("SkillTreePics/gloves.png");
	BufferedImage makhai = ImageLoader.load("SkillTreePics/makhai.png");
	BufferedImage zeus = ImageLoader.load("SkillTreePics/zeus.png");
	BufferedImage pallas = ImageLoader.load("SkillTreePics/pallas.png");
	BufferedImage ambrosia = ImageLoader.load("SkillTreePics/ambrosia.jpg");

	//Creates arrays to store the sprites for the empty heart and full heart, can be modified by replacing # of sprites in setup
	private Sprite[] fullHearts = {new Sprite(ImageLoader.load("GUISprites/HeartFull.png"), 30, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartFull.png"), 59, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartFull.png"), 88, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartFull.png"), 117, 9),
	 	new Sprite(ImageLoader.load("GUISprites/HeartFull.png"), 146, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartFull.png"), 175, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartFull.png"), 204, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartFull.png"), 233, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartFull.png"), 262, 9),
};
	//Initializes array of emptyheart sprites, can be modified by replacing # of sprites in setup
	private Sprite[] emptyHearts = {new Sprite(ImageLoader.load("GUISprites/HeartEmpty.png"), 30, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartEmpty.png"), 59, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartEmpty.png"), 88, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartEmpty.png"), 117, 9),
	 	new Sprite(ImageLoader.load("GUISprites/HeartEmpty.png"), 146, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartEmpty.png"), 175, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartEmpty.png"), 204, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartEmpty.png"), 233, 9),
		new Sprite(ImageLoader.load("GUISprites/HeartEmpty.png"), 262, 9),
};
	private boolean gameStart;
	private final Key skillTreeKey = Key.T;
	private boolean skillTreeActivated = false;
	private final Key inventoryKey = Key.I;

	private final Key ultSwitchKey = Key.M;
	private boolean ultActivated = false;
	private SpriteFont ultText1; 
	private SpriteFont ultText2; 
	private SpriteFont ultText3; 
	private SpriteFont ultText4; 
	private SpriteFont ultText5; 

	
	//Dev tools
	private final Key levelKey = Key.K;
	private final Key unlockKey = Key.U;

	// The JPanel and various important class instances are setup here
	public GamePanel() {
		super();
		this.setDoubleBuffered(true);

		//sets the scales for the hearts
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

		pauseLabel = new SpriteFont("PAUSE", 365, 280, "Chalkduster", 24, Color.white);
		pauseLabel.setOutlineColor(Color.black);
		pauseLabel.setOutlineThickness(2.0f);
		
		readyToFire = new SpriteFont("Ready To Fire", 700,455,"Chalkduster", 8, Color. RED);

		treeSelecterV = new SpriteFont("Vegetable Tree", 100,100,"Comic Sans", 25, Color. WHITE);
		treeSelecterP = new SpriteFont("Protein Tree", 200,200,"Comic Sans", 25, Color. WHITE);
		treeSelecterG = new SpriteFont("Grain Tree", 300,300,"Comic Sans", 25, Color. WHITE);
		treeSelecterF = new SpriteFont("Fruit Tree",400,400,"Comic Sans", 25, Color. WHITE);
		treeSelecterD = new SpriteFont("Dairy Tree", 500,500,"Comic Sans", 25, Color. WHITE);

		currentProjectile = new SpriteFont("Current Projectiles", 50,50,"Sans Serif", 50, Color. WHITE);
		currentItems = new SpriteFont("Current Items", 50,150,"Sans Serif", 50, Color. WHITE);
		playerStats = new SpriteFont("Current Player Stats", 50,250,"Sans Serif", 50, Color. WHITE);

		ultText1 = new SpriteFont(FruitSkillTree.ultimateFruitSkill.getName(), 100, 50, "Sans Serif", 50, Color.BLACK);
		ultText2 = new SpriteFont(GrainSkillTree.ultimateGrainSkill.getName(), 100, 150, "Sans Serif", 50, Color.BLACK);
		ultText3 = new SpriteFont(VeggieSkillTree.ultimateVeggieSkill.getName(), 100, 250, "Sans Serif", 50, Color.BLACK);
		ultText4 = new SpriteFont(ProteinSkillTree.ultimateProteinSkill.getName(), 100, 350, "Sans Serif", 50, Color.BLACK);
		ultText5 = new SpriteFont(DairySkillTree.ultimateDairySkill.getName(),100, 450, "Sans Serif", 50, Color.BLACK);


		fpsDisplayLabel = new SpriteFont("FPS", 4, 3, "Comic Sans", 12, Color.black);

		//Initializes healthbar, doesn't draw it
		healthBar = new SpriteFont("Health: " + Player.playerHealth, 20, 20, "COMIC SANS", 30, Color.red);
		healthBar.setOutlineColor(Color.black);
		healthBar.setOutlineThickness(2.0f);
		
		expBar = new SpriteFont("Skill Points: " + Player.playerXPLevel, 20, 40, "Comic Sans", 30, Colors.CORNFLOWER_BLUE);
		expBar.setOutlineColor(Color.black);
		expBar.setOutlineThickness(3);
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

	
	int levelCount = 0;
	public void update() {
		
		updatePauseState();
		updateShowFPSState();
		updateSkillTreeState();
		updateInventoryState();
		updateUltSwitchState();

		//Dev Tools
		if(Keyboard.isKeyDown(levelKey)){
			Player.playerXPLevel += 10;
		}
		if(Keyboard.isKeyDown(unlockKey)){
			fruit.unlockAll();
			grain.unlockAll();
			protein.unlockAll();
			veggie.unlockAll();
			dairy.unlockAll();
			Player.playerUltimates.add(FruitSkillTree.ultimateFruitSkill);
			Player.playerUltimates.add(GrainSkillTree.ultimateGrainSkill);
			Player.playerUltimates.add(ProteinSkillTree.ultimateProteinSkill);
			Player.playerUltimates.add(VeggieSkillTree.ultimateVeggieSkill);
			Player.playerUltimates.add(DairySkillTree.ultimateDairySkill);
		}

		//Pause logic
		if(isGamePaused || skillTreeActivated|| isInventoryActivated || ultActivated){

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
	private void updateInventoryState() {
		if (Keyboard.isKeyDown(inventoryKey) && !keyLocker.isKeyLocked(inventoryKey)) {
			isInventoryActivated = !isInventoryActivated;
			keyLocker.lockKey(inventoryKey);
		}

		if (Keyboard.isKeyUp(inventoryKey)) {
			keyLocker.unlockKey(inventoryKey);
		}
	}

	int escTimer = 0;
	private void updateSkillTreeState() {
		if(!select){
			escTimer++;
		}
		else{
			escTimer = 0;
		}
		if (Keyboard.isKeyDown(skillTreeKey) && !keyLocker.isKeyLocked(skillTreeKey)) {
			skillTreeActivated = !skillTreeActivated;
			keyLocker.lockKey(skillTreeKey);
			Game.gameMusic.pause();
			Game.bossMusic1.pause();
			Game.skillTreeBackground.play();
		}
		if(skillTreeActivated && Keyboard.isKeyDown(Key.ESC) && escTimer > 20){
			skillTreeActivated = !skillTreeActivated;
			keyLocker.lockKey(skillTreeKey);
			Game.gameMusic.play();
			Game.skillTreeBackground.pause();
		}
		if(!skillTreeActivated && MenuScreen.getGameStarted() && !PlayLevelScreen.inBossFight1){ 
			Game.gameMusic.play();
			Game.skillTreeBackground.pause();
			Game.bossMusic1.pause();
		}
		if(!skillTreeActivated && MenuScreen.getGameStarted() && PlayLevelScreen.inBossFight1){
			Game.bossMusic1.play();
			Game.skillTreeBackground.pause();
			Game.gameMusic.pause();
		}


		if (Keyboard.isKeyUp(skillTreeKey)) {
			keyLocker.unlockKey(skillTreeKey);
		}
	}
	private void updateUltSwitchState() {
		if(Keyboard.isKeyDown(ultSwitchKey) && !keyLocker.isKeyLocked(ultSwitchKey)) {
			ultActivated = !ultActivated;
			keyLocker.lockKey(ultSwitchKey);
		}
		if(Keyboard.isKeyUp(ultSwitchKey)) {
			keyLocker.unlockKey(ultSwitchKey);
		}
		if(ultActivated && Keyboard.isKeyDown(Key.ESC)){
			ultActivated = !ultActivated;
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
	private int reload;

	public void draw() {
		screenManager.draw(graphicsHandler);
		
		//draws the healthbar and updates it accordingly after the game start button is clicked
		if(MenuScreen.getGameStarted()){
		//checks the health each frame and updates it accordingly when health changes
		for(int i = 0; i <= Player.playerHealth-1; i++){
			fullHearts[i].draw(graphicsHandler);
		}
		for(int i = Player.playerHealth; i < Player.getMaxHealth() ; i++){
			emptyHearts[i].draw(graphicsHandler);
		}
		//Draws experience bar
		expBar.draw(graphicsHandler);
		Enemy.getEnemyText().draw(graphicsHandler);
		expBar.setText("Skill Points: " + Player.playerXPLevel);
		//Draws Ult Bar
		graphicsHandler.drawFilledRectangle(10, 150, 100, 20, Color.GRAY);
		graphicsHandler.drawFilledRectangle(10, 150, (int) ((Player.ultMeter/1000.0)*100), 20, Color.BLUE);
		//shows player projectile
		graphicsHandler.drawImage(ImageLoader.load("GUISprites/itemBox.png"), 700, 475,75,75);
		if(!Player.playerCurrentProjectiles.isEmpty()){
			graphicsHandler.drawImage(ImageLoader.load(Player.playerCurrentProjectiles.get(Player.projectileInHand).getCurentProjectilePNG()), 700, 475,75,75);
			graphicsHandler.drawFilledRectangle(700, 455,(Player.playerCurrentProjectiles.get(Player.projectileInHand).shootTime)/2,10, new Color(50, 50, 50, 255));
		}
		//shows coins
		graphicsHandler.drawImage(ImageLoader.load("GUISprites/Coin.png"), 700, 0,75,75);
		String curencyString = Currency.normalCurrency + "";
		SpriteFont curencyStringLable = new SpriteFont(curencyString, 600, -10, "Chalkduster", 70, Color.white);
		curencyStringLable.setOutlineColor(Color.white);
		curencyStringLable.setOutlineThickness(2.0f);
		curencyStringLable.draw(graphicsHandler);

		
		reload = Player.cooldown;

		
		graphicsHandler.drawFilledRectangle(700, 455,reload/2,10, new Color(50, 255, 50, 255));

		if(Player.readyToFire){
			

			readyToFire.draw(graphicsHandler);

		}

		if(PlayLevelScreen.inBossFight1){
			showBossHealth1();
		}
		if(PlayLevelScreen.inBossFight2){
			showBossHealth2();
		}
		if(PlayLevelScreen.inBossFight3){
			showBossHealth3();
		}
		
		}

		// if game is paused, draw pause gfx over Screen gfx
		if (isGamePaused) {
			pauseLabel.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 100));
		}

		if (isInventoryActivated) {
			graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 100));
			displayInventory();
		}

		if(skillTreeActivated){
			pauseLabel.draw(graphicsHandler);
			//graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(100,100,100,255));
			graphicsHandler.drawImage(skilltreeImg, 0,0, ScreenManager.getScreenWidth(),ScreenManager.getScreenHeight());
			displaySkillTree();
		}

		if(ultActivated){
			displayUltSelector();
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

	int currentInventortOption = 0;
	boolean inventorySelect = false;
	int inventoryTimer = 0;


	private void displayInventory(){

		if(inventorySelect){
			switch(currentInventortOption){
				case 0 : displayCurrentProjectiles();
				break;
				case 1 : displayCurrentItems();
				break;
				case 2 : displayCurrentPlayerStats();
				break;
			}
		}
		else{
			currentProjectile.draw(graphicsHandler);
			currentItems.draw(graphicsHandler);
			playerStats.draw(graphicsHandler);

			switch(currentInventortOption){
				case 0 : currentProjectile.setColor(Color.RED);
						playerStats.setColor(Color.WHITE);
						currentItems.setColor(Color.WHITE);
						treeSelecterF.setColor(Color.WHITE);
						treeSelecterD.setColor(Color.WHITE);
					break;
				case 1 : currentItems.setColor(Color.RED);
						currentProjectile.setColor(Color.WHITE);
						playerStats.setColor(Color.WHITE);
						treeSelecterF.setColor(Color.WHITE);
						treeSelecterD.setColor(Color.WHITE);
					break;
				case 2 : playerStats.setColor(Color.RED);
						currentProjectile.setColor(Color.WHITE);
						currentItems.setColor(Color.WHITE);
						treeSelecterF.setColor(Color.WHITE);
						treeSelecterD.setColor(Color.WHITE);
					break;
			}
			if(isInventoryActivated && Keyboard.isKeyDown(Key.S) && inventoryTimer > 10){
				currentInventortOption++;
				if(currentInventortOption > 2){
					currentInventortOption = 0;
				}
				inventoryTimer = 0;

			}
			else if(isInventoryActivated && Keyboard.isKeyDown(Key.W) && inventoryTimer > 10){
				currentInventortOption--;
				if(currentInventortOption < 0){
					currentInventortOption = 2;
				}
				inventoryTimer = 0;

			}
			if(isInventoryActivated && Keyboard.isKeyDown(Key.SPACE) && inventoryTimer > 10){
				inventorySelect = true;
			}

			inventoryTimer++;

		}

	}
	private void displayCurrentProjectiles() {
		if(Keyboard.isKeyDown(Key.I)){
			inventorySelect = false;
		}
		int inventoryX = 100;
		int inventoryY = 50;
		int projectileIndex = 0;

		
		ArrayList<Integer> projectileLoactionX = new ArrayList<Integer>();
		ArrayList<Integer> projectileLoactionY = new ArrayList<Integer>();

		ArrayList<String> projectileDescription = new ArrayList<String>();
                for (int i = 0; i < Player.playerCurrentProjectiles.size(); i++) {
			graphicsHandler.drawImage(ImageLoader.load(Player.playerCurrentProjectiles.get(i).getCurentProjectilePNG()), inventoryX, inventoryY, 100, 100);
			projectileIndex ++;

			// projectileLoactionX.add(inventoryX);
			// projectileLoactionX.add(inventoryY);
			// projectileDescription.add(Player.playerCurrentProjectiles.get(i).getProjectileDescription());

			inventoryX+=100; 
		}



	}

	private void displayCurrentItems() {
		if(Keyboard.isKeyDown(Key.I)){
			inventorySelect = false;
		}
		int inventoryX = 100;
		int inventoryY = 50;
		int itemsIndex = 0;

		
		ArrayList<Integer> itemLoactionX = new ArrayList<Integer>();
		ArrayList<Integer> itemLoactionY = new ArrayList<Integer>();

		ArrayList<String> projectileDescription = new ArrayList<String>();

                for (int i = 0; i < Player.itemArray.size(); i++) {
			graphicsHandler.drawImage(ImageLoader.load(Player.itemArray.get(i).getCurentItemPNG()), inventoryX, inventoryY, 100, 100);
			itemsIndex ++;
			
			inventoryX+=100; 
		}



	}
	
	public static ArrayList<String> playerStatsStrings = new ArrayList<>();

	private void displayCurrentPlayerStats() {
		if(Keyboard.isKeyDown(Key.I)){
			inventorySelect = false;
		}
		Player.playerStats.clear();
		Player.playerStats.add(Player.getWalkSpeed().intValue());
		Player.playerStats.add(Player.getAttackSpeed());
		Player.playerStats.add(Player.getAttackDamage());
		Player.playerStats.add(Player.getAttackRange());
		Player.playerStats.add(Player.getDash());
		Player.playerStats.add(Player.getMaxHealth());
		Player.playerStats.add(Player.getPlayerArmor());
		
		playerStatsStrings.clear();
		playerStatsStrings.add("Walk Speed");
		playerStatsStrings.add("Attack Speed");
		playerStatsStrings.add("Attack Damage");
		playerStatsStrings.add("Attack Range");
		playerStatsStrings.add("Dash Amount");
		playerStatsStrings.add("Max Health");
		playerStatsStrings.add("Armor Amount");

		int inventoryX = 200;
		int inventoryY = 0;
		int inventoryStringX = 0;
		int inventoryStringY = 0;


                for (int i = 0; i < Player.playerStats.size(); i++) {
			drawPlayerStat = new SpriteFont((Player.playerStats.get(i).toString()), inventoryX, inventoryY,"Comic Sans", 25, Color. WHITE);
			drawPlayerStatString = new SpriteFont((playerStatsStrings.get(i).toString()+ ":"), inventoryStringX, inventoryStringY,"Comic Sans", 25, Color. WHITE);

			drawPlayerStat.draw(graphicsHandler);
			drawPlayerStatString.draw(graphicsHandler);

			inventoryY+=50; 

			inventoryStringY+=50; 




		}

	}

	int currentTree = 0;
	int timer = 0;
	static boolean select = false;

	public static boolean getSelectStatus() {
		return select == true;
	}

	int ultTimer = 0;
	int ultSelector = 0;
	private void displayUltSelector(){
		ultTimer++;
		graphicsHandler.drawImage(skilltreeImg, 0,0,ScreenManager.getScreenWidth(),ScreenManager.getScreenHeight());
		if(Player.playerUltimates.contains(FruitSkillTree.ultimateFruitSkill)){
			if(ultSelector == 0){
				ultText1.setColor(Color.YELLOW);
			}
			else{
				ultText1.setColor(Color.BLACK);
			}
			ultText1.draw(graphicsHandler);
		}
		if(Player.playerUltimates.contains(GrainSkillTree.ultimateGrainSkill)){
			if(ultSelector == 1){
				ultText2.setColor(Color.YELLOW);
			}
			else{
				ultText2.setColor(Color.BLACK);
			}
			ultText2.draw(graphicsHandler);
		}
		if(Player.playerUltimates.contains(ProteinSkillTree.ultimateProteinSkill)){
			if(ultSelector == 3){
				ultText4.setColor(Color.YELLOW);
			}
			else{
				ultText4.setColor(Color.BLACK);
			}
			ultText4.draw(graphicsHandler);
		}
		if(Player.playerUltimates.contains(VeggieSkillTree.ultimateVeggieSkill)){
			if(ultSelector == 2){
				ultText3.setColor(Color.YELLOW);
			}
			else{
				ultText3.setColor(Color.BLACK);
			}
			ultText3.draw(graphicsHandler);
		}
		if(Player.playerUltimates.contains(DairySkillTree.ultimateDairySkill)){
			if(ultSelector == 4){
				ultText5.setColor(Color.YELLOW);
			}
			else{
				ultText5.setColor(Color.BLACK);
			}
			ultText5.draw(graphicsHandler);
		}
		if(ultTimer > 20 && Keyboard.isKeyDown(Key.S)){
			ultSelector++;
			if(ultSelector > 4){
				ultSelector = 0;
			}
			ultTimer = 0;
		}
		else if(ultTimer > 20 && Keyboard.isKeyDown(Key.W)){
			ultSelector--;
			if(ultSelector < 0){
				ultSelector = 4;
			}
			ultTimer = 0;
		}
		else if(ultTimer > 20 && Keyboard.isKeyDown(Key.SPACE)){
			if(ultSelector == 0 && Player.playerUltimates.contains(FruitSkillTree.ultimateFruitSkill)){
				Player.currentUltimate = FruitSkillTree.ultimateFruitSkill;
			}
			else if(ultSelector == 1 && Player.playerUltimates.contains(GrainSkillTree.ultimateGrainSkill)){
				Player.currentUltimate = GrainSkillTree.ultimateGrainSkill;
			}
			else if(ultSelector == 2 && Player.playerUltimates.contains(VeggieSkillTree.ultimateVeggieSkill)){
				Player.currentUltimate = VeggieSkillTree.ultimateVeggieSkill;
			}
			else if(ultSelector == 3 && Player.playerUltimates.contains(ProteinSkillTree.ultimateProteinSkill)){
				Player.currentUltimate = ProteinSkillTree.ultimateProteinSkill;
			}
			else if(ultSelector == 4 && Player.playerUltimates.contains(DairySkillTree.ultimateDairySkill)){
				Player.currentUltimate = DairySkillTree.ultimateDairySkill;
			}
			System.out.println(Player.currentUltimate.getName());
		}
	}
	
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
			graphicsHandler.drawImage(skilltreeImg, 0,0, ScreenManager.getScreenWidth(),ScreenManager.getScreenHeight());
			graphicsHandler.drawFilledRectangleWithBorder( 90,90, 190, 50, Color.GRAY, Color.BLACK, 2);
			graphicsHandler.drawFilledRectangleWithBorder( 190,190, 170, 50, Color.GRAY, Color.BLACK, 2);
			graphicsHandler.drawFilledRectangleWithBorder( 290,290, 150, 50, Color.GRAY, Color.BLACK, 2);
			graphicsHandler.drawFilledRectangleWithBorder( 390,390, 150, 50, Color.GRAY, Color.BLACK, 2);
			graphicsHandler.drawFilledRectangleWithBorder( 490,490, 150, 50, Color.GRAY, Color.BLACK, 2);


			treeSelecterV.draw(graphicsHandler);
			treeSelecterP.draw(graphicsHandler);
			treeSelecterG.draw(graphicsHandler);
			treeSelecterF.draw(graphicsHandler);
			treeSelecterD.draw(graphicsHandler);
			
			switch(currentTree){
				case 0 : treeSelecterV.setColor(Color.YELLOW);
						treeSelecterP.setColor(Color.WHITE);
						treeSelecterG.setColor(Color.WHITE);
						treeSelecterF.setColor(Color.WHITE);
						treeSelecterD.setColor(Color.WHITE);
					break;
				case 1 : treeSelecterP.setColor(Color.YELLOW);
						treeSelecterV.setColor(Color.WHITE);
						treeSelecterG.setColor(Color.WHITE);
						treeSelecterF.setColor(Color.WHITE);
						treeSelecterD.setColor(Color.WHITE);
					break;
				case 2 : treeSelecterG.setColor(Color.YELLOW);
						treeSelecterV.setColor(Color.WHITE);
						treeSelecterP.setColor(Color.WHITE);
						treeSelecterF.setColor(Color.WHITE);
						treeSelecterD.setColor(Color.WHITE);
					break;
				case 3 : treeSelecterF.setColor(Color.YELLOW);
						treeSelecterV.setColor(Color.WHITE);
						treeSelecterP.setColor(Color.WHITE);
						treeSelecterG.setColor(Color.WHITE);
						treeSelecterD.setColor(Color.WHITE);
					break;
				case 4 : treeSelecterD.setColor(Color.YELLOW);
						treeSelecterV.setColor(Color.WHITE);
						treeSelecterP.setColor(Color.WHITE);
						treeSelecterG.setColor(Color.WHITE);
						treeSelecterF.setColor(Color.WHITE);
					break;
			}
			if(skillTreeActivated && Keyboard.isKeyDown(Key.S) && timer > 10){
				currentTree++;
				if(currentTree > 4){
					currentTree = 0;
				}
				timer = 0;
			}
			else if(skillTreeActivated && Keyboard.isKeyDown(Key.W) && timer > 10){
				currentTree--;
				if(currentTree < 0){
					currentTree = 4;
				}
				timer = 0;
			}
			timer++;

			if(skillTreeActivated && Keyboard.isKeyDown(Key.SPACE) && timer > 10){
				select = true;
			}
		}
		
	}
	int veggieTimer = 0;
	private void displayVeggieTree() {
		try{
			//Center Skill
			if(veggieSelection.getId() == 6){
				graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, 50, 50, 50, Color.RED, Color.YELLOW, 2);
			}
			else{
				if(veggie.array[0].getUnlockedStatus()){
					graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, 50, 50, 50, Color.RED, Color.GREEN, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, 50, 50, 50, Color.RED, Color.BLACK, 2);
				}
			}
			//Left Branch
			int lXloc = 50;
			int lYloc = 100;
			for(int i = 1; i < 6; i++){
				if(veggie.array[i].getId() == veggieSelection.getId()){
					graphicsHandler.drawFilledRectangleWithBorder(lXloc, lYloc, 50, 50, Color.RED, Color.YELLOW, 2);
				}
				else if(veggie.array[i].getUnlockedStatus()){
					graphicsHandler.drawFilledRectangleWithBorder(lXloc, lYloc, 50, 50, Color.RED, Color.GREEN, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(lXloc, lYloc, 50, 50, Color.RED, Color.BLACK, 2);
				}
				lYloc += 100;
			}
			//Drawing Lines
			int lxloc1 = 50;
			int lyloc1 = 100;
			for(int i = 1; i < 6; i++){
				if(i == 1){
					if(veggie.array[i].getUnlockedStatus()){
						graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 - 35, 325, 10, Color.GREEN);
						graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 - 35, 10, 35, Color.GREEN);
					}
					else{
						graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 - 35, 325, 10, Color.BLACK);
						graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 - 35, 10, 35, Color.BLACK);
					}
				}
				else{
					if(veggie.array[i].getUnlockedStatus()){
						graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 + 50, 10, 50, Color.GREEN);
					}
					else{
						graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 + 50, 10, 50, Color.BLACK);
					}
					lyloc1 += 100;
				}
			}
			//Right Branch
			int rXloc = screenManager.getScreenWidth()-100;
			int rYloc = 100;
			for(int i = 6; i < 9; i++){
				if(veggie.array[i].getId() == veggieSelection.getId()){
					graphicsHandler.drawFilledRectangleWithBorder(rXloc, rYloc, 50, 50, Color.RED, Color.YELLOW, 2);
				}
				else if(veggie.array[i].getUnlockedStatus()){
					graphicsHandler.drawFilledRectangleWithBorder(rXloc, rYloc, 50, 50, Color.RED, Color.GREEN, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(rXloc, rYloc, 50, 50, Color.RED, Color.BLACK, 2);
				}
				rYloc += 100;
			}
			//Drawing Lines
			int rxloc1 = screenManager.getScreenWidth()-100;
			int ryloc1 = 100;
			for(int i = 6; i < 9; i++){
				if(i == 6){
					if(veggie.array[i].getUnlockedStatus()){
						graphicsHandler.drawFilledRectangle(442, ryloc1 - 35, 275, 10, Color.GREEN);
						graphicsHandler.drawFilledRectangle(rxloc1 + 20, ryloc1 - 25, 10, 25, Color.GREEN);
					}
					else{
						graphicsHandler.drawFilledRectangle(442, ryloc1 - 35, 275, 10, Color.BLACK);
						graphicsHandler.drawFilledRectangle(rxloc1 + 20, ryloc1 - 25, 10, 25, Color.BLACK);
					}	
				}
				else{
					if(veggie.array[i].getUnlockedStatus()){
						graphicsHandler.drawFilledRectangle(rxloc1 + 20, ryloc1 + 50, 10, 50, Color.GREEN);
					}
					else{
						graphicsHandler.drawFilledRectangle(rxloc1 + 20, ryloc1 + 50, 10, 50, Color.BLACK);
					}
					ryloc1 += 100;
				}
			}
			//Ultimate Skill
			if(veggieSelection.getId() == 10){
				graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, screenManager.getScreenHeight()-75, 50, 50, Color.RED, Color.YELLOW, 2);
			}
			else if(veggie.array[9].getUnlockedStatus()){
				graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, screenManager.getScreenHeight()-75, 50, 50, Color.RED, Color.GREEN, 2);
			}
			else{
				graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, screenManager.getScreenHeight()-75, 50, 50, Color.RED, Color.BLACK, 2);
			}
			//Drawing Lines
			if(veggie.array[9].getUnlockedStatus()){
				//Left
				graphicsHandler.drawFilledRectangle(100, screenManager.getScreenHeight()-50, 295, 10, Color.GREEN);
				//Right
				graphicsHandler.drawFilledRectangle(rxloc1 + 20, ryloc1 + 50, 10, 180, Color.GREEN);
				graphicsHandler.drawFilledRectangle(440, screenManager.getScreenHeight()-50, 275, 10, Color.GREEN);
			}
			else{
				//Left
				graphicsHandler.drawFilledRectangle(100, screenManager.getScreenHeight()-50, 295, 10, Color.BLACK);
				//Right
				graphicsHandler.drawFilledRectangle(rxloc1 + 20, ryloc1 + 50, 10, 180, Color.BLACK);
				graphicsHandler.drawFilledRectangle(440, screenManager.getScreenHeight()-50, 275, 10, Color.BLACK);
			}
			//Navigation
			//Center to branch
			veggieTimer++;
			if(veggieSelection.getId() == 6){
				if(Keyboard.isKeyDown(Key.A) && veggieTimer > 20){
					veggieSelection = veggieSelection.getLeftSkill();
					veggieTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.D) && veggieTimer > 20){
					veggieSelection = veggieSelection.getRightSkill();
					veggieTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.SPACE) && veggieTimer > 20){
					veggie.unlockNode(veggieSelection);
					veggieTimer = 0;
				}
			}
			//Left branch
			if(veggieSelection.getId() < 6){
				if(veggieSelection.getId() == 5 && veggieTimer > 20 && Keyboard.isKeyDown(Key.D)){
					veggieSelection = veggieSelection.getParent();
					veggieTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.S) && veggieTimer > 20){
					veggieSelection = veggieSelection.getLeftSkill();
					veggieTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.W) && veggieTimer > 20){
					veggieSelection = veggieSelection.getParent();
					veggieTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.SPACE) && veggieTimer > 20){
					veggie.unlockNode(veggieSelection);
					veggieTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.D) && veggieTimer > 20 && veggieSelection.getId() == 1){
					veggie.goToUltimate();
					veggieSelection = veggie.getCurrentNode();
					veggieTimer = 0;
				}
			}
			//Right Branch
			if(veggieSelection.getId() > 6 && veggieSelection.getId() < 10){
				if(veggieSelection.getId() == 7 && veggieTimer > 20 && Keyboard.isKeyDown(Key.A)){
					veggieSelection = veggieSelection.getParent();
					veggieTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.S) && veggieTimer > 20){
					veggieSelection = veggieSelection.getRightSkill();
					veggieTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.W) && veggieTimer > 20){
					veggieSelection = veggieSelection.getParent();
					veggieTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.SPACE) && veggieTimer > 20){
					veggie.unlockNode(veggieSelection);
					veggieTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.A) && veggieTimer > 20 && veggieSelection.getId() == 9){
					veggie.goToUltimate();
					veggieSelection = veggie.getCurrentNode();
					veggieTimer = 0;
				}
			}
			//Ultimate Navigation
			if(veggieSelection.getId() == 10){
				if(Keyboard.isKeyDown(Key.A) && veggieTimer > 20){
					veggieSelection = veggie.array[5];
					veggieTimer = 0;
				}
				else if(veggieTimer > 20 && Keyboard.isKeyDown(Key.D)){
					veggieSelection = veggie.array[8];
					veggieTimer = 0;
				}
				else if(veggieTimer > 20 && Keyboard.isKeyDown(Key.SPACE)){
					veggie.unlockNode(veggieSelection);
					veggieTimer = 0;
				}
			}
			//Drawing box that displays the information
			graphicsHandler.drawFilledRectangle(150, 125, 500, 300, Color.BLACK);
			SpriteFont title = new SpriteFont(veggieSelection.getName(), 160, 130, getFont(), Color.WHITE);
			title.setFontSize(25);
			title.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(150, 165, 500, 1, Color.WHITE);
			SpriteFont effect = new SpriteFont("Effect: ", 160, 175, getFont(), Color.WHITE);
			effect.setFontSize(25);
			effect.draw(graphicsHandler);
			SpriteFont descrip1 = new SpriteFont(veggieSelection.getEffect(), 160, 210, getFont(), Color.WHITE);
			descrip1.setFontSize(20);
			descrip1.draw(graphicsHandler);

			//Picture Selector
			switch(veggieSelection.getId()){
				case 1 :
					graphicsHandler.drawImage(gloves, 400, 200,200,200);
					break;
				case 2 :
					graphicsHandler.drawImage(bulub, 400, 200,200,200);
					break;
				case 3 :
					graphicsHandler.drawImage(phobos, 400, 200, 200, 200);
					break;
				case 4 :
					graphicsHandler.drawImage(lijing, 400, 200, 200, 200);
					break;
				case 5 :
					graphicsHandler.drawImage(caolo, 400, 200, 200, 200);
					break;
				case 6 :
					graphicsHandler.drawImage(victoria, 400, 200, 200, 200);
					break;
				case 7 :
					graphicsHandler.drawImage(makhai, 400, 200, 200, 200);
					break;
				case 8 :
					graphicsHandler.drawImage(zeus, 400, 200, 200, 200);
					break;
				case 9 :
					graphicsHandler.drawImage(pallas, 400, 200, 200, 200);
					break;
				case 10 :
					graphicsHandler.drawImage(ambrosia, 400, 200, 200, 200);
					break;
			}
		}
		catch(NullPointerException e){
			System.out.println("Cannot Go Any Further!!!");
			veggie.resetCurrentNode();
			veggieSelection = veggie.getCurrentNode();
		}
		if(Keyboard.isKeyDown(Key.ESC)){
			select = false;
		}
	}
	int proteinTimer = 0;
	private void displayProteinTree(){  //CHANGE TO PROTEIN
		try{
			//Center Skill
			if(proteinSelection.getId() == 4){
				graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, 50, 50, 50, Color.RED, Color.YELLOW, 2);
			}
			else{
				if(protein.array[0].getUnlockedStatus()){
					graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, 50, 50, 50, Color.RED, Color.GREEN, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, 50, 50, 50, Color.RED, Color.BLACK, 2);
				}
			}
			//Left Branch
			int lXloc = 50;
			int lYloc = 100;
			for(int i = 1; i < 4; i++){
				if(protein.array[i].getId() == proteinSelection.getId()){
					graphicsHandler.drawFilledRectangleWithBorder(lXloc, lYloc, 50, 50, Color.RED, Color.YELLOW, 2);
				}
				else if(protein.array[i].getUnlockedStatus()){
					graphicsHandler.drawFilledRectangleWithBorder(lXloc, lYloc, 50, 50, Color.RED, Color.GREEN, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(lXloc, lYloc, 50, 50, Color.RED, Color.BLACK, 2);
				}
				lYloc += 100;
			}
			//Drawing Lines
			int lxloc1 = 50;
			int lyloc1 = 100;
			for(int i = 1; i < 4; i++){
				if(i == 1){
					if(protein.array[i].getUnlockedStatus()){
						graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1- 30, 325, 10, Color.GREEN);
						graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 - 30, 10, 30, Color.GREEN);
					}
					else{
						graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 - 30, 325, 10, Color.BLACK);
						graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 - 30, 10, 30, Color.BLACK);
					}
				}
				else{
					if(protein.array[i].getUnlockedStatus()){
						graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 + 50, 10, 50, Color.GREEN);
					}
					else{
						graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 + 50, 10, 50, Color.BLACK);
					}
					lyloc1 += 100;
				}
			}
			//Right Branch
			int rXloc = screenManager.getScreenWidth()-100;
			int rYloc = 100;
			for(int i = 4; i < 7; i++){
				if(protein.array[i].getId() == proteinSelection.getId()){
					graphicsHandler.drawFilledRectangleWithBorder(rXloc, rYloc, 50, 50, Color.RED, Color.YELLOW, 2);
				}
				else if(protein.array[i].getUnlockedStatus()){
					graphicsHandler.drawFilledRectangleWithBorder(rXloc, rYloc, 50, 50, Color.RED, Color.GREEN, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(rXloc, rYloc, 50, 50, Color.RED, Color.BLACK, 2);
				}
				rYloc += 100;
			}
			//Drawing Lines
			int rxloc1 = screenManager.getScreenWidth()-100;
			int ryloc1 = 100;
			for(int i = 4; i < 7; i++){
				if(i == 4){
					if(protein.array[i].getUnlockedStatus()){
						graphicsHandler.drawFilledRectangle(445, 70, 270, 10, Color.GREEN);
						graphicsHandler.drawFilledRectangle(rxloc1 + 20, ryloc1 - 30, 10, 30, Color.GREEN);
					}
					else{
						graphicsHandler.drawFilledRectangle(445, 70, 270, 10, Color.BLACK);
						graphicsHandler.drawFilledRectangle(rxloc1 + 20, ryloc1 - 30, 10, 30, Color.BLACK);
					}
				}
				else{
					if(protein.array[i].getUnlockedStatus()){
						graphicsHandler.drawFilledRectangle(rxloc1 + 20, ryloc1 + 50, 10, 50, Color.GREEN);
					}
					else{
						graphicsHandler.drawFilledRectangle(rxloc1 + 20, ryloc1 + 50, 10, 50, Color.BLACK);
					}
					ryloc1 += 100;
				}
			}
			//Ultimate Skill
			if(proteinSelection.getId() == 8){
				graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, screenManager.getScreenHeight()-100, 50, 50, Color.RED, Color.YELLOW, 2);
			}
			else if(protein.array[7].getUnlockedStatus()){
				graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, screenManager.getScreenHeight()-100, 50, 50, Color.RED, Color.GREEN, 2);
			}
			else{
				graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, screenManager.getScreenHeight()-100, 50, 50, Color.RED, Color.BLACK, 2);
			}
			//Drawing Lines
			if(protein.array[7].getUnlockedStatus()){
				graphicsHandler.drawFilledRectangle(rxloc1 + 20, ryloc1 + 50, 10, 150, Color.GREEN);
				graphicsHandler.drawFilledRectangle((screenManager.getScreenWidth()/2) + 50, screenManager.getScreenHeight() - 75, 275, 10, Color.GREEN);
				graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 + 50, 10, 135, Color.GREEN);
				graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 + 185, 325, 10, Color.GREEN);
			}
			else{
				graphicsHandler.drawFilledRectangle(rxloc1 + 20, ryloc1 + 50, 10, 150, Color.BLACK);
				graphicsHandler.drawFilledRectangle((screenManager.getScreenWidth()/2) + 50, screenManager.getScreenHeight() - 75, 275, 10, Color.BLACK);
				graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 + 50, 10, 135, Color.BLACK);
				graphicsHandler.drawFilledRectangle(lxloc1 + 20, lyloc1 + 185, 325, 10, Color.BLACK);
			}
			//Navigation
			//Center to branch
			proteinTimer++;
			if(proteinSelection.getId() == 4){
				if(Keyboard.isKeyDown(Key.A) && proteinTimer > 20){
					proteinSelection = proteinSelection.getLeftSkill();
					proteinTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.D) && proteinTimer > 20){
					proteinSelection = proteinSelection.getRightSkill();
					proteinTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.SPACE) && proteinTimer > 20){
					protein.unlockNode(proteinSelection);
					proteinTimer = 0;
				}
			}
			//Left branch
			if(proteinSelection.getId() < 4){
				if(Keyboard.isKeyDown(Key.D) && proteinSelection.getId() == 3 && proteinTimer > 20){
					proteinSelection = proteinSelection.getParent();
					proteinTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.S) && proteinTimer > 20){
					if(proteinSelection.getId() == 1){
						protein.goToUltimate();
						proteinSelection = protein.getCurrentNode();
					}
					else{
						proteinSelection = proteinSelection.getLeftSkill();
					}
					proteinTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.W) && proteinTimer > 20){
					proteinSelection = proteinSelection.getParent();
					proteinTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.SPACE) && proteinTimer > 20){
					protein.unlockNode(proteinSelection);
					proteinTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.D) && proteinTimer > 20 && proteinSelection.getId() == 1){
					protein.goToUltimate();
					proteinSelection = protein.getCurrentNode();
					proteinTimer = 0;
				}
			}
			//Right Branch
			if(proteinSelection.getId() > 4 && proteinSelection.getId() < 8){
				if(proteinSelection.getId() == 5 && proteinTimer > 20 && Keyboard.isKeyDown(Key.A)){
					proteinSelection = proteinSelection.getParent();
					proteinTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.S) && proteinTimer > 20){
					proteinSelection = proteinSelection.getRightSkill();
					proteinTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.W) && proteinTimer > 20){
					proteinSelection = proteinSelection.getParent();
					proteinTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.SPACE) && proteinTimer > 20){
					protein.unlockNode(proteinSelection);
					proteinTimer = 0;
				}
				else if(proteinSelection.getId() == 7 && proteinTimer > 20 && Keyboard.isKeyDown(Key.A)){
					protein.goToUltimate();
					proteinSelection = protein.getCurrentNode();
					proteinTimer = 0;
				}
			}
			//Ultimate navigation
			if(proteinSelection.getId() == 8){
				if(Keyboard.isKeyDown(Key.A) && proteinTimer > 20){
					proteinSelection = protein.array[3];
					proteinTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.D) && proteinTimer > 20){
					proteinSelection = protein.array[6];
					proteinTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.SPACE) && proteinTimer > 20){
					protein.unlockNode(proteinSelection);
					proteinTimer = 0;
				}
			}
			//Drawing box that displays the information
			graphicsHandler.drawFilledRectangle(150, 125, 500, 300, Color.BLACK);
			SpriteFont title = new SpriteFont(proteinSelection.getName(), 160, 130, getFont(), Color.WHITE);
			title.setFontSize(25);
			title.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(150, 165, 500, 1, Color.WHITE);
			SpriteFont effect = new SpriteFont("Effect: ", 160, 175, getFont(), Color.WHITE);
			effect.setFontSize(25);
			effect.draw(graphicsHandler);
			SpriteFont descrip1 = new SpriteFont(proteinSelection.getEffect(), 160, 210, getFont(), Color.WHITE);
			descrip1.setFontSize(20);
			descrip1.draw(graphicsHandler);

			//Picture Selector
			switch(proteinSelection.getId()){
				case 1 :
					graphicsHandler.drawImage(set, 400, 200,200,200);
					break;
				case 2 :
					graphicsHandler.drawImage(bellona, 400, 200,200,200);
					break;
				case 3 :
					graphicsHandler.drawImage(ares, 400, 200, 200, 200);
					break;
				case 4 :
					graphicsHandler.drawImage(pantheon, 400, 200, 200, 200);
					break;
				case 5 :
					graphicsHandler.drawImage(sobek, 400, 200, 200, 200);
					break;
				case 6 :
					graphicsHandler.drawImage(bast, 400, 200, 200, 200);
					break;
				case 7 :
					graphicsHandler.drawImage(odin, 400, 200, 200, 200);
					break;
				case 8 :
					graphicsHandler.drawImage(thor, 400, 200, 200, 200);
					break;
			}
		}
		catch(NullPointerException e){
			System.out.println("Cannot Go Any Further!!!");
			protein.resetCurrentNode();
			proteinSelection = protein.getCurrentNode();
		}
		if(Keyboard.isKeyDown(Key.ESC)){
			select = false;
		}
	}
	int grainTimer = 0;
	private void displayGrainTree(){
		try{
			int yLoc = 10;
			int xLoc = screenManager.getScreenWidth()/2 - 10;
			for(SkillTreeNode skill : grain.array){
				if(skill.getId() == grainSelection.getId()){
					graphicsHandler.drawFilledRectangleWithBorder(xLoc, yLoc, 50, 50, Color.RED, Color.YELLOW, 2);
				}
				else if(skill.getUnlockedStatus()){
					graphicsHandler.drawFilledRectangleWithBorder(xLoc, yLoc, 50, 50, Color.RED, Color.GREEN, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(xLoc, yLoc, 50, 50, Color.RED, Color.BLACK, 2);
				}
				yLoc+= 100;
			}
			//line drawing
			int xLoc1 = xLoc + 20;
			int yLoc1 = 60;
			for(SkillTreeNode skill : grain.array){
				if(skill.getId() == 1){
					//do nothing
				}
				else{
					if(skill.getUnlockedStatus()){
						graphicsHandler.drawFilledRectangle(xLoc1, yLoc1, 10, 50, Color.GREEN);
					}
					else{
						graphicsHandler.drawFilledRectangle(xLoc1, yLoc1, 10, 50, Color.BLACK);
					}
					yLoc1 += 100;
				}
			}
			grainTimer++;
			if(Keyboard.isKeyDown(Key.S) && grainTimer > 20){
				grainTimer = 0;
				grainSelection = grainSelection.getRightSkill();
			}
			else if(Keyboard.isKeyDown(Key.W) && grainTimer > 20){
				grainTimer = 0;
				grainSelection = grainSelection.getParent();
			}
			else if(Keyboard.isKeyDown(Key.SPACE) && grainTimer > 20){
				grainTimer = 0;
				grain.unlockNode(grainSelection);
			}
			//Drawing box that displays the information
			graphicsHandler.drawFilledRectangle(10, 20, 350, 530, Color.BLACK);
			SpriteFont title = new SpriteFont(grainSelection.getName(), 15, 25, getFont(), Color.WHITE);
			title.setFontSize(25);
			title.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(10, 60, 350, 1, Color.WHITE);
			SpriteFont effect = new SpriteFont("Effect: ", 15, 100, getFont(), Color.WHITE);
			effect.setFontSize(25);
			effect.draw(graphicsHandler);
			SpriteFont descrip1 = new SpriteFont(grainSelection.getEffect(), 15, 150, getFont(), Color.WHITE);
			descrip1.setFontSize(20);
			descrip1.draw(graphicsHandler);
			
			switch(grainSelection.getId()){
				case 1 :
					graphicsHandler.drawImage(flour, 30, 230,300,300);
					break;
				case 2 :
					graphicsHandler.drawImage(ceres, 30, 230,300,300);
					break;
				case 3 :
					graphicsHandler.drawImage(radegast, 30, 230, 300, 300);
					break;
				case 4 :
					graphicsHandler.drawImage(freyr, 30, 230, 300, 300);
					break;
				case 5 :
					graphicsHandler.drawImage(demeter, 30, 230, 300, 300);
					break;
				case 6 :
					graphicsHandler.drawImage(gaea, 30, 230, 300, 300);
					break;
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
		try{
			//Center Skill
			if(fruitSelection.getId() == 6){
				graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, 50, 50, 50, Color.RED, Color.YELLOW, 2);
			}
			else{
				if(fruit.array[0].getUnlockedStatus()){
					graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, 50, 50, 50, Color.RED, Color.GREEN, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, 50, 50, 50, Color.RED, Color.BLACK, 2);
				}
			}
			//Left Branch
			int lXloc = 50;
			int lYloc = 50;
			for(int i = 1; i < 6; i++){
				if(fruit.array[i].getId() == fruitSelection.getId()){
					graphicsHandler.drawFilledRectangleWithBorder(lXloc, lYloc, 50, 50, Color.RED, Color.YELLOW, 2);
				}
				else if(fruit.array[i].getUnlockedStatus()){
					graphicsHandler.drawFilledRectangleWithBorder(lXloc, lYloc, 50, 50, Color.RED, Color.GREEN, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(lXloc, lYloc, 50, 50, Color.RED, Color.BLACK, 2);
				}
				lYloc += 100;
			}
			//Line drawing
			int lYloc1 = 50;
			int lXloc1 = 50;
			for(int i = 1; i < 6; i++){
				if(i == 1){
					if(fruit.array[i].getUnlockedStatus()){
						graphicsHandler.drawFilledRectangle(lXloc1 + 50, lYloc1 + 20, 295, 10, Color.GREEN);
					}
					else{
						graphicsHandler.drawFilledRectangle(lXloc1 + 50, lYloc1 + 20, 295, 10, Color.BLACK);
					}
				}
				else{
					if(fruit.array[i].getUnlockedStatus()){
						graphicsHandler.drawFilledRectangle(lXloc1 + 20, lYloc1 + 50, 10, 50, Color.GREEN);
					}
					else{
						graphicsHandler.drawFilledRectangle(lXloc1 + 20, lYloc1 + 50, 10, 50, Color.BLACK);
					}
					lYloc1 += 100;
				}
			}
			//Right Branch
			int rXloc = screenManager.getScreenWidth()-100;
			int rYloc = 50;
			for(int i = 6; i < 11; i++){
				if(fruit.array[i].getId() == fruitSelection.getId()){
					graphicsHandler.drawFilledRectangleWithBorder(rXloc, rYloc, 50, 50, Color.RED, Color.YELLOW, 2);
				}
				else if(fruit.array[i].getUnlockedStatus()){
					graphicsHandler.drawFilledRectangleWithBorder(rXloc, rYloc, 50, 50, Color.RED, Color.GREEN, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(rXloc, rYloc, 50, 50, Color.RED, Color.BLACK, 2);
				}
				rYloc += 100;
			}
			//Drawing lines
			int rXloc1 = screenManager.getScreenWidth() - 100;
			int rYloc1 = 50;
			if(fruit.array[6].getUnlockedStatus()){
				graphicsHandler.drawFilledRectangle(445, 70, 240, 10, Color.GREEN);
			}
			else{
				graphicsHandler.drawFilledRectangle(445, 70, 240, 10, Color.BLACK);
			}
			for(int i = 6; i < 10; i++){
				if(fruit.array[i+1].getUnlockedStatus()){
					graphicsHandler.drawFilledRectangle(rXloc1 + 20, rYloc1 + 50, 10, 50, Color.GREEN);
				}
				else{
					graphicsHandler.drawFilledRectangle(rXloc1 + 20, rYloc1 + 50, 10, 50, Color.BLACK);
				}
				rYloc1 += 100;
			}
			//Ultimate Skill & drawing lines
			if(fruitSelection.getId() == 12){
				graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, screenManager.getScreenHeight()-120, 50, 50, Color.RED, Color.YELLOW, 2);
			}
			else if(fruit.array[11].getUnlockedStatus()){
				graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, screenManager.getScreenHeight()-120, 50, 50, Color.RED, Color.GREEN, 2);
			}
			else{
				graphicsHandler.drawFilledRectangleWithBorder(screenManager.getScreenWidth()/2, screenManager.getScreenHeight()-120, 50, 50, Color.RED, Color.BLACK, 2);
			}
			if(fruit.array[11].getUnlockedStatus()){
				graphicsHandler.drawFilledRectangle(100, screenManager.getScreenHeight()-100, 295, 10, Color.GREEN);
				graphicsHandler.drawFilledRectangle(445, screenManager.getScreenHeight()-100, 240, 10, Color.GREEN);
			}
			else{
				graphicsHandler.drawFilledRectangle(100, screenManager.getScreenHeight()-100, 295, 10, Color.BLACK);
				graphicsHandler.drawFilledRectangle(445, screenManager.getScreenHeight()-100, 240, 10, Color.BLACK);
			}
			//Navigation
			//Center to branch
			fruitTimer++;
			if(fruitSelection.getId() == 6){
				if(Keyboard.isKeyDown(Key.A) && fruitTimer > 20){
					fruitSelection = fruitSelection.getLeftSkill();
					fruitTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.D) && fruitTimer > 20){
					fruitSelection = fruitSelection.getRightSkill();
					fruitTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.SPACE) && fruitTimer > 20){
					fruit.unlockNode(fruitSelection);
					fruitTimer = 0;
				}
			}
			//Left branch
			if(fruitSelection.getId() < 6){
				if(Keyboard.isKeyDown(Key.D) && fruitSelection.getId() == 5 && fruitTimer > 20){
					fruitSelection = fruitSelection.getParent();
					fruitTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.S) && fruitTimer > 20){
					fruitSelection = fruitSelection.getLeftSkill();
					fruitTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.W) && fruitTimer > 20){
					fruitSelection = fruitSelection.getParent();
					fruitTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.SPACE) && fruitTimer > 20){
					fruit.unlockNode(fruitSelection);
					fruitTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.D) && fruitTimer > 20 && fruitSelection.getId() == 1){
					fruit.goToUltimate();
					fruitSelection = fruit.getCurrentNode();
					fruitTimer = 0;
				}
			}
			//Right Branch
			if(fruitSelection.getId() > 6 && fruitSelection.getId() < 12){
				if(Keyboard.isKeyDown(Key.A) && fruitSelection.getId() == 7 && fruitTimer > 20){
					fruitSelection = fruitSelection.getParent();
					fruitTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.S) && fruitTimer > 20){
					fruitSelection = fruitSelection.getRightSkill();
					fruitTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.W) && fruitTimer > 20){
					fruitSelection = fruitSelection.getParent();
					fruitTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.SPACE) && fruitTimer > 20){
					fruit.unlockNode(fruitSelection);
					fruitTimer = 0;
				}
				else if(Keyboard.isKeyDown(Key.A) && fruitTimer > 20 && fruitSelection.getId() == 11){
					fruitSelection = fruitSelection.getRightSkill();
					fruitTimer = 0;
				}
			}
			//Ultimate Navigation
			if(fruitSelection.getId() == 12){
				if(fruitTimer > 20 && Keyboard.isKeyDown(Key.A)){
					fruitSelection = fruit.array[5];
					fruitTimer = 0;
				}
				else if(fruitTimer > 20 && Keyboard.isKeyDown(Key.D)){
					fruitSelection = fruit.array[10];
					fruitTimer = 0;
				}
				else if(fruitTimer > 20 && Keyboard.isKeyDown(Key.SPACE)){
					fruit.unlockNode(fruitSelection);
					fruitTimer = 0;
				}
			}
			//Drawing box that displays the information
			graphicsHandler.drawFilledRectangle(150, 125, 500, 300, Color.BLACK);
			SpriteFont title = new SpriteFont(fruitSelection.getName(), 160, 130, getFont(), Color.WHITE);
			title.setFontSize(25);
			title.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(150, 165, 500, 1, Color.WHITE);
			SpriteFont effect = new SpriteFont("Effect: ", 160, 175, getFont(), Color.WHITE);
			effect.setFontSize(25);
			effect.draw(graphicsHandler);
			SpriteFont descrip1 = new SpriteFont(fruitSelection.getEffect(), 160, 210, getFont(), Color.WHITE);
			descrip1.setFontSize(20);
			descrip1.draw(graphicsHandler);

			//Picture Selector
			switch(fruitSelection.getId()){
				case 1 :
					graphicsHandler.drawImage(orange, 400, 200,200,200);
					break;
				case 2 :
					graphicsHandler.drawImage(orange, 400, 200,200,200);
					break;
				case 3 :
					graphicsHandler.drawImage(orange, 400, 200, 200, 200);
					break;
				case 4 :
					graphicsHandler.drawImage(orange, 400, 200, 200, 200);
					break;
				case 5 :
					graphicsHandler.drawImage(orange, 400, 200, 200, 200);
					break;
				case 6 :
					graphicsHandler.drawImage(basket, 400, 200, 200, 200);
					break;
				case 7 :
					graphicsHandler.drawImage(horn, 400, 200, 200, 200);
					break;
				case 8 :
					graphicsHandler.drawImage(momotaro, 400, 200, 200, 200);
					break;
				case 9 :
					graphicsHandler.drawImage(maui, 400, 200, 200, 200);
					break;
				case 10 :
					graphicsHandler.drawImage(ulu, 400, 200, 200, 200);
					break;
				case 11 :
					graphicsHandler.drawImage(pomegranate, 400, 200, 200, 200);
					break;
				case 12 :
					graphicsHandler.drawImage(idun, 400, 200, 200, 200);
					break;
			}
		}
		catch(NullPointerException e){
			System.out.println("Cannot Go Any Further!!!");
			fruit.resetCurrentNode();
			fruitSelection = fruit.getCurrentNode();
		}
		//Escape key
		if(Keyboard.isKeyDown(Key.ESC)){
			select = false;
		}
	}

	int dairyTimer = 0;
	private void displayDairyTree(){
		try{
			//Drawing all of the Skills
			int xLoc = screenManager.getScreenWidth()/2 - 10;
			int yLoc = 10;
			for(SkillTreeNode skill : dairy.array1){
				if(skill.getId() == dairySelection.getId()){
					graphicsHandler.drawFilledRectangleWithBorder(xLoc, yLoc, 50, 50, Color.RED, Color.YELLOW, 2);
				}
				else if(skill.getUnlockedStatus()){
					graphicsHandler.drawFilledRectangleWithBorder(xLoc, yLoc, 50, 50, Color.RED, Color.GREEN, 2);
				}
				else{
					graphicsHandler.drawFilledRectangleWithBorder(xLoc, yLoc, 50, 50, Color.RED, Color.BLACK, 2);
				}
				yLoc += 100;
				if(yLoc > screenManager.getScreenHeight()){
					yLoc = 10;
					xLoc += 100;
				}
			}
			//Drawing Lines
			int xLoc1 = screenManager.getScreenWidth()/2 -10;
			int yLoc1 = 10;
			for(SkillTreeNode skill : dairy.array1){
				if(skill.getId() == 1 || skill.getId() == 7){
					//do nothing
				}
				else{
					if(skill.getUnlockedStatus()){
						graphicsHandler.drawFilledRectangle(xLoc1 + 20, yLoc1 + 50, 10, 50, Color.GREEN);
					}
					else{
						graphicsHandler.drawFilledRectangle(xLoc1 + 20, yLoc1 + 50, 10, 50, Color.BLACK);
					}
					yLoc1 += 100;
					if(yLoc1 > screenManager.getScreenHeight()- 100){
						yLoc1 = 10;
						xLoc1 += 100;
					}
				}
			}
			dairyTimer++;
			//Navigation
			if(Keyboard.isKeyDown(Key.S) && dairyTimer > 20){
				dairyTimer = 0;
				dairySelection = dairySelection.getRightSkill();
			}
			else if(Keyboard.isKeyDown(Key.W) && dairyTimer > 20){
				dairyTimer = 0;
				dairySelection = dairySelection.getParent();
			}
			else if(Keyboard.isKeyDown(Key.SPACE) && dairyTimer > 20){
				dairyTimer = 0;
				dairy.unlockNode(dairySelection);
			}
			//Drawing box that displays the information
			graphicsHandler.drawFilledRectangle(10, 20, 350, 530, Color.BLACK);
			SpriteFont title = new SpriteFont(dairySelection.getName(), 15, 25, getFont(), Color.WHITE);
			title.setFontSize(25);
			title.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(10, 60, 350, 1, Color.WHITE);
			SpriteFont effect = new SpriteFont("Effect: ", 15, 100, getFont(), Color.WHITE);
			effect.setFontSize(25);
			effect.draw(graphicsHandler);
			SpriteFont descrip1 = new SpriteFont(dairySelection.getEffect(), 15, 150, getFont(), Color.WHITE);
			descrip1.setFontSize(20);
			descrip1.draw(graphicsHandler);

			//Picture Selector
			switch(dairySelection.getId()){
				case 1 :
					graphicsHandler.drawImage(mars, 30, 220);
					break;
				case 2 :
					graphicsHandler.drawImage(laran, 30, 220,300,300);
					break;
				case 3 :
					graphicsHandler.drawImage(tyr, 30, 220, 300, 300);
					break;
				case 4 :
					graphicsHandler.drawImage(bia, 30, 220, 300, 300);
					break;
				case 5 :
					graphicsHandler.drawImage(satis, 30, 220, 300, 300);
					break;
				case 6 :
					graphicsHandler.drawImage(chiyou, 30, 220, 300, 300);
					break;
				case 7 :
					graphicsHandler.drawImage(perseus, 30, 220, 300, 300);
					break;
				case 8 :
					graphicsHandler.drawImage(diQing, 30, 220, 300, 300);
					break;
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
	public void showBossHealth1(){
		Floor1Boss.updateCurrentHealth();
		graphicsHandler.drawRectangle(10, screenManager.getScreenHeight()-40, screenManager.getScreenWidth() - 150, 30, Color.BLACK,5);
		graphicsHandler.drawFilledRectangle(10, screenManager.getScreenHeight()-40, (int) ((Floor1Boss.currenthealth/100.0) * (screenManager.getScreenWidth()-150)), 30 , Color.GREEN);
		//System.out.println((Floor1Boss.currenthealth/100.0));
	}

	public void showBossHealth2(){
		Floor2Boss.updateCurrentHealth();
		graphicsHandler.drawRectangle(10, screenManager.getScreenHeight()-40, screenManager.getScreenWidth() - 150, 30, Color.BLACK,5);
		graphicsHandler.drawFilledRectangle(10, screenManager.getScreenHeight()-40, (int) ((Floor2Boss.currenthealth/100.0) * (screenManager.getScreenWidth()-150)), 30 , Color.GREEN);
		//System.out.println((Floor2Boss.currenthealth/100.0));
	}

	public void showBossHealth3(){
		Floor3Boss.updateCurrentHealth();
		graphicsHandler.drawRectangle(10, screenManager.getScreenHeight()-40, screenManager.getScreenWidth() - 150, 30, Color.BLACK,5);
		graphicsHandler.drawFilledRectangle(10, screenManager.getScreenHeight()-40, (int) ((Floor3Boss.currenthealth/100.0) * (screenManager.getScreenWidth()-150)), 30 , Color.GREEN);
		//System.out.println((Floor2Boss.currenthealth/100.0));
	}
}
