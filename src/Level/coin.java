package Level;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Utils.Point;

public class coin extends Item{
    
    public coin (Point location){
        super(location, new SpriteSheet(ImageLoader.load("GUISprites/HeartFull.png"),5,5),"DEFAULT");
        showDescription = false;
        initialize();
    }

    public void update(Player player){
        // if(this.overlaps(player)){
        //     this.setMapEntityStatus(MapEntityStatus.REMOVED);

        // }
        // if(this.mapEntityStatus == MapEntityStatus.REMOVED) {
        //     Currency.normalCurrency += 1;

        // }
System.out.println("ASDASD");
       
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
