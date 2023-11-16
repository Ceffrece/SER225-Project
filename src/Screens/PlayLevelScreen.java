package Screens;

import Engine.Screen;
import Engine.GraphicsHandler;
import Game.Game;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.HubMap;
import Maps.MarcusMap;
import Maps.Shop;
import Maps.TestMap;
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
    public static boolean inBossFight1 = false;

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
        if(player.getPlayerHealth() == 0 && player.deathCounter == 299){
            MenuScreen.setGameStarted(false);
            screenCoordinator.setGameState(GameState.DYING);
        }
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
        for (Item item : map.getItems()) {
            if (item.getInteractScript() != null) {
                item.getInteractScript().setMap(map);
                item.getInteractScript().setPlayer(player);
            }
        }

        
            
        
    }
    public Map loadMap(int mapId){
        Map newMap;
        switch (mapId){
            case 0:
                newMap = new HubMap();
                inBossFight1 = false;
                return newMap;
            case 1:
                newMap = new DungeonRoom1();
                inBossFight1 = false;
                return newMap;
            case 2:
                newMap = new DungeonRoom2();
                inBossFight1 = false;
                return newMap;
            case 3:
                newMap = new DungeonRoom3();
                inBossFight1 = false;
                return newMap;
            case 4:
                newMap = new DungeonRoom4();
                inBossFight1 = false;
                return newMap;
            case 5:
                newMap = new DungeonRoom5();
                inBossFight1 = false;
                return newMap;
            case 6:
                newMap = new DungeonRoom6();
                inBossFight1 = false;
                return newMap;
            case 7:
                newMap = new DungeonRoom7();
                inBossFight1 = false;
                return newMap;
            case 8:
                newMap = new DungeonRoom8();
                inBossFight1 = false;
                return newMap;
            case 9:
                newMap = new DungeonRoom9();
                inBossFight1 = false;
                return newMap;
            case 10:
                newMap = new DungeonRoom10();
                inBossFight1 = false;
                return newMap;
            case 100:
                newMap = new Floor1Boss();
                Game.gameMusic.pause();
                Game.bossMusic1.play();
                inBossFight1 = true;
                return newMap;
            case 111:
                newMap = new Shop();
                Game.gameMusic.pause();
                Game.bossMusic1.play();
                inBossFight1 = false;
                return newMap;
            case 101:
                newMap = new TestMap();
                inBossFight1 = false;
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
