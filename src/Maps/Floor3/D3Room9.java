package Maps.Floor3;

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
import Tilesets.Floor3Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class D3Room9 extends Map {

    public D3Room9() {
        super("D3Room9.txt", new Floor3Tileset());
        // this.playerStartPosition = getMapTile(4, 19).getLocation();
        this.mapInt = 29;
        this.idSwitch = 29;                //Aka ""
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
    
            //Pickup coin = new Pickup(getMapTile(4,11).getLocation());
            //pickups.add(coin);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        //getMapTile(19,4).setInteractScript(new RandomChangeMapScript(3));
    }
    
}
