package Level;

import java.security.SecureRandom;
import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Utils.Point;

public class Boss extends Enemy{
    public int health;
    public int attackCounter = 0;
    public SecureRandom random;
    public String itentity;

    public Boss(Point location, SpriteSheet ss, String startingAnimation){
        super(location.x, location.y, ss, startingAnimation);
        random = new SecureRandom();
        initialize();
    }

    public void attack(int num){
        switch(num){
            case 1 : attack1(); break;
            case 2 : attack2(); break;
            case 3 : attack3(); break;
            case 4 : attack4(); break;
            case 5 : attack5(); break;
        }
    }

    private void attack1(){
        System.out.println("Attack 1");
    }

    private void attack2(){
        System.out.println("Attack 2");
    }

    private void attack3(){
        System.out.println("Attack 3");
    }

    private void attack4(){
        System.out.println("Attack 4");
    }

    private void attack5(){
        System.out.println("Attack 5");
    }

    public void update(Player player){
        super.update();
        this.attackCounter++;
        if(attackCounter >= 250){
            attack(random.nextInt(1,6));
            attackCounter = 0;
        }
        if(map.projectiles.contains())
    }

    public void initialize(){
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
                                .withBounds(0, 0, 100, 100)
                                .build()
                });
            }};
        }
}
