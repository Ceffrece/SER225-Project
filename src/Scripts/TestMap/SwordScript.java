package Scripts.TestMap;

import Level.Item;
import Level.MapEntityStatus;
import Level.Player;
import Level.Script;
import Level.ScriptState;

public class SwordScript extends Script<Item>{

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
        Player.addItemToArray(entity);
        Player.setCurrentItem(entity);
        
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
                case "maxHealth":  Player.addAttackDamage(entity.statIncrease);
                        break;
                case "invincibilityTimer":  player.addIncibilityTimer(entity.statIncrease);
                        break;
                case "dash":  Player.addDash(entity.statIncrease);
                        break;
                case "playerArmor":  Player.addPlayerArmor(entity.statIncrease);
                        break;
                case "critChance":  Player.addCritChance(entity.statIncrease);
                        break;
            }
    
        entity.setMapEntityStatus(MapEntityStatus.REMOVED);
        end();
        return ScriptState.COMPLETED;
    }
}

