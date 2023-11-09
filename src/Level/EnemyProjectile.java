package Level;

import GameObject.SpriteSheet;
import Level.Projectiles.bannanaProjectile;
import Level.Projectiles.carrotProjectile;
import Level.Projectiles.fruitFlyProjectile;
import Level.Projectiles.peaProjectile;
import Level.Projectiles.peporoniSlicer;
import Level.Projectiles.riceBallProjectile;
import GameObject.Frame;
import Utils.Direction;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;

public class EnemyProjectile extends MapEntity{
        //this will help see what projectile is being fired
        private String curentProjectile;
        //index for what projectile is going to be shot
        private int projectileChosen = 0;

        protected int existenceFrames = (Enemy.attackRange)*25+50;
        int turn = existenceFrames/2;

        protected int damage;

        public String projectileID;
        public static String projectilePng;

        public int shootTime;

        private String projectileDescription;

        public EnemyProjectile(Utils.Point location, SpriteSheet spriteSheet, String startingAnimation, int shootTime) {
                super(location.x, location.y, spriteSheet, startingAnimation);
                this.shootTime = shootTime;                
            }
        
            public EnemyProjectile(float x, float y, HashMap<String, Frame[]> animations, String startingAnimation) {
                super(x, y, animations, startingAnimation);
            }
        
            public EnemyProjectile(float x, float y, Frame[] frames) {
                super(x, y, frames);
            }
        
            public EnemyProjectile(float x, float y, Frame frame) {
                super(x, y, frame);
            }
        
            public EnemyProjectile(float x, float y) {
                super(x, y);
            }
             
            public EnemyProjectile(Utils.Point location, String currentProjectile, Enemy enemy) {
                super(location.x, location.y);
                super.setIdentity(identity);

                setCurentProjectile(currentProjectile);
            }
            


            
            public boolean isAlive() {
                // Code to check if the projectile is still active
                return true;
            }
            
            
            
            //@Override
            public void onEndCollisionCheckX(boolean hasCollided, Direction direction, Player playerCollidedWith) {                
                // if projectile collides with anything solid on the x axis, it is removed
                if (hasCollided && !map.players.contains(playerCollidedWith)){
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                }else if (hasCollided){
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                    touchedPlayer(playerCollidedWith);
                }
            }
            // entityCollidedWith.overlaps(this)
            // this.overlaps(entityCollidedWith)
            public void onEndCollisionCheckY(boolean hasCollided, Direction direction, Player playerCollidedWith) {
                // if projectile collides with anything solid on the x axis, it is removed
                if (hasCollided && !map.players.contains(playerCollidedWith)) {
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                }else if (hasCollided){
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                    touchedPlayer(playerCollidedWith);
                }
            }
            public void currentProjectile(String currentProjectile, MapEntity enemy){
                if (projectileChosen == 0){ 
                    switch(currentProjectile){
                        case "peaProjectile":
                             peaProjectile projectile = new peaProjectile(enemy.getLocation(), enemy);
                             map.addProjectile(projectile);

                             break;
                        case "riceBallProjectile":
                             riceBallProjectile projectile2 = new riceBallProjectile(enemy.getLocation(), enemy);

                             map.addProjectile(projectile2);
                             break;
                        case "bannanaProjectile":
                             bannanaProjectile projectile3 = new bannanaProjectile(enemy.getLocation(), enemy);
                             map.addProjectile(projectile3);
                             break;
                        case "fruitFlyProjectile":
                            fruitFlyProjectile projectile4 = new fruitFlyProjectile(enemy.getLocation(), enemy);
                             map.addProjectile(projectile4);
                             break;
                        case "carrotProjectile":
                        carrotProjectile carrotProjectile = new carrotProjectile(enemy.getLocation(), enemy);
                             map.addProjectile(carrotProjectile);
                             break;
                        case "pepPro":
                                peporoniSlicer peporoniSlicer = new peporoniSlicer(enemy.getLocation(), enemy);
                                  map.addProjectile(peporoniSlicer);
                                  break;
                        default:
                            break;
                    }
                projectileChosen++;
            }
        }
            public void update(MapEntity enemy) {
                currentProjectile(curentProjectile, enemy);
                super.update();
            }       
            public void touchedPlayer(Player player){
                player.hurtPlayer(this);
            }
            
            // A subclass can override this method to specify what it does when it touches the player
            public void touchedEnemy(MapEntity enemy) {
                if (this.identity == "player"){
                    enemy.hurtEnemy(this.damage);
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                }
            }
            //Set SpriteSheet
            @Override
            public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
                return new HashMap<String, Frame[]>() {{
                    put("DEFAULT", new Frame[]{
                        new FrameBuilder(spriteSheet.getSprite(0, 0))
                                .withScale(3)
                                .withBounds(5, 4, 7, 7)
                                .build()
                });
            }};
        }
        public void setCurentProjectile(String curentProjectile){
            this.curentProjectile = curentProjectile;
        }
        public String getCurentProjectile(){
            return curentProjectile;
        }
        @Override
        public void draw(GraphicsHandler graphicsHandler) {
            if (map != null) {
                graphicsHandler.drawImage(
                                currentFrame.getImage(),
                                Math.round(getCalibratedXLocation()),
                                Math.round(getCalibratedYLocation()),
                                currentFrame.getWidth(),
                                currentFrame.getHeight(),
                                currentFrame.getImageEffect());

                // Uncomment this to draw player's bounds to screen -- useful for debugging
                
                //if (this instanceof Projectile) {
                //        drawBounds(graphicsHandler, new Color(255, 0, 0, 100));
                //}
                
        } else {
                super.draw(graphicsHandler);
        }
    }
        public String getCurentProjectilePNG(){
            return projectilePng;
    }
    
        
        
        public int getDamage() {
            return damage;
        }
        public void setDamage(int damage) {
            this.damage = damage;
        }
        public void setExistenceFrames(int existenceFrames) {
            this.existenceFrames = existenceFrames;
        }
        public int getExistenceFrames() {
            return existenceFrames;
        }
        public void setShootTime(int shootTime) {
            this.shootTime = shootTime;
        }

        public int getShootTime() {
            return shootTime;
        }
        public void setProjectileDescription(String string) {
            this.projectileDescription=projectileDescription ;
        }
        public String getProjectileDescription() {
            return projectileDescription;
        }
        
}