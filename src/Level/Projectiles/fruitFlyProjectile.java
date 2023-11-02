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


public class fruitFlyProjectile extends Projectile {
        private float speedX;
        private float speedY;
        private float CircleX;
        private float CircleY;
        private int existenceFrames = (Player.attackRange)*75;
        float turn = existenceFrames/1.5f;
        private int hasDirection = 0;
        private SpriteSheet spriteSheet;

        private static int shootTime = 100;

        public static String projectileID = "fruitFlyProjectile";
        public static String projectilePng = "Projectiles/fruitFlyProjectile.png";

        public fruitFlyProjectile(Point location,GameObject object) {
                super(location, new SpriteSheet(ImageLoader.load("Projectiles/fruitFlyProjectile.png"), 16, 16), "DEFAULT",150);
                super.setIdentity(identity);

                super.projectileID = projectileID;
                super.projectilePng = projectilePng;

                super.existenceFrames = existenceFrames;
                int turn = existenceFrames/2;

                spriteSheet = new SpriteSheet(ImageLoader.load("Projectiles/fruitFlyProjectile.png"), 16, 16);
                update();
                super.setDamage(Player.attackDamage*10);
                initialize();
                
        }
        
        
        public void getProjectileDirection(Player player){
                if (hasDirection ==0){ 
                        if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  3.5f;
                                speedX = -3.5f; 

                                CircleY = -3.5f;
                                CircleX = 3.5f;
                        }
                        else if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.RIGHT) {
                                speedY =  3.5f;
                                speedX = 3.5f; 

                                CircleY = -3.5f;
                                CircleX = -3.5f;
                        }
                        else if (player.getFacingDirection() == Direction.UP && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  -3.5f;
                                speedX = -3.5f;

                                CircleY = 3.5f;
                                CircleX = 3.5f;
                        }
                        else if (player.getFacingDirection() == Direction.UP && player.getLastWalkingXDirection() == Direction.RIGHT) {
                                speedY =  -3.5f;
                                speedX = 3.5f; 

                                CircleY = 3.5f;
                                CircleX = -3.5f;
                        }
                        else if (player.getFacingDirection() == Direction.RIGHT) {
                                speedX = 3.5f;

                                CircleX = -3.5f;

                        } 
                        else if (player.getFacingDirection() == Direction.LEFT) {
                                speedX = -3.5f; 

                                CircleX = 3.5f;
                        }
                        else if (player.getFacingDirection() == Direction.UP) {
                                speedY = -3.5f;

                                CircleX = 3.5f;

                        }
                         else if (player.getFacingDirection() == Direction.DOWN) {
                            speedY =  3.5f;

                            CircleX = -3.5f;

    
                        }
                       
                }
                hasDirection++;
               
        }
        @Override
            public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
                return new HashMap<String, Frame[]>() {{
                put("DEFAULT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 0))
                                .withScale(3)
                                .withBounds(6, 12, 16, 16)
                                .build()
                });
            }};
            
        }
        public String getCurentProjectilePNG(){
                return "Projectiles/fruitFlyProjectile.png";
        }
        public void update(Player player) {
                super.update();
                
                getProjectileDirection(player);
                loadAnimations(spriteSheet);

                if (existenceFrames > turn) {
                        moveXHandleCollision(speedX);
                        moveYHandleCollision(speedY);
                    } else {
                        rotateAroundPlayer(player);
                    }
                if (this.existenceFrames <= 0) {
                        this.mapEntityStatus = MapEntityStatus.REMOVED;
                } 
                existenceFrames--;
                if (intersects(player)&&this.identity == "enemy") {
                    touchedPlayer(player);
                }
       
        }
        private float angle = 0;

        public void rotateAroundPlayer(Player player) {
                // Calculate the distance (radius) between the projectile and the player
                float distance = (float) Math.sqrt(Math.pow(this.getX() - player.getX(), 2) + Math.pow(this.getY() - player.getY(), 2));
            
                // Update the angle of rotation
                angle += 0.05; // You can adjust this value to change the speed of rotation
            
                // Calculate the new x and y positions using trigonometric functions
                CircleX = player.getX() + distance * (float) Math.cos(angle);
                CircleY = player.getY() + distance * (float) Math.sin(angle);
            
                // Move the projectile to the new position
                moveXHandleCollision(CircleX - this.getX()); // offset x
                moveYHandleCollision(CircleY - this.getY()); // offset y
            }
}

