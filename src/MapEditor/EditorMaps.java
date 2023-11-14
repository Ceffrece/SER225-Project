package MapEditor;

import Level.Map;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.Floor1.DungeonRoom1;
import Maps.Floor1.DungeonRoom2;
import Maps.Floor1.DungeonRoom3;
import Maps.Floor1.DungeonRoom4;
import Maps.Floor1.DungeonRoom5;
import Maps.Floor1.DungeonRoom6;
import Maps.Floor1.DungeonRoom7;
import Maps.Floor1.DungeonRoom8;
import Maps.Floor1.DungeonRoom9;
import Maps.Floor1.DungeonRoom10;
import Maps.Floor1.Floor1Boss;
import Maps.MarcusMap;
import Maps.Shop;
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
            add("DungeonRoom3");
            add("DungeonRoom4");
            add("DungeonRoom5");
            add("DungeonRoom6");
            add("DungeonRoom7");
            add("DungeonRoom8");
            add("DungeonRoom9");
            add("DungeonRoom10");
            add("Shop");
            add("Floor1Boss");

        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "Shop":
                return new Shop();
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
            case "DungeonRoom3":
                return new DungeonRoom3();
            case "DungeonRoom4":
                return new DungeonRoom4();
            case "DungeonRoom5":
                return new DungeonRoom5();
            case "DungeonRoom6":
                return new DungeonRoom6();
            case "DungeonRoom7":
                return new DungeonRoom7();
            case "DungeonRoom8":
                return new DungeonRoom8();
            case "DungeonRoom9":
                return new DungeonRoom9();
            case "DungeonRoom10":
                return new DungeonRoom10();
            case "Floor1Boss":
                return new Floor1Boss();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
