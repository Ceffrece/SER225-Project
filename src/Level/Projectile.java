package Level;

import GameObject.SpriteSheet;
import Level.Projectiles.peaProjectile;
import Level.Projectiles.riceBallProjectile;
import GameObject.Frame;
import Utils.Direction;

import java.awt.Point;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;

public class Projectile extends MapEntity{
        

        private float speed;
        private String curentProjectile;
        private int projectileChosen = 0;
        private int existenceFrames = 300;
        protected int damage = 10;
        public String projectileID;
        public static String projectilePng;

        public Projectile(Utils.Point location, SpriteSheet spriteSheet, String startingAnimation, String identity) {
                super(location.x, location.y, spriteSheet, startingAnimation);
                super.setIdentity(identity);

                initialize();
            }
        
            public Projectile(float x, float y, HashMap<String, Frame[]> animations, String startingAnimation) {
                super(x, y, animations, startingAnimation);
            }
        
            public Projectile(float x, float y, Frame[] frames) {
                super(x, y, frames);
            }
        
            public Projectile(float x, float y, Frame frame) {
                super(x, y, frame);
            }
        
            public Projectile(float x, float y) {
                super(x, y);
            }
             
            public Projectile(Utils.Point location, String currentProjectile, Player player) {
                super(location.x, location.y);
                super.setIdentity(identity);
                setCurentProjectile(currentProjectile);
            }

            public void setSpeed(float speed){
                this.speed = speed;
            }
            public boolean isAlive() {
                // Code to check if the projectile is still active
                return true;
            }
            
            
            @Override
            public void initialize() {
                super.initialize();
            }
            @Override
            public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
                // if projectile collides with anything solid on the x axis, it is removed
                if (hasCollided && !map.enemies.contains(entityCollidedWith)) {
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                }else if (hasCollided){
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                    touchedEnemy(entityCollidedWith);
                }
            }
            public void onEndCollisionCheckY(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
                // if projectile collides with anything solid on the x axis, it is removed
                
                if (hasCollided && !map.enemies.contains(entityCollidedWith)) {
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                }else if (hasCollided){
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                    touchedEnemy(entityCollidedWith);
                }
                
                
            }
            public void currentProjectile(String currentProjectile,Player player){
                if (projectileChosen ==0){ 
                    switch(currentProjectile){
                        case "peaProjectile":
                             peaProjectile projectile = new peaProjectile(player.getLocation(), player);
                             map.addProjectile(projectile);
                             break;
                        case "riceBallProjectile":
                             riceBallProjectile projectile2 = new riceBallProjectile(player.getLocation(), player);
                             map.addProjectile(projectile2);
                             break;
                        default:
                            break;
                    }
                projectileChosen++;
            }
        }
            public void update(Player player) {
                currentProjectile(curentProjectile, player);
                super.update();

                if (existenceFrames == 0) {
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                } 
                else {
                    
                    super.update();
                }
                
                existenceFrames--;

            }

            public void touchedEnemy(MapEntity enemy){
                // for (int i = 0; i < map.enemies.size(); i++) {
                //     if(overlaps(map.enemies.get(i))){
                //         System.out.println(this.damage);
                //         map.enemies.get(i).hurtEnemy(this.damage);                        
                //     }
                //   }
                enemy.hurtEnemy(this.damage);
            }
            
            // A subclass can override this method to specify what it does when it touches the player
            public void touchedPlayer(Player player) {
                if (this.identity == "enemy"){
                    player.hurtPlayer(this);
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
                                .withBounds(1, 1, 16, 16)
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
            super.draw(graphicsHandler);
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
        
}