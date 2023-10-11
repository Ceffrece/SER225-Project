package Scripts.TestMap;

import Level.Item;
import Level.MapEntity;
import Level.MapEntityStatus;
import Level.NPC;
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
        entity.setMapEntityStatus(MapEntityStatus.REMOVED);
        System.out.println(map);
        end();
        return ScriptState.COMPLETED;
    }
}
