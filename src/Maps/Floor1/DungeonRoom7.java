package Maps.Floor1;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.HickoryHamHurler;
import Enemy.PastaPoltergeist;
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

public class DungeonRoom7 extends Map {

    public DungeonRoom7() {
        super("DungeonMap7.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(5, 26).getLocation();
        this.mapInt = 7;
        this.idSwitch = 7;                //Aka "Minecraft Bread"
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

            HickoryHamHurler hickoryhamhurler1 = new HickoryHamHurler(0, getMapTile(11, 15).getLocation());
            hickoryhamhurler1.setExistenceFlag("hasTalkedToHickoryHamHurler");
            enemies.add(hickoryhamhurler1);
    
            PastaPoltergeist pastapoltergeist1 = new PastaPoltergeist(0, getMapTile(18, 8).getLocation());
            pastapoltergeist1.setExistenceFlag("hasTalkedToCerealKiller");
            enemies.add(pastapoltergeist1);

            PastaPoltergeist pastapoltergeist2 = new PastaPoltergeist(0, getMapTile(19, 18).getLocation());
            pastapoltergeist2.setExistenceFlag("hasTalkedToCerealKiller");
            enemies.add(pastapoltergeist2);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(24,5).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
