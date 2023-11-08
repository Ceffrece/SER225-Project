package Maps.Floor1;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import Level.Enemy;
import Level.Map;
import Level.Tileset;
import Tilesets.Floor1Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class Floor1Boss extends Map {

    public Floor1Boss() {
        super("Floor1BossRoom.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(12, 24).getLocation();
        this.mapInt = 100;
        this.idSwitch = 100;                //TODO Auto-generated constructor stub
        }


        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();
    
           
    
            
    
           
    
            
            return enemies;
        }
    @Override
    public void loadScripts() {
        

        getMapTile(12,2).setInteractScript(new ChangeMapScript(0));
    }
    
}
