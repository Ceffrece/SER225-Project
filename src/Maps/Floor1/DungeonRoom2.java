package Maps.Floor1;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import EnhancedMapTiles.Spikes;
import Level.EnhancedMapTile;
import Level.Enemy;
import Level.Map;
import Level.Tileset;
import Tilesets.Floor1Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class DungeonRoom2 extends Map {

    public DungeonRoom2() {
        super("DungeonMap2.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(12, 24).getLocation();
        this.mapInt = 2;
        this.idSwitch = 2;                //TODO Auto-generated constructor stub
        }


        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();
    
           
    
            CerealKiller cerealkiller2 = new CerealKiller(0, getMapTile(3, 12).getLocation());
            cerealkiller2.setExistenceFlag("hasTalkedToCerealKiller");
            enemies.add(cerealkiller2);
    
            Eggssassin eggssassin1 = new Eggssassin(0, getMapTile(10, 14).getLocation());
            eggssassin1.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin1);
    
           
    
            
            return enemies;
        }
    @Override
    public void loadScripts() {

        getMapTile(12,2).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
