package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Player;
import Level.TileType;
import Utils.Point;

// This class is for an invisible special tile that hurts the player as normal when they're in contact
// Not specifically tied to the spike tile, but named such because that is its most common usage
public class Spikes extends EnhancedMapTile {
    public Spikes(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Misc//Transparent.png"), 16, 16), TileType.PASSABLE);
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (player.overlaps(this) && Player.invincibilityTimer == 0) {
            Player.hurtPlayer();
            System.out.println("player hit; hp: " + Player.playerHealth);
            Player.invincibilityTimer = 180;
        }
    }

    @Override
    protected GameObject loadBottomLayer(SpriteSheet spriteSheet) {
        Frame frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
                .withScale(3)
                .build();
        return new GameObject(x, y, frame);
    }
}