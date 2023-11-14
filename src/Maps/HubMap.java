package Maps;

import java.util.ArrayList;

import Enemy.Eggssassin;
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
                triggers.add(new Trigger(790, 1030, 100, 10, new RandomChangeMapScript(1), "teleport"));
               
                return triggers;
           }
    public ArrayList<Item> loadItems() {
        ArrayList<Item> items = new ArrayList<>();

        Item peaPickup = new Item(getMapTile(20,13).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load("Projectiles/peaProjectile.png"),16,16),"DEFAULT","peaProjectile");
        peaPickup.setInteractScript(new ProjectilePickup()); 
        items.add(peaPickup);

        Item riceballPickup = new Item(getMapTile(20,17).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load("Projectiles/riceBallProjectile.png"),16,16),"DEFAULT","riceBallProjectile");
        riceballPickup.setInteractScript(new ProjectilePickup());
        items.add(riceballPickup);

        Item bannaPickup = new Item(getMapTile(22,15).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load("Projectiles/bannanaProjectile.png"),16,16),"DEFAULT","bannanaProjectile");
        bannaPickup.setInteractScript(new ProjectilePickup());
        items.add(bannaPickup);
//    public Item(Point location, SpriteSheet ss, String startingAnimation,String projectileToAdd){

        Item pepPickup = new Item(getMapTile(22,18).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load("Projectiles/pepPro.png"),16,16),"DEFAULT","peporoniSlicer");
        pepPickup.setInteractScript(new ProjectilePickup());
        items.add(pepPickup);

        Item cheesePickup = new Item(getMapTile(22,12).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load("GUISprites/cheeseIcon.png"),16,16),"DEFAULT","cheese");
        cheesePickup.setInteractScript(new ProjectilePickup());
        items.add(cheesePickup);
        

        return items;
    }
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

       

        

       

        
        return enemies;
    }
    @Override
    public void loadScripts() {
        getMapTile(7, 12).setInteractScript(new SimpleTextScript("This is where you can choose your ultimate\nability (once unlocked)")); 

        getMapTile(17,12).setInteractScript(new SimpleTextScript("This is where you can choose your starting\nweapon (once unlocked)"));

        getMapTile(11, 19).setInteractScript(new SimpleTextScript("This is an open area for you to test your\nweapons/abilities!")); 

        getMapTile(11,6).setInteractScript(new SimpleTextScript("Enter this door to enter the Food Pyramid and\nbegin your run!"));

        getMapTile(12,2).setInteractScript(new RandomChangeMapScript(1));
    }
    
}
