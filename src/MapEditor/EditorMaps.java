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
import Maps.Floor2.D2Room1;
import Maps.Floor2.D2Room2;
import Maps.Floor2.D2Room3;
import Maps.Floor2.D2Room4;
import Maps.Floor2.D2Room5;
import Maps.Floor2.D2Room6;
import Maps.Floor2.D2Room7;
import Maps.Floor2.D2Room8;
import Maps.Floor2.D2Room9;
import Maps.Floor2.D2Room10;
import Maps.Floor3.D3Room1;
import Maps.Floor3.D3Room2;
import Maps.Floor3.D3Room3;
import Maps.Floor3.D3Room4;
import Maps.Floor3.D3Room5;
import Maps.Floor3.D3Room6;
import Maps.Floor3.D3Room7;
import Maps.Floor3.D3Room8;
import Maps.Floor3.D3Room9;
import Maps.Floor3.D3Room10;
import Maps.Floor1.Floor1Boss;
import Maps.Floor2.Floor2Boss;
import Maps.Floor3.Floor3Boss;
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
            add("D2Room1");
            add("D2Room2");
            add("D2Room3");
            add("D2Room4");
            add("D2Room5");
            add("D2Room6");
            add("D2Room7");
            add("D2Room8");
            add("D2Room9");
            add("D2Room10");
            add("D3Room1");
            add("D3Room2");
            add("D3Room3");
            add("D3Room4");
            add("D3Room5");
            add("D3Room6");
            add("D3Room7");
            add("D3Room8");
            add("D3Room9");
            add("D3Room10");
            add("Floor1Boss");
            add("Floor2Boss");
            add("Floor3Boss");
            add("Shop");

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
            case "D2Room1":
                return new D2Room1();
            case "D2Room2":
                return new D2Room2();
            case "D2Room3":
                return new D2Room3();
            case "D2Room4":
                return new D2Room4();
            case "D2Room5":
                return new D2Room5();
            case "D2Room6":
                return new D2Room6();
            case "D2Room7":
                return new D2Room7();
            case "D2Room8":
                return new D2Room8();
            case "D2Room9":
                return new D2Room9();
            case "D2Room10":
                return new D2Room10();
            case "D3Room1":
                return new D3Room1();
            case "D3Room2":
                return new D3Room2();
            case "D3Room3":
                return new D3Room3();
            case "D3Room4":
                return new D3Room4();
            case "D3Room5":
                return new D3Room5();
            case "D3Room6":
                return new D3Room6();
            case "D3Room7":
                return new D3Room7();
            case "D3Room8":
                return new D3Room8();
            case "D3Room9":
                return new D3Room9();
            case "D3Room10":
                return new D3Room10();
            case "Floor1Boss":
                return new Floor1Boss();
            case "Floor2Boss":
                return new Floor2Boss();
            case "Floor3Boss":
                return new Floor3Boss();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
