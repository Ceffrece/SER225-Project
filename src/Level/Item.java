package Level;

import java.util.HashMap;

import javax.swing.text.StyledEditorKit.BoldAction;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Utils.Point;

public class Item extends MapEntity{

    public boolean heldByPlayer = false;
    public boolean hasImpartedStat = false;

    public int statIncrease;
    public String stat;

    public String curentItemPNG;
    public String projectileToAdd;
    

    public Item(Point location, SpriteSheet ss, String startingAnimation, String stat, int statIncrease,String inventoryIcon){
        super(location.x,location.y,ss,startingAnimation);
        isUncollidable = true;
        setCurentItemPNG(inventoryIcon);
        this.statIncrease = statIncrease;
        this.stat = stat;

        initialize();
    }
    //Constructor for Pickup Items
    public Item(Point location, SpriteSheet ss, String startingAnimation,String projectileToAdd){
        super(location.x,location.y,ss,startingAnimation);
        this.projectileToAdd = projectileToAdd;
    
        initialize();
    }
    public Item(Point location, SpriteSheet ss, String startingAnimation) {
        super(location.x,location.y,ss,startingAnimation);
        this.projectileToAdd = projectileToAdd;
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
    public String getCurentItemPNG() {
        return curentItemPNG;
    }
    public void setCurentItemPNG(String inventoryIcon) {
        this.curentItemPNG = inventoryIcon;
    }
    

}
