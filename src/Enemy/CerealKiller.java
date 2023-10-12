package Enemy;

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
                super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("CerealKiller.png"), 14, 16), "STAND_LEFT");
                super.setIdentity("enemy");
                super.setHealth(100);
                
        }

        @Override
        public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
                return new HashMap<String, Frame[]>() {{
                put("STAND_LEFT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 0))
                                .withScale(3)
                                .withBounds(4, 5, 14, 16)
                                .build()
                });
                put("STAND_RIGHT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 0))
                                .withScale(3)
                                .withBounds(4, 5, 14, 16)
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
    public void draw(GraphicsHandler graphicsHandler)
    {
        super.draw(graphicsHandler);
    }

}
