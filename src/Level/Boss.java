package Level;

import java.awt.Color;
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
    public int floorLevel;

    public Boss(Point location, SpriteSheet ss, String startingAnimation, int health, int floorLevel){
        super(location.x, location.y, ss, startingAnimation);
        random = new SecureRandom();
        isUncollidable = false;
        identity = "boss";
        this.health = health;
        this.floorLevel = floorLevel;
        initialize();
    }

    public void attack(int num){
        int value = (num*this.floorLevel);
        switch(value){
            case 1 : attack1(); break;
            case 2 : attack2(); break;
            case 3 : attack3(); break;
            case 4 : attack4(); break;
            case 5 : attack5(); break;
            case 6 : attack6(); break;
            case 7 : attack7(); break;
            case 8 : attack8(); break;
            case 9 : attack9(); break;
            case 10 : attack10(); break;
            case 11 : attack11(); break;
            case 12 : attack12(); break;
            case 13 : attack13(); break;
            case 14 : attack14(); break;
            case 15 : attack15(); break;
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

    private void attack6() {
        System.out.println("Attack 6");
    }

    private void attack7() {
        System.out.println("Attack 7");
    }

    private void attack8() {
        System.out.println("Attack 8");
    }

    private void attack9() {
        System.out.println("Attack 9");
    }

    private void attack10() {
        System.out.println("Attack 10");
    }

    private void attack11() {
        System.out.println("Attack 11");
    }

    private void attack12() {
        System.out.println("Attack 12");
    }

    private void attack13() {
        System.out.println("Attack 13");
    }

    private void attack14() {
        System.out.println("Attack 14");
    }

    private void attack15() {
        System.out.println("Attack 15");
    }
    
    public void update(Player player){
        super.update();
        this.attackCounter++;
        if(attackCounter >= 250){
            attack(random.nextInt(1,6));
            attackCounter = 0;
        }
    }

    @Override
    public void hurtEnemy(int damage){
        this.health -= damage;
        if(this.health <= 0){
            this.setMapEntityStatus(MapEntityStatus.REMOVED);
        }
        System.out.println("Boss Health = " + this.health);
    }
    public void initialize(){
        super.initialize();
    }
    @Override
    public int getHealth(){
        return this.health;
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

            // Uncomment this to draw player's bounds to screen -- useful for debugging
            
            if (this instanceof Boss) {
                    drawBounds(graphicsHandler, new Color(255, 0, 0, 100));
            }
            
    } else {
            super.draw(graphicsHandler);
    }
    }
    @Override
            public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
                return new HashMap<String, Frame[]>() {{
                    put("DEFAULT", new Frame[]{
                        new FrameBuilder(spriteSheet.getSprite(0, 0))
                                .withScale(5)
                                .withBounds(0, 0, 100, 40)
                                .build()
                });
            }};
        }
}
