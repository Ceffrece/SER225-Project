package Maps.Floor1;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import EnhancedMapTiles.Spikes;
import Level.EnhancedMapTile;
import Level.Enemy;
import Level.Map;
import Level.Tileset;
import Tilesets.Floor1Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class DungeonRoom6 extends Map {

    public DungeonRoom6() {
        super("DungeonMap6.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(2, 9).getLocation();
        this.mapInt = 6;
        this.idSwitch = 6;                //Aka "Horizontal Stripes are Slimming"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    

    
            return enhancedMapTiles;
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            Eggssassin eggssassin1 = new Eggssassin(0, getMapTile(33, 6).getLocation());
            eggssassin1.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin1);

            Eggssassin eggssassin2 = new Eggssassin(0, getMapTile(33, 10).getLocation());
            eggssassin2.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin2);

            Eggssassin eggssassin3 = new Eggssassin(0, getMapTile(17, 3).getLocation());
            eggssassin3.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin3);

            Eggssassin eggssassin4 = new Eggssassin(0, getMapTile(17, 7).getLocation());
            eggssassin4.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin4);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(33,2).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
