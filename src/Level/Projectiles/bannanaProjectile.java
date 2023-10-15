package Level.Projectiles;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Utils.Direction;
import Utils.Point;
import Level.Player;
import Level.Projectile;
import NPCs.Dinosaur;


public class bannanaProjectile extends Projectile {
        private float speedX;
        private float speedY;
        private int existenceFrames = 300;
        private int hasDirection = 0;
        private SpriteSheet spriteSheet;

        public static String projectileID = "bannanaProjectile";
        public static String projectilePng = "bannanaIcon.png";

        public bannanaProjectile(Point location,GameObject object) {
                super(location, new SpriteSheet(ImageLoader.load("bannanaProjectile.png"), 16, 16), "SPIN", null);
                super.setIdentity(identity);
                super.projectileID = projectileID;
                super.projectilePng = projectilePng;
                spriteSheet = new SpriteSheet(ImageLoader.load("bannanaProjectile.png"), 16, 16);
                update();
                super.setDamage(50);
                initialize();
                
        }
        public bannanaProjectile(Point location, String currentProjectile, Dinosaur dinosaur) {
                super(location, new SpriteSheet(ImageLoader.load("bannanaProjectile.png"), 16, 16), "SPIN", null);
        }
        public void getProjectileDirection(Player player){
                if (hasDirection ==0){ 
                        if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  3.5f;
                                speedX = -3.5f; 
                        }
                        else if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.RIGHT) {
                                speedY =  3.5f;
                                speedX = 3.5f; 
                        }
                        else if (player.getFacingDirection() == Direction.UP && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  -3.5f;
                                speedX = -3.5f; 
                        }
                        else if (player.getFacingDirection() == Direction.UP && player.getLastWalkingXDirection() == Direction.RIGHT) {
                                speedY =  -3.5f;
                                speedX = 3.5f; 
                        }
                        else if (player.getFacingDirection() == Direction.RIGHT) {
                                speedX = 3.5f;
                        } 
                        else if (player.getFacingDirection() == Direction.LEFT) {
                                speedX = -3.5f; 
                        }
                        else if (player.getFacingDirection() == Direction.UP) {
                                speedY = -3.5f;
                        }
                         else if (player.getFacingDirection() == Direction.DOWN) {
                            speedY =  3.5f;
    
                        }
                       
                }
                hasDirection++;
               
        }
        @Override
            public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
                return new HashMap<String, Frame[]>() {{
                    put("SPIN", new Frame[]{
                        new FrameBuilder(spriteSheet.getSprite(0, 0), 9)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 1), 5)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 2), 5)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 3), 9)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 4), 5)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 0), 9)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 5)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 5)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 3), 9)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 4), 5)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                            new FrameBuilder(spriteSheet.getSprite(2, 0), 9)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 1), 5)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 2), 5)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 3), 9)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 4), 5)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                            new FrameBuilder(spriteSheet.getSprite(3, 0), 9)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(3, 1), 5)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(3, 2), 5)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(3, 3), 9)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(3, 4), 5)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build()
                });
                put("DEFAULT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 0))
                                .withScale(3)
                                .withBounds(6, 12, 16, 16)
                                .build()
                });
            }};
            
        }
        public String getCurentProjectilePNG(){
                return "bannanaIcon.png";
        }
        public void update(Player player) {
                super.update();

                getProjectileDirection(player);
                loadAnimations(spriteSheet);
                moveXHandleCollision(speedX);
                moveYHandleCollision(speedY);


                if (intersects(player)|| this.identity == "enemy") {
                    touchedPlayer(player);
                }
       
        }

}

