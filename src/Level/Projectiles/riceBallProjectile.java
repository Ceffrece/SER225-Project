package Level.Projectiles;

import Engine.ImageLoader;

import GameObject.SpriteSheet;
import Utils.Direction;
import Utils.Point;
import Level.Player;
import Level.Projectile;


public class riceBallProjectile extends Projectile {
        private float speedX;
        private float speedY;
        private int existenceFrames = 300;
        private int hasDirection = 0;
        public riceBallProjectile(Point location, float speed,Player player) {
                super(location.x, location.y, new SpriteSheet(ImageLoader.load("riceBallProjectile.png"), 16, 16), "DEFAULT", null, speed);
                super.setIdentity(identity);

                
                initialize();
                
        }
        public void getProjectileDirection(Player player){
                if (hasDirection ==0){ 
                        if (player.getFacingDirection() == Direction.RIGHT) {
                                speedX = 1.5f;
                        } 
                        else if (player.getFacingDirection() == Direction.LEFT) {
                                speedX = -1.5f; 
                        }
                        else if (player.getFacingDirection() == Direction.UP) {
                                speedY = -1.5f;
    
                        }
                         else if (player.getFacingDirection() == Direction.DOWN) {
                            speedY = -1.5f;
    
                        }
                    

                }
                hasDirection++;
               
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

