package Maps.Floor3;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import EnhancedMapTiles.Spikes;
import Level.EnhancedMapTile;
import Level.Enemy;
import Level.Map;
import Level.Pickup;
import Level.NPC;
import Level.Tileset;
import NPCs.Walrus;
import Tilesets.Floor3Tileset;
import Scripts.Floor2Script;
import Scripts.Floor3Script;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;
import Scripts.TestMap.RandomChangeMapScript;

public class D3Room1 extends Map {

    public D3Room1() {
        super("D3Room1.txt", new Floor3Tileset());
        this.playerStartPosition = getMapTile(2, 8).getLocation();
        this.mapInt = 21;
        this.idSwitch = 21;                //Aka "Minecraft Milk Bucket"
        }

        //Temporary NPC
        public ArrayList<NPC> loadNPCs() {
            ArrayList<NPC> npcs = new ArrayList<>();

            //Walrus walrus = new Walrus(1, getMapTile(10, 5).getLocation().subtractY(40));
            //walrus.setInteractScript(new Floor3Script());
            //npcs.add(walrus);

            return npcs;
        }
        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    
            Spikes spikes1 = new Spikes(getMapTile(6, 12).getLocation());
            Spikes spikes2 = new Spikes(getMapTile(6, 13).getLocation());
            Spikes spikes3 = new Spikes(getMapTile(6, 14).getLocation());
            Spikes spikes4 = new Spikes(getMapTile(6, 15).getLocation());
            Spikes spikes5 = new Spikes(getMapTile(7, 12).getLocation());
            Spikes spikes6 = new Spikes(getMapTile(7, 13).getLocation());
            Spikes spikes7 = new Spikes(getMapTile(7, 14).getLocation());
            Spikes spikes8 = new Spikes(getMapTile(7, 15).getLocation());
            Spikes spikes9 = new Spikes(getMapTile(8, 12).getLocation());
            Spikes spikes10 = new Spikes(getMapTile(8, 13).getLocation());
            Spikes spikes11 = new Spikes(getMapTile(8, 16).getLocation());
            Spikes spikes12 = new Spikes(getMapTile(8, 17).getLocation());
            Spikes spikes13 = new Spikes(getMapTile(8, 18).getLocation());
            Spikes spikes14 = new Spikes(getMapTile(8, 19).getLocation());
            Spikes spikes15 = new Spikes(getMapTile(9, 12).getLocation());
            Spikes spikes16 = new Spikes(getMapTile(9, 13).getLocation());
            Spikes spikes17 = new Spikes(getMapTile(9, 16).getLocation());
            Spikes spikes18 = new Spikes(getMapTile(9, 17).getLocation());
            Spikes spikes19 = new Spikes(getMapTile(9, 18).getLocation());
            Spikes spikes20 = new Spikes(getMapTile(9, 19).getLocation());
            Spikes spikes21 = new Spikes(getMapTile(16, 10).getLocation());
            Spikes spikes22 = new Spikes(getMapTile(16, 11).getLocation());
            Spikes spikes23 = new Spikes(getMapTile(16, 12).getLocation());
            Spikes spikes24 = new Spikes(getMapTile(16, 13).getLocation());
            Spikes spikes25 = new Spikes(getMapTile(16, 14).getLocation());
            Spikes spikes26 = new Spikes(getMapTile(16, 15).getLocation());
            Spikes spikes27 = new Spikes(getMapTile(16, 18).getLocation());
            Spikes spikes28 = new Spikes(getMapTile(16, 19).getLocation());
            Spikes spikes29 = new Spikes(getMapTile(17, 10).getLocation());
            Spikes spikes30 = new Spikes(getMapTile(17, 11).getLocation());
            Spikes spikes31 = new Spikes(getMapTile(17, 12).getLocation());
            Spikes spikes32 = new Spikes(getMapTile(17, 13).getLocation());
            Spikes spikes33 = new Spikes(getMapTile(17, 14).getLocation());
            Spikes spikes34 = new Spikes(getMapTile(17, 15).getLocation());
            Spikes spikes35 = new Spikes(getMapTile(17, 18).getLocation());
            Spikes spikes36 = new Spikes(getMapTile(17, 19).getLocation());
            Spikes spikes37 = new Spikes(getMapTile(18, 10).getLocation());
            Spikes spikes38 = new Spikes(getMapTile(18, 11).getLocation());
            Spikes spikes39 = new Spikes(getMapTile(19, 10).getLocation());
            Spikes spikes40 = new Spikes(getMapTile(19, 11).getLocation());
            enhancedMapTiles.add(spikes1);
            enhancedMapTiles.add(spikes2);
            enhancedMapTiles.add(spikes3);
            enhancedMapTiles.add(spikes4);
            enhancedMapTiles.add(spikes5);
            enhancedMapTiles.add(spikes6);
            enhancedMapTiles.add(spikes7);
            enhancedMapTiles.add(spikes8);
            enhancedMapTiles.add(spikes9);
            enhancedMapTiles.add(spikes10);
            enhancedMapTiles.add(spikes11);
            enhancedMapTiles.add(spikes12);
            enhancedMapTiles.add(spikes13);
            enhancedMapTiles.add(spikes14);
            enhancedMapTiles.add(spikes15);
            enhancedMapTiles.add(spikes16);
            enhancedMapTiles.add(spikes17);
            enhancedMapTiles.add(spikes18);
            enhancedMapTiles.add(spikes19);
            enhancedMapTiles.add(spikes20);
            enhancedMapTiles.add(spikes21);
            enhancedMapTiles.add(spikes22);
            enhancedMapTiles.add(spikes23);
            enhancedMapTiles.add(spikes24);
            enhancedMapTiles.add(spikes25);
            enhancedMapTiles.add(spikes26);
            enhancedMapTiles.add(spikes27);
            enhancedMapTiles.add(spikes28);
            enhancedMapTiles.add(spikes29);
            enhancedMapTiles.add(spikes30);
            enhancedMapTiles.add(spikes31);
            enhancedMapTiles.add(spikes32);
            enhancedMapTiles.add(spikes33);
            enhancedMapTiles.add(spikes34);
            enhancedMapTiles.add(spikes35);
            enhancedMapTiles.add(spikes36);
            enhancedMapTiles.add(spikes37);
            enhancedMapTiles.add(spikes38);
            enhancedMapTiles.add(spikes39);
            enhancedMapTiles.add(spikes40);
    
            return enhancedMapTiles;
        }

        // Where coins go
        public ArrayList<Pickup> loadPickups() {
            ArrayList<Pickup> pickups = new ArrayList<>();
    
            Pickup coin = new Pickup(getMapTile(8,14).getLocation());
            pickups.add(coin);
    
            Pickup coin1 = new Pickup(getMapTile(8,15).getLocation());
            pickups.add(coin1);
    
            Pickup coin2 = new Pickup(getMapTile(9,14).getLocation());
            pickups.add(coin2);

            Pickup coin3 = new Pickup(getMapTile(9,15).getLocation());
            pickups.add(coin3);
            
            return pickups;
    
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            Spineapple spineapple1 = new Spineapple(0, getMapTile(7, 22).getLocation());
            spineapple1.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple1);

            Spineapple spineapple2 = new Spineapple(0, getMapTile(16, 22).getLocation());
            spineapple2.setExistenceFlag("hasTalkedToSpineapple");
            enemies.add(spineapple2);
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        getMapTile(21,8).setInteractScript(new RandomChangeMapScript(3));
    }
    
}
