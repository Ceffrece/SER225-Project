package Maps.Floor3;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.EggplantArtillery;
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

public class D3Room2 extends Map {

    public D3Room2() {
        super("D3Room2.txt", new Floor3Tileset());
        this.playerStartPosition = getMapTile(9, 11).getLocation();
        this.mapInt = 22;
        this.idSwitch = 22;                //Aka "X Marks the Milk"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(7, 9).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(7, 10).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(7, 11).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(7, 12).getLocation());
            Spikes spikes5 = new Spikes(getMapTile(8, 6).getLocation());
            Spikes spikes6 = new Spikes(getMapTile(9, 6).getLocation());
            Spikes spikes7 = new Spikes(getMapTile(10, 6).getLocation());
            Spikes spikes8 = new Spikes(getMapTile(11, 6).getLocation());
            Spikes spikes9 = new Spikes(getMapTile(8, 15).getLocation());
            Spikes spikes10 = new Spikes(getMapTile(9, 15).getLocation());
            Spikes spikes11 = new Spikes(getMapTile(10, 15).getLocation());
            Spikes spikes12 = new Spikes(getMapTile(11, 15).getLocation());
            Spikes spikes13 = new Spikes(getMapTile(12, 9).getLocation());
            Spikes spikes14 = new Spikes(getMapTile(12, 10).getLocation());
            Spikes spikes15 = new Spikes(getMapTile(12, 11).getLocation());
            Spikes spikes16 = new Spikes(getMapTile(12, 12).getLocation());
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
    
            return enhancedMapTiles;
        }

        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(8,10).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(8,11).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(9,7).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(9,14).getLocation());
            pickups.add(coin3);

            Pickup coin4 = new Pickup(getMapTile(10,7).getLocation());
            pickups.add(coin4);
    
            Pickup coin5 = new Pickup(getMapTile(10,14).getLocation());
            pickups.add(coin5);
    
            Pickup coin6 = new Pickup(getMapTile(11,10).getLocation());
            pickups.add(coin6);

            Pickup coin7 = new Pickup(getMapTile(11,11).getLocation());
            pickups.add(coin7);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            EggplantArtillery spineapple1 = new EggplantArtillery(0, getMapTile(2, 2).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            EggplantArtillery spineapple2 = new EggplantArtillery(0, getMapTile(2, 19).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);

            EggplantArtillery spineapple3 = new EggplantArtillery(0, getMapTile(17, 19).getLocation());
            spineapple3.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple3);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(17,2).setInteractScript(new RandomChangeMapScript(3));
    }
    
}
