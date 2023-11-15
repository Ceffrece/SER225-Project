package Level;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ScreenManager;
import GameObject.Frame;
import GameObject.SpriteSheet;
import SpriteFont.SpriteFont;
import Utils.Point;
import Engine.GamePanel;

import java.awt.*;


public class Item extends MapEntity{
	private GraphicsHandler graphicsHandler;
    public Boolean showDescription;
    public int cost;
    public boolean dontShowDesc;

    public boolean heldByPlayer = false;
    public boolean hasImpartedStat = false;

    public int statIncrease;
    public String stat;

    public String curentItemPNG;
    public String projectileToAdd;
    
    public String description;
    public Item(Point location, SpriteSheet ss, String startingAnimation, String stat, int statIncrease,String inventoryIcon){
        super(location.x,location.y,ss,startingAnimation);
        isUncollidable = true;
        setCurentItemPNG(inventoryIcon);
        this.statIncrease = statIncrease;
        this.stat = stat;


        initialize();
    }
    //Constructor for Pickup projectiles
    public Item(Point location, SpriteSheet ss, String startingAnimation,String projectileToAdd, String description, int cost){
        super(location.x,location.y,ss,startingAnimation);
        this.projectileToAdd = projectileToAdd;
        this.cost = cost;
        this.description = description;
        dontShowDesc = false;
        isUncollidable = true;

        initialize();

    }
    public Item(Point location, SpriteSheet ss, String startingAnimation) {
        super(location.x,location.y,ss,startingAnimation);
        this.projectileToAdd = projectileToAdd;
        isUncollidable = true;
        dontShowDesc = true;
        initialize();
}
public Item(float x, float y) {
    super(x, y);
    }
	private SpriteFont itemDescriptionText;

public void update(Player player) {
    if(this.overlaps(player)){
        showDescription = true;
    }
    else {
        showDescription = false;

    }
    super.update();


    }
    public void initialize() {
        super.initialize();
    }
    public Font font = new Font("Chalkduster", Font.PLAIN, 15);
	private SpriteFont descrptionTextSprite;
	private SpriteFont CostText;



    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        
        CostText = new SpriteFont(cost + "", (int)this.getCalibratedXLocation(), (int)this.getCalibratedYLocation()-100,"Chalkduster", 50, Color. BLACK);
   
        descrptionTextSprite = new SpriteFont(description, (int)this.getCalibratedXLocation(), (int)this.getCalibratedYLocation()-30,"Chalkduster", 20, Color. BLACK);
        super.draw(graphicsHandler);
        if(showDescription){
            graphicsHandler.drawFilledRectangle((int)this.getCalibratedXLocation(), (int)this.getCalibratedYLocation()-30, 160,30, new Color(200, 200, 200, 255));
            descrptionTextSprite.draw(graphicsHandler);
            CostText.draw(graphicsHandler);
        }


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
