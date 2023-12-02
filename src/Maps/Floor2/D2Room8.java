package Maps.Floor2;

import java.util.ArrayList;

import Enemy.CauliflowerCreeper;
import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.KiwiKamikaze;
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

public class D2Room8 extends Map {

    public D2Room8() {
        super("D2Room8.txt", new Floor2Tileset());
        this.playerStartPosition = getMapTile(2, 8).getLocation();
        this.mapInt = 18;
        this.idSwitch = 18;                //Aka "Flappy Bird"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(3, 6).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(3, 10).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(9, 10).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(9, 14).getLocation());
            Spikes spikes5 = new Spikes(getMapTile(15, 8).getLocation());
            Spikes spikes6 = new Spikes(getMapTile(15, 12).getLocation());
            Spikes spikes7 = new Spikes(getMapTile(21, 3).getLocation());
            Spikes spikes8 = new Spikes(getMapTile(21, 7).getLocation());
            Spikes spikes9 = new Spikes(getMapTile(27, 9).getLocation());
            Spikes spikes10 = new Spikes(getMapTile(27, 13).getLocation());
            Spikes spikes11 = new Spikes(getMapTile(33, 6).getLocation());
            Spikes spikes12 = new Spikes(getMapTile(33, 10).getLocation());
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
    
            Pickup coin = new Pickup(getMapTile(9,13).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(21,6).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(33,9).getLocation());
            pickups.add(coin2);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            KiwiKamikaze spineapple1 = new KiwiKamikaze(0, getMapTile(2, 2).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            CauliflowerCreeper spineapple2 = new CauliflowerCreeper(0, getMapTile(2, 14).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(38,8).setInteractScript(new RandomChangeMapScript(2));
    }
    
}
