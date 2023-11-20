package Maps.Floor2;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import EnhancedMapTiles.Spikes;
import Level.EnhancedMapTile;
import Level.Enemy;
import Level.Map;
import Level.Tileset;
import Tilesets.Floor2Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class D2Room1 extends Map {

    public D2Room1() {
        super("D2Room1.txt", new Floor2Tileset());
        this.playerStartPosition = getMapTile(10, 18).getLocation();
        this.mapInt = 11;
        this.idSwitch = 11;                //Aka "Four Corner Compound"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
        Spikes spikes1 = new Spikes(getMapTile(2, 15).getLocation());
        Spikes spikes2 = new Spikes(getMapTile(2, 18).getLocation());
        Spikes spikes3 = new Spikes(getMapTile(18, 15).getLocation());
        Spikes spikes4 = new Spikes(getMapTile(18, 18).getLocation());
        Spikes spikes5 = new Spikes(getMapTile(3, 4).getLocation());
        Spikes spikes6 = new Spikes(getMapTile(3, 11).getLocation());
        Spikes spikes7 = new Spikes(getMapTile(17, 4).getLocation());
        Spikes spikes8 = new Spikes(getMapTile(17, 11).getLocation());
        enhancedMapTiles.add(spikes1);
        enhancedMapTiles.add(spikes2);
        enhancedMapTiles.add(spikes3);
        enhancedMapTiles.add(spikes4);
        enhancedMapTiles.add(spikes5);
        enhancedMapTiles.add(spikes6);
        enhancedMapTiles.add(spikes7);
        enhancedMapTiles.add(spikes8);
    
            return enhancedMapTiles;
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            Spineapple spineapple1 = new Spineapple(0, getMapTile(6, 6).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            Spineapple spineapple2 = new Spineapple(0, getMapTile(14, 6).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(10,4).setInteractScript(new RandomChangeMapScript(2));
    }
    
}
