package Maps.Floor1;

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
import Tilesets.Floor1Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class DungeonRoom10 extends Map {

    public DungeonRoom10() {
        super("DungeonMap10.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(4, 17).getLocation();
        this.mapInt = 10;
        this.idSwitch = 10;                //Aka "Real Life Bread"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
        Spikes spikes1 = new Spikes(getMapTile(6, 6).getLocation());
        Spikes spikes2 = new Spikes(getMapTile(6, 7).getLocation());
        Spikes spikes3 = new Spikes(getMapTile(7, 6).getLocation());
        Spikes spikes4 = new Spikes(getMapTile(7, 7).getLocation());
        Spikes spikes5 = new Spikes(getMapTile(10, 16).getLocation());
        Spikes spikes6 = new Spikes(getMapTile(10, 17).getLocation());
        Spikes spikes7 = new Spikes(getMapTile(11, 10).getLocation());
        Spikes spikes8 = new Spikes(getMapTile(11, 11).getLocation());
        Spikes spikes9 = new Spikes(getMapTile(11, 16).getLocation());
        Spikes spikes10 = new Spikes(getMapTile(11, 17).getLocation());
        Spikes spikes11 = new Spikes(getMapTile(12, 10).getLocation());
        Spikes spikes12 = new Spikes(getMapTile(12, 11).getLocation());
        Spikes spikes13 = new Spikes(getMapTile(15, 4).getLocation());
        Spikes spikes14 = new Spikes(getMapTile(15, 5).getLocation());
        Spikes spikes15 = new Spikes(getMapTile(16, 4).getLocation());
        Spikes spikes16 = new Spikes(getMapTile(16, 5).getLocation());
        Spikes spikes17 = new Spikes(getMapTile(18, 12).getLocation());
        Spikes spikes18 = new Spikes(getMapTile(18, 13).getLocation());
        Spikes spikes19 = new Spikes(getMapTile(19, 12).getLocation());
        Spikes spikes20 = new Spikes(getMapTile(19, 13).getLocation());
        Spikes spikes21 = new Spikes(getMapTile(22, 8).getLocation());
        Spikes spikes22 = new Spikes(getMapTile(22, 9).getLocation());
        Spikes spikes23 = new Spikes(getMapTile(23, 8).getLocation());
        Spikes spikes24 = new Spikes(getMapTile(23, 9).getLocation());
        Spikes spikes25 = new Spikes(getMapTile(24, 15).getLocation());
        Spikes spikes26 = new Spikes(getMapTile(24, 16).getLocation());
        Spikes spikes27 = new Spikes(getMapTile(25, 15).getLocation());
        Spikes spikes28 = new Spikes(getMapTile(25, 16).getLocation());
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
        enhancedMapTiles.add(spikes26);
        enhancedMapTiles.add(spikes27);
        enhancedMapTiles.add(spikes28);

            return enhancedMapTiles;
        }
        
        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            //Pickup coin = new Pickup(getMapTile(4,11).getLocation());
            //pickups.add(coin);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            Eggssassin eggssassin1 = new Eggssassin(0, getMapTile(20, 6).getLocation());
            eggssassin1.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin1);

            Eggssassin eggssassin2 = new Eggssassin(0, getMapTile(21, 16).getLocation());
            eggssassin2.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin2);
            
            return enemies;
        }
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(11,9).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(12,9).getLocation());
            pickups.add(coin1);

            Pickup coina = new Pickup(getMapTile(11,12).getLocation());
            pickups.add(coina);
    
            Pickup coin1b = new Pickup(getMapTile(12,12).getLocation());
            pickups.add(coin1b);
    
            Pickup coin2 = new Pickup(getMapTile(17,13).getLocation());
            pickups.add(coin2);
    
            Pickup coin3 = new Pickup(getMapTile(20,13).getLocation());
            pickups.add(coin3);
    
            Pickup coin4 = new Pickup(getMapTile(3,7).getLocation());
            pickups.add(coin4);
    
            Pickup coin5 = new Pickup(getMapTile(3,5).getLocation());
            pickups.add(coin5);
            Pickup coin6 = new Pickup(getMapTile(2,6).getLocation());
            pickups.add(coin6);
            
            return pickups;
    
        }
        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(26,6).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
