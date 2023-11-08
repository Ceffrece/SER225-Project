package Maps.Floor1;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import EnhancedMapTiles.Spikes;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Map;
import Level.Tileset;
import Tilesets.Floor1Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class DungeonRoom1 extends Map {

    public DungeonRoom1() {
        super("DungeonMap.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(12, 24).getLocation();
        this.mapInt = 1;
        this.idSwitch = 1;                //aka "The Former Hub Room"
        }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        Spikes spikes1 = new Spikes(getMapTile(3, 10).getLocation());
        Spikes spikes2 = new Spikes(getMapTile(3, 17).getLocation());
        Spikes spikes3 = new Spikes(getMapTile(21, 10).getLocation());
        Spikes spikes4 = new Spikes(getMapTile(21, 17).getLocation());
        enhancedMapTiles.add(spikes1);
        enhancedMapTiles.add(spikes2);
        enhancedMapTiles.add(spikes3);
        enhancedMapTiles.add(spikes4);

        return enhancedMapTiles;
    }

        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();
    
            Spineapple spineapple1 = new Spineapple(0, getMapTile(2, 12).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);
    
            CerealKiller cerealkiller2 = new CerealKiller(0, getMapTile(22, 13).getLocation());
            cerealkiller2.setExistenceFlag("hasTalkedToCerealKiller");
            enemies.add(cerealkiller2);
    
            Eggssassin eggssassin1 = new Eggssassin(0, getMapTile(13, 5).getLocation());
            eggssassin1.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin1);
    
           
    
            
            return enemies;
        }
    @Override
    public void loadScripts() {
        getMapTile(12,2).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
