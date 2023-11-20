package Maps;

import java.util.ArrayList;

import Enemy.Eggssassin;
import Engine.ImageLoader;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.Item;
import Level.Map;
import Level.NPC;
import Level.Pickup;
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

public class Shop extends Map {

    public Shop() {
        super("Shop.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(10, 10).getLocation();
        this.mapInt = 111;
        this.idSwitch = 111;

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
    public String filename;
    public String projectileToAdd;
    public String description;
    public int cost;
    public ArrayList<Item> loadItems() {
        ArrayList<Item> items = new ArrayList<>();


      
        int randomProjectile =(int) ((Math.random() * 6) + 1);
        switch(randomProjectile){
            case 1:
            filename = "Projectiles/peaProjectile.png";
            projectileToAdd = "peaProjectile" ;
            description = "Pea Projectile";
            cost = 5;
                break;
            case 2:
            filename = "Projectiles/riceBallProjectile.png";
            projectileToAdd ="riceBallProjectile" ;
            description = "Rice Ball Projectile";
            cost = 5;
                break;
            case 3:
            filename ="Projectiles/bannanaProjectile.png" ;
            projectileToAdd = "bannanaProjectile";
            description = "bannana Boomerang";

            cost = 8;

                break;
            case 4:
            filename = "Projectiles/pepPro.png";
            projectileToAdd = "peporoniSlicer";
            description = "Peporoni Slicer";

            cost = 10;

                 break;
            case 5:
            filename = "GUISprites/carrotIcon.png";
            projectileToAdd = "carrotProjectile";
            description = "Carrot Shot";
            cost = 7;
                 break;
            case 6:
            filename = "GUISprites/cheeseIcon.png";
            projectileToAdd = "cheese";
            description = "Three Cheese Maneige";
            cost = 15;
            default:
                break;
        }

        Item projectileForSale = new Item(getMapTile(5,14).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load(filename),16,16),"DEFAULT",projectileToAdd,description,cost);
        projectileForSale.setInteractScript(new ProjectilePickup());
        items.add(projectileForSale);

        



        return items;
    }
    public ArrayList<Pickup> loadPickups() {
        ArrayList<Pickup> pickups = new ArrayList<>();

        Pickup coin = new Pickup(getMapTile(14,14).getLocation().subtractY(40));
        pickups.add(coin);

        Pickup coin1 = new Pickup(getMapTile(14,15).getLocation().subtractY(40));
        pickups.add(coin1);

        Pickup coin2 = new Pickup(getMapTile(15,14).getLocation().subtractY(40));
        pickups.add(coin2);

        Pickup coin3 = new Pickup(getMapTile(15,15).getLocation().subtractY(40));
        pickups.add(coin3);

        Pickup coin4 = new Pickup(getMapTile(16,14).getLocation().subtractY(40));
        pickups.add(coin4);

        
        return pickups;

    }
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        return enemies;
    }
    @Override
    public void loadScripts() {

        getMapTile(12,2).setInteractScript(new RandomChangeMapScript(1));

        getMapTile(12,6).setInteractScript(new ChangeMapScript(100));

    }
    
}
