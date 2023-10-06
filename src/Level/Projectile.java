package Level;

import GameObject.GameObject;
import GameObject.SpriteSheet;
import GameObject.Frame;

import java.util.HashMap;

public class Projectile extends MapEntity{

        public Projectile(float x, float y, SpriteSheet spriteSheet, String startingAnimation, String identity) {
                super(x, y, spriteSheet, startingAnimation);
                super.setIdentity(identity);
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
        
            @Override
            public void initialize() {
                super.initialize();
            }
        
            public void update(Player player) {
                super.update();
                if (intersects(player)) {
                    touchedPlayer(player);
                }
            }
        
            // A subclass can override this method to specify what it does when it touches the player
            public void touchedPlayer(Player player) {
                
                player.hurtPlayer(this);
            }
        }


