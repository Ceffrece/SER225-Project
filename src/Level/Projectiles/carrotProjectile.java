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


public class carrotProjectile extends Projectile {
        private float speedX;
        private float speedY;
        private int existenceFrames = (Player.attackRange)*35;
        private int hasDirection = 0;

        private static int shootTime = 150;

        public static String projectileID = "carrotProjectile";
        public static String projectilePng = "Projectiles/carrotProjectile.png";

        public carrotProjectile(Point location,GameObject object) {
                super(location, new SpriteSheet(ImageLoader.load("Projectiles/carrotProjectile.png"), 16, 16), "UP",150);
                super.setIdentity(identity);
                super.setExistenceFrames(existenceFrames);
                super.existenceFrames = existenceFrames;
                
                super.projectileID = projectileID;
                super.projectilePng = projectilePng;


                super.setDamage(Player.attackDamage*25);
                initialize();
                
        }
        
        
        public void getProjectileDirection(Player player){
                if (hasDirection ==0){ 
                        if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  4.5f;
                                speedX = -4.5f; 
                                this.currentAnimationName= "DIAGONALDOWNLEFT";
                        }
                        else if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.RIGHT) {
                                speedY =  4.5f;
                                speedX = 4.5f; 
                                this.currentAnimationName = "DIAGONALDOWNRIGHT";

                        }
                        else if (player.getFacingDirection() == Direction.UP && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  -4.5f;
                                speedX = -4.5f; 
                                this.currentAnimationName = "DIAGONALUPLEFT";

                        }
                        else if (player.getFacingDirection() == Direction.UP && player.getLastWalkingXDirection() == Direction.RIGHT) {
                                speedY =  -4.5f;
                                speedX = 4.5f; 
                                this.currentAnimationName = "DIAGONALUPRIGHT";


                        }
                        else if (player.getFacingDirection() == Direction.RIGHT) {
                                speedX = 4.5f;
                                this.currentAnimationName = "RIGHT";

                        } 
                        else if (player.getFacingDirection() == Direction.LEFT) {
                                speedX = -4.5f; 
                                this.currentAnimationName = "LEFT";

                        }
                        else if (player.getFacingDirection() == Direction.UP) {
                                speedY = -4.5f;
                                this.currentAnimationName = "UP";

                        }
                         else if (player.getFacingDirection() == Direction.DOWN) {
                            speedY =  4.5f;
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
                                        .withBounds(4, 1, 8, 14)
                                        .build()
                        });
                        put("DOWN", new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 0))
                                        .withScale(3)
                                        .withBounds(4, 1, 8, 14)
                                        .withImageEffect(ImageEffect. FLIP_H_AND_V)
                                        .build()
                        });
                        put("LEFT", new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 1))
                                        .withScale(3)
                                        .withBounds(1, 4, 14, 8)
                                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)                                
                                        .build()
                        });
                        put("RIGHT", new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 1))
                                        .withScale(3)
                                        .withBounds(1, 4, 14, 8)
                                        .build()
                        });
                        put("DIAGONALUPRIGHT", new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 2))
                                        .withScale(3)
                                        .withBounds(2, 2, 12, 12)
                                        .build()
                        });
                        put("DIAGONALUPLEFT", new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 2))
                                        .withScale(3)
                                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)                                
                                        .withBounds(2, 2, 12, 12)
                                        .build()
                        });
                        put("DIAGONALDOWNLEFT", new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 2))
                                        .withScale(3)
                                        .withImageEffect(ImageEffect.FLIP_H_AND_V)                                
                                        .withBounds(2, 2, 12, 12)
                                        .build()
                        });
                        put("DIAGONALDOWNRIGHT", new Frame[] {
                                new FrameBuilder(spriteSheet.getSprite(0, 2))
                                        .withScale(3)
                                        .withImageEffect(ImageEffect.FLIP_VERTICAL)                                
                                        .withBounds(2, 2, 12, 12)
                                        .build()
                        });
                }
        };
               
        }
        public String getCurentProjectilePNG(){
                return "GUISprites/carrotIcon.png";
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

