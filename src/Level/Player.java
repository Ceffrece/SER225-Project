package Level;

import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import GameObject.GameObject;
import GameObject.Rectangle;
import GameObject.SpriteSheet;
import SpriteFont.SpriteFont;
import Utils.Direction;

import java.awt.*;
import java.util.ArrayList;

public abstract class Player extends GameObject {
    // values that affect player movement
    // these should be set in a subclass
    //playerSpeed, attackSpeed, attackDamage, attackRange, playerHealth
    private SpriteFont healthBar;

    protected float walkSpeed = 2.3f;
    protected int attackSpeed = 1;
    protected int attackRange = 1;
    public static int playerHealth = 5;
    protected int attackDamage = 1;
    protected int maxHealth = 5;
    protected int invincibilityTimer = 0;
    protected int playerXPLevel = 0;
    protected int playerXPPoints = 0;

    protected int dash = 0;
    protected int playerArmor = 0;
    protected int critChance = 0;

    protected int interactionRange = 5;
    protected Direction currentWalkingXDirection;
    protected Direction currentWalkingYDirection;
    protected Direction lastWalkingXDirection;
    protected Direction lastWalkingYDirection;

    // values used to handle player movement
    protected float moveAmountX, moveAmountY;
    protected float lastAmountMovedX, lastAmountMovedY;

    // values used to keep track of player's current state
    protected PlayerState playerState;
    protected PlayerState previousPlayerState;
    protected Direction facingDirection;
    protected Direction lastMovementDirection;

    // classes that listen to player events can be added to this list
    protected ArrayList<PlayerListener> listeners = new ArrayList<>();

    // define keys
    protected KeyLocker keyLocker = new KeyLocker();
    protected Key MOVE_LEFT_KEY = Key.LEFT;
    protected Key MOVE_RIGHT_KEY = Key.RIGHT;
    protected Key MOVE_UP_KEY = Key.UP;
    protected Key MOVE_DOWN_KEY = Key.DOWN;
    protected Key INTERACT_KEY = Key.SPACE;
    protected Key FIRE_KEY = Key.F;

    //define id for projectile type 
    protected int projectileId;
    
    protected boolean isInvincible = false;
    public Player(SpriteSheet spriteSheet, float x, float y, String startingAnimationName) {
        super(spriteSheet, x, y, startingAnimationName);
        facingDirection = Direction.RIGHT;
        playerState = PlayerState.STANDING;
        previousPlayerState = playerState;
        this.affectedByTriggers = true;

    }

    public void update() {
        moveAmountX = 0;
        moveAmountY = 0;
        if(invincibilityTimer > 0){
            invincibilityTimer -= 1;
        }
        // if player is currently playing through level (has not won or lost)
        // update player's state and current actions, which includes things like determining how much it should move each frame and if its walking or jumping
        do {
            previousPlayerState = playerState;
            handlePlayerState();
        } while (previousPlayerState != playerState);

        // move player with respect to map collisions based on how much player needs to move this frame
        if (playerState != PlayerState.INTERACTING||playerState != PlayerState.FIRING) {
            lastAmountMovedY = super.moveYHandleCollision(moveAmountY);
            lastAmountMovedX = super.moveXHandleCollision(moveAmountX);
        }
        handlePlayerAnimation();

        updateLockedKeys();

        // update player's animation
        super.update();
    }

    // based on player's current state, call appropriate player state handling method
    protected void handlePlayerState() {
        switch (playerState) {
            case STANDING:
                playerStanding();
                break;
            case WALKING:
                playerWalking();
                break;
            case INTERACTING:
                playerInteracting();
                break;
            case FIRING:
                playerFiring();
                break;
        }
    }

    protected void playerFiring(){

        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }
        // if a walk key is pressed, player enters WALKING state
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY) || Keyboard.isKeyDown(MOVE_RIGHT_KEY) || Keyboard.isKeyDown(MOVE_UP_KEY) || Keyboard.isKeyDown(MOVE_DOWN_KEY)) {
            playerState = PlayerState.WALKING;
        }
        else if (Keyboard.isKeyUp(MOVE_LEFT_KEY) && Keyboard.isKeyUp(MOVE_RIGHT_KEY) && Keyboard.isKeyUp(MOVE_UP_KEY) && Keyboard.isKeyUp(MOVE_DOWN_KEY)) {
            playerState = PlayerState.STANDING;
        }
        
        
    
    }

    // player STANDING state logic
    protected void playerStanding() {
        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }
        // if Fireing Key is not locked and Fire Key is down, lock key 
        if (!keyLocker.isKeyLocked(FIRE_KEY) && Keyboard.isKeyDown(FIRE_KEY)) {
            keyLocker.lockKey(FIRE_KEY);
            playerState = PlayerState.FIRING;
        }

        // if a walk key is pressed, player enters WALKING state
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY) || Keyboard.isKeyDown(MOVE_RIGHT_KEY) || Keyboard.isKeyDown(MOVE_UP_KEY) || Keyboard.isKeyDown(MOVE_DOWN_KEY)) {
            playerState = PlayerState.WALKING;
        }

        
    }

    // player WALKING state logic
    protected void playerWalking() {
        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }
        
        if (!keyLocker.isKeyLocked(FIRE_KEY) && Keyboard.isKeyDown(FIRE_KEY)) {
            keyLocker.lockKey(FIRE_KEY);
            playerState = PlayerState.FIRING;
        }
        
        

        // if walk left key is pressed, move player to the left
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY)) {
            moveAmountX -= walkSpeed;
            facingDirection = Direction.LEFT;
            currentWalkingXDirection = Direction.LEFT;
            lastWalkingXDirection = Direction.LEFT;
        }

        // if walk right key is pressed, move player to the right
        else if (Keyboard.isKeyDown(MOVE_RIGHT_KEY)) {
            moveAmountX += walkSpeed;
            facingDirection = Direction.RIGHT;
            currentWalkingXDirection = Direction.RIGHT;
            lastWalkingXDirection = Direction.RIGHT;
        }
        else {
            currentWalkingXDirection = Direction.NONE;
        }

        if (Keyboard.isKeyDown(MOVE_UP_KEY)) {
            moveAmountY -= walkSpeed;
            currentWalkingYDirection = Direction.UP;
            lastWalkingYDirection = Direction.UP;
        }
        else if (Keyboard.isKeyDown(MOVE_DOWN_KEY)) {
            moveAmountY += walkSpeed;
            currentWalkingYDirection = Direction.DOWN;
            lastWalkingYDirection = Direction.DOWN;
        }
        else {
            currentWalkingYDirection = Direction.NONE;
        }

        if ((currentWalkingXDirection == Direction.RIGHT || currentWalkingXDirection == Direction.LEFT) && currentWalkingYDirection == Direction.NONE) {
            lastWalkingYDirection = Direction.NONE;
        }

        if ((currentWalkingYDirection == Direction.UP || currentWalkingYDirection == Direction.DOWN) && currentWalkingXDirection == Direction.NONE) {
            lastWalkingXDirection = Direction.NONE;
        }

        if (Keyboard.isKeyUp(MOVE_LEFT_KEY) && Keyboard.isKeyUp(MOVE_RIGHT_KEY) && Keyboard.isKeyUp(MOVE_UP_KEY) && Keyboard.isKeyUp(MOVE_DOWN_KEY)&& Keyboard.isKeyUp(FIRE_KEY)) {
            playerState = PlayerState.STANDING;
        }
    }

    // player INTERACTING state logic -- intentionally does nothing so player is locked in place while a script is running
    protected void playerInteracting() { }

    protected void updateLockedKeys() {
        if (Keyboard.isKeyUp(INTERACT_KEY) && playerState != PlayerState.INTERACTING) {
            keyLocker.unlockKey(INTERACT_KEY);
        }
        if (Keyboard.isKeyUp(FIRE_KEY) && playerState != PlayerState.FIRING) {
            keyLocker.unlockKey(FIRE_KEY);
        }
    }

    // anything extra the player should do based on interactions can be handled here
    protected void handlePlayerAnimation() {
        if (playerState == PlayerState.STANDING) {
            // sets animation to a STAND animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";
        }
        else if (playerState == PlayerState.WALKING) {
            // sets animation to a WALK animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "WALK_RIGHT" : "WALK_LEFT";
        }
        else if (playerState == PlayerState.INTERACTING) {
            // sets animation to STAND when player is interacting
            // player can be told to stand or walk during Script by using the "stand" and "walk" methods
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";
        }
        else if (playerState == PlayerState.FIRING) {
            // sets animation to STAND when player is Fireing
            // player can be told to stand or walk during Script by using the "stand" and "walk" methods
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";
        }
    }

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) { 
        if(hasCollided){
            if(entityCollidedWith.getIdentity() == "enemy" ){
                if(invincibilityTimer == 0){
                    hurtPlayer(entityCollidedWith);
                    System.out.println("player hit; hp: " + playerHealth);
                    invincibilityTimer = 180;
                }
            }
        }
    }

    @Override
    public void onEndCollisionCheckY(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) { 
        if(hasCollided){
            if(entityCollidedWith.getIdentity() == "enemy" ){
                if(invincibilityTimer == 0){
                    hurtPlayer(entityCollidedWith);
                    System.out.println("player hit; hp: " + playerHealth);
                    invincibilityTimer = 180;
                }
            }
        }
    }

    // other entities can call this method to hurt the player
    public void hurtPlayer(MapEntity mapEntity) {
        if(playerHealth > 0){
            playerHealth -= 1;
        }else{
            playerHealth = 0;
        }

    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    public void addListener(PlayerListener listener) {
        listeners.add(listener);
    }

    public Rectangle getInteractionRange() {
        return new Rectangle(
                getBounds().getX1() - interactionRange,
                getBounds().getY1() - interactionRange,
                getBounds().getWidth() + (interactionRange * 2),
                getBounds().getHeight() + (interactionRange * 2));
    }

    public Key getInteractKey() { return INTERACT_KEY; }
    public Direction getCurrentWalkingXDirection() { return currentWalkingXDirection; }
    public Direction getCurrentWalkingYDirection() { return currentWalkingYDirection; }
    public Direction getLastWalkingXDirection() { return lastWalkingXDirection; }
    public Direction getLastWalkingYDirection() { return lastWalkingYDirection; }

    public void stand(Direction direction) {
        facingDirection = direction;
        if (direction == Direction.RIGHT) {
            this.currentAnimationName = "STAND_RIGHT";
        }
        else if (direction == Direction.LEFT) {
            this.currentAnimationName = "STAND_LEFT";
        }
    }

    public void walk(Direction direction, float speed) {
        facingDirection = direction;
        if (direction == Direction.RIGHT) {
            this.currentAnimationName = "WALK_RIGHT";
        }
        else if (direction == Direction.LEFT) {
            this.currentAnimationName = "WALK_LEFT";
        }
        else {
            if (this.currentAnimationName.contains("RIGHT")) {
                this.currentAnimationName = "WALK_RIGHT";
            }
            else {
                this.currentAnimationName = "WALK_LEFT";
            }
        }
        if (direction == Direction.UP) {
            moveY(-speed);

        }
        else if (direction == Direction.DOWN) {
            moveY(speed);
        }
        else if (direction == Direction.LEFT) {
            moveX(-speed);
        }
        else if (direction == Direction.RIGHT) {
            moveX(speed);
        }
    }

   //----setters and getters and helper functions :D for player varaibles----
    //walk speed setter
    public void setWalkSpeed(Float walkSpeed) {
        this.walkSpeed = walkSpeed;
      }
      //walk speed getter 
      public Float getWalkSpeed() {
        return walkSpeed;
      }

      public void addWalkSpeed(Float x){
            walkSpeed += x;
      }
      //attack speed setter
      public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
      }
      //attack speed getter
      public int getAttackSpeed() {
        return attackSpeed;
      }
      public void addAttackSpeed(int x) {
        attackSpeed += x ;
      }

      //attack Damage setter
      public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
      }
       //attack Damage getter
       public int getAttackDamage() {
        return attackDamage;
      }
      public void addAttackDamage(int x) {
        attackDamage += x;
      }


      //attack  Range setter
      public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
      }
       //attack Range getter
       public int getAttackRange() {
        return attackRange;
      }
      public void addAttackRange(int x) {
            attackRange += x;
      }


      //player Health setter
      public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
      }
       //playerRange getter
       public int getPlayerHealth() {
        return playerHealth;
      }
      public void addPlayerHealth(int x) {
        playerHealth += x;
      }

      //player XP setters
      public void addPlayerXPLevel(int x){
        this.playerXPLevel += x;
      }
      public void addPlayerXPPoints(int x){
        this.playerXPPoints += x;
      }

      //player XP getters
      public int getPlayerXPLevel(){
        return this.playerXPLevel;
      }
      public int getPlayerXPPoints(int x){
        return this.playerXPPoints;
      }

      //player MaxHealth setters and getters
      public void setPlayerMaxHealth(int x){
        this.maxHealth = x;
      }
      public void addPlayerMaxHealth(int x){
        this.maxHealth += x;
      }
      public int getMaxHealth(){
        return this.maxHealth;
      }



      //--------unloackable--------
      // dash setter
      public void setDash(int dash) {
        this.dash = dash;
      }
       //dash getter
       public int getDash() {
        return dash;
      }
      public void addDash(int x) {
        dash += x;
      }

      // playerArmor setter
      public void setPlayerArmor(int playerArmor) {
        this.playerArmor = playerArmor;
      }
       //playerArmor getter
       public int getPlayerArmor() {
        return playerArmor;
      }
      public void addPlayerArmor(int x) {
        playerArmor += x;
      }

      // CritChance setter
      public void setCritChance(int critChance) {
        this.critChance = critChance;
      }
       //CritChance getter
       public int getCritChance() {
        return critChance;
      }
      public void addCritChance(int x) {
        critChance += x;
      }
      // CritChance setter
      public void setInvincibilityTimer(int invincibilityTimer) {
        this.invincibilityTimer = invincibilityTimer;
      }
       //CritChance getter
       public int getInvincibilityTimer() {
        return invincibilityTimer;
      }
      public void addIncibilityTimer(int x) {
         invincibilityTimer += x;
      }
    }
