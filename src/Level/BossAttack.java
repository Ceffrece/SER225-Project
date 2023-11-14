package Level;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Utils.Point;

public class BossAttack extends MapEntity{
    
    public int hurtFrames;
    private String identity;
    private int width;
    private int height;

    public BossAttack(Point point, SpriteSheet ss, String startingAnimation, int width, int height){
        super(point.x,point.y,ss,startingAnimation);
        isUncollidable = true;
        this.identity = "enemy";
        this.width = width;
        this.height = height;

        initialize();
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void initialize(){
        super.initialize();
    }

    public void update(Player player){
        super.update();
        this.hurtFrames++;

        if(this.overlaps(player) && hurtFrames > 50){
            if(this.identity.equals("enemy")){
                player.hurtPlayer(this);
                this.setMapEntityStatus(MapEntityStatus.REMOVED);
            }
        }
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
