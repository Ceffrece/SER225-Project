package Maps.Floor1;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.HickoryHamHurler;
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

public class DungeonRoom5 extends Map {

    public DungeonRoom5() {
        super("DungeonMap5.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(3, 8).getLocation();
        this.mapInt = 5;
        this.idSwitch = 5;                //Aka "C The Sequel"
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

            HickoryHamHurler hickoryhamhurler1 = new HickoryHamHurler(0, getMapTile(19, 5).getLocation());
            hickoryhamhurler1.setExistenceFlag("hasTalkedToHickoryHamHurler");
            enemies.add(hickoryhamhurler1);

            HickoryHamHurler hickoryhamhurler2 = new HickoryHamHurler(0, getMapTile(5, 19).getLocation());
            hickoryhamhurler2.setExistenceFlag("hasTalkedToHickoryHamHurler");
            enemies.add(hickoryhamhurler2);
    
            Eggssassin eggssassin1 = new Eggssassin(0, getMapTile(19, 19).getLocation());
            eggssassin1.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin1);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(3,16).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
