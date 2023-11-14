package Enemy;

import java.awt.Color;
import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Enemy;
import Utils.Point;

// This class is for the Cereal Killer Enemy
public class CerealKiller extends Enemy
{
        protected int health;

      
        public CerealKiller(int id, Point location) 
        {
                super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("EnemySprites/CerealKiller.png"), 16, 16), "STAND_LEFT");
                super.setIdentity("enemy");
                super.setHealth(100);
                
        }

        @Override
        public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
                return new HashMap<String, Frame[]>() {{
                put("STAND_LEFT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 0))
                                .withScale(3)
                                .withBounds(3, 6, 14, 16)
                                .build()
                });
                put("STAND_RIGHT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 0))
                                .withScale(3)
                                .withBounds(3, 6, 14, 16)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .build()
                });

                put("WALK_LEFT", new Frame[]{
                        new FrameBuilder(spriteSheet.getSprite(1, 0), 12)
                                .withScale(3)
                                .withBounds(1, 3, 12, 13)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 1), 12)
                                .withScale(3)
                                .withBounds(1, 3, 12, 13)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 2), 12)
                                .withScale(3)
                                .withBounds(1, 3, 12, 13)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 3), 12)
                                .withScale(3)
                                .withBounds(1, 3, 12, 13)
                                .build()
                });

                put("WALK_RIGHT", new Frame[]{
                        new FrameBuilder(spriteSheet.getSprite(1, 0), 12)
                                .withScale(3)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(1, 3, 12, 13)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 1), 12)
                                .withScale(3)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(1, 3, 12, 13)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 2), 12)
                                .withScale(3)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(1, 3, 12, 13)
                                .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 3), 12)
                                .withScale(3)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .withBounds(1, 3, 12, 13)
                                .build()
                });
                }};
        }
        public void update()
        {
            super.update();

        }
        public int getHealth() {
                return health;
        }

        public void setHealth(int health) {
                this.health = health;
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
                
                //if (this instanceof Enemy) {
                //        drawBounds(graphicsHandler, new Color(255, 0, 0, 100));
                //}
                
        } else {
                super.draw(graphicsHandler);
        }
    }

}
