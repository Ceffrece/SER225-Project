package Maps;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import Level.Enemy;
import Level.Map;
import Level.Tileset;
import Tilesets.Floor1Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;

public class DungeonRoom1 extends Map {

    public DungeonRoom1() {
        super("DungeonMap.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(12, 24).getLocation();
        this.mapInt = 0;
        this.idSwitch = 0;                //TODO Auto-generated constructor stub
        }


        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();
    
            Spineapple spineapple1 = new Spineapple(0, getMapTile(8, 8).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);
    
            CerealKiller cerealkiller2 = new CerealKiller(0, getMapTile(3, 12).getLocation());
            cerealkiller2.setExistenceFlag("hasTalkedToCerealKiller");
            enemies.add(cerealkiller2);
    
            Eggssassin eggssassin1 = new Eggssassin(0, getMapTile(10, 14).getLocation());
            eggssassin1.setExistenceFlag("hasTalkedToEggssassin");
            enemies.add(eggssassin1);
    
           
    
            
            return enemies;
        }
    @Override
    public void loadScripts() {
        getMapTile(7, 12).setInteractScript(new SimpleTextScript("This is where you can choose your ultimate\nability (once unlocked)")); 

        getMapTile(17,12).setInteractScript(new SimpleTextScript("This is where you can choose your starting\nweapon (once unlocked)"));

        getMapTile(11, 19).setInteractScript(new SimpleTextScript("This is an open area for you to test your\nweapons/abilities!")); 

        getMapTile(11,6).setInteractScript(new SimpleTextScript("Enter this door to enter the Food Pyramid and\nbegin your run!"));

        getMapTile(12,2).setInteractScript(new ChangeMapScript(1));
    }
    
}
