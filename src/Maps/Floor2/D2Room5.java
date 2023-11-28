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

public class D2Room5 extends Map {

    public D2Room5() {
        super("D2Room5.txt", new Floor2Tileset());
        this.playerStartPosition = getMapTile(1, 1).getLocation();
        this.mapInt = 15;
        this.idSwitch = 15;                //Aka "Woven Threads"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    

    
            return enhancedMapTiles;
        }

        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(1,18).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(5,14).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(9,10).getLocation());
            pickups.add(coin2);
    
            Pickup coin3 = new Pickup(getMapTile(13,6).getLocation());
            pickups.add(coin3);
    
            Pickup coin4 = new Pickup(getMapTile(17,2).getLocation());
            pickups.add(coin4);
    
            Pickup coin5 = new Pickup(getMapTile(13,22).getLocation());
            pickups.add(coin5);

            Pickup coin6 = new Pickup(getMapTile(17,18).getLocation());
            pickups.add(coin6);
    
            Pickup coin7 = new Pickup(getMapTile(21,14).getLocation());
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

        getMapTile(22,22).setInteractScript(new RandomChangeMapScript(2));
    }
    
}
