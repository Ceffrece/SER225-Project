package Maps.Floor2;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.KiwiKamikaze;
import Enemy.MachoMandarin;
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

public class D2Room10 extends Map {

    public D2Room10() {
        super("D2Room10.txt", new Floor2Tileset());
        this.playerStartPosition = getMapTile(9, 14).getLocation();
        this.mapInt = 20;
        this.idSwitch = 20;                //Aka "Moldy Watermelon"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(8, 2).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(8, 3).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(9, 2).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(9, 3).getLocation());
            Spikes spikes5 = new Spikes(getMapTile(11, 7).getLocation());
            Spikes spikes6 = new Spikes(getMapTile(11, 8).getLocation());
            Spikes spikes7 = new Spikes(getMapTile(12, 7).getLocation());
            Spikes spikes8 = new Spikes(getMapTile(12, 8).getLocation());
            Spikes spikes9 = new Spikes(getMapTile(14, 2).getLocation());
            Spikes spikes10 = new Spikes(getMapTile(14, 3).getLocation());
            Spikes spikes11 = new Spikes(getMapTile(14, 12).getLocation());
            Spikes spikes12 = new Spikes(getMapTile(14, 13).getLocation());
            Spikes spikes13 = new Spikes(getMapTile(15, 2).getLocation());
            Spikes spikes14 = new Spikes(getMapTile(15, 3).getLocation());
            Spikes spikes15 = new Spikes(getMapTile(15, 12).getLocation());
            Spikes spikes16 = new Spikes(getMapTile(15, 13).getLocation());
            Spikes spikes17 = new Spikes(getMapTile(17, 7).getLocation());
            Spikes spikes18 = new Spikes(getMapTile(17, 8).getLocation());
            Spikes spikes19 = new Spikes(getMapTile(18, 7).getLocation());
            Spikes spikes20 = new Spikes(getMapTile(18, 8).getLocation());
            Spikes spikes21 = new Spikes(getMapTile(20, 2).getLocation());
            Spikes spikes22 = new Spikes(getMapTile(20, 3).getLocation());
            Spikes spikes23 = new Spikes(getMapTile(20, 12).getLocation());
            Spikes spikes24 = new Spikes(getMapTile(20, 13).getLocation());
            Spikes spikes25 = new Spikes(getMapTile(21, 2).getLocation());
            Spikes spikes26 = new Spikes(getMapTile(21, 3).getLocation());
            Spikes spikes27 = new Spikes(getMapTile(21, 12).getLocation());
            Spikes spikes28 = new Spikes(getMapTile(21, 13).getLocation());
            Spikes spikes29 = new Spikes(getMapTile(23, 7).getLocation());
            Spikes spikes30 = new Spikes(getMapTile(23, 8).getLocation());
            Spikes spikes31 = new Spikes(getMapTile(24, 7).getLocation());
            Spikes spikes32 = new Spikes(getMapTile(24, 8).getLocation());
            Spikes spikes33 = new Spikes(getMapTile(26, 2).getLocation());
            Spikes spikes34 = new Spikes(getMapTile(26, 3).getLocation());
            Spikes spikes35 = new Spikes(getMapTile(26, 12).getLocation());
            Spikes spikes36 = new Spikes(getMapTile(26, 13).getLocation());
            Spikes spikes37 = new Spikes(getMapTile(27, 2).getLocation());
            Spikes spikes38 = new Spikes(getMapTile(27, 3).getLocation());
            Spikes spikes39 = new Spikes(getMapTile(27, 12).getLocation());
            Spikes spikes40 = new Spikes(getMapTile(27, 13).getLocation());
            Spikes spikes41 = new Spikes(getMapTile(29, 7).getLocation());
            Spikes spikes42 = new Spikes(getMapTile(29, 8).getLocation());
            Spikes spikes43 = new Spikes(getMapTile(30, 7).getLocation());
            Spikes spikes44 = new Spikes(getMapTile(30, 8).getLocation());
            Spikes spikes45 = new Spikes(getMapTile(32, 2).getLocation());
            Spikes spikes46 = new Spikes(getMapTile(32, 3).getLocation());
            Spikes spikes47 = new Spikes(getMapTile(33, 2).getLocation());
            Spikes spikes48 = new Spikes(getMapTile(33, 3).getLocation());
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
            enhancedMapTiles.add(spikes29);
            enhancedMapTiles.add(spikes30);
            enhancedMapTiles.add(spikes31);
            enhancedMapTiles.add(spikes32);
            enhancedMapTiles.add(spikes33);
            enhancedMapTiles.add(spikes34);
            enhancedMapTiles.add(spikes35);
            enhancedMapTiles.add(spikes36);
            enhancedMapTiles.add(spikes37);
            enhancedMapTiles.add(spikes38);
            enhancedMapTiles.add(spikes39);
            enhancedMapTiles.add(spikes40);
            enhancedMapTiles.add(spikes41);
            enhancedMapTiles.add(spikes42);
            enhancedMapTiles.add(spikes43);
            enhancedMapTiles.add(spikes44);
            enhancedMapTiles.add(spikes45);
            enhancedMapTiles.add(spikes46);
            enhancedMapTiles.add(spikes47);
            enhancedMapTiles.add(spikes48);
    
            return enhancedMapTiles;
        }

        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(13,4).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(13,11).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(16,4).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(16,11).getLocation());
            pickups.add(coin3);

            Pickup coin4 = new Pickup(getMapTile(25,4).getLocation());
            pickups.add(coin4);
    
            Pickup coin5 = new Pickup(getMapTile(25,11).getLocation());
            pickups.add(coin5);
    
            Pickup coin6 = new Pickup(getMapTile(28,4).getLocation());
            pickups.add(coin6);

            Pickup coin7 = new Pickup(getMapTile(28,11).getLocation());
            pickups.add(coin7);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            KiwiKamikaze spineapple1 = new KiwiKamikaze(0, getMapTile(18, 18).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            KiwiKamikaze spineapple2 = new KiwiKamikaze(0, getMapTile(23, 18).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);

            MachoMandarin spineapple3 = new MachoMandarin(0, getMapTile(20, 9).getLocation());
            spineapple3.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple3);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(37,2).setInteractScript(new RandomChangeMapScript(2));
    }
    
}
