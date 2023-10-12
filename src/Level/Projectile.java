package Level;

import GameObject.SpriteSheet;
import Level.Projectiles.peaProjectile;
import Level.Projectiles.riceBallProjectile;
import NPCs.Dinosaur;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.Sprite;
import Utils.Direction;

import java.awt.Point;
import java.util.HashMap;

import javax.swing.text.DefaultEditorKit.CutAction;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;

public class Projectile extends MapEntity{

        private float speed;
        private String curentProjectile = "riceBallProjectile";
        private int projectileChosen = 0;
        private int existenceFrames = 300;
        public Projectile(Utils.Point location, SpriteSheet spriteSheet, String startingAnimation, String identity, float speed) {
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
             
            public Projectile(Utils.Point location, String currentProjectile,GameObject object) {
                super(location.x, location.y);
                super.setIdentity(identity);
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
                if (hasCollided) {
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                }
            }
            public void onEndCollisionCheckY(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) {
                // if projectile collides with anything solid on the x axis, it is removed
                if (hasCollided) {
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                }
            }
            public void currentProjectile(String currentProjectile,GameObject object){
                if (projectileChosen == 0){ 
                    switch(currentProjectile){
                        case "peaProjectile":
                             peaProjectile projectile = new peaProjectile(object.getLocation(),1.5f, object);
                             map.addProjectile(projectile);
                             projectileChosen+= 1;
                             break;
                        case "riceBallProjectile":
                             riceBallProjectile projectile2 = new riceBallProjectile(object.getLocation(),1.5f, object);
                             map.addProjectile(projectile2);
                             projectileChosen+= 1;
                             break;
                        default:
                            break;
                    }
                    System.out.println(projectileChosen);
                    projectileChosen++;
            }
        }
            public void update(GameObject object) {
                currentProjectile(curentProjectile, object);
                super.update();

                if (existenceFrames == 0) {
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                } else {
                    
                    super.update();
                }
                existenceFrames--;
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
                                .withBounds(1, 1, 5, 5)
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
        
}


