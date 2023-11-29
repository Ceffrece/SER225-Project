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

public class D3Room8 extends Map {

    public D3Room8() {
        super("D3Room8.txt", new Floor3Tileset());
        this.playerStartPosition = getMapTile(18, 2).getLocation();
        this.mapInt = 28;
        this.idSwitch = 28;                //Aka "Just go Right Lmao"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(2, 5).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(4, 14).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(6, 5).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(6, 9).getLocation());
            Spikes spikes5 = new Spikes(getMapTile(10, 14).getLocation());
            Spikes spikes6 = new Spikes(getMapTile(11, 7).getLocation());
            Spikes spikes7 = new Spikes(getMapTile(11, 14).getLocation());
            Spikes spikes8 = new Spikes(getMapTile(12, 14).getLocation());
            Spikes spikes9 = new Spikes(getMapTile(13, 14).getLocation());
            Spikes spikes10 = new Spikes(getMapTile(16, 14).getLocation());
            Spikes spikes11 = new Spikes(getMapTile(17, 11).getLocation());
            Spikes spikes12 = new Spikes(getMapTile(19, 9).getLocation());
            Spikes spikes13 = new Spikes(getMapTile(22, 10).getLocation());
            Spikes spikes14 = new Spikes(getMapTile(26, 8).getLocation());
            Spikes spikes15 = new Spikes(getMapTile(27, 9).getLocation());
            Spikes spikes16 = new Spikes(getMapTile(27, 12).getLocation());
            Spikes spikes17 = new Spikes(getMapTile(27, 13).getLocation());
            Spikes spikes18 = new Spikes(getMapTile(28, 8).getLocation());
            Spikes spikes19 = new Spikes(getMapTile(32, 9).getLocation());
            Spikes spikes20 = new Spikes(getMapTile(33, 12).getLocation());
            Spikes spikes21 = new Spikes(getMapTile(34, 5).getLocation());
            Spikes spikes22 = new Spikes(getMapTile(36, 11).getLocation());
            Spikes spikes23 = new Spikes(getMapTile(38, 5).getLocation());
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
            enhancedMapTiles.add(spikes12);
            enhancedMapTiles.add(spikes13);
            enhancedMapTiles.add(spikes14);
            enhancedMapTiles.add(spikes15);
            enhancedMapTiles.add(spikes16);
            enhancedMapTiles.add(spikes17);
            enhancedMapTiles.add(spikes18);
            enhancedMapTiles.add(spikes19);
            enhancedMapTiles.add(spikes20);
            enhancedMapTiles.add(spikes21);
            enhancedMapTiles.add(spikes22);
            enhancedMapTiles.add(spikes23);
    
            return enhancedMapTiles;
        }
        
        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(2,6).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(2,15).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(38,6).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(38,15).getLocation());
            pickups.add(coin3);

            Pickup coin4 = new Pickup(getMapTile(27,8).getLocation());
            pickups.add(coin4);
    
            Pickup coin5 = new Pickup(getMapTile(13,11).getLocation());
            pickups.add(coin5);

            Pickup coin6 = new Pickup(getMapTile(34,6).getLocation());
            pickups.add(coin6);
    
            Pickup coin7 = new Pickup(getMapTile(24,10).getLocation());
            pickups.add(coin7);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(22,2).setInteractScript(new RandomChangeMapScript(3));
    }
    
}
