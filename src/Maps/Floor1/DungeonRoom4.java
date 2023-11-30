package Maps.Floor1;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.HickoryHamHurler;
import Enemy.KiwiKamikaze;
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

public class DungeonRoom4 extends Map {

    public DungeonRoom4() {
        super("DungeonMap4.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(9, 3).getLocation();
        this.mapInt = 4;
        this.idSwitch = 4;                //Aka "Red Canyon Level 5"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
        Spikes spikes1 = new Spikes(getMapTile(2, 41).getLocation());
        Spikes spikes2 = new Spikes(getMapTile(3, 41).getLocation());
        Spikes spikes3 = new Spikes(getMapTile(8, 37).getLocation());
        Spikes spikes4 = new Spikes(getMapTile(9, 35).getLocation());
        Spikes spikes5 = new Spikes(getMapTile(10, 37).getLocation());
        Spikes spikes6 = new Spikes(getMapTile(15, 41).getLocation());
        Spikes spikes7 = new Spikes(getMapTile(16, 41).getLocation());
        enhancedMapTiles.add(spikes1);
        enhancedMapTiles.add(spikes2);
        enhancedMapTiles.add(spikes3);
        enhancedMapTiles.add(spikes4);
        enhancedMapTiles.add(spikes5);
        enhancedMapTiles.add(spikes6);
        enhancedMapTiles.add(spikes7);
    
            return enhancedMapTiles;
        }


        
        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            HickoryHamHurler kiwikamikaze1 = new HickoryHamHurler(0, getMapTile(11, 14).getLocation());
            kiwikamikaze1.setExistenceFlag("hasTalkedToHickoryHamHurler");
            enemies.add(kiwikamikaze1);

            HickoryHamHurler kiwikamikaze2 = new HickoryHamHurler(0, getMapTile(7, 14).getLocation());
            kiwikamikaze2.setExistenceFlag("hasTalkedToHickoryHamHurler");
            enemies.add(kiwikamikaze2);
            
            return enemies;
        }
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(7,14).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(11,14).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(9,36).getLocation());
            pickups.add(coin2);
    
            Pickup coin3 = new Pickup(getMapTile(8,33).getLocation());
            pickups.add(coin3);
    
            Pickup coin4 = new Pickup(getMapTile(10,33).getLocation());
            pickups.add(coin4);
    
            Pickup coin5 = new Pickup(getMapTile(9,40).getLocation());
            pickups.add(coin5);
            
            return pickups;
    
        }
        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(17,31).setInteractScript(new SimpleTextScript("Naked? Nonsense!"));

        getMapTile(1,31).setInteractScript(new SimpleTextScript("A kirby reference? That's absurd!"));

        getMapTile(9,41).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
