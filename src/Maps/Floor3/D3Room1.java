package Maps.Floor3;

import java.util.ArrayList;

import Enemy.CerealKiller;
import Enemy.Eggssassin;
import Enemy.Spineapple;
import EnhancedMapTiles.Spikes;
import Level.EnhancedMapTile;
import Level.Enemy;
import Level.Map;
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
        // this.playerStartPosition = getMapTile(4, 19).getLocation();
        this.mapInt = 21;
        this.idSwitch = 21;                //Aka ""
        }

        //Temporary NPC
        public ArrayList<NPC> loadNPCs() {
            ArrayList<NPC> npcs = new ArrayList<>();

            Walrus walrus = new Walrus(1, getMapTile(10, 5).getLocation().subtractY(40));
            walrus.setInteractScript(new Floor3Script());
            npcs.add(walrus);

            return npcs;
        }
        // Where enhanced map tiles go (aka spikes)
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
            ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
    

    
            return enhancedMapTiles;
        }

        // Where enemies will go
        public ArrayList<Enemy> loadEnemies() {
            ArrayList<Enemy> enemies = new ArrayList<>();

            
            
            return enemies;
        }

        // Where the end of level door/sign is
    @Override
    public void loadScripts() {

        //getMapTile(19,4).setInteractScript(new RandomChangeMapScript(3));
    }
    
}
