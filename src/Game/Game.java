package Game;

import Engine.GameWindow;
import Engine.Music;
import Engine.ScreenManager;

/*
 * The game starts here
 * This class just starts up a GameWindow and attaches the ScreenCoordinator to the ScreenManager instance in the GameWindow
 * From this point on the ScreenCoordinator class will dictate what the game does
 */
public class Game {
    public static Music skillTreeBackground = new Music("Resources/Music/danceWithDragons.wav"); 
    public static Music startScreenMusic = new Music("Resources/Music/demigods.wav");
    public static Music gameMusic = new Music("Resources/Music/gameMusic-floor1.wav");
    public static Music bossMusic1 = new Music("Resources/Music/dies-irae.wav");

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        GameWindow gameWindow = new GameWindow();
        ScreenManager screenManager = gameWindow.getScreenManager();
        screenManager.setCurrentScreen(new ScreenCoordinator());
        gameWindow.startGame();

        startScreenMusic.play();
    }
}
