package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Sprite;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This is the class for the main menu screen
public class MenuScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected int menuItemSelected = -1;
    protected SpriteFont playGame;
    protected SpriteFont credits;
    protected SpriteFont marcusMap; // new map for test purposes
    protected SpriteFont instructions; // Initializes the instructions waow
    protected Map background;
    protected int keyPressTimer;
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();
    protected Sprite titleScreen = new Sprite(ImageLoader.load("TitleScreen.png"), 0, 0);
    public static boolean gameStarted;
    GraphicsHandler graphicsHandler = new GraphicsHandler();
    ScreenManager screenManager = new ScreenManager();
    

    public MenuScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        playGame = new SpriteFont("PLAY", 560, 150, "Comic Sans", 20, new Color(49, 207, 240));
        playGame.setOutlineColor(Color.black);
        playGame.setOutlineThickness(3);
        credits = new SpriteFont("CREDITS", 545, 200, "Comic Sans", 20, new Color(49, 207, 240));
        credits.setOutlineColor(Color.black);
        credits.setOutlineThickness(3);
        marcusMap = new SpriteFont("MARCUS", 545, 250, "Comic Sans", 20, new Color(49, 207, 240));
        marcusMap.setOutlineColor(Color.black);
        marcusMap.setOutlineThickness(3);
        instructions = new SpriteFont("INSTRUCTIONS", 510, 300, "Comic Sans", 20, new Color(49, 207, 240));
        instructions.setOutlineColor(Color.black);
        instructions.setOutlineThickness(3);
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        keyPressTimer = 0;
        menuItemSelected = -1;
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        // update background map (to play tile animations)
        background.update(null);
        // if down or up is pressed, change menu item "hovered" over (blue square in front of text will move along with currentMenuItemHovered changing)
        if (Keyboard.isKeyDown(Key.S) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.W) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered--;
        } else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        // if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
        if (currentMenuItemHovered > 3) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 3;
        }

        // sets location for blue square in front of text (pointerLocation) and also sets color of spritefont text based on which menu item is being hovered
        if (currentMenuItemHovered == 0) {
            playGame.setColor(new Color(255, 215, 0));
            credits.setColor(new Color(49, 207, 240));
            marcusMap.setColor(new Color(49, 207, 240));
            instructions.setColor(new Color(49, 207, 240));
            pointerLocationX = 530;
            pointerLocationY = 154;
        } else if (currentMenuItemHovered == 1) {
            playGame.setColor(new Color(49, 207, 240));
            credits.setColor(new Color(255, 215, 0));
            marcusMap.setColor(new Color(49, 207, 240));
            instructions.setColor(new Color(49, 207, 240));
            pointerLocationX = 515;
            pointerLocationY = 204;
        } else if (currentMenuItemHovered == 2) {
            playGame.setColor(new Color(49, 207, 240));
            credits.setColor(new Color(49, 207, 240));
            marcusMap.setColor(new Color(255, 215, 0));
            instructions.setColor(new Color(49, 207, 240));
            pointerLocationX = 515;
            pointerLocationY = 254;
        } else if(currentMenuItemHovered == 3){
            playGame.setColor(new Color(49, 207, 240));
            credits.setColor(new Color(49, 207, 240));
            marcusMap.setColor(new Color(49, 207, 240));
            instructions.setColor(new Color(255, 215, 0));
            pointerLocationX = 480;
            pointerLocationY = 304;
        }

        // if space is pressed on menu item, change to appropriate screen based on which menu item was chosen
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            menuItemSelected = currentMenuItemHovered;
            if (menuItemSelected == 0) {
                screenCoordinator.setGameState(GameState.LEVEL);
                gameStarted = true;
            } else if (menuItemSelected == 1) {
                screenCoordinator.setGameState(GameState.CREDITS);
            } else if (menuItemSelected == 2) {
                screenCoordinator.setGameState(GameState.MARCUS);
                gameStarted = true;
            } else if(menuItemSelected == 3){
                screenCoordinator.setGameState(GameState.INSTRUCTIONS);
            }
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        titleScreen.draw(graphicsHandler);
        playGame.draw(graphicsHandler);
        credits.draw(graphicsHandler);
        marcusMap.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(49, 207, 240), Color.black, 2);
    }
    
    public static boolean getGameStarted(){
        return gameStarted;
    }
}
