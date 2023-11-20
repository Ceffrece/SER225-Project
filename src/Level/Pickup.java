package Level;

import java.awt.Color;
import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Utils.Point;

public class Pickup extends Item{
    private int xpValue;
    private boolean xp;
    private boolean coinPick;
    public Pickup (Point location, SpriteSheet ss, String startingAnimation, int xpValue){
        super(location, ss, startingAnimation);
        this.xpValue = xpValue;
        xp = true;
        showDescription = false;
        initialize();
    }
    public Pickup (Point location){
        super(location, new SpriteSheet(ImageLoader.load("GUISprites/Coin.png"),16,16),"DEFAULT");
        showDescription = false;
        coinPick = true;
        initialize();
    }
    public void update(Player player){
        if(this.overlaps(player)){
            this.setMapEntityStatus(MapEntityStatus.REMOVED);

        }
        if(this.mapEntityStatus == MapEntityStatus.REMOVED) {
            if(xp){
                Player.playerXPLevel += this.xpValue;
            }
            else if (coinPick){
                Currency.normalCurrency ++;
            }

        }

       
        super.update();
    }

    public void initialize() {
        super.initialize();
    }
    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        if (map != null) {
            graphicsHandler.drawImage(
                            currentFrame.getImage(),
                            Math.round(getCalibratedXLocation()),
                            Math.round(getCalibratedYLocation()),
                            currentFrame.getWidth(),
                            currentFrame.getHeight(),
                            currentFrame.getImageEffect());

            // Uncomment this to draw bounds to screen -- useful for debugging
            
            //if (this instanceof Pickup) {
            //        drawBounds(graphicsHandler, new Color(255, 0, 0, 100));
            //}
            
    } else {
            super.draw(graphicsHandler);
    }
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
