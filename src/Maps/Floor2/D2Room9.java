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

public class D2Room9 extends Map {

    public D2Room9() {
        super("D2Room9.txt", new Floor2Tileset());
        this.playerStartPosition = getMapTile(12, 12).getLocation();
        this.mapInt = 19;
        this.idSwitch = 19;                //Aka "Four Cheese Vegetable"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(14, 14).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(14, 16).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(14, 18).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(14, 20).getLocation());
            Spikes spikes5 = new Spikes(getMapTile(14, 22).getLocation());
            Spikes spikes6 = new Spikes(getMapTile(16, 14).getLocation());
            Spikes spikes7 = new Spikes(getMapTile(16, 16).getLocation());
            Spikes spikes8 = new Spikes(getMapTile(16, 18).getLocation());
            Spikes spikes9 = new Spikes(getMapTile(16, 20).getLocation());
            Spikes spikes10 = new Spikes(getMapTile(16, 22).getLocation());
            Spikes spikes11 = new Spikes(getMapTile(18, 14).getLocation());
            Spikes spikes12 = new Spikes(getMapTile(18, 16).getLocation());
            Spikes spikes13 = new Spikes(getMapTile(18, 18).getLocation());
            Spikes spikes14 = new Spikes(getMapTile(18, 20).getLocation());
            Spikes spikes15 = new Spikes(getMapTile(18, 22).getLocation());
            Spikes spikes16 = new Spikes(getMapTile(20, 14).getLocation());
            Spikes spikes17 = new Spikes(getMapTile(20, 16).getLocation());
            Spikes spikes18 = new Spikes(getMapTile(20, 18).getLocation());
            Spikes spikes19 = new Spikes(getMapTile(20, 20).getLocation());
            Spikes spikes20 = new Spikes(getMapTile(20, 22).getLocation());
            Spikes spikes21 = new Spikes(getMapTile(22, 14).getLocation());
            Spikes spikes22 = new Spikes(getMapTile(22, 16).getLocation());
            Spikes spikes23 = new Spikes(getMapTile(22, 18).getLocation());
            Spikes spikes24 = new Spikes(getMapTile(22, 20).getLocation());
            Spikes spikes25 = new Spikes(getMapTile(22, 22).getLocation());
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
            enhancedMapTiles.add(spikes25);
    
            return enhancedMapTiles;
        }

        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(1,12).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(12,1).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(12,23).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(23,12).getLocation());
            pickups.add(coin3);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            Spineapple spineapple1 = new Spineapple(0, getMapTile(2, 12).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            Spineapple spineapple2 = new Spineapple(0, getMapTile(12, 2).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);

            Spineapple spineapple3 = new Spineapple(0, getMapTile(12, 22).getLocation());
            spineapple3.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple3);

            Spineapple spineapple4 = new Spineapple(0, getMapTile(21, 12).getLocation());
            spineapple4.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple4);

            Spineapple spineapple5 = new Spineapple(0, getMapTile(1, 1).getLocation());
            spineapple5.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple5);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(22,12).setInteractScript(new RandomChangeMapScript(2));
    }
    
}
