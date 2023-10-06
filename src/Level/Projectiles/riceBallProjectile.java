package Level.Projectiles;
import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Utils.Point;
import Level.Projectile;
public class riceBallProjectile extends Projectile {

        public riceBallProjectile(float x, float y, SpriteSheet spriteSheet) {
                super(x, y, new SpriteSheet(ImageLoader.load("riceBallProjectile.png"), 14, 14), "STAND_LEFT", null);
        }
        
}
