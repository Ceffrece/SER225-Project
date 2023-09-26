package Maps;

import java.util.ArrayList;

import Level.Map;
import Level.NPC;
import NPCs.Walrus;
import Scripts.MarcusMap.WalrusScript;
import Tilesets.CommonTileset;

public class MarcusMap extends Map {

    public MarcusMap() {
        super("marcus_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(10, 2).getLocation();
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus walrus = new Walrus(1, getMapTile(18, 1).getLocation());
        walrus.setExistenceFlag("hasTalkedToWalrus");
        walrus.setInteractScript(new WalrusScript());
        npcs.add(walrus);

        return npcs;
    }
}