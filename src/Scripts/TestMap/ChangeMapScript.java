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

    private int mapSwitchID;
        public ChangeMapScript(int mapSwitchID) {
        this.mapSwitchID = mapSwitchID;
    }


    @Override
    protected void setup() {

    }

    @Override
    protected void cleanup() {

    }

    @Override
    protected ScriptState execute() {
        System.out.println(mapSwitchID + ", "+map.getMapInt());
        map.setIdSwitch(mapSwitchID);
        
        return ScriptState.COMPLETED;
    }
}