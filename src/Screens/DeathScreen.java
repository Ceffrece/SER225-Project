package Screens;
import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Sprite;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

/*
 * WARNING!! CODE BELOW IS 100% HAUNTED AND SCARY DO NOT TOUCH!! <3
 */

public class DeathScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected SpriteFont playAgain;
    protected SpriteFont giveUp;
    protected int keyPressTimer;
    protected int currentMenuItemHovered = 0;
    protected int menuItemSelected = -1;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected Sprite titleScreen = new Sprite(ImageLoader.load("ImageScreens/gameOver.png"), 0, 0);
    GraphicsHandler graphicsHandler = new GraphicsHandler();
    ScreenManager screenManager = new ScreenManager();

    public DeathScreen(ScreenCoordinator screenCoordinator){
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize(){
        playAgain = new SpriteFont("Try Again", 250, 400, "Comic Sans", 30, new Color(255, 0, 0));
        playAgain.setOutlineColor(Color.black);
        playAgain.setOutlineThickness(3);
        giveUp = new SpriteFont("Give Up", 450, 400, "Comic Sans", 30, new Color(110, 0, 0));
        giveUp.setOutlineColor(Color.black);
        giveUp.setOutlineThickness(3);
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        keyPressTimer = 0;
        menuItemSelected = -1;
        keyLocker.lockKey(Key.SPACE);
    }

    @Override
    public void update(){

        background.update(null);
        if (Keyboard.isKeyDown(Key.A) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered--;
        } else if (Keyboard.isKeyDown(Key.D) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered++;
        } else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        if (currentMenuItemHovered > 1) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 1;
        }

        if(currentMenuItemHovered == 0){
            playAgain.setColor(new Color(255, 0, 0));
            giveUp.setColor(new Color(110, 0, 0));
        }else if(currentMenuItemHovered == 1){
            playAgain.setColor(new Color(110, 0, 0));
            giveUp.setColor(new Color(255, 0, 0));
        }

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            menuItemSelected = currentMenuItemHovered;
            if (menuItemSelected == 0) {
                MenuScreen.setGameStarted(true);
                screenCoordinator.setGameState(GameState.LEVEL);
            } else if (menuItemSelected == 1) {
                screenCoordinator.setGameState(GameState.MENU);
            }
        }
    }
    public void draw(GraphicsHandler graphicsHandler) {
            background.draw(graphicsHandler);
            titleScreen.draw(graphicsHandler);
            playAgain.draw(graphicsHandler);
            giveUp.draw(graphicsHandler);
        }
}
