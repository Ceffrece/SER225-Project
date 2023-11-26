package Scripts ;

import Level.Currency;
import Level.Item;
import Level.MapEntityStatus;
import Level.Player;
import Level.Script;
import Level.ScriptState;
import Level.Currency;

public class ItemPickup extends Script<Item>{


      
@Override
    protected void setup() {
    }

    @Override
    protected void cleanup() {
        
    }

    @Override
    public ScriptState execute() {
        start();       

        entity.heldByPlayer = true;
        System.out.println(entity.stat);

        if(entity.cost <= Currency.normalCurrency){
            Currency.purchaseItem(entity.cost, 0);
            switch (entity.stat) {
                case "attackSpeed":  Player.addAttackSpeed(entity.statIncrease);
                    break;
                case "attackRange":  Player.addAttackRange(entity.statIncrease);
                    break;
                case "attackDamage":  Player.addAttackDamage(entity.statIncrease);
                    break;
                case "walkSpeed":
                    float y = entity.statIncrease; 
                    Player.addWalkSpeed(y);
                    break;
                case "playerHealth":  Player.addAttackDamage(entity.statIncrease);
                    break;
                case "maxHealth":  Player.addPlayerMaxHealth(entity.statIncrease);
                    break;
                case "invincibilityTimer":  player.addIncibilityTimer(entity.statIncrease);
                    break;
                case "dash":  Player.addDash(entity.statIncrease);
                    break;
                case "playerArmor":  Player.addPlayerArmor(entity.statIncrease);
                    break;
                case "critChance" :  Player.addCritChance(entity.statIncrease);
                    break;

                    
            }
            Player.addItemToArray(entity);
            entity.setMapEntityStatus(MapEntityStatus.REMOVED);
        }

        
        end();
        return ScriptState.COMPLETED;
    }
}

