package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class CreditsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont tilesetLabel;
    protected SpriteFont returnInstructionsLabel;
    protected SpriteFont teamMembers;
    protected SpriteFont caden;
    protected SpriteFont marcus;
    protected SpriteFont bill;
    protected SpriteFont kyle;
    protected SpriteFont riley;


    public CreditsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        creditsLabel = new SpriteFont("Credits", 15, 7, "Times New Roman", 30, Color.white);
        createdByLabel = new SpriteFont("Created by Alex Thimineur and Team Let Us Cook", 15, 120, "Times New Roman", 25, Color.white);
        teamMembers = new SpriteFont("Let Us Cook Team Members:", 15, 160, "Times New Roman", 25, Color.white);
        caden = new SpriteFont("Caden Effrece", 15, 180, "Times New Roman", 25, Color.white);
        marcus = new SpriteFont("Marcus Ferreria", 15, 200, "Times New Roman", 25, Color.white);
        bill = new SpriteFont("Bill Regan", 15, 220, "Times New Roman", 25, Color.white);
        kyle = new SpriteFont("Kyle MacDonald", 15, 240, "Times New Roman", 25, Color.white);
        riley = new SpriteFont("Riley Damasco", 15, 260, "Times New Roman", 25, Color.white);

        tilesetLabel = new SpriteFont("Custom tileset Dawnlike by DragonDePlatino and DawnBringer", 15, 500, "Times New Roman", 25, Color.white);
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 532, "Times New Roman", 30, Color.white);
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        creditsLabel.draw(graphicsHandler);
        createdByLabel.draw(graphicsHandler);
        tilesetLabel.draw(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
        teamMembers.draw(graphicsHandler);
        caden.draw(graphicsHandler);
        marcus.draw(graphicsHandler);
        riley.draw(graphicsHandler);
        bill.draw(graphicsHandler);
        kyle.draw(graphicsHandler);
    }
}
