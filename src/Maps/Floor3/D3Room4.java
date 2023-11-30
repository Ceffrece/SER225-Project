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

public class D3Room4 extends Map {

    public D3Room4() {
        super("D3Room4.txt", new Floor3Tileset());
        this.playerStartPosition = getMapTile(2, 2).getLocation();
        this.mapInt = 24;
        this.idSwitch = 24;                //Aka "The House Always Wins"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(4, 6).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(4, 7).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(5, 6).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(5, 7).getLocation());
            Spikes spikes5 = new Spikes(getMapTile(6, 6).getLocation());
            Spikes spikes6 = new Spikes(getMapTile(6, 7).getLocation());
            Spikes spikes7 = new Spikes(getMapTile(42, 6).getLocation());
            Spikes spikes8 = new Spikes(getMapTile(42, 7).getLocation());
            Spikes spikes9 = new Spikes(getMapTile(43, 6).getLocation());
            Spikes spikes10 = new Spikes(getMapTile(43, 7).getLocation());
            Spikes spikes11 = new Spikes(getMapTile(44, 6).getLocation());
            Spikes spikes12 = new Spikes(getMapTile(44, 7).getLocation());
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
    
            return enhancedMapTiles;
        }

        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(17,7).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(18,6).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(19,7).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(20,6).getLocation());
            pickups.add(coin3);

            Pickup coin4 = new Pickup(getMapTile(21,7).getLocation());
            pickups.add(coin4);
    
            Pickup coin5 = new Pickup(getMapTile(22,6).getLocation());
            pickups.add(coin5);

            Pickup coin6 = new Pickup(getMapTile(23,7).getLocation());
            pickups.add(coin6);
    
            Pickup coin7 = new Pickup(getMapTile(24,6).getLocation());
            pickups.add(coin7);
    
            Pickup coin8 = new Pickup(getMapTile(25,7).getLocation());
            pickups.add(coin8);

            Pickup coin9 = new Pickup(getMapTile(26,6).getLocation());
            pickups.add(coin9);

            Pickup coin10 = new Pickup(getMapTile(27,7).getLocation());
            pickups.add(coin10);
    
            Pickup coin11 = new Pickup(getMapTile(28,6).getLocation());
            pickups.add(coin11);

            Pickup coin12 = new Pickup(getMapTile(29,7).getLocation());
            pickups.add(coin12);

            Pickup coin13 = new Pickup(getMapTile(30,6).getLocation());
            pickups.add(coin13);
    
            Pickup coin14 = new Pickup(getMapTile(31,7).getLocation());
            pickups.add(coin14);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            CerealKiller spineapple1 = new CerealKiller(0, getMapTile(24, 2).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(46,2).setInteractScript(new RandomChangeMapScript(3));
    }
    
}
