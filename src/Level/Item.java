package Level;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Utils.Point;

public class Item extends MapEntity{

    public Item(Point location, SpriteSheet ss, String startingAnimation){
        super(location.x,location.y,ss,startingAnimation);
        isUncollidable = true;
        initialize();
    }
    public void update(Player player) {
        super.update();
    }
    public void initialize() {
        super.initialize();
    }
    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
    @Override
            public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
                return new HashMap<String, Frame[]>() {{
                    put("DEFAULT", new Frame[]{
                        new FrameBuilder(spriteSheet.getSprite(0, 0))
                                .withScale(3)
                                .withBounds(0, 0, 50, 50)
                                .build()
                });
            }};
        }

}
