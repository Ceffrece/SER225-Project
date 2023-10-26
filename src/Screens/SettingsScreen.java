package Screens;
import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Sprite;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Level.Player;
import java.awt.*;

//This screen handles the settings for the player
public class SettingsScreen extends Screen{

    protected ScreenCoordinator screenCoordinator;
    protected SpriteFont wasdToMove;
    protected SpriteFont arrowsToMove;
    protected KeyLocker keyLocker = new KeyLocker();
    GraphicsHandler graphicsHandler = new GraphicsHandler();
    ScreenManager screenManager = new ScreenManager();
    protected Map background;
    protected int keyPressTimer;
    protected int currentMenuItemHovered;
    protected int menuItemSelected;
    protected int pointerLocationX, pointerLocationY;


    public SettingsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize(){
        wasdToMove = new SpriteFont("WASD to Move", 200, 150, "Comic Sans", 20, new Color(49, 207, 240));
        wasdToMove.setOutlineColor(Color.black);
        wasdToMove.setOutlineThickness(3);
        arrowsToMove = new SpriteFont("Arrow Keys to Move", 175, 200, "Comic Sans", 20, new Color(49, 207, 240));
        arrowsToMove.setOutlineColor(Color.black);
        arrowsToMove.setOutlineThickness(3);
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        keyLocker.lockKey(Key.ESC);
    }
    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }

        // if escape is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.ESC) && Keyboard.isKeyDown(Key.ESC)) {
            screenCoordinator.setGameState(GameState.MENU);
        }

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
        if (currentMenuItemHovered > 1) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 1;
        }

        if (currentMenuItemHovered == 0){
            wasdToMove.setColor(new Color(255, 215, 0));
            arrowsToMove.setColor(new Color(49, 207, 240));
            pointerLocationX = 170;
            pointerLocationY = 154;
        }else if(currentMenuItemHovered == 1){
            wasdToMove.setColor(new Color(49, 207, 240));
            arrowsToMove.setColor(new Color(255, 215, 0));
            pointerLocationX = 145;
            pointerLocationY = 204;
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            menuItemSelected = currentMenuItemHovered;
            if (menuItemSelected == 0) {
                Player.updateControls(0);
            } else if (menuItemSelected == 1) {
                Player.updateControls(1);
            }
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        wasdToMove.draw(graphicsHandler);
        arrowsToMove.draw(graphicsHandler);
        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(49, 207, 240), Color.black, 2);
    }
}
