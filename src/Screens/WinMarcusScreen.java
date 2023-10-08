package Screens;

import Engine.*;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the win level screen
public class WinMarcusScreen extends Screen {
    protected SpriteFont winMessage;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected MarcusScreen marcusScreen;

    public WinMarcusScreen(MarcusScreen marcusScreen) {
        this.marcusScreen = marcusScreen;
        initialize();
    }

    @Override
    public void initialize() {
        winMessage = new SpriteFont("Marcus is really tired", 250, 239, "Comic Sans", 30, Color.white);
        instructions = new SpriteFont("Press Space to play again or Escape to go back to the main menu", 110, 279,"Comic Sans", 20, Color.white);
        keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.ESC);
    }

    @Override
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }

        // if space is pressed, reset level. if escape is pressed, go back to main menu
        if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
            marcusScreen.resetLevel();
        } else if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
            marcusScreen.goBackToMenu();
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        winMessage.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
    }
}
