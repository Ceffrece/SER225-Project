package Maps.Floor2;

import java.util.ArrayList;

import Enemy.CauliflowerCreeper;
import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import EnhancedMapTiles.Spikes;
import Level.EnhancedMapTile;
import Level.Enemy;
import Level.Map;
import Level.Pickup;
import Level.Tileset;
import Tilesets.Floor2Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class D2Room2 extends Map {

    public D2Room2() {
        super("D2Room2.txt", new Floor2Tileset());
        this.playerStartPosition = getMapTile(2, 26).getLocation();
        this.mapInt = 12;
        this.idSwitch = 12;                //Aka "I Accidentally Made the Team Fortress 2 Logo so Now It's a Map"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(14, 14).getLocation());
            enhancedMapTiles.add(spikes1);
    
            return enhancedMapTiles;
        }

        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(2,14).getLocation());
            pickups.add(coin);

            Pickup coin2 = new Pickup(getMapTile(14,2).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(14,26).getLocation());
            pickups.add(coin3);

            Pickup coin4 = new Pickup(getMapTile(26,14).getLocation());
            pickups.add(coin4);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            CauliflowerCreeper spineapple1 = new CauliflowerCreeper(0, getMapTile(2, 2).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            CauliflowerCreeper spineapple2 = new CauliflowerCreeper(0, getMapTile(26, 26).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(26,2).setInteractScript(new RandomChangeMapScript(2));
    }
    
}
