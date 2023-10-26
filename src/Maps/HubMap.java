package Maps;

import Level.Map;
import Tilesets.Floor1Tileset;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ChangeMapScript;

public class HubMap extends Map {

    public HubMap() {
        super("hub_map.txt", new Floor1Tileset());
        this.playerStartPosition = getMapTile(12, 14).getLocation();
        this.mapInt = 0;
        this.idSwitch = 0;

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
