package Maps.Floor1;

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
import Tilesets.Floor1Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class Floor1Boss extends Map {

    public static Boss broc;
    public static int currenthealth;

    public Floor1Boss() {
        super("Floor1BossRoom.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(12, 24).getLocation();
        this.mapInt = 100;
        this.idSwitch = 100;
        }


        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();
            
    
           
    
            
            return enemies;
        }

        public ArrayList<Boss> loadBosses() {
            ArrayList<Boss> bosses = new ArrayList<>();
            broc = new Boss(getMapTile(7,6).getLocation(), new SpriteSheet(ImageLoader.load("EnemySprites/the_broc.png"), 100, 40), "DEFAULT", 100, 1);
            bosses.add(broc);
            currenthealth = broc.getHealth();
            return bosses;
        }

        public static void updateCurrentHealth() {
            currenthealth = broc.getHealth();
        }

    @Override
    public void loadScripts() {
        

        getMapTile(12,2).setInteractScript(new ChangeMapScript(0));
    }
    
}
