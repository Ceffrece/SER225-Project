package Maps.Floor2;

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
import Tilesets.Floor2Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class Floor2Boss extends Map {

    public static Boss boss2;
    public static int currenthealth;

    public Floor2Boss() {
        super("Floor2Boss.txt", new Floor2Tileset());
        // this.playerStartPosition = getMapTile(12, 24).getLocation();
        this.mapInt = 102;
        this.idSwitch = 102;
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();
            
    
           
    
            
            return enemies;
        }

        // Where the boss will go
        public ArrayList<Boss> loadBosses() {
            ArrayList<Boss> bosses = new ArrayList<>();
            boss2 = new Boss(getMapTile(7,6).getLocation(), new SpriteSheet(ImageLoader.load("EnemySprites/.png"), 100, 40), "DEFAULT", 100, 2);
            bosses.add(boss2);
            currenthealth = boss2.getHealth();
            return bosses;
        }
        public static void updateCurrentHealth() {
            currenthealth = boss2.getHealth();
        }

    @Override
    public void loadScripts() {
        

        //getMapTile(12,2).setInteractScript(new ChangeMapScript(0));
    }
    
}
