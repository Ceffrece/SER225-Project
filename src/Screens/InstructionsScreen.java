package Screens;
import Engine.*;
import Engine.Screen;
import Engine.ScreenManager;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.KeyLocker;
import Engine.Keyboard;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Sprite;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;


public class InstructionsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected SpriteFont escapeToLeave;
    protected KeyLocker keyLocker = new KeyLocker();
    protected Sprite instructions = new Sprite(ImageLoader.load("Instructions.png"), 0, 0);
    GraphicsHandler graphicsHandler = new GraphicsHandler();
    ScreenManager screenManager = new ScreenManager();
    protected Map background;
    
    public InstructionsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize(){
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        keyLocker.lockKey(Key.SPACE);
    }

    @Override
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

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
    }
}
