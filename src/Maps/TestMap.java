package Maps;

import EnhancedMapTiles.PushableRock;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.Item;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Projectile;
import Level.Trigger;
import Level.Projectiles.riceBallProjectile;
import NPCs.Dinosaur;
import NPCs.Walrus;
import Scripts.SimpleTextScript;
import Scripts.addPlayerStatScript;
import Scripts.teleportScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.WalrusScript;
import Scripts.TestMap.SwordScript;
import Tilesets.CommonTileset;

import java.util.ArrayList;

import Engine.ImageLoader;

// Represents a test map to be used in a level
public class TestMap extends Map {

    public TestMap() {
        super("test_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
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
        
        // riceBallProjectile projectile = new Projectile(player.getLocation());

        return npcs;
    }
    public ArrayList<Item> loadItems() {
        ArrayList<Item> items = new ArrayList<>();

        Item sword = new Item(getMapTile(5,10).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load("sword.png"),50,50),"DEFAULT");
        sword.setInteractScript(new SwordScript());
        items.add(sword);

        return items;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        return triggers;
    }

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

