package Level.Projectiles;

import Engine.ImageLoader;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Utils.Direction;
import Utils.Point;
import Level.Player;
import Level.Projectile;
import NPCs.Dinosaur;


public class riceBallProjectile extends Projectile {
        private float speedX;
        private float speedY;
        private int existenceFrames = 300;
        private int hasDirection = 0;
        public static String projectileID = "riceBallProjectile";
        public static String projectilePng = "riceBallProjectile.png";

        public riceBallProjectile(Point location,GameObject object) {
                super(location, new SpriteSheet(ImageLoader.load("riceBallProjectile.png"), 16, 16), "DEFAULT", null);
                super.setIdentity(identity);
                super.projectileID = projectileID;
                super.projectilePng = projectilePng;

                super.setDamage(50);
                initialize();
                
        }
        public riceBallProjectile(Point location, String currentProjectile, Dinosaur dinosaur) {
                super(location, new SpriteSheet(ImageLoader.load("riceBallProjectile.png"), 16, 16), "DEFAULT", null);
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
        public String getCurentProjectilePNG(){
                return "riceBallProjectile.png";
        }
        public void update(Player player) {
                super.update();
                getProjectileDirection(player);

                moveXHandleCollision(speedX);
                moveYHandleCollision(speedY);


                if (intersects(player)|| this.identity == "enemy") {
                    touchedPlayer(player);
                }
       
        }

}

