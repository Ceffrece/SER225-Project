package Maps.Floor3;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.EggplantArtillery;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import EnhancedMapTiles.Spikes;
import Level.EnhancedMapTile;
import Level.Enemy;
import Level.Map;
import Level.Pickup;
import Level.Tileset;
import Tilesets.Floor3Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class D3Room7 extends Map {

    public D3Room7() {
        super("D3Room7.txt", new Floor3Tileset());
        this.playerStartPosition = getMapTile(1, 28).getLocation();
        this.mapInt = 27;
        this.idSwitch = 27;                //Aka "Spyglass Clash"
        }

        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    

    
            return enhancedMapTiles;
        }
        
        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(2,28).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(3,25).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(7,23).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(10,18).getLocation());
            pickups.add(coin3);

            Pickup coin4 = new Pickup(getMapTile(16,14).getLocation());
            pickups.add(coin4);
    
            Pickup coin5 = new Pickup(getMapTile(21,7).getLocation());
            pickups.add(coin5);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            EggplantArtillery spineapple1 = new EggplantArtillery(0, getMapTile(23, 2).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            EggplantArtillery spineapple2 = new EggplantArtillery(0, getMapTile(27, 6).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(27,2).setInteractScript(new RandomChangeMapScript(3));
    }
    
}
