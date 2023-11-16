package Maps.Floor3;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import Engine.ImageLoader;
import GameObject.SpriteSheet;
import Level.Boss;
import Level.Enemy;
import Level.Map;
import Level.Tileset;
import Tilesets.Floor3Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class Floor3Boss extends Map {

    public Floor3Boss() {
        super("Floor3Boss.txt", new Floor3Tileset());
        // this.playerStartPosition = getMapTile(12, 24).getLocation();
        this.mapInt = 104;
        this.idSwitch = 104;
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();
            
    
           
    
            
            return enemies;
        }

        // Where the boss will go
        public ArrayList<Boss> loadBosses() {
            ArrayList<Boss> bosses = new ArrayList<>();

            return bosses;
        }

    @Override
    public void loadScripts() {
        

        //getMapTile(12,2).setInteractScript(new ChangeMapScript(0));
    }
    
}
