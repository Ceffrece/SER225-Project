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

public class D3Room9 extends Map {

    public D3Room9() {
        super("D3Room9.txt", new Floor3Tileset());
        this.playerStartPosition = getMapTile(41, 10).getLocation();
        this.mapInt = 29;
        this.idSwitch = 29;                //Aka "Hey Where's the Dairy Aisle?"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(14, 6).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(14, 10).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(14, 14).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(39, 6).getLocation());
            Spikes spikes5 = new Spikes(getMapTile(39, 10).getLocation());
            Spikes spikes6 = new Spikes(getMapTile(39, 14).getLocation());
            enhancedMapTiles.add(spikes1);
            enhancedMapTiles.add(spikes2);
            enhancedMapTiles.add(spikes3);
            enhancedMapTiles.add(spikes4);
            enhancedMapTiles.add(spikes5);
            enhancedMapTiles.add(spikes6);
    
            return enhancedMapTiles;
        }
        
        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(5,7).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(5,10).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(5,13).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(5,16).getLocation());
            pickups.add(coin3);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            Spineapple spineapple1 = new Spineapple(0, getMapTile(8, 5).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            Spineapple spineapple2 = new Spineapple(0, getMapTile(8, 8).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);

            Spineapple spineapple3 = new Spineapple(0, getMapTile(8, 11).getLocation());
            spineapple3.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple3);

            Spineapple spineapple4 = new Spineapple(0, getMapTile(8, 14).getLocation());
            spineapple4.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple4);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(1,15).setInteractScript(new RandomChangeMapScript(3));
    }
    
}
