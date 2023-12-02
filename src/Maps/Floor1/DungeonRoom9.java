package Maps.Floor1;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.MapleBaconMarauder;
import Enemy.PastaPoltergeist;
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

public class DungeonRoom9 extends Map {

    public DungeonRoom9() {
        super("DungeonMap9.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(12, 24).getLocation();
        this.mapInt = 9;
        this.idSwitch = 9;                //Aka "Scrambled Breads"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    

    
            return enhancedMapTiles;
        }
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(8,16).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(16,16).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(20,2).getLocation());
            pickups.add(coin2);
            Pickup coin2a = new Pickup(getMapTile(19,2).getLocation());
            pickups.add(coin2a);
            Pickup coin2b = new Pickup(getMapTile(21,2).getLocation());
            pickups.add(coin2b);
            Pickup coin2c = new Pickup(getMapTile(20,1).getLocation());
            pickups.add(coin2c);
            Pickup coin2d = new Pickup(getMapTile(20,3).getLocation());
            pickups.add(coin2d);
    
            Pickup coin3 = new Pickup(getMapTile(12,16).getLocation());
            pickups.add(coin3);
    
            
    
            Pickup coin5 = new Pickup(getMapTile(16,4).getLocation());
            pickups.add(coin5);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            PastaPoltergeist eggssassin1 = new PastaPoltergeist(0, getMapTile(3, 15).getLocation());
            eggssassin1.setExistenceFlag("hasTalkedToPastaPoltergeist");
            enemies.add(eggssassin1);

            MapleBaconMarauder eggssassin2 = new MapleBaconMarauder(0, getMapTile(18, 22).getLocation());
            eggssassin2.setExistenceFlag("hasTalkedToMapleBaconMarauder");
            enemies.add(eggssassin2);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(12,15).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
