package Maps.Floor1;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import EnhancedMapTiles.Spikes;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Map;
import Level.Pickup;
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

    // Where coins go
    public ArrayList<Pickup> loadPickups() {
        ArrayList<Pickup> pickups = new ArrayList<>();

        Pickup coin = new Pickup(getMapTile(4,11).getLocation());
        pickups.add(coin);

        Pickup coin1 = new Pickup(getMapTile(4,16).getLocation());
        pickups.add(coin1);

        Pickup coin2 = new Pickup(getMapTile(20,11).getLocation());
        pickups.add(coin2);

        Pickup coin3 = new Pickup(getMapTile(20,16).getLocation());
        pickups.add(coin3);

        Pickup coin4 = new Pickup(getMapTile(9,4).getLocation());
        pickups.add(coin4);

        Pickup coin5 = new Pickup(getMapTile(15,4).getLocation());
        pickups.add(coin5);
        
        return pickups;

    }

        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();
    
            CerealKiller cerealkiller2 = new CerealKiller(0, getMapTile(4, 12).getLocation());
            cerealkiller2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(cerealkiller2);
    
            CerealKiller cerealkiller1 = new CerealKiller(0, getMapTile(20, 12).getLocation());
            cerealkiller1.setExistenceFlag("hasTalkedToCerealKiller");
            enemies.add(cerealkiller1);
    
            Eggssassin eggssassin1 = new Eggssassin(0, getMapTile(12, 5).getLocation());
            eggssassin1.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin1);
    
           
    
            
            return enemies;
        }
    @Override
    public void loadScripts() {
        
        getMapTile(12,2).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
