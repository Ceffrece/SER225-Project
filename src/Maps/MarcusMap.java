package Maps;

import java.util.ArrayList;

import Level.Map;
import Level.NPC;
import NPCs.Walrus;
import Scripts.SimpleTextScript;
import Scripts.MarcusMap.WalrusScript;
import Tilesets.Floor1Tileset;

public class MarcusMap extends Map {

    public MarcusMap() {
        super("marcus_map.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(10, 2).getLocation();
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus walrus = new Walrus(1, getMapTile(17, 2).getLocation());
        walrus.setExistenceFlag("hasTalkedToWalrus");
        walrus.setInteractScript(new WalrusScript());
        npcs.add(walrus);

        return npcs;
    }

    @Override
    public void loadScripts() {
        getMapTile(12, 0).setInteractScript(new SimpleTextScript("Marcus put his blood, sweat, tears, and\ncountless cans of Liquid Death into this map.")); 

        getMapTile(11,15).setInteractScript(new SimpleTextScript("Congrats on walking all the way down here!"));

        getMapTile(16, 4).setInteractScript(new SimpleTextScript("You look lovely today :)")); 

        getMapTile(1,9).setInteractScript(new SimpleTextScript("Maybe one day this door will function :)"));
    }
}