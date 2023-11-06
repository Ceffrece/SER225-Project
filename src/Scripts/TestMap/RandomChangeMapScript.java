package Scripts.TestMap;

import java.util.ArrayList;

import Game.GameState;
import Level.Camera;
import Level.Map;
import Level.Script;
import Level.ScriptState;

import Players.Cat;
import Game.GameState;
import Game.ScreenCoordinator;
import java.lang.Math;

 

public class RandomChangeMapScript extends Script {
    public static ArrayList<Integer> floorsVisited = new ArrayList<>(); 

    public static ArrayList<Integer> floor1 = new ArrayList<>(); 

    
    private int floor;
    public static boolean floor1Loaded = false;
    
    public RandomChangeMapScript(int floor) {
        if(!floor1Loaded){
            floor1.add(1);
            floor1.add(2);
        }
        floor1Loaded = true;
        this.floor = floor;

    }


    @Override
    protected void setup() {

    }

    @Override
    protected void cleanup() {

    }

    @Override
    protected ScriptState execute() {
        switch(floor){
            case 1:
                if(floor1.size() > 0){
                    int mapToGoTo =(int) ((Math.random() * floor1.size()) + 1);
                    System.out.println(floor1.get(mapToGoTo-1));
                    floorsVisited.add(floor1.get(mapToGoTo-1));
                    map.setIdSwitch(floor1.get(mapToGoTo-1));
                    floor1.remove(mapToGoTo-1);
                }
                else{
                    //change to boss room
                    for(int i = 0; i >= floorsVisited.size(); i++){
                        floor1.add(floorsVisited.get(i));
                    }
                    map.setIdSwitch(100);
                }
                
                break;
            default:
                break;

        }
        // System.out.println(mapSwitchID + ", "+map.getMapInt());
        // map.setIdSwitch(mapSwitchID);
        
        return ScriptState.COMPLETED;
    }
}