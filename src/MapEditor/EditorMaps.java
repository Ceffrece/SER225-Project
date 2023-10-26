package MapEditor;

import Level.Map;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.MarcusMap;
import Maps.DungeonRoom;
import Maps.HubMap;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("MarcusMap");
            add("HubMap");
            add("DungeonRoom");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "MarcusMap":
                return new MarcusMap();
            case "HubMap":
                return new HubMap();
            case "DungeonRoom":
                return new DungeonRoom();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
