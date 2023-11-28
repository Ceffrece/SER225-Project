package Maps.Floor2;

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
import Tilesets.Floor2Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class D2Room4 extends Map {

    public D2Room4() {
        super("D2Room4.txt", new Floor2Tileset());
        this.playerStartPosition = getMapTile(10, 29).getLocation();
        this.mapInt = 14;
        this.idSwitch = 14;                //Aka "Scattered Rooms"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(7, 12).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(6, 13).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(7, 14).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(8, 13).getLocation());
            Spikes spikes5 = new Spikes(getMapTile(12, 8).getLocation());
            Spikes spikes6 = new Spikes(getMapTile(13, 7).getLocation());
            Spikes spikes7 = new Spikes(getMapTile(13, 9).getLocation());
            Spikes spikes8 = new Spikes(getMapTile(14, 8).getLocation());
            Spikes spikes9 = new Spikes(getMapTile(17, 12).getLocation());
            Spikes spikes10 = new Spikes(getMapTile(18, 11).getLocation());
            Spikes spikes11 = new Spikes(getMapTile(18, 13).getLocation());
            Spikes spikes12 = new Spikes(getMapTile(19, 12).getLocation());
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
    
            Pickup coin = new Pickup(getMapTile(2,3).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(7,3).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(2,28).getLocation());
            pickups.add(coin2);
    
            Pickup coin3 = new Pickup(getMapTile(19,28).getLocation());
            pickups.add(coin3);
    
            Pickup coin4 = new Pickup(getMapTile(3,17).getLocation());
            pickups.add(coin4);
    
            Pickup coin5 = new Pickup(getMapTile(17,16).getLocation());
            pickups.add(coin5);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            Spineapple spineapple1 = new Spineapple(0, getMapTile(2, 29).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            Spineapple spineapple2 = new Spineapple(0, getMapTile(19, 29).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);

            Spineapple spineapple3 = new Spineapple(0, getMapTile(2, 2).getLocation());
            spineapple3.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple3);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(17,3).setInteractScript(new RandomChangeMapScript(2));
    }
    
}
