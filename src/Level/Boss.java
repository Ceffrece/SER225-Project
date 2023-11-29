package Level;

import java.awt.Color;
import java.security.SecureRandom;
import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
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
        BossAttack a1 = new BossAttack(getLocation().addY(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a2 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a3 = new BossAttack(getLocation().addY(300).addX(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a1);
        map.addAttack(a2);
        map.addAttack(a3);
    }

    private void attack2(){
        BossAttack a1 = new BossAttack(getLocation().addY(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a4 = new BossAttack(getLocation().addY(300).addX(100), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a5 = new BossAttack(getLocation().addY(300).addX(-100), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a6 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);       
        BossAttack a7 = new BossAttack(getLocation().addY(300).addX(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);                
        map.addAttack(a1);
        map.addAttack(a4);
        map.addAttack(a5);
        map.addAttack(a6);
        map.addAttack(a7);
    }

    private void attack3(){
        BossAttack a8 = new BossAttack(getLocation().addY(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a9 = new BossAttack(getLocation().addY(200).addX(100), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a10 = new BossAttack(getLocation().addY(300).addX(20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a11 = new BossAttack(getLocation().addY(300).addX(250), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a12 = new BossAttack(getLocation().addY(200).addX(400), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a13 = new BossAttack(getLocation().addY(230).addX(-20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a8);
        map.addAttack(a9);
        map.addAttack(a10);
        map.addAttack(a11);
        map.addAttack(a12);
        map.addAttack(a13);
    }

    private void attack4(){
        BossAttack a1 = new BossAttack(getLocation().addY(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a2 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a5 = new BossAttack(getLocation().addY(300).addX(-100), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a7 = new BossAttack(getLocation().addY(300).addX(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);                
        BossAttack a13 = new BossAttack(getLocation().addY(230).addX(-20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a1);
        map.addAttack(a2);
        map.addAttack(a5);
        map.addAttack(a7);
        map.addAttack(a13);
    }

    private void attack5(){
        BossAttack a3 = new BossAttack(getLocation().addY(300).addX(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a4 = new BossAttack(getLocation().addY(300).addX(100), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a6 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);       
        BossAttack a10 = new BossAttack(getLocation().addY(300).addX(20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a12 = new BossAttack(getLocation().addY(200).addX(400), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a3);
        map.addAttack(a4);
        map.addAttack(a6);
        map.addAttack(a10);
        map.addAttack(a12);
    }

    private void attack6() {
        BossAttack a8 = new BossAttack(getLocation().addY(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a13 = new BossAttack(getLocation().addY(230).addX(-20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a11 = new BossAttack(getLocation().addY(300).addX(250), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a1 = new BossAttack(getLocation().addY(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a9 = new BossAttack(getLocation().addY(200).addX(100), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a9);
        map.addAttack(a1);
        map.addAttack(a11);
        map.addAttack(a13);
        map.addAttack(a8);
    }

    private void attack7() {
        BossAttack a9 = new BossAttack(getLocation().addY(200).addX(100), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a13 = new BossAttack(getLocation().addY(230).addX(-20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a6 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);       
        BossAttack a4 = new BossAttack(getLocation().addY(300).addX(100), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a10 = new BossAttack(getLocation().addY(300).addX(20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a10);
        map.addAttack(a4);
        map.addAttack(a13);
        map.addAttack(a6);
        map.addAttack(a9);
    }

    private void attack8() {
        BossAttack a6 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);       
        BossAttack a13 = new BossAttack(getLocation().addY(230).addX(-20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a3 = new BossAttack(getLocation().addY(300).addX(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a1 = new BossAttack(getLocation().addY(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a8 = new BossAttack(getLocation().addY(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a8);
        map.addAttack(a6);
        map.addAttack(a13);
        map.addAttack(a3);
        map.addAttack(a1);
    }

    private void attack9() {
        BossAttack a11 = new BossAttack(getLocation().addY(300).addX(250), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a6 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);       
        BossAttack a2 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a10 = new BossAttack(getLocation().addY(300).addX(20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a12 = new BossAttack(getLocation().addY(200).addX(400), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a12);
        map.addAttack(a10);
        map.addAttack(a2);
        map.addAttack(a6);
        map.addAttack(a11);        
    }

    private void attack10() {
        BossAttack a6 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);       
        BossAttack a12 = new BossAttack(getLocation().addY(200).addX(400), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a3 = new BossAttack(getLocation().addY(300).addX(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a8 = new BossAttack(getLocation().addY(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a4 = new BossAttack(getLocation().addY(300).addX(100), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a4);
        map.addAttack(a8);
        map.addAttack(a12);
        map.addAttack(a6);       
        map.addAttack(a3); 
    }

    private void attack11() {
        BossAttack a6 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);       
        BossAttack a8 = new BossAttack(getLocation().addY(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a10 = new BossAttack(getLocation().addY(300).addX(20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a2 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a13 = new BossAttack(getLocation().addY(230).addX(-20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a13);
        map.addAttack(a2);
        map.addAttack(a10);
        map.addAttack(a8);
        map.addAttack(a6);
    }

    private void attack12() {
        BossAttack a13 = new BossAttack(getLocation().addY(230).addX(-20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a4 = new BossAttack(getLocation().addY(300).addX(100), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a2 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a1 = new BossAttack(getLocation().addY(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a7 = new BossAttack(getLocation().addY(300).addX(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);                
        map.addAttack(a7);
        map.addAttack(a1);
        map.addAttack(a2);
        map.addAttack(a4);
        map.addAttack(a13);
    }

    private void attack13() {
        BossAttack a6 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);       
        BossAttack a13 = new BossAttack(getLocation().addY(230).addX(-20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a1 = new BossAttack(getLocation().addY(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a10 = new BossAttack(getLocation().addY(300).addX(20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a5 = new BossAttack(getLocation().addY(300).addX(-100), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a5);
        map.addAttack(a10);
        map.addAttack(a1);
        map.addAttack(a13);
        map.addAttack(a6);
    }

    private void attack14() {
        BossAttack a6 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);       
        BossAttack a7 = new BossAttack(getLocation().addY(300).addX(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);                
        BossAttack a2 = new BossAttack(getLocation().addY(300).addX(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a11 = new BossAttack(getLocation().addY(300).addX(250), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a9 = new BossAttack(getLocation().addY(200).addX(100), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a9);
        map.addAttack(a11);
        map.addAttack(a2);
        map.addAttack(a7);
        map.addAttack(a6);
    }

    private void attack15() {
        BossAttack a7 = new BossAttack(getLocation().addY(300).addX(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);                
        BossAttack a11 = new BossAttack(getLocation().addY(300).addX(250), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a13 = new BossAttack(getLocation().addY(230).addX(-20), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a1 = new BossAttack(getLocation().addY(300), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        BossAttack a8 = new BossAttack(getLocation().addY(200), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"),30,30), "DEFAULT", 30, 30);
        map.addAttack(a8);
        map.addAttack(a1);
        map.addAttack(a13);
        map.addAttack(a11);
        map.addAttack(a7);
    }
    
    public void update(Player player){
        super.update();
        this.attackCounter++;
        if(attackCounter >= 250){
            attack(random.nextInt(6));
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
