package Level.Projectiles;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Utils.Direction;
import Utils.Point;
import Level.MapEntityStatus;
import Level.Player;
import Level.Projectile;
import NPCs.Dinosaur;


public class bannanaProjectile extends Projectile {
        private float speedX;
        private float speedY;
        private float boomX;
        private float boomY;
        private int existenceFrames = (Player.attackRange)*75;
        int turn = existenceFrames/2;
        private int hasDirection = 0;
        private SpriteSheet spriteSheet;

        private static int shootTime = 100;

        public static String projectileID = "bannanaProjectile";
        public static String projectilePng = "bannanaIcon.png";

        public bannanaProjectile(Point location,GameObject object) {
                super(location, new SpriteSheet(ImageLoader.load("bannanaProjectile.png"), 16, 16), "SPIN",100);
                super.setIdentity(identity);

                super.projectileID = projectileID;
                super.projectilePng = projectilePng;

                super.existenceFrames = existenceFrames;
                int turn = existenceFrames/2;

                spriteSheet = new SpriteSheet(ImageLoader.load("bannanaProjectile.png"), 16, 16);
                update();
                super.setDamage(Player.attackDamage*10);
                initialize();
                
        }
        
        
        public void getProjectileDirection(Player player){
                if (hasDirection ==0){ 
                        if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  3.5f;
                                speedX = -3.5f; 

                                boomY = -3.5f;
                                boomX = 3.5f;
                        }
                        else if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.RIGHT) {
                                speedY =  3.5f;
                                speedX = 3.5f; 

                                boomY = -3.5f;
                                boomX = -3.5f;
                        }
                        else if (player.getFacingDirection() == Direction.UP && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  -3.5f;
                                speedX = -3.5f;

                                boomY = 3.5f;
                                boomX = 3.5f;
                        }
                        else if (player.getFacingDirection() == Direction.UP && player.getLastWalkingXDirection() == Direction.RIGHT) {
                                speedY =  -3.5f;
                                speedX = 3.5f; 

                                boomY = 3.5f;
                                boomX = -3.5f;
                        }
                        else if (player.getFacingDirection() == Direction.RIGHT) {
                                speedX = 3.5f;

                                boomX = -3.5f;

                        } 
                        else if (player.getFacingDirection() == Direction.LEFT) {
                                speedX = -3.5f; 

                                boomX = 3.5f;
                        }
                        else if (player.getFacingDirection() == Direction.UP) {
                                speedY = -3.5f;

                                boomY = 3.5f;

                        }
                         else if (player.getFacingDirection() == Direction.DOWN) {
                            speedY =  3.5f;

                            boomY = -3.5f;

    
                        }
                       
                }
                hasDirection++;
               
        }
        @Override
            public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
                return new HashMap<String, Frame[]>() {{
                    put("SPIN", new Frame[]{
                        new FrameBuilder(spriteSheet.getSprite(0, 0), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 1), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 2), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 3), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 4), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 5), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                        new FrameBuilder(spriteSheet.getSprite(1, 0), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 3), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 4), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                            new FrameBuilder(spriteSheet.getSprite(1, 5), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                            new FrameBuilder(spriteSheet.getSprite(2, 0), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 1), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 2), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 3), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 4), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                            new FrameBuilder(spriteSheet.getSprite(2, 5), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                            new FrameBuilder(spriteSheet.getSprite(3, 0), 2)
                            .withScale(3)
                            .withBounds(6, 12, 16, 16)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(3, 1), 2)
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

                if (existenceFrames > turn){
                        moveXHandleCollision(speedX);
                        moveYHandleCollision(speedY);
                }else{
                        moveXHandleCollision(boomX);
                        moveYHandleCollision(boomY);
                }
                if (this.existenceFrames <= 0) {
                        this.mapEntityStatus = MapEntityStatus.REMOVED;
                } 
                existenceFrames--;
                if (intersects(player)&&this.identity == "enemy") {
                    touchedPlayer(player);
                }
       
        }

}

