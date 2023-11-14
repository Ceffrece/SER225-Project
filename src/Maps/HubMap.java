package Maps;

import java.util.ArrayList;

import Enemy.Eggssassin;
import Enemy.Spineapple;
import Engine.ImageLoader;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.Item;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.Walrus;
import Tilesets.Floor1Tileset;
import Scripts.ProjectilePickup;
import Scripts.SimpleTextScript;
import Scripts.MarcusMap.WalrusScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.RandomChangeMapScript;
import Scripts.TestMap.SwordScript;

public class HubMap extends Map {

    public HubMap() {
        super("hub_map.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(12, 14).getLocation();
        this.mapInt = 0;
        this.idSwitch = 0;

    }
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus walrus = new Walrus(1, getMapTile(10, 5).getLocation().subtractY(40));
        walrus.setInteractScript(new WalrusScript());
        npcs.add(walrus);
        

        return npcs;
    }
    public ArrayList<Trigger> loadTriggers() {
                ArrayList<Trigger> triggers = new ArrayList<>();
               
                return triggers;
           }
    public ArrayList<Item> loadItems() {
        ArrayList<Item> items = new ArrayList<>();



        

        return items;
    }
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

       
            Spineapple spineapple1 = new Spineapple(0, getMapTile(2, 12).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            Spineapple spineapple2 = new Spineapple(0, getMapTile(10, 13).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);
        

       

        
        return enemies;
    }
    @Override
    public void loadScripts() {
        getMapTile(7, 12).setInteractScript(new SimpleTextScript("This is where you can choose your ultimate\nability (once unlocked)")); 

        getMapTile(17,12).setInteractScript(new SimpleTextScript("This is where you can choose your starting\nweapon (once unlocked)"));

        getMapTile(11, 19).setInteractScript(new SimpleTextScript("This is an open area for you to test your\nweapons/abilities!")); 

        getMapTile(11,6).setInteractScript(new SimpleTextScript("Enter this door to enter the Food Pyramid and\nbegin your run!"));

        // if (loadEnemies().size() == 0) {
        //     getMapTile(12,2).setInteractScript(new RandomChangeMapScript(1));
        // }
        getMapTile(12,2).setInteractScript(new RandomChangeMapScript(1));

        getMapTile(2,14).setInteractScript(new ChangeMapScript(111));

    }
    
}
