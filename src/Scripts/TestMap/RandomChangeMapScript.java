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
    public static ArrayList<Integer> floor2 = new ArrayList<>();
    public static ArrayList<Integer> floor3 = new ArrayList<>(); 

    
    private int floor;
    public static boolean floor1Loaded = false;
    public static boolean floor2Loaded = false;
    public static boolean floor3Loaded = false;
    
    public RandomChangeMapScript(int floor) {
        if(!floor1Loaded){
            floor1.add(1);
            floor1.add(2);
            floor1.add(3);
            floor1.add(4);
            floor1.add(5);
            floor1.add(6);
            floor1.add(7);
            floor1.add(8);
            floor1.add(9);
            floor1.add(10);
        }
        floor1Loaded = true;
        if(!floor2Loaded){
            floor2.add(11);
            floor2.add(12);
            floor2.add(13);
            floor2.add(14);
            floor2.add(15);
            floor2.add(16);
            floor2.add(17);
            floor2.add(18);
            floor2.add(19);
            floor2.add(20);
        }
        floor2Loaded = true;
        if(!floor3Loaded){
            floor3.add(21);
            floor3.add(22);
            floor3.add(23);
            floor3.add(24);
            floor3.add(25);
            floor3.add(26);
            floor3.add(27);
            floor3.add(28);
            floor3.add(29);
            floor3.add(30);
        }
        floor3Loaded = true;
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
        if (this.map.getEnemies().size() == 0) {
            switch(floor){
                case 1:
                    if(floor1.size() > 5){
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
                case 2:
                    if(floor2.size() > 5){
                        int mapToGoTo =(int) ((Math.random() * floor2.size()) + 1);
                        System.out.println(floor2.get(mapToGoTo-1));
                        floorsVisited.add(floor2.get(mapToGoTo-1));
                        map.setIdSwitch(floor2.get(mapToGoTo-1));
                        floor2.remove(mapToGoTo-1);
                    }
                    else{
                        //change to boss room
                        for(int i = 0; i >= floorsVisited.size(); i++){
                            floor2.add(floorsVisited.get(i));
                        }
                        map.setIdSwitch(102);
                    }
                    break;
                case 3:
                    if(floor3.size() > 5){
                        int mapToGoTo =(int) ((Math.random() * floor3.size()) + 1);
                        System.out.println(floor3.get(mapToGoTo-1));
                        floorsVisited.add(floor3.get(mapToGoTo-1));
                        map.setIdSwitch(floor3.get(mapToGoTo-1));
                        floor3.remove(mapToGoTo-1);
                    }
                    else{
                        //change to boss room
                        for(int i = 0; i >= floorsVisited.size(); i++){
                            floor3.add(floorsVisited.get(i));
                        }
                        map.setIdSwitch(104);
                    }
                    break;
                default:
                    break;

            }
        }
        // System.out.println(mapSwitchID + ", "+map.getMapInt());
        // map.setIdSwitch(mapSwitchID);
        
        return ScriptState.COMPLETED;
    }
}