package MapEditor;

import Level.Map;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.MarcusMap;
import Maps.DungeonRoom1;
import Maps.DungeonRoom2;
import Maps.DungeonRoom1;
import Maps.HubMap;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("MarcusMap");
            add("HubMap");
            add("DungeonRoom1");
            add("DungeonRoom2");
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
            case "DungeonRoom1":
                return new DungeonRoom1();
            case "DungeonRoom2":
                return new DungeonRoom2();

            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
