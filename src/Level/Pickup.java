package Level;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Utils.Point;

public class Pickup extends Item{
    private int xpValue;

    public Pickup (Point location, SpriteSheet ss, String startingAnimation, int xpValue){
        super(location, ss, startingAnimation);
        this.xpValue = xpValue;
        initialize();
    }

    public void update(Player player){
        if(this.overlaps(player)){
            this.setMapEntityStatus(MapEntityStatus.REMOVED);
        }
        if(this.mapEntityStatus == MapEntityStatus.REMOVED) {
            Player.playerXPLevel += this.xpValue;
        }
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
                                .withBounds(0, 0, 7, 7)
                                .build()
                });
            }};
        }
}
