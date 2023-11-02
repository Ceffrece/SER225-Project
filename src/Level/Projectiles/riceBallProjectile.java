package Level.Projectiles;

import Engine.ImageLoader;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Utils.Direction;
import Utils.Point;
import Level.MapEntityStatus;
import Level.Player;
import Level.Projectile;


public class riceBallProjectile extends Projectile {
        private float speedX;
        private float speedY;
        private int existenceFrames = (Player.attackRange)*55;
        private int hasDirection = 0;

        private static int shootTime = 100;

        public static String projectileID = "riceBallProjectile";
        public static String projectilePng = "Projectiles/riceBallProjectile.png";

        public riceBallProjectile(Point location,GameObject object) {
                super(location, new SpriteSheet(ImageLoader.load("Projectiles/riceBallProjectile.png"), 16, 16), "DEFAULT",100);
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
                return "Projectiles/riceBallProjectile.png";
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

