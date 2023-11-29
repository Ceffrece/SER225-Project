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
import Scripts.ItemPickup;
import Scripts.ProjectilePickup;
import Scripts.SimpleTextScript;
import Scripts.MarcusMap.WalrusScript;
import Scripts.MarcusMap.shopKeeperScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.RandomChangeMapScript;
import Scripts.TestMap.SwordScript;

public class Shop extends Map {

    public Shop() {
        super("Shop.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(12, 24).getLocation();
        this.mapInt = 111;
        this.idSwitch = 111;

    }
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus walrus = new Walrus(1, getMapTile(12, 13).getLocation().subtractY(40));
        walrus.setInteractScript(new shopKeeperScript());
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
        //randomizes the projectile
        int randomProjectile =(int) ((Math.random() * 5) + 1);
        switch(randomProjectile){
            case 1:
            filename = "Projectiles/peaProjectile.png";
            projectileToAdd = "peaProjectile" ;
            description = "Pea Projectile";
            cost = 10;
                break;
            case 2:
            filename = "GUISprites/cheeseIcon.png";
            projectileToAdd = "cheese";
            description = "Three Cheese Maneige";
            cost = 35;
                break;
            case 3:
            filename ="Projectiles/bannanaProjectile.png" ;
            projectileToAdd = "bannanaProjectile";
            description = "bannana Boomerang";

            cost = 18;
                break;
            case 4:
            filename = "Projectiles/pepPro.png";
            projectileToAdd = "peporoniSlicer";
            description = "Peporoni Slicer";

            cost = 25;

                 break;
            case 5:
            filename = "GUISprites/carrotIcon.png";
            projectileToAdd = "carrotProjectile";
            description = "Carrot Shot";
            cost = 20;
                 break;
        }

        Item projectileForSale = new Item(getMapTile(5,14).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load(filename),16,16),"DEFAULT",projectileToAdd,description,cost);
        projectileForSale.setInteractScript(new ProjectilePickup());
        items.add(projectileForSale);

        int itemRareity = (int) ((Math.random() * 100) + 1);
        int StatAdd = 0;
        System.out.println(itemRareity);
        if (itemRareity <= 60){
            cost = 5;
            StatAdd = 1;
        }
        else if ((itemRareity <= 85)){
            cost = 10;
            StatAdd = 2;
        }
        else{
            StatAdd = 4;
            cost = 32;
        }
        
        String statString = "";
        int randomItem =(int) ((Math.random() * 5) + 1);
        switch(randomItem){
            case 1:
            filename = "Misc/sCube.png";
            description = "sugar cube(WLK SPD+)";
            statString = "walkSpeed";
                break;
            case 2:
            filename = "Misc/cherryBomb.png";
            description = "Cherry Bomb(ATK+)";
            statString = "attackDamage";

                break;
            case 3:
            filename = "Misc/healthItem.png";
            description = "Health Soda(MX HEAL+)";
            statString = "maxHealth";

                break;
            case 4:
                filename = "Misc/attackSpeedCandy.png";
                description = "Sugar Rush Candy(ATK SPD+)";
                statString = "attackSpeed";
    
                    break;
            case 5:
                    filename = "Misc/eyeClare.png";
                    description = "Eagle Eye Eclair(ATTK RNG+)";
                    statString = "attackRange";
        
                        break;
        }
        
        Item itemForSale = new Item(getMapTile(19,14).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load(filename),16,16),"DEFAULT", statString, StatAdd,filename,cost,description);
        itemForSale.setInteractScript(new ItemPickup());
        items.add(itemForSale);
        



        return items;
    }
    public ArrayList<Pickup> loadPickups() {
        ArrayList<Pickup> pickups = new ArrayList<>();

        
        return pickups;

    }
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        return enemies;
    }
    @Override
    public void loadScripts() {

        getMapTile(12,2).setInteractScript(new RandomChangeMapScript(1));

        getMapTile(12,6).setInteractScript(new RandomChangeMapScript(3));

    }
    
}
