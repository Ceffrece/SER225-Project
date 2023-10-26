package Screens;
import Engine.*;
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
        keyLocker.lockKey(Key.ESC);
    }

    @Override
    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.ESC) && Keyboard.isKeyDown(Key.ESC)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
    }
}
