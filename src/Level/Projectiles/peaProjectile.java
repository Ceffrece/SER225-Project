package Level.Projectiles;

import java.util.HashMap;

import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Utils.Direction;
import Utils.Point;
import Level.Player;
import Level.Projectile;
import Builders.FrameBuilder;


public class peaProjectile extends Projectile {
        private float speedX;
        private float speedY;
        private int existenceFrames = 300;
        private int hasDirection = 0;
        public peaProjectile(Point location,GameObject object) {
                super(location, new SpriteSheet(ImageLoader.load("peaProjectile.png"), 16, 16), "DEFAULT", null);
                super.setIdentity(identity);
                super.setDamage(20);
                initialize();
                
        }
        public void getProjectileDirection(Player player){
                if (hasDirection ==0){ 
                        if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  1.5f;
                                speedX = -1.5f; 

                        }
                        else if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.RIGHT) {
                                speedY =  1.5f;
                                speedX = 1.5f; 

                        }
                        else if (player.getFacingDirection() == Direction.UP && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  -1.5f;
                                speedX = -1.5f; 

                        }
                        else if (player.getFacingDirection() == Direction.UP && player.getLastWalkingXDirection() == Direction.RIGHT) {
                                speedY =  -1.5f;
                                speedX = 1.5f; 

                        }
                        else if (player.getFacingDirection() == Direction.RIGHT) {
                                speedX = 1.5f;
                        } 
                        else if (player.getFacingDirection() == Direction.LEFT) {
                                speedX = -1.5f; 
                        }
                        else if (player.getFacingDirection() == Direction.UP) {
                                speedY = -1.5f;
    
                        }
                         else if (player.getFacingDirection() == Direction.DOWN) {
                            speedY =  1.5f;
    
                        }
                    

                }
                hasDirection++;
               
        }
        @Override
        public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
            return new HashMap<String, Frame[]>() {{
                put("DEFAULT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(2)
                            .withBounds(1, 1, 16, 16)
                            .build()
            });
        }};
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

