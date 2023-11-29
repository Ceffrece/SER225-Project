package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Utils.Point;

import java.awt.Color;
import java.util.HashMap;

// This class is for the Platino NPC
public class Platino extends NPC {

    public Platino(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Misc/Platino.png"), 16, 16), "STAND_LEFT");
    }

    public void update(Player player) {
        super.update(player);
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                            .withScale(3)
                            .withBounds(4, 3, 8, 13)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                            .withScale(3)
                            .withBounds(4, 3, 8, 13)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                           .withScale(3)
                           .withBounds(4, 3, 8, 13)
                           .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                           .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                           .withScale(3)
                           .withBounds(4, 3, 8, 13)
                           .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                           .build()
           });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        if (map != null) {
            graphicsHandler.drawImage(
                            currentFrame.getImage(),
                            Math.round(getCalibratedXLocation()),
                            Math.round(getCalibratedYLocation()),
                            currentFrame.getWidth(),
                            currentFrame.getHeight(),
                            currentFrame.getImageEffect());

            // Uncomment this to draw player's bounds to screen -- useful for debugging
            
            //if (this instanceof NPC) {
            //        drawBounds(graphicsHandler, new Color(255, 0, 0, 100));
            //}
            
    } else {
            super.draw(graphicsHandler);
    }
}
}
