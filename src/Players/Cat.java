package Players;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Player;

import java.util.HashMap;

// This is the class for the Cat player character
// basically just sets some values for physics and then defines animations
public class Cat extends Player {
int spriteOffset = 0;
    public Cat(float x, float y) {
      super(new SpriteSheet(ImageLoader.load("Player/Player.png"), 16, 16), x, y, "STAND_RIGHT");
       //player speed, attack speed, attack damage, attack range, player health
       float walkSpeed;
       int  attackSpeed;
       int  attackDamage;
       int  attackRange;
       int  playerHealth;
       int dash;
       int experienceLevel;
       int experiencePoints;
       int projectileId;
    }
    

    
    public void update() {
        super.update();
    }

    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {

        return new HashMap<String, Frame[]>() {{
            put("STAND_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(4, 3, 7, 11)
                            .build()
            });
            put("STAND_RIGHT_DAMAGED", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(4, 0), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(4, 1), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build()
            });

            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build()
            });

            put("STAND_LEFT_DAMAGED", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(4, 0), 5)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(4, 1), 5)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build()
            });
            put("STAND_UP", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(3, 5))
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build()
        });
        put("STAND_UP_DAMAGED", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(7, 5), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(7, 4), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build()
        });
        put("STAND_DOWN", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(2, 5))
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build()
        });
        put("STAND_DOWN_DAMAGED", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(6, 5), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(6, 4), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build()
        });
            put("WALK_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 9)
                            .withScale(3)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 5)
                            .withScale(3)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 3), 5)
                            .withScale(3)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 4), 9)
                            .withScale(3)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 5), 5)
                            .withScale(3)
                            .withBounds(4, 3, 7, 11)
                            .build(),
            });
            put("WALK_RIGHT_DAMAGED", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(5, 1), 9)
                            .withScale(3)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 2), 5)
                            .withScale(3)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 3), 5)
                            .withScale(3)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 4), 9)
                            .withScale(3)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 5), 5)
                            .withScale(3)
                            .withBounds(4, 3, 7, 11)
                            .build(),
            });

            put("WALK_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 9)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 5)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 3), 5)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 4), 9)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 5), 5)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build(),    
            });
            put("WALK_LEFT_DAMAGED", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(5, 1), 9)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 2), 5)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 3), 5)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 4), 9)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 5), 5)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 3, 7, 11)
                            .build(),    
            });
            put("WALK_UP", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(3, 1), 9)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(3, 2), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(3, 3), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(3, 4), 9)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(3, 5), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
        });
        put("WALK_UP_DAMAGED", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(7, 1), 9)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(7, 2), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(7, 3), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(7, 4), 9)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(7, 5), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
        });
        put("WALK_DOWN", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(2, 1), 9)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(2, 2), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(2, 3), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(2, 4), 9)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(2, 5), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
        });
        put("WALK_DOWN_DAMAGED", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(6, 1), 9)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(6, 2), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(6, 3), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(6, 4), 9)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(6, 5), 5)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
        });
        put("DEATH", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(8, 0), 30)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(8, 1), 10)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(8, 2), 500)
                        .withScale(3)
                        .withBounds(4, 3, 7, 11)
                        .build(),
        });
        }};
    }
}
