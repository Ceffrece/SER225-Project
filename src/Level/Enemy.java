package Level;
import java.util.HashMap;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Utils.Direction;
// This class is a base class for all Enemies in the game - all enemies should extend from it
public class Enemy extends MapEntity
{
    protected int id = 0;
    protected int health;
    
    public Enemy(int id, float x, float y, SpriteSheet spriteSheet, String startingAnimation)
    {
        super(x, y, spriteSheet, startingAnimation);
        isUncollidable = true;
        super.setIdentity("enemy");
        this.id = id;
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
            //moveYHandleCollision(speed) suggestion from Alex, look for this in the player.java, this is how players don't run into trees
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
    public void update(Player player)
    {   
        facePlayer(player);
        walkTowardPlayer(player);
        if(Player.invincibilityTimer > 0){
            Player.invincibilityTimer -= 1;
        }
        // if this.overlaps player then hurtPlayer, enemies cannot be damaged by projectiles from this method
        if (player.overlaps(this) && Player.invincibilityTimer == 0)
        {
            Player.hurtPlayer(this);
            Player.invincibilityTimer = 180;
        }
        super.update();
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
        System.out.println("Hit for "+ damage + " left "+ health);
        if (health <= 0){
            Pickup testXPOrb = new Pickup(this.getLocation(), new SpriteSheet(ImageLoader.load("Pickups/xpOrb.png"),7,7),"DEFAULT",1);
            testXPOrb.setIdentity("xpOrb");
            map.addPickup(testXPOrb);
            this.mapEntityStatus = MapEntityStatus.REMOVED;
        }
    }
}