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

public class D3Room10 extends Map {

    public D3Room10() {
        super("D3Room10.txt", new Floor3Tileset());
        this.playerStartPosition = getMapTile(15, 11).getLocation();
        this.mapInt = 30;
        this.idSwitch = 30;                //Aka "Phoned in Cheese Wheel"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(3, 13).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(3, 17).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(6, 11).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(6, 15).getLocation());
            Spikes spikes5 = new Spikes(getMapTile(6, 19).getLocation());
            Spikes spikes6 = new Spikes(getMapTile(23, 13).getLocation());
            Spikes spikes7 = new Spikes(getMapTile(23, 17).getLocation());
            Spikes spikes8 = new Spikes(getMapTile(24, 12).getLocation());
            Spikes spikes9 = new Spikes(getMapTile(24, 18).getLocation());
            Spikes spikes10 = new Spikes(getMapTile(25, 11).getLocation());
            Spikes spikes11 = new Spikes(getMapTile(25, 19).getLocation());
            enhancedMapTiles.add(spikes1);
            enhancedMapTiles.add(spikes2);
            enhancedMapTiles.add(spikes3);
            enhancedMapTiles.add(spikes4);
            enhancedMapTiles.add(spikes5);
            enhancedMapTiles.add(spikes6);
            enhancedMapTiles.add(spikes7);
            enhancedMapTiles.add(spikes8);
            enhancedMapTiles.add(spikes9);
            enhancedMapTiles.add(spikes10);
            enhancedMapTiles.add(spikes11);
    
            return enhancedMapTiles;
        }
        
        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(15,9).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(9,15).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(15,21).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(21,15).getLocation());
            pickups.add(coin3);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            Spineapple spineapple1 = new Spineapple(0, getMapTile(15, 3).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            Spineapple spineapple2 = new Spineapple(0, getMapTile(14, 27).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);

            Spineapple spineapple3 = new Spineapple(0, getMapTile(16, 27).getLocation());
            spineapple3.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple3);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(19,15).setInteractScript(new RandomChangeMapScript(3));
    }
    
}
