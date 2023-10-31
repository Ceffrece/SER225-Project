package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.ImageEffect;
import GameObject.Sprite;
import Level.Map;
// import Tilesets.CommonTileset; (unused)
import Tilesets.Floor1Tileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class TitleScreenMap extends Map {

    private Sprite cat;

    public TitleScreenMap() {
        super("title_screen_map.txt", new Floor1Tileset());
        Point catLocation = getMapTile(9, 5).getLocation().addX(10);
        cat = new Sprite(ImageLoader.loadSubImage("Player.png", Colors.MAGENTA, 0, 0, 16, 16));
        cat.setScale(3);
        cat.setImageEffect(ImageEffect.FLIP_HORIZONTAL);
        cat.setLocation(catLocation.x, catLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        cat.draw(graphicsHandler);
    }
}
