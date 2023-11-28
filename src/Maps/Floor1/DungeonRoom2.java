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

        // Where coins go
    public ArrayList<Pickup> loadPickups() {
        ArrayList<Pickup> pickups = new ArrayList<>();

        //Pickup coin = new Pickup(getMapTile(4,11).getLocation());
        //pickups.add(coin);
        
        return pickups;

    }

    @Override
    public void loadScripts() {

        getMapTile(12,2).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
