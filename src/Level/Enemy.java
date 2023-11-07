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

    public Direction enemyWalkingDirectionX;
    public Direction enemyWalkingDirectionY;

    protected EnemyState enemyState;
    protected EnemyState previousEnemyState;

    // values used to handle enemy movement
    protected float moveAmountX, moveAmountY;
    protected float lastAmountMovedX, lastAmountMovedY;

    public Enemy(int id, float x, float y, SpriteSheet spriteSheet, String startingAnimation)
    {
        super(x, y, spriteSheet, startingAnimation);
        isUncollidable = false;
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
        // collision shouldn't be done here  
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
    public void handleEnemyCollison(Player player){
        if (player.overlaps(this) && player.getPlayerState() == PlayerState.WALKING) {
            if (player.getCurrentWalkingXDirection() == Direction.LEFT) {
                if (canMoveLeft(player)) {
                    moveXHandleCollision(-1);
                }
            }
            else if (player.getCurrentWalkingXDirection() == Direction.RIGHT) {
                if (canMoveRight(player)) {
                    moveXHandleCollision(1);
                }
            }
             if (player.getCurrentWalkingYDirection() == Direction.UP) {
                if (canMoveUp(player)) {
                    moveYHandleCollision(-1);
                }
            }
            else if (player.getCurrentWalkingYDirection() == Direction.DOWN) {
                if (canMoveDown(player)) {
                    moveYHandleCollision(1);
                }
            }
        }
        if (player.overlaps(this) && player.getPlayerState() == PlayerState.STANDING) {
             if (player.getLastWalkingXDirection() == Direction.LEFT) {
                if (canMoveLeft(player)) {
                    moveXHandleCollision(-1);
                }
            }
            else if (player.getLastWalkingXDirection() == Direction.RIGHT) {
                if (canMoveRight(player)) {
                    moveXHandleCollision(1);
                }
            }
             if (player.getLastWalkingYDirection() == Direction.UP) {
                if (canMoveUp(player)) {
                    moveYHandleCollision(-1);
                }
            }
            else if (player.getLastWalkingYDirection() == Direction.DOWN) {
                if (canMoveDown(player)) {
                    moveYHandleCollision(1);
                }
        }
    }

    }
    private boolean canMoveLeft(Player player) {
        return player.getBoundsX1() <= getBoundsX2() + 1 && player.getBoundsX2() > getBoundsX2() && canMoveX(player);
    }

    private boolean canMoveRight(Player player) {
        return player.getBoundsX2() + 1 >= getBoundsX1() && player.getBoundsX1() < getBoundsX1() && canMoveX(player);
    }

    private boolean canMoveX(Player player) {
        return (player.getBoundsY1() <= getBoundsY2() && player.getBoundsY2() >= getBoundsY2()) ||
                (player.getBoundsY2() >= getBoundsY1() && player.getBoundsY1() <= getBoundsY1()) ||
                (player.getBoundsY2() <= getBoundsY2() && player.getBoundsY1() >= getBoundsY1());
    }

    private boolean canMoveUp(Player player) {
        return player.getBoundsY1() <= getBoundsY2() + 1 && player.getBoundsY2() > getBoundsY2() && canMoveY(player);
    }

    private boolean canMoveDown(Player player) {
        return player.getBoundsY2() + 1 >= getBoundsY1() && player.getBoundsY1() < getBoundsY1() && canMoveY(player);
    }

    private boolean canMoveY(Player player) {
        return (player.getBoundsX1() <= getBoundsX2() && player.getBoundsX2() >= getBoundsX2()) ||
                (player.getBoundsX2() >= getBoundsX1() && player.getBoundsX1() <= getBoundsX1()) ||
                (player.getBoundsX2() <= getBoundsX2() && player.getBoundsX1() >= getBoundsX1());
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
        // if(player.overlaps(this))
        // {
        
        //     if (direction == Direction.UP)
        //     {
        //         handleCollisionY(-speed);
        //         //moveYHandleCollision(speed) suggestion from Alex, look for this in the player.java, this is how players don't run into trees
        //     }
        //     else if (direction == Direction.DOWN)
        //     {
        //         handleCollisionY(speed);
        //     }
        //     else if (direction == Direction.LEFT)
        //     {
        //         handleCollisionX(-speed);
        //     }
        //     else if (direction == Direction.RIGHT)
        //     {
        //         handleCollisionX(speed);
        //     }
        // }
    }

    public void update(Player player)
    {   
        facePlayer(player);
        walkTowardPlayer(player);
        // move enemy with respect to map collisions based on how much enemy needs to move this frame
        if (enemyState != EnemyState.INTERACTING||enemyState != EnemyState.FIRING) {
            lastAmountMovedY = super.moveYHandleCollision(moveAmountY);
            lastAmountMovedX = super.moveXHandleCollision(moveAmountX);
        }
        handleEnemyCollison(player);
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
    // no longer NPC-based from here to the bottom
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
    public Direction getEnemyWalkingDirectionX() {
        return enemyWalkingDirectionX;
    }

    public void setEnemyWalkingDirectionX(Direction enemyWalkingDirectionX) {
        this.enemyWalkingDirectionX = enemyWalkingDirectionX;
    }

    public Direction getEnemyWalkingDirectionY() {
        return enemyWalkingDirectionY;
    }

    public void setEnemyWalkingDirectionY(Direction enemyWalkingDirectionY) {
        this.enemyWalkingDirectionY = enemyWalkingDirectionY;
    }
}