package Level;

import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import GameObject.GameObject;
import GameObject.Rectangle;
import GameObject.SpriteSheet;
import Level.Projectiles.bannanaProjectile;
import Level.Projectiles.fruitFlyProjectile;
import Level.Projectiles.peaProjectile;
import Level.Projectiles.riceBallProjectile;
import NPCs.Walrus;
import SpriteFont.SpriteFont;
import Utils.Direction;
import Utils.Point;

import Level.Map;
import java.awt.*;
import java.util.ArrayList;

public abstract class Player extends GameObject {
    // values that affect player movement
    // these should be set in a subclass
    //playerSpeed, attackSpeed, attackDamage, attackRange, playerHealth
    private SpriteFont healthBar;

    public static int cooldown = 750;
    public static boolean readyToFire = false;
    

    public static float walkSpeed = 2.3f;
    public static int attackSpeed = 2;
    public static int attackRange = 1;
    public static int playerHealth = 5;
    public static int attackDamage = 1;
    public static int maxHealth = 5;
    public static int invincibilityTimer = 0;
    public static int playerXPLevel = 0;
    public static int playerXPPoints = 0;

    protected String currentProjectile = "peaProjectile";

    public static int dash = 0;
    public static int playerArmor = 0;
    public static int critChance = 0;

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

    public static ArrayList<Projectile> playerCurrentProjectiles = new ArrayList<>();
    public static int projectileInHand = 0;

    // classes that listen to player events can be added to this list
    protected ArrayList<PlayerListener> listeners = new ArrayList<>();

    public static ArrayList<Integer> playerStats = new ArrayList<>();


    // define keys
    protected KeyLocker keyLocker = new KeyLocker();
    protected Key MOVE_LEFT_KEY = Key.A;
    protected Key MOVE_RIGHT_KEY = Key.D;
    protected Key MOVE_UP_KEY = Key.W;
    protected Key MOVE_DOWN_KEY = Key.S;
    protected Key INTERACT_KEY = Key.SPACE;
    protected Key FIRE_KEY = Key.F;

    protected Key CHANGE_PROJECT = Key.SHIFT;


   
    protected boolean isInvincible = false;
    public Player(SpriteSheet spriteSheet, float x, float y, String startingAnimationName) {
        super(spriteSheet, x, y, startingAnimationName);
        facingDirection = Direction.RIGHT;
        playerState = PlayerState.STANDING;
        previousPlayerState = playerState;
        this.affectedByTriggers = true;

        peaProjectile peaProjectile = new peaProjectile(getLocation(), null);
        riceBallProjectile riceBallProjectile = new riceBallProjectile(getLocation(), null);
        bannanaProjectile bannanaProjectile = new bannanaProjectile(getLocation(), null);
        fruitFlyProjectile fruitFlyProjectile = new fruitFlyProjectile(getLocation(), null);
        
        playerCurrentProjectiles.add(fruitFlyProjectile);
        playerCurrentProjectiles.add(peaProjectile);
        playerCurrentProjectiles.add(riceBallProjectile);
        playerCurrentProjectiles.add(bannanaProjectile);



    }

    public void update() {
        moveAmountX = 0;
        moveAmountY = 0;

        //adds the attack speed to cooldown, when cooldown hits a range you can shoot
        if(cooldown >= playerCurrentProjectiles.get(projectileInHand).shootTime){
            readyToFire = true;
        }else{
            readyToFire = false;

        }

        if(readyToFire){

        }
        else{
            cooldown += attackSpeed;

        }

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
            case CHANGE:
                playerChange();
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
            Projectile projectileShooting = new Projectile(this.getLocation(),this.getCurentProjectile(), this);
            
            

            if(cooldown >= playerCurrentProjectiles.get(projectileInHand).shootTime){
                map.addProjectile(projectileShooting);
                cooldown = 0;
            }else{
                readyToFire = false;
            }
    }
    protected void playerChange(){
        if(projectileInHand >= playerCurrentProjectiles.size()-1){
            projectileInHand = 0;
        }
        else{
            projectileInHand ++;
        }
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

        if (!keyLocker.isKeyLocked(CHANGE_PROJECT) && Keyboard.isKeyDown(CHANGE_PROJECT)) {
            keyLocker.lockKey(CHANGE_PROJECT);
            playerState = PlayerState.CHANGE;
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
            facingDirection = Direction.UP;
            currentWalkingYDirection = Direction.UP;
            lastWalkingYDirection = Direction.UP;
        }
        else if (Keyboard.isKeyDown(MOVE_DOWN_KEY)) {
            moveAmountY += walkSpeed;
            facingDirection = Direction.DOWN;
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
        if (!keyLocker.isKeyLocked(CHANGE_PROJECT) && Keyboard.isKeyDown(CHANGE_PROJECT)) {
            keyLocker.lockKey(CHANGE_PROJECT);
            playerState = PlayerState.CHANGE;
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
        if (Keyboard.isKeyUp(CHANGE_PROJECT) && playerState != PlayerState.INTERACTING) {
            keyLocker.unlockKey(CHANGE_PROJECT);
        }
        
    }

    // anything extra the player should do based on interactions can be handled here
    protected void handlePlayerAnimation() {
        if (playerState == PlayerState.STANDING) {
            // sets animation to a STAND animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" 
            :facingDirection == Direction.LEFT ? "STAND_LEFT"
            :facingDirection == Direction.UP ? "STAND_UP"
            : "STAND_DOWN";
        }
        else if (playerState == PlayerState.WALKING) {
            // sets animation to a WALK animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "WALK_RIGHT" 
            :facingDirection == Direction.LEFT ? "WALK_LEFT"
            :facingDirection == Direction.UP ? "WALK_UP"
            : "WALK_DOWN";
    
            
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
    public static void hurtPlayer(MapEntity mapEntity) {
        if(playerHealth > 0){
            playerHealth -= 1;
        }else{
            playerHealth = 0;
        }

    }

    public static void hurtPlayer() {
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
        else if (direction == Direction.UP) {
            this.currentAnimationName = "STAND_UP";
        }
        else if (direction == Direction.DOWN) {
            this.currentAnimationName = "STAND_DOWN";
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
        else if (direction == Direction.UP) {
            this.currentAnimationName = "WALK_UP";
        }
        else if (direction == Direction.DOWN) {
            this.currentAnimationName = "WALK_DOWN";
        }
        else {
            if (this.currentAnimationName.contains("RIGHT")) {
                this.currentAnimationName = "WALK_RIGHT";
            }
            else if (this.currentAnimationName.contains("LEFT")) {
                this.currentAnimationName = "WALK_LEFT";
            }
            else if (this.currentAnimationName.contains("UP")) {
                this.currentAnimationName = "WALK_UP";
            }
            else {
                this.currentAnimationName = "WALK_DOWN";
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
    public String getCurentProjectile(){
        
        return playerCurrentProjectiles.get(projectileInHand).projectileID;
    }
   //----setters and getters and helper functions :D for player varaibles----
    //walk speed setter
    public static void setWalkSpeed(Float walkSpeeed) {
        walkSpeed = walkSpeeed;
      }
      //walk speed getter 
      public static Float getWalkSpeed() {
        return walkSpeed;
      }

      public static void addWalkSpeed(Float x){
            walkSpeed += x;
      }
      //attack speed setter
      public static void setAttackSpeed(int spd) {
        attackSpeed = spd;
      }
      //attack speed getter
      public static int getAttackSpeed() {
        return attackSpeed;
      }
      public static void addAttackSpeed(int x) {
        attackSpeed += x ;
      }

      //attack Damage setter
      public void setAttackDamage(int dmg) {
        attackDamage = dmg;
      }
       //attack Damage getter
       public static int getAttackDamage() {
        return attackDamage;
      }
      public void addAttackDamage(int x) {
        attackDamage += x;
      }


      //attack  Range setter
      public void setAttackRange(int range) {
        attackRange = range;
      }
       //attack Range getter
       public static int getAttackRange() {
        return attackRange;
      }
      public void addAttackRange(int x) {
            attackRange += x;
      }

    
      //player Health setter
      public void setPlayerHealth(int hlth) {
        playerHealth = hlth;
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
        playerXPLevel += x;
      }
      public void addPlayerXPPoints(int x){
        playerXPPoints += x;
      }

      //player XP getters
      public int getPlayerXPLevel(){
        return playerXPLevel;
      }
      public int getPlayerXPPoints(int x){
        return playerXPPoints;
      }

      //player MaxHealth setters and getters
      public void setPlayerMaxHealth(int x){
        maxHealth = x;
      }
      public void addPlayerMaxHealth(int x){
        maxHealth += x;
      }
      public static int getMaxHealth(){
        return maxHealth;
      }



      //--------unloackable--------
      // dash setter
      public void setDash(int dashSet) {
        dash = dashSet;
      }
       //dash getter
       public static int getDash() {
        return dash;
      }
      public static void addDash(int x) {
        dash += x;
      }

      // playerArmor setter
      public void setPlayerArmor(int playerArmorSet) {
        playerArmor = playerArmorSet;
      }
       //playerArmor getter
       public static int getPlayerArmor() {
        return playerArmor;
      }
      public void addPlayerArmor(int x) {
        playerArmor += x;
      }

      // CritChance setter
      public void setCritChance(int critChanceSet) {
        critChance = critChanceSet;
      }
       //CritChance getter
       public int getCritChance() {
        return critChance;
      }
      public void addCritChance(int x) {
        critChance += x;
      }
      // CritChance setter
      public void setInvincibilityTimer(int invincibilityTimerSet) {
        invincibilityTimer = invincibilityTimerSet;
      }
       //CritChance getter
       public int getInvincibilityTimer() {
        return invincibilityTimer;
      }
      public void addIncibilityTimer(int x) {
         invincibilityTimer += x;
      }
    }
