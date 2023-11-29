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

public class D2Room7 extends Map {

    public D2Room7() {
        super("D2Room7.txt", new Floor2Tileset());
        this.playerStartPosition = getMapTile(15, 17).getLocation();
        this.mapInt = 17;
        this.idSwitch = 17;                //Aka "Planned Pathing"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(1, 8).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(1, 9).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(1, 10).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(1, 11).getLocation());
            Spikes spikes5 = new Spikes(getMapTile(1, 12).getLocation());
            Spikes spikes6 = new Spikes(getMapTile(1, 13).getLocation());
            Spikes spikes7 = new Spikes(getMapTile(1, 14).getLocation());
            Spikes spikes8 = new Spikes(getMapTile(1, 15).getLocation());
            Spikes spikes9 = new Spikes(getMapTile(2, 8).getLocation());
            Spikes spikes10 = new Spikes(getMapTile(3, 8).getLocation());
            Spikes spikes11 = new Spikes(getMapTile(5, 13).getLocation());
            Spikes spikes12 = new Spikes(getMapTile(5, 14).getLocation());
            Spikes spikes13 = new Spikes(getMapTile(5, 15).getLocation());
            Spikes spikes14 = new Spikes(getMapTile(7, 1).getLocation());
            Spikes spikes15 = new Spikes(getMapTile(7, 2).getLocation());
            Spikes spikes16 = new Spikes(getMapTile(7, 3).getLocation());
            Spikes spikes17 = new Spikes(getMapTile(7, 4).getLocation());
            Spikes spikes18 = new Spikes(getMapTile(8, 1).getLocation());
            Spikes spikes19 = new Spikes(getMapTile(9, 1).getLocation());
            Spikes spikes20 = new Spikes(getMapTile(10, 1).getLocation());
            Spikes spikes21 = new Spikes(getMapTile(11, 1).getLocation());
            Spikes spikes22 = new Spikes(getMapTile(12, 1).getLocation());
            Spikes spikes23 = new Spikes(getMapTile(11, 5).getLocation());
            Spikes spikes24 = new Spikes(getMapTile(12, 5).getLocation());
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
            enhancedMapTiles.add(spikes24);
    
            return enhancedMapTiles;
        }

        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(6,7).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(9,7).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(6,10).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(9,10).getLocation());
            pickups.add(coin3);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            Spineapple spineapple1 = new Spineapple(0, getMapTile(15, 3).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            Spineapple spineapple2 = new Spineapple(0, getMapTile(19, 3).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(2,18).setInteractScript(new RandomChangeMapScript(2));
    }
    
}
