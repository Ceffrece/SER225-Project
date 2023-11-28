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

public class DungeonRoom2 extends Map {

    public DungeonRoom2() {
        super("DungeonMap2.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(12, 24).getLocation();
        this.mapInt = 2;
        this.idSwitch = 2;                //Aka "Can't Walk on Lava"
        }


        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            Eggssassin eggssassin1 = new Eggssassin(0, getMapTile(31, 18).getLocation());
            eggssassin1.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin1);
    
            Eggssassin eggssassin2 = new Eggssassin(0, getMapTile(25, 12).getLocation());
            eggssassin2.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin2);
    
            
            return enemies;
        }
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(20,13).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(20,18).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(24,22).getLocation());
            pickups.add(coin2);
    
            Pickup coin3 = new Pickup(getMapTile(29,22).getLocation());
            pickups.add(coin3);
    
    
            Pickup coin5 = new Pickup(getMapTile(35,16).getLocation());
            pickups.add(coin5);
            
            return pickups;
    
        }
    @Override
    public void loadScripts() {

        getMapTile(12,2).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
