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

public class DungeonRoom8 extends Map {

    public DungeonRoom8() {
        super("DungeonMap8.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(2, 17).getLocation();
        this.mapInt = 8;
        this.idSwitch = 8;                //Aka "Spikey Wheat Field"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
        Spikes spikes1 = new Spikes(getMapTile(2, 13).getLocation());
        Spikes spikes2 = new Spikes(getMapTile(3, 7).getLocation());
        Spikes spikes3 = new Spikes(getMapTile(3, 8).getLocation());
        Spikes spikes4 = new Spikes(getMapTile(4, 10).getLocation());
        Spikes spikes5 = new Spikes(getMapTile(4, 11).getLocation());
        Spikes spikes6 = new Spikes(getMapTile(7, 8).getLocation());
        Spikes spikes7 = new Spikes(getMapTile(7, 9).getLocation());
        Spikes spikes8 = new Spikes(getMapTile(8, 12).getLocation());
        Spikes spikes9 = new Spikes(getMapTile(9, 5).getLocation());
        Spikes spikes10 = new Spikes(getMapTile(9, 6).getLocation());
        Spikes spikes11 = new Spikes(getMapTile(11, 10).getLocation());
        Spikes spikes12 = new Spikes(getMapTile(11, 11).getLocation());
        Spikes spikes13 = new Spikes(getMapTile(12, 9).getLocation());
        Spikes spikes14 = new Spikes(getMapTile(14, 6).getLocation());
        Spikes spikes15 = new Spikes(getMapTile(15, 7).getLocation());
        Spikes spikes16 = new Spikes(getMapTile(15, 8).getLocation());
        Spikes spikes17 = new Spikes(getMapTile(17, 11).getLocation());
        Spikes spikes18 = new Spikes(getMapTile(17, 12).getLocation());
        Spikes spikes19 = new Spikes(getMapTile(18, 9).getLocation());
        Spikes spikes20 = new Spikes(getMapTile(20, 5).getLocation());
        Spikes spikes21 = new Spikes(getMapTile(20, 6).getLocation());
        Spikes spikes22 = new Spikes(getMapTile(21, 4).getLocation());
        Spikes spikes23 = new Spikes(getMapTile(21, 10).getLocation());
        Spikes spikes24 = new Spikes(getMapTile(21, 11).getLocation());
        Spikes spikes25 = new Spikes(getMapTile(23, 7).getLocation());
        Spikes spikes26 = new Spikes(getMapTile(23, 8).getLocation());
        Spikes spikes27 = new Spikes(getMapTile(25, 11).getLocation());
        Spikes spikes28 = new Spikes(getMapTile(25, 12).getLocation());
        Spikes spikes29 = new Spikes(getMapTile(28, 8).getLocation());
        Spikes spikes30 = new Spikes(getMapTile(28, 9).getLocation());
        Spikes spikes31 = new Spikes(getMapTile(29, 7).getLocation());
        Spikes spikes32 = new Spikes(getMapTile(32, 11).getLocation());
        Spikes spikes33 = new Spikes(getMapTile(32, 12).getLocation());
        Spikes spikes34 = new Spikes(getMapTile(33, 6).getLocation());
        Spikes spikes35 = new Spikes(getMapTile(33, 7).getLocation());
        Spikes spikes36 = new Spikes(getMapTile(35, 10).getLocation());
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
        enhancedMapTiles.add(spikes13);
        enhancedMapTiles.add(spikes14);
        enhancedMapTiles.add(spikes15);
        enhancedMapTiles.add(spikes16);
        enhancedMapTiles.add(spikes17);
        enhancedMapTiles.add(spikes18);
        enhancedMapTiles.add(spikes19);
        enhancedMapTiles.add(spikes20);
        enhancedMapTiles.add(spikes21);
        enhancedMapTiles.add(spikes22);
        enhancedMapTiles.add(spikes23);
        enhancedMapTiles.add(spikes24);
        enhancedMapTiles.add(spikes25);
        enhancedMapTiles.add(spikes26);
        enhancedMapTiles.add(spikes27);
        enhancedMapTiles.add(spikes28);
        enhancedMapTiles.add(spikes29);
        enhancedMapTiles.add(spikes30);
        enhancedMapTiles.add(spikes31);
        enhancedMapTiles.add(spikes32);
        enhancedMapTiles.add(spikes33);
        enhancedMapTiles.add(spikes34);
        enhancedMapTiles.add(spikes35);
        enhancedMapTiles.add(spikes36);
    
            return enhancedMapTiles;
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(35,2).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
