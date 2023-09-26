package Players;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Player;

import java.util.HashMap;

// This is the class for the Cat player character
// basically just sets some values for physics and then defines animations
public class Cat extends Player {

    public Cat(float x, float y) {
      super(new SpriteSheet(ImageLoader.load("Player.png"), 24, 24), x, y, "STAND_RIGHT");
       //player speed, attack speed, attack damage, attack range, player health
       float walkSpeed;
       int  attackSpeed;
       int  attackDamage;
       int  attackRange;
       int  playerHealth;
       int dash;
    }

    //----setters and getters for player varaibles----
    //walk speed setter
     public void setWalkSpeed(Float walkSpeed) {
        this.walkSpeed = walkSpeed;
      }
      //walk speed getter 
      public Float getWalkSpeed() {
        return walkSpeed;
      }
      
      //attack speed setter
      public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
      }
      //attack speed getter
      public int setAttackSpeed() {
        return attackSpeed;
      }

      //attack Damage setter
      public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
      }
       //attack Damage getter
       public int setAttackDamage() {
        return attackDamage;
      }


      //attack  Range setter
      public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
      }
       //attack Range getter
       public int setAttackRange() {
        return attackRange;
      }

      //player Health setter
      public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
      }
       //playerRange getter
       public int setPlayerHealth() {
        return playerHealth;
      }
      //--------unloackable--------
      // dash setter
      public void setDash(int dash) {
        this.dash = dash;
      }
       //dash getter
       public int setDash() {
        return dash;
      }

      // playerArmor setter
      public void setPlayerArmor(int playerArmor) {
        this.playerArmor = playerArmor;
      }
       //playerArmor getter
       public int setPlayerArmor() {
        return playerArmor;
      }

      // CritChance setter
      public void setCritChance(int critChance) {
        this.critChance = critChance;
      }
       //CritChance getter
       public int setCritChance() {
        return critChance;
      }
    public void update() {
        super.update();
    }

    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build()
            });

            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 12, 12, 7)
                            .build()
            });

            put("WALK_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(1, 0), 14)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 14)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 14)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 3), 14)
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build()
            });

            put("WALK_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(1, 0), 14)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 14)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 14)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 12, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 3), 14)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(6, 12, 12, 7)
                            .build()
            });
        }};
    }
}
