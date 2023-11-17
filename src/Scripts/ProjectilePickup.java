package Scripts ;

import Level.Currency;
import Level.Item;
import Level.MapEntityStatus;
import Level.Player;
import Level.Script;
import Level.ScriptState;
import Level.Currency;

public class ProjectilePickup extends Script<Item>{


      
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
        System.out.println(Currency.normalCurrency);

        if(entity.cost <= Currency.normalCurrency){
            Currency.purchaseItem(entity.cost, 0);
            switch (entity.projectileToAdd) {
                case "peaProjectile":  
                    Player.addProjectile("peaProjectile");
                    break;

                case "riceBallProjectile":
                    Player.addProjectile("riceBallProjectile");

                    break;
                case "bannanaProjectile":
                    Player.addProjectile("bannanaProjectile");
                    break;
                case "peporoniSlicer":
                    Player.addProjectile("peporoniSlicer");
                    break;
                case "cheese":
                    Player.addProjectile("cheese");
                    break;
                case "carrotProjectile":
                    Player.addProjectile("carrotProjectile");
                    break;

             default :
             Player.addProjectile("riceBallProjectile");
             break;
                    
            }
            entity.setMapEntityStatus(MapEntityStatus.REMOVED);
        }
        System.out.println(Currency.normalCurrency);

        
        end();
        return ScriptState.COMPLETED;
    }
}

