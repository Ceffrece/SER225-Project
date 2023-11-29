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

public class D3Room6 extends Map {

    public D3Room6() {
        super("D3Room6.txt", new Floor3Tileset());
        this.playerStartPosition = getMapTile(2, 2).getLocation();
        this.mapInt = 26;
        this.idSwitch = 26;                //Aka "Leaking Bottle of Milk"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(10, 2).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(10, 17).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(17, 2).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(17, 17).getLocation());
            enhancedMapTiles.add(spikes1);
            enhancedMapTiles.add(spikes2);
            enhancedMapTiles.add(spikes3);
            enhancedMapTiles.add(spikes4);
    
            return enhancedMapTiles;
        }
        
        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(10,6).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(10,13).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(17,6).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(17,13).getLocation());
            pickups.add(coin3);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            Spineapple spineapple1 = new Spineapple(0, getMapTile(2, 17).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            Spineapple spineapple2 = new Spineapple(0, getMapTile(25, 2).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);

            Spineapple spineapple3 = new Spineapple(0, getMapTile(24, 17).getLocation());
            spineapple3.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple3);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(25,17).setInteractScript(new RandomChangeMapScript(3));
    }
    
}
