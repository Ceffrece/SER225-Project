package Maps.Floor3;

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
import Tilesets.Floor3Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class D3Room3 extends Map {

    public D3Room3() {
        super("D3Room3.txt", new Floor3Tileset());
        this.playerStartPosition = getMapTile(12, 13).getLocation();
        this.mapInt = 23;
        this.idSwitch = 23;                //Aka "Milk Inside a Box of Milk Inside a Box of Milk"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(4, 4).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(4, 21).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(7, 11).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(8, 11).getLocation());
            Spikes spikes5 = new Spikes(getMapTile(11, 7).getLocation());
            Spikes spikes6 = new Spikes(getMapTile(11, 8).getLocation());
            Spikes spikes7 = new Spikes(getMapTile(14, 10).getLocation());
            Spikes spikes8 = new Spikes(getMapTile(15, 11).getLocation());
            Spikes spikes9 = new Spikes(getMapTile(21, 4).getLocation());
            enhancedMapTiles.add(spikes1);
            enhancedMapTiles.add(spikes2);
            enhancedMapTiles.add(spikes3);
            enhancedMapTiles.add(spikes4);
            enhancedMapTiles.add(spikes5);
            enhancedMapTiles.add(spikes6);
            enhancedMapTiles.add(spikes7);
            enhancedMapTiles.add(spikes8);
            enhancedMapTiles.add(spikes9);
    
            return enhancedMapTiles;
        }

        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(3,3).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(5,5).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(3,22).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(5,20).getLocation());
            pickups.add(coin3);

            Pickup coin4 = new Pickup(getMapTile(20,5).getLocation());
            pickups.add(coin4);
    
            Pickup coin5 = new Pickup(getMapTile(22,3).getLocation());
            pickups.add(coin5);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            Spineapple spineapple1 = new Spineapple(0, getMapTile(4, 6).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            Spineapple spineapple2 = new Spineapple(0, getMapTile(6, 4).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(21,21).setInteractScript(new RandomChangeMapScript(3));
    }
    
}
