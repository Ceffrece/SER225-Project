package Screens;
import Engine.Screen;
import Engine.ScreenManager;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Sprite;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;


public class InstructionsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected SpriteFont escapeToLeave;
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
    }

    @Override
    public void update() {
        background.update(null);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
    }
}
