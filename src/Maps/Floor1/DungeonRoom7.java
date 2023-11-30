package Maps.Floor1;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.HickoryHamHurler;
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
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(4,14).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(5,13).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(16,24).getLocation());
            pickups.add(coin2);
    
            Pickup coin3 = new Pickup(getMapTile(14,26).getLocation());
            pickups.add(coin3);
    
            Pickup coin4 = new Pickup(getMapTile(11,7).getLocation());
            pickups.add(coin4);
    
            Pickup coin5 = new Pickup(getMapTile(27,13).getLocation());
            pickups.add(coin5);
            
            return pickups;
    
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

            MapleBaconMarauder pastapoltergeist2 = new MapleBaconMarauder(0, getMapTile(19, 18).getLocation());
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
