package Maps;

import java.util.ArrayList;

import Engine.ImageLoader;
import GameObject.SpriteSheet;
import Level.Item;
import Level.Map;
import Tilesets.Floor1Tileset;
import Scripts.ProjectilePickup;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.SwordScript;

public class HubMap extends Map {

    public HubMap() {
        super("hub_map.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(12, 14).getLocation();
        this.mapInt = 0;
        this.idSwitch = 0;

    }
    public ArrayList<Item> loadItems() {
        ArrayList<Item> items = new ArrayList<>();

        Item peaPickup = new Item(getMapTile(20,13).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load("peaProjectile.png"),16,16),"DEFAULT","peaProjectile");
        peaPickup.setInteractScript(new ProjectilePickup());
        items.add(peaPickup);

        Item riceballPickup = new Item(getMapTile(20,17).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load("riceBallProjectile.png"),16,16),"DEFAULT","riceBallProjectile");
        riceballPickup.setInteractScript(new ProjectilePickup());
        items.add(riceballPickup);

        Item bannaPickup = new Item(getMapTile(22,15).getLocation().subtractY(40),new SpriteSheet(ImageLoader.load("bannanaProjectile.png"),16,16),"DEFAULT","bannanaProjectile");
        bannaPickup.setInteractScript(new ProjectilePickup());
        items.add(bannaPickup);

        

        return items;
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
