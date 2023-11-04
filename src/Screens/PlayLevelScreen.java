package Screens;

import Engine.Screen;
import Engine.GraphicsHandler;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.DungeonRoom1;
import Maps.DungeonRoom2;
import Maps.Floor1Boss;
import Maps.HubMap;
import Maps.MarcusMap;
import Maps.TestMap;
import Players.Cat;
import Utils.Direction;
import Utils.Point;

// This class is for when the rpg game is actually being played
public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinMarcusScreen winMarcusScreen;
    protected FlagManager flagManager;

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }
    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("hasTalkedToWalrus", false);
        
        // define/setup map
        this.map = new HubMap();
        map.setFlagManager(flagManager);

        // setup player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        this.player.setMap(map);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        this.playLevelScreenState = PlayLevelScreenState.RUNNING;
        this.player.setFacingDirection(Direction.LEFT);

        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());

        // setup map scripts to have references to the map and player
        for (MapTile mapTile : map.getMapTiles()) {
            if (mapTile.getInteractScript() != null) {
                mapTile.getInteractScript().setMap(map);
                mapTile.getInteractScript().setPlayer(player);
            }
        }
        for (Item item : map.getItems()) {
            if (item.getInteractScript() != null) {
                item.getInteractScript().setMap(map);
                item.getInteractScript().setPlayer(player);
            }
        }
        for (NPC npc : map.getNPCs()) {
            if (npc.getInteractScript() != null) {
                npc.getInteractScript().setMap(map);
                npc.getInteractScript().setPlayer(player);
            }
        }
        for (EnhancedMapTile enhancedMapTile : map.getEnhancedMapTiles()) {
            if (enhancedMapTile.getInteractScript() != null) {
                enhancedMapTile.getInteractScript().setMap(map);
                enhancedMapTile.getInteractScript().setPlayer(player);
            }
        }
        for (Trigger trigger : map.getTriggers()) {
            if (trigger.getTriggerScript() != null) {
                trigger.getTriggerScript().setMap(map);
                trigger.getTriggerScript().setPlayer(player);
            }
        }

        // winMarcusScreen = new WinMarcusScreen(this);
    }

    public void update() {
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the rpg level going
            case RUNNING:
                player.update();
                map.update(player);
                if (map.getMapInt() != map.getIdSwitch()) {
                    this.map = loadMap(map.getIdSwitch());
                    this.map.setFlagManager(flagManager);
                    loadMapInfo(this.map);
                    this.player.setMap(this.map);
                    Point playerStartPosition = map.getPlayerStartPosition();
                    this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
                }
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                winMarcusScreen.update();
                break;
        }

        
        
    }
    public void loadMapInfo(Map map) {
        // setup map scripts to have references to the map and player
        for (MapTile mapTile : map.getMapTiles()) {
            if (mapTile.getInteractScript() != null) {
                mapTile.getInteractScript().setMap(map);
                mapTile.getInteractScript().setPlayer(player);
            }
        }
        for (NPC npc : map.getNPCs()) {
            if (npc.getInteractScript() != null) {
                npc.getInteractScript().setMap(map);
                npc.getInteractScript().setPlayer(player);
            }
        }
        for (EnhancedMapTile enhancedMapTile : map.getEnhancedMapTiles()) {
            if (enhancedMapTile.getInteractScript() != null) {
                enhancedMapTile.getInteractScript().setMap(map);
                enhancedMapTile.getInteractScript().setPlayer(player);
            }
        }

        for (Trigger trigger : map.getTriggers()) {
            if (trigger.getTriggerScript() != null) {
                trigger.getTriggerScript().setMap(map);
                trigger.getTriggerScript().setPlayer(player);
            }
        }

        
            
        
    }
    public Map loadMap(int mapId){
        Map newMap;
        switch (mapId){
            case 0:
                newMap = new HubMap();
                return newMap;
            case 1:
                newMap = new DungeonRoom1();
                return newMap;
            case 2:
                newMap = new DungeonRoom2();
                return newMap;
            case 100:
                newMap = new Floor1Boss();
                return newMap;
            case 101:
                newMap = new TestMap();
                return newMap;
            default:
                return null;
        }
    }
    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                break;
            case LEVEL_COMPLETED:
                winMarcusScreen.draw(graphicsHandler);
                break;
        }
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }


    public void resetLevel() {
        initialize();
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED
    }
}
