package Scripts.TestMap;

import Game.GameState;
import Level.Camera;
import Level.Map;
import Level.Script;
import Level.ScriptState;

import Players.Cat;
import Game.GameState;
import Game.ScreenCoordinator;



public class ChangeMapScript extends Script {

        
    private int mapID;

        public ChangeMapScript(int mapID) {
        this.mapID = mapID;
    }


    @Override
    protected void setup() {

    }

    @Override
    protected void cleanup() {

    }

    @Override
    protected ScriptState execute() {
        map.setIdSwitch(mapID);
        return ScriptState.COMPLETED;
    }
}