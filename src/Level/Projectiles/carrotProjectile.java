package Level.Projectiles;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Utils.Direction;
import Utils.Point;
import Level.MapEntityStatus;
import Level.Player;
import Level.Projectile;
import NPCs.Dinosaur;


public class carrotProjectile extends Projectile {
        private float speedX;
        private float speedY;
        private int existenceFrames = (Player.attackRange)*55;
        private int hasDirection = 0;

        private static int shootTime = 100;

        public static String projectileID = "carrotProjectile";
        public static String projectilePng = "carrotProjectile.png";

        public carrotProjectile(Point location,GameObject object) {
                super(location, new SpriteSheet(ImageLoader.load("carrotProjectile.png"), 16, 16), "UP",100);
                super.setIdentity(identity);
                super.setExistenceFrames(existenceFrames);
                super.existenceFrames = existenceFrames;
                
                super.projectileID = projectileID;
                super.projectilePng = projectilePng;


                super.setDamage(Player.attackDamage*10);
                initialize();
                
        }
        
        
        public void getProjectileDirection(Player player){
                if (hasDirection ==0){ 
                        if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  3.5f;
                                speedX = -3.5f; 
                                this.currentAnimationName = "RIGHT";
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
                                this.currentAnimationName = "RIGHT";

                        } 
                        else if (player.getFacingDirection() == Direction.LEFT) {
                                speedX = -3.5f; 
                        }
                        else if (player.getFacingDirection() == Direction.UP) {
                                speedY = -3.5f;
    
                        }
                         else if (player.getFacingDirection() == Direction.DOWN) {
                            speedY =  3.5f;
                            this.currentAnimationName = "DOWN";

    
                        }
                       
                    
                hasDirection++;
                }

                }
                @Override
            public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
                return new HashMap<String, Frame[]>() {{
                        put("UP", new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 0))
                                        .withScale(3)
                                        .withBounds(6, 12, 16, 16)
                                        .build()
                        });
                        put("DOWN", new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 0))
                                        .withScale(3)
                                        .withBounds(6, 12, 16, 16)
                                        .withImageEffect(ImageEffect. FLIP_H_AND_V)
                                        .build()
                        });
                        put("LEFT", new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 0))
                                        .withScale(3)
                                        .withBounds(6, 12, 16, 16)
                                        .build()
                        });
                        put("RIGHT", new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 0))
                                        .withScale(3)
                                        // .withImageEffect(ImageEffect. FLIP_H_AND_V)
                                        .withImageEffect(ImageEffect. FLIP_H_AND_V)
                                
                                        .withBounds(6, 12, 16, 16)
                                        .build()
                        });
                }
        };
               
        }
        public String getCurentProjectilePNG(){
                return "carrotProjectile.png";
        }
        public void update(Player player) {
                super.update();
                getProjectileDirection(player);

                moveXHandleCollision(speedX);
                moveYHandleCollision(speedY);
                if (this.existenceFrames <= 0) {
                        this.mapEntityStatus = MapEntityStatus.REMOVED;
                } 
                existenceFrames--;
                if (intersects(player)|| this.identity == "enemy") {
                    touchedPlayer(player);
                }
       
        }

}

