package Level.Projectiles;

import java.util.HashMap;

import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Utils.Direction;
import Utils.Point;
import Level.MapEntityStatus;
import Level.Player;
import Level.Projectile;
import Builders.FrameBuilder;


public class peaProjectile extends Projectile {
        private float speedX;
        private float speedY;

        private int existenceFrames = (Player.attackRange)*50;
        int turn = existenceFrames/2;

        private int hasDirection = 0;

        private static int shootTime = 300;

        public static String projectileID = "peaProjectile";
        public static String projectilePng = "peaProjectile.png";
        
        public peaProjectile(Point location,GameObject object) {

                super(location, new SpriteSheet(ImageLoader.load("peaProjectile.png"), 16, 16), "DEFAULT",100);
                
                super.setIdentity(identity);

                this.shootTime = shootTime;
                super.projectileID = projectileID;
                super.projectilePng = projectilePng;

                super.setExistenceFrames(existenceFrames);
                super.setDamage(Player.attackDamage*15+5);

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
        
        public String getCurentProjectilePNG(){
                return "peaProjectile.png";
        }
        public void update(Player player) {
                super.update();

                
                getProjectileDirection(player);

                moveXHandleCollision(speedX);
                moveYHandleCollision(speedY);

                if (this.existenceFrames <= 0) {
                        this.mapEntityStatus = MapEntityStatus.REMOVED;
                    } 
                if (intersects(player)|| this.identity == "enemy") {
                    touchedPlayer(player);
                }
                existenceFrames --;
       
        }
        

}

