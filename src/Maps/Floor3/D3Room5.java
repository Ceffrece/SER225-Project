package Maps.Floor3;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.ColdStone;
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

public class D3Room5 extends Map {

    public D3Room5() {
        super("D3Room5.txt", new Floor3Tileset());
        this.playerStartPosition = getMapTile(10, 15).getLocation();
        this.mapInt = 25;
        this.idSwitch = 25;                //Aka "Bottleneck Breakdown"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(2, 2).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(2, 16).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(18, 2).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(18, 16).getLocation());
            enhancedMapTiles.add(spikes1);
            enhancedMapTiles.add(spikes2);
            enhancedMapTiles.add(spikes3);
            enhancedMapTiles.add(spikes4);
    
            return enhancedMapTiles;
        }

        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(1,1).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(1,17).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(19,1).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(19,17).getLocation());
            pickups.add(coin3);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            CerealKiller spineapple1 = new CerealKiller(0, getMapTile(4, 8).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            CerealKiller spineapple2 = new CerealKiller(0, getMapTile(7, 5).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);

            CerealKiller spineapple3 = new CerealKiller(0, getMapTile(10, 2).getLocation());
            spineapple3.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple3);

            CerealKiller spineapple4 = new CerealKiller(0, getMapTile(13, 5).getLocation());
            spineapple4.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple4);

            ColdStone spineapple5 = new ColdStone(0, getMapTile(16, 8).getLocation());
            spineapple5.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple5);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(10,25).setInteractScript(new RandomChangeMapScript(3));
    }
    
}
