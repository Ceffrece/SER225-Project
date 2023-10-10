package Enemies;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Enemies;
import Utils.Point;

// This class is for the Cereal Killer Enemy
public class CerealKiller extends Enemies
{
    private static String imageFileName;

public CerealKiller(int id, Point location)
    {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load(imageFileName:"Walrus.png"), 20, 20), "STAND_LEFT");
        super.setIdentity("enemy");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(4, 5, 5, 10)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(3)
                           .withBounds(4, 5, 5, 10)
                           .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                           .build()
           });

            put("WALK_LEFT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                            .withScale(3)
                            .withBounds(4, 5, 5, 10)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                            .withScale(3)
                            .withBounds(4, 5, 5, 10)
                            .build()
            });

            put("WALK_RIGHT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 5, 5, 10)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 5, 5, 10)
                            .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler)
    {
        super.draw(graphicsHandler);
    }

}
