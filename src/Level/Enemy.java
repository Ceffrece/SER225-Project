package Level;
import java.util.ArrayList;
import java.util.HashMap;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Keyboard;
import Engine.Music;
import GameObject.Frame;
import java.security.SecureRandom;

import GameObject.SpriteSheet;
import Level.Projectiles.bannanaProjectile;
import Level.Projectiles.carrotProjectile;
import Level.Projectiles.peaProjectile;
import Level.Projectiles.peporoniSlicer;
import Level.Projectiles.riceBallProjectile;
import Utils.Direction;
import Utils.Point;
import SpriteFont.SpriteFont;
import Utils.Colors;
import java.awt.*;
// This class is a base class for all Enemies in the game - all enemies should extend from it
public class Enemy extends MapEntity
{
    protected int id = 0;
    // protected int health = 5; no longer needed
    public int health = 5;
    public boolean canShoot = true;
    protected EnemyState enemyState;
    protected EnemyState previousEnemyState;
    public SecureRandom random;
    public GraphicsHandler graphicsHandler;
    public static int cooldown = 0;
    public static boolean readyToFire = false;
    public static int attackSpeed = 2;
    public static int attackRange = 1;
    public static int invincibilityTimer = 0;
    public static int shootingTimer = 0; //320
    
    protected String currentProjectile = "peaProjectile";
    public static ArrayList<Projectile> enemyCurrentProjectiles = new ArrayList<>();
    public static int projectileInHand = 0;
    public static SpriteFont damageText = new SpriteFont("-", -100, -100 + 10,"Comic Sans", 25, Color.red);
    public Enemy(int id, float x, float y, SpriteSheet spriteSheet, String startingAnimation)
    {
        
        super(x, y, spriteSheet, startingAnimation);
        isUncollidable = true;
        graphicsHandler = new GraphicsHandler();
        random = new SecureRandom();

        super.setIdentity("enemy");
        this.id = id;
        
        carrotProjectile carrotProjectile = new carrotProjectile(getLocation(), null);

        enemyCurrentProjectiles.add(carrotProjectile);
    }
    //class for kiwi
    public Enemy(int id, float x, float y, SpriteSheet spriteSheet, String startingAnimation,boolean canShoot)
    {
        super(x, y, spriteSheet, startingAnimation);
        isUncollidable = true;
        random = new SecureRandom();
        this.canShoot = canShoot;
        super.setIdentity("enemy");
        this.id = id;
        
        carrotProjectile carrotProjectile = new carrotProjectile(getLocation(), null);

        enemyCurrentProjectiles.add(carrotProjectile);
    }
    //Constructor for the boss
    public Enemy(float x, float y, SpriteSheet spriteSheet, String startingAnimation)
    {
        super(x, y, spriteSheet, startingAnimation);
        isUncollidable = true;
        super.setIdentity("enemy");
    }
    public Enemy(int id, float x, float y, HashMap<String, Frame[]> animations, String startingAnimation)
    {
        super(x, y, animations, startingAnimation);
        this.id = id;
    }
    public Enemy(int id, float x, float y, Frame[] frames)
    {
        super(x, y, frames);
        this.id = id;
    }
    public Enemy(int id, float x, float y, Frame frame)
    {
        super(x, y, frame);
        this.id = id;
    }
    public Enemy(int id, float x, float y)
    {
        super(x, y);
        this.id = id;
    }
    public int getId() { return id; }
    public void facePlayer(Player player)
    {
        if (Math.round(getBoundsX2()) - (getBounds().getWidth() / 2) < Math.round(player.getBoundsX2()))
        {
            this.currentAnimationName = "STAND_RIGHT";
        }
        else if (Math.round(getBoundsX1()) + (getBounds().getWidth() / 2) > Math.round(player.getBoundsX1()))
        {
            this.currentAnimationName = "STAND_LEFT";
        }
    }
    public void walkTowardPlayer(Player player)
    {
        if (Math.round(getBoundsX2()) - (getBounds().getWidth() / 2) < Math.round(player.getBoundsX2()))
        {
            walk(Direction.RIGHT, .5f);
        }
        if (Math.round(getBoundsX1()) + (getBounds().getWidth() / 2) > Math.round(player.getBoundsX1()))
        {
            walk(Direction.LEFT, .5f);
        }
        if (Math.round(getBoundsY2()) - (getBounds().getWidth() / 2) < Math.round(player.getBoundsY2()))
        {
            walk(Direction.DOWN, .5f);
        }
        if (Math.round(getBoundsY1()) + (getBounds().getWidth() / 2) > Math.round(player.getBoundsY1()))
        {
            walk(Direction.UP,.5f);
        }
    }
    public void stand(Direction direction) 
    {
        if (direction == Direction.RIGHT)
        {
            this.currentAnimationName = "STAND_Right";
        }
        else if (direction == Direction.LEFT)
        {
            this.currentAnimationName = "STAND_LEFT";
        }
    }
    public void walk(Direction direction, float speed)
    {
        if (direction == Direction.RIGHT)
        {
            this.currentAnimationName = "WALK_RIGHT";
        }
        else if (direction == Direction.LEFT)
        {
            this.currentAnimationName = "WALK_LEFT";
        }
        else
        {
            if (this.currentAnimationName.contains("RIGHT")) 
            {
                this.currentAnimationName = "WALK_RIGHT";
            }
            else
            {
                this.currentAnimationName = "WALK_LEFT";
            }
        }
        if (direction == Direction.UP)
        {
            moveY(-speed);
        }
        else if (direction == Direction.DOWN)
        {
            moveY(speed);
        }
        else if (direction == Direction.LEFT)
        {
            moveX(-speed);
        }
        else if (direction == Direction.RIGHT)
        {
            moveX(speed);
        }
    }
  
    int timer = 0;
    public void update(Player player)
    {   
        facePlayer(player);
        walkTowardPlayer(player);
        //adds the attack speed to cooldown, when cooldown hits a range you can shoot

        if(timer >= 5500 && canShoot){
                EnemyProjectile pro = new EnemyProjectile(this.getLocation(), new SpriteSheet(ImageLoader.load("EnemySprites/red.png"), 8, 8), "DEFAULT", 150);
                map.addEnemyProjectile(pro);
                timer = 0;
        }

        timer += random.nextInt(25) + 5;
        
        //if(Player.invincibilityTimer > 0){
        //    Player.invincibilityTimer -= 1;
        //}
        // if this.overlaps player then hurtPlayer, enemies cannot be damaged by projectiles from this method
        if (player.overlaps(this) && Player.invincibilityTimer == 0)
        {
            Player.hurtPlayer(this);
            Player.invincibilityTimer = 180;
        }
        super.update();
    }

    public String getCurentProjectile(){
        
        return enemyCurrentProjectiles.get(projectileInHand).projectileID;
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler)
    {
        super.draw(graphicsHandler);
    }
    public int getID(){
        return id; 
    }
    // 
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void hurtEnemy(int damage) {
        
        this.health -= damage;
        damageText = new SpriteFont("DAMAGE PER SHOT: -" + damage, 480,520,"Comic Sans", 18, Color.red);
        damageText.setOutlineColor(Color.black);
        damageText.setOutlineThickness(3);
        if (health <= 0){
            Pickup testXPOrb = new Pickup(this.getLocation().addX(-10), new SpriteSheet(ImageLoader.load("Pickups/xpOrb.png"),7,7),"DEFAULT",1);
            testXPOrb.setIdentity("xpOrb");
            map.addPickup(testXPOrb);
             
            if( random.nextInt(0,6) == 1){
                Pickup healthPickup= new Pickup(this.getLocation().addX(10), "wow");
                map.addPickup(healthPickup);
             }
            

            
            this.mapEntityStatus = MapEntityStatus.REMOVED;

        }
    }
    public static SpriteFont getEnemyText(){
        return damageText;
    }
}