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

public class DungeonRoom3 extends Map {

    public DungeonRoom3() {
        super("DungeonMap3.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(4, 19).getLocation();
        this.mapInt = 3;
        this.idSwitch = 3;                //Aka "Lava Donut"
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

            CerealKiller cerealkiller1 = new CerealKiller(0, getMapTile(5, 5).getLocation());
            cerealkiller1.setExistenceFlag("hasTalkedToCerealKiller");
            enemies.add(cerealkiller1);

            CerealKiller cerealkiller2 = new CerealKiller(0, getMapTile(19, 18).getLocation());
            cerealkiller2.setExistenceFlag("hasTalkedToCerealKiller");
            enemies.add(cerealkiller2);

            CerealKiller cerealkiller3 = new CerealKiller(0, getMapTile(17, 3).getLocation());
            cerealkiller3.setExistenceFlag("hasTalkedToCerealKiller");
            enemies.add(cerealkiller3);

            CerealKiller cerealkiller4 = new CerealKiller(0, getMapTile(19, 7).getLocation());
            cerealkiller4.setExistenceFlag("hasTalkedToCerealKiller");
            enemies.add(cerealkiller4);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(19,4).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
