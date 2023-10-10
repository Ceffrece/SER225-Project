package Level;

import GameObject.SpriteSheet;
import Level.Projectiles.riceBallProjectile;
import GameObject.Frame;
import Utils.Direction;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;

public class Projectile extends MapEntity{

        private float speed;
        private int existenceFrames = 300;
        public Projectile(float x, float y, SpriteSheet spriteSheet, String startingAnimation, String identity, float speed) {
                super(x, y, spriteSheet, startingAnimation);
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
            public void update(Player player) {
                super.update();
                // if (intersects(player)|| identity == "enemy") {
                //     touchedPlayer(player);
                // }
                // if (player.facingDirection == Direction.RIGHT) {
                //     speed = 1.5f;
                //     moveXHandleCollision(speed);
                // } else if (player.facingDirection == Direction.LEFT) {
                //     speed = -1.5f;
                //     moveXHandleCollision(speed);
                // }
                // else if (player.facingDirection == Direction.UP) {
                //     speed = -1.5f;
                //     moveYHandleCollision(speed);

                // }
                // else if (player.facingDirection == Direction.DOWN) {
                //     speed = -1.5f;
                //     moveYHandleCollision(speed);

                // }
                // if timer is up, set map entity status to REMOVED
                // the camera class will see this next frame and remove it permanently from the map
                if (existenceFrames == 0) {
                    this.mapEntityStatus = MapEntityStatus.REMOVED;
                } else {
                    // move Projectile forward
                    
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
        @Override
        public void draw(GraphicsHandler graphicsHandler) {
            super.draw(graphicsHandler);
        }
        
}


