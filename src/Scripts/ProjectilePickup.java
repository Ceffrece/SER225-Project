package Scripts ;

import Level.Item;
import Level.MapEntityStatus;
import Level.Player;
import Level.Script;
import Level.ScriptState;

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
                    
            }
    
        entity.setMapEntityStatus(MapEntityStatus.REMOVED);
        end();
        return ScriptState.COMPLETED;
    }
}

