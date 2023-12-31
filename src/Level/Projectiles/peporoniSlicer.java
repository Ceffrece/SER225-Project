package Level.Projectiles;

import java.util.HashMap;

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
import Builders.FrameBuilder;


public class peporoniSlicer extends Projectile {
        private float speedX;
        private float speedY;

        private int existenceFrames = (Player.attackRange)*50;
        int turn = existenceFrames/2;

        private int hasDirection = 0;

        private static int shootTime = 300;

        public static String projectileID = "pepPro";
        public static String projectilePng = "Projectiles/pepIcon.png";
        
        public peporoniSlicer(Point location,GameObject object) {

                super(location, new SpriteSheet(ImageLoader.load("Projectiles/pepPro.png"), 16, 16), "DEFAULT",40);
                
                super.setIdentity(identity);

                this.shootTime = shootTime;
                super.projectileID = projectileID;
                super.projectilePng = projectilePng;

                super.setExistenceFrames(existenceFrames);
                super.setDamage(Player.attackDamage*5+5);

                initialize();
                
        }
        public void getProjectileDirection(Player player){
                if (hasDirection ==0){ 
                        if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  5.0f;
                                speedX = -5.0f; 

                        }
                        else if (player.getFacingDirection() == Direction.DOWN && player.getLastWalkingXDirection() == Direction.RIGHT) {
                                speedY =  5.0f;
                                speedX = 5.0f; 

                        }
                        else if (player.getFacingDirection() == Direction.UP && player.getLastWalkingXDirection() == Direction.LEFT) {
                                speedY =  -5.0f;
                                speedX = -5.0f; 

                        }
                        else if (player.getFacingDirection() == Direction.UP && player.getLastWalkingXDirection() == Direction.RIGHT) {
                                speedY =  -5.0f;
                                speedX = 5.0f; 

                        }
                        else if (player.getFacingDirection() == Direction.RIGHT) {
                                speedX = 5.0f;
                        } 
                        else if (player.getFacingDirection() == Direction.LEFT) {
                                speedX = -5.0f; 
                        }
                        else if (player.getFacingDirection() == Direction.UP) {
                                speedY = -5.0f;
    
                        }
                         else if (player.getFacingDirection() == Direction.DOWN) {
                            speedY =  5.0f;
    
                        }
                    

                }
                hasDirection++;
               
        }
        @Override
        public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
            return new HashMap<String, Frame[]>() {{
                put("DEFAULT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0),5)
                            .withScale(2)
                            .withBounds(4, 4, 8, 8)
                            .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 1),5)
                            .withScale(2)
                            .withBounds(4, 4, 8, 8)
                            .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 0),5)
                            .withScale(2)
                            .withBounds(4, 4, 8, 8)
                            .withImageEffect(ImageEffect.FLIP_H_AND_V)
                            .build(),
                        new FrameBuilder(spriteSheet.getSprite(0, 1),5)
                            .withScale(2)
                            .withBounds(4, 4, 8, 8)
                            .withImageEffect(ImageEffect.FLIP_H_AND_V)
                            .build()
                
            });
        }};
}
        
        public String getCurentProjectilePNG(){
                return "Projectiles/pepIcon.png";
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

