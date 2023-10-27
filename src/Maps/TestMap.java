package Maps;

import EnhancedMapTiles.PushableRock;
import GameObject.Frame;
import GameObject.Sprite;
import GameObject.SpriteSheet;
import Level.Item;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Map;
import Level.MapEntityStatus;
import Level.NPC;
import Level.Pickup;
import Level.Projectile;
import Level.Trigger;
import Level.Projectiles.riceBallProjectile;
import NPCs.Dinosaur;
import NPCs.Walrus;
import Scripts.SimpleTextScript;
import Scripts.addPlayerStatScript;
import Scripts.teleportScript;
import Scripts.TestMap.DinoScript;
// import Scripts.TestMap.LostBallScript; (now unused, kept within comments just in case)
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.WalrusScript;
import Scripts.TestMap.SwordScript;
import Tilesets.CommonTileset;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import Engine.ImageLoader;

// Represents a test map to be used in a level
public class TestMap extends Map {

    public TestMap() {
        super("test_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
        this.mapInt = 1;
        this.idSwitch = 1;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        PushableRock pushableRock = new PushableRock(getMapTile(2, 7).getLocation());
        enhancedMapTiles.add(pushableRock);

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus walrus = new Walrus(1, getMapTile(4, 28).getLocation().subtractY(40));
        walrus.setInteractScript(new WalrusScript());
        npcs.add(walrus);

        Dinosaur dinosaur = new Dinosaur(2, getMapTile(13, 4).getLocation());
        dinosaur.setExistenceFlag("hasTalkedToDinosaur");
        dinosaur.setInteractScript(new DinoScript());
        npcs.add(dinosaur);
        

        return npcs;
    }
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        CerealKiller cerealkiller1 = new CerealKiller(0, getMapTile(11, 1).getLocation());
        cerealkiller1.setExistenceFlag("hasTalkedToCerealKiller");
        enemies.add(cerealkiller1);

        CerealKiller cerealkiller2 = new CerealKiller(0, getMapTile(12, 2).getLocation());
        cerealkiller2.setExistenceFlag("hasTalkedToCerealKiller");
        enemies.add(cerealkiller2);

        CerealKiller cerealkiller3 = new CerealKiller(0, getMapTile(13, 3).getLocation());
        cerealkiller3.setExistenceFlag("hasTalkedToCerealKiller");
        enemies.add(cerealkiller3);

        CerealKiller cerealkiller4 = new CerealKiller(0, getMapTile(14, 4).getLocation());
        cerealkiller4.setExistenceFlag("hasTalkedToCerealKiller");
        enemies.add(cerealkiller4);
        
        Spineapple spineapple1 = new Spineapple(0, getMapTile(4, 4).getLocation());
        spineapple1.setExistenceFlag("hasTalkedToSpineapple");
        enemies.add(spineapple1);

        Spineapple spineapple2 = new Spineapple(0, getMapTile(5, 5).getLocation());
        spineapple2.setExistenceFlag("hasTalkedToSpineapple");
        enemies.add(spineapple2);

        Spineapple spineapple3 = new Spineapple(0, getMapTile(6, 6).getLocation());
        spineapple3.setExistenceFlag("hasTalkedToSpineapple");
        enemies.add(spineapple3);

        Spineapple spineapple4 = new Spineapple(0, getMapTile(7, 7).getLocation());
        spineapple4.setExistenceFlag("hasTalkedToSpineapple");
        enemies.add(spineapple4);

        Eggssassin eggssassin1 = new Eggssassin(0, getMapTile(11, 14).getLocation());
        eggssassin1.setExistenceFlag("hasTalkedToEggssassin");
        enemies.add(eggssassin1);

        Eggssassin eggssassin2 = new Eggssassin(0, getMapTile(13, 16).getLocation());
        eggssassin2.setExistenceFlag("hasTalkedToEggssassin");
        enemies.add(eggssassin2);

        Eggssassin eggssassin3 = new Eggssassin(0, getMapTile(20, 5).getLocation());
        eggssassin3.setExistenceFlag("hasTalkedToEggssassin");
        enemies.add(eggssassin3);

        Eggssassin eggssassin4 = new Eggssassin(0, getMapTile(20, 8).getLocation());
        eggssassin4.setExistenceFlag("hasTalkedToEggssassin");
        enemies.add(eggssassin4);

        return enemies;
    }
    public ArrayList<Item> loadItems() {
        ArrayList<Item> items = new ArrayList<>();

        Item sword = new Item(getMapTile(5,10).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load("sword.png"),50,50),"DEFAULT", "walkSpeed", 5,"sword.png");
        sword.setInteractScript(new SwordScript());
        items.add(sword);

        return items;
    }
    public ArrayList<Pickup> loadPickups() {
        ArrayList<Pickup> pickups = new ArrayList<>();
            Pickup testXPOrb = new Pickup(getMapTile(10,10).getLocation(), new SpriteSheet(ImageLoader.load("xpOrb.png"),7,7),"DEFAULT",1);
            testXPOrb.setIdentity("xpOrb");
            pickups.add(testXPOrb); 

        /*for(Enemy enemy : loadEnemies()) {
            if(enemy.getMapEntityStatus() == MapEntityStatus.REMOVED){
                Pickup xpOrb = new Pickup(enemy.getLocation(), new SpriteSheet(ImageLoader.load("xpOrb.png"),5,5),"DEFAULT",1);
                pickups.add(xpOrb);
            }
        }*/

        return pickups;
    }

//    @Override
//    public ArrayList<Trigger> loadTriggers() {
//        ArrayList<Trigger> triggers = new ArrayList<>();
//        triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
//        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
//        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));
//        return triggers;
//    }

    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());

        getMapTile(11, 17).setInteractScript(new teleportScript(10 ,25));

        getMapTile(14, 17).setInteractScript(new teleportScript(14 ,2));
    }
}

