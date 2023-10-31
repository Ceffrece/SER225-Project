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
import Level.Player;
import Utils.Direction;
import Utils.Point;

// This class is for the Spineapple Enemy
public class Spineapple extends Enemy
{
        protected int health;

      
        public Spineapple(int id, Point location) 
        {
                super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Spineapple.png"), 14, 16), "STAND_LEFT");
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

        public void walkTowardPlayer(Player player)
    {
        if (Math.round(getBoundsX2()) - (getBounds().getWidth() / 2) < Math.round(player.getBoundsX2()))
        {
            walk(Direction.RIGHT, 1.0f);
        }
        if (Math.round(getBoundsX1()) + (getBounds().getWidth() / 2) > Math.round(player.getBoundsX1()))
        {
            walk(Direction.LEFT, 1.0f);
        }
        if (Math.round(getBoundsY2()) - (getBounds().getWidth() / 2) < Math.round(player.getBoundsY2()))
        {
            walk(Direction.DOWN, 1.0f);
        }
        if (Math.round(getBoundsY1()) + (getBounds().getWidth() / 2) > Math.round(player.getBoundsY1()))
        {
            walk(Direction.UP,1.0f);
        }
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
