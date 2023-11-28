package Maps.Floor1;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import EnhancedMapTiles.Spikes;
import Level.EnhancedMapTile;
import Level.Enemy;
import Level.Map;
import Level.Pickup;
import Level.Tileset;
import Tilesets.Floor1Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class DungeonRoom5 extends Map {

    public DungeonRoom5() {
        super("DungeonMap5.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(3, 8).getLocation();
        this.mapInt = 5;
        this.idSwitch = 5;                //Aka "C The Sequel"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    

    
            return enhancedMapTiles;
        }

        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            //Pickup coin = new Pickup(getMapTile(4,11).getLocation());
            //pickups.add(coin);
            
            return pickups;
    
        }
        
        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            CerealKiller cerealkiller1 = new CerealKiller(0, getMapTile(19, 5).getLocation());
            cerealkiller1.setExistenceFlag("hasTalkedToCerealKiller");
            enemies.add(cerealkiller1);

            CerealKiller cerealkiller2 = new CerealKiller(0, getMapTile(5, 19).getLocation());
            cerealkiller2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(cerealkiller2);
    
            Eggssassin eggssassin1 = new Eggssassin(0, getMapTile(19, 19).getLocation());
            eggssassin1.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin1);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(3,16).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
