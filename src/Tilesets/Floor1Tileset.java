package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
// import GameObject.ImageEffect; (unused)
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// Class for the tileset meant for floor 1 (bread/grains themed)
// Each room will be its own map so this is gonna get called quite a few times
public class Floor1Tileset extends Tileset {
    
    public Floor1Tileset() {
        super(ImageLoader.load("tilesets//Floor1Tileset.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // top left sandy ground (sand1)
        Frame sand1Frame = new FrameBuilder(getSubImage(0,0))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand1Tile = new MapTileBuilder(sand1Frame);

        mapTiles.add(sand1Tile);

        // top sandy ground (sand2)
        Frame sand2Frame = new FrameBuilder(getSubImage(0,1))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand2Tile = new MapTileBuilder(sand2Frame);

        mapTiles.add(sand2Tile);

        // top right sandy ground (sand3)
        Frame sand3Frame = new FrameBuilder(getSubImage(0,2))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand3Tile = new MapTileBuilder(sand3Frame);

        mapTiles.add(sand3Tile);

        // left sandy ground (sand4)
        Frame sand4Frame = new FrameBuilder(getSubImage(1,0))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand4Tile = new MapTileBuilder(sand4Frame);

        mapTiles.add(sand4Tile);

        // center sandy ground (sand5)
        Frame sand5Frame = new FrameBuilder(getSubImage(1,1))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand5Tile = new MapTileBuilder(sand5Frame);

        mapTiles.add(sand5Tile);

        // right sandy ground (sand6)
        Frame sand6Frame = new FrameBuilder(getSubImage(1,2))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand6Tile = new MapTileBuilder(sand6Frame);

        mapTiles.add(sand6Tile);

        // bottom left sandy ground (sand7)
        Frame sand7Frame = new FrameBuilder(getSubImage(2,0))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand7Tile = new MapTileBuilder(sand7Frame);

        mapTiles.add(sand7Tile);

        // bottom sandy ground (sand8)
        Frame sand8Frame = new FrameBuilder(getSubImage(2,1))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand8Tile = new MapTileBuilder(sand8Frame);

        mapTiles.add(sand8Tile);

        // bottom right sandy ground (sand9)
        Frame sand9Frame = new FrameBuilder(getSubImage(2,2))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand9Tile = new MapTileBuilder(sand9Frame);

        mapTiles.add(sand9Tile);

        // left horizontal row sandy ground (sand10)
        Frame sand10Frame = new FrameBuilder(getSubImage(3,0))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand10Tile = new MapTileBuilder(sand10Frame);

        mapTiles.add(sand10Tile);

        // middle horizontal row sandy ground (sand11)
        Frame sand11Frame = new FrameBuilder(getSubImage(3,1))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand11Tile = new MapTileBuilder(sand11Frame);

        mapTiles.add(sand11Tile);

        // right horizontal row sandy ground (sand12)
        Frame sand12Frame = new FrameBuilder(getSubImage(3,2))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand12Tile = new MapTileBuilder(sand12Frame);

        mapTiles.add(sand12Tile);

        // top vertical row sandy ground (sand13)
        Frame sand13Frame = new FrameBuilder(getSubImage(0,3))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand13Tile = new MapTileBuilder(sand13Frame);

        mapTiles.add(sand13Tile);

        // middle vertical row sandy ground (sand14)
        Frame sand14Frame = new FrameBuilder(getSubImage(1,3))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand14Tile = new MapTileBuilder(sand14Frame);

        mapTiles.add(sand14Tile);

        // bottom vertical row sandy ground (sand15)
        Frame sand15Frame = new FrameBuilder(getSubImage(2,3))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand15Tile = new MapTileBuilder(sand15Frame);

        mapTiles.add(sand15Tile);

        // single sandy ground (sand16)
        Frame sand16Frame = new FrameBuilder(getSubImage(0,4))
            .withScale(tileScale)
            .build();

        MapTileBuilder sand16Tile = new MapTileBuilder(sand16Frame);

        mapTiles.add(sand16Tile);

        // door (door)
        Frame doorFrame = new FrameBuilder(getSubImage(3,3))
            .withScale(tileScale)
            .build();

        MapTileBuilder doorTile = new MapTileBuilder(doorFrame);

        mapTiles.add(doorTile);

        // spikes (spikes)
        Frame[] spikesFrames = new Frame[] {
            new FrameBuilder(getSubImage(5,4), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(6,4), 65)
                    .withScale(tileScale)
                    .build()
        };

        MapTileBuilder spikesTile = new MapTileBuilder(spikesFrames);

        mapTiles.add(spikesTile);

        // top left wooden ground (wood1)
        Frame wood1Frame = new FrameBuilder(getSubImage(0,5))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood1Tile = new MapTileBuilder(wood1Frame);
        
        mapTiles.add(wood1Tile);

        // top wood ground (wood2)
        Frame wood2Frame = new FrameBuilder(getSubImage(0,6))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood2Tile = new MapTileBuilder(wood2Frame);
        
        mapTiles.add(wood2Tile);

        // top right wood ground (wood3)
        Frame wood3Frame = new FrameBuilder(getSubImage(0,7))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood3Tile = new MapTileBuilder(wood3Frame);
        
        mapTiles.add(wood3Tile);

        // left wood ground (wood4)
        Frame wood4Frame = new FrameBuilder(getSubImage(1,5))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood4Tile = new MapTileBuilder(wood4Frame);
        
        mapTiles.add(wood4Tile);

        // center wood ground (wood5)
        Frame wood5Frame = new FrameBuilder(getSubImage(1,6))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood5Tile = new MapTileBuilder(wood5Frame);
        
        mapTiles.add(wood5Tile);

        // right wood ground (wood6)
        Frame wood6Frame = new FrameBuilder(getSubImage(1,7))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood6Tile = new MapTileBuilder(wood6Frame);
        
        mapTiles.add(wood6Tile);

        // bottom left wood ground (wood7)
        Frame wood7Frame = new FrameBuilder(getSubImage(2,5))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood7Tile = new MapTileBuilder(wood7Frame);
        
        mapTiles.add(wood7Tile);

        // bottom wood ground (wood8)
        Frame wood8Frame = new FrameBuilder(getSubImage(2,6))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood8Tile = new MapTileBuilder(wood8Frame);
        
        mapTiles.add(wood8Tile);

        // bottom right wood ground (wood9)
        Frame wood9Frame = new FrameBuilder(getSubImage(2,7))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood9Tile = new MapTileBuilder(wood9Frame);
        
        mapTiles.add(wood9Tile);

        // left horizontal row wood ground (wood10)
        Frame wood10Frame = new FrameBuilder(getSubImage(4,8))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood10Tile = new MapTileBuilder(wood10Frame);
        
        mapTiles.add(wood10Tile);

        // middle horizontal row wood ground (wood11)
        Frame wood11Frame = new FrameBuilder(getSubImage(5,8))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood11Tile = new MapTileBuilder(wood11Frame);
        
        mapTiles.add(wood11Tile);

        // right horizontal row wood ground (wood12)
        Frame wood12Frame = new FrameBuilder(getSubImage(6,8))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood12Tile = new MapTileBuilder(wood12Frame);
        
        mapTiles.add(wood12Tile);

        // top vertical row wood ground (wood13)
        Frame wood13Frame = new FrameBuilder(getSubImage(0,8))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood13Tile = new MapTileBuilder(wood13Frame);
        
        mapTiles.add(wood13Tile);

        // middle vertical row wood ground (wood14)
        Frame wood14Frame = new FrameBuilder(getSubImage(1,8))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood14Tile = new MapTileBuilder(wood14Frame);
        
        mapTiles.add(wood14Tile);

        // bottom vertical row wood ground (wood15)
        Frame wood15Frame = new FrameBuilder(getSubImage(2,8))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood15Tile = new MapTileBuilder(wood15Frame);
        
        mapTiles.add(wood15Tile);

        // single wood ground (wood16)
        Frame wood16Frame = new FrameBuilder(getSubImage(3,8))
            .withScale(tileScale)
            .build();

        MapTileBuilder wood16Tile = new MapTileBuilder(wood16Frame);
        
        mapTiles.add(wood16Tile);

        // top left lava (lava1)
        Frame[] lava1Frames = new Frame[] {
            new FrameBuilder(getSubImage(5,5), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(3,5), 65)
                    .withScale(tileScale)
                    .build()
        };

        MapTileBuilder lava1Tile = new MapTileBuilder(lava1Frames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lava1Tile);

        // top lava (lava2)
        Frame[] lava2Frames = new Frame[] {
            new FrameBuilder(getSubImage(5,6), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(3,6), 65)
                    .withScale(tileScale)
                    .build()
        };

        MapTileBuilder lava2Tile = new MapTileBuilder(lava2Frames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lava2Tile);

        // top right lava (lava3)
        Frame[] lava3Frames = new Frame[] {
            new FrameBuilder(getSubImage(5,7), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(3,7), 65)
                    .withScale(tileScale)
                    .build()
        };

        MapTileBuilder lava3Tile = new MapTileBuilder(lava3Frames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lava3Tile);

        // bottom left lava (lava4)
        Frame[] lava4Frames = new Frame[] {
            new FrameBuilder(getSubImage(6,5), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(4,5), 65)
                    .withScale(tileScale)
                    .build()
        };

        MapTileBuilder lava4Tile = new MapTileBuilder(lava4Frames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lava4Tile);

        // bottom lava (lava5)
        Frame[] lava5Frames = new Frame[] {
            new FrameBuilder(getSubImage(6,6), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(4,6), 65)
                    .withScale(tileScale)
                    .build()
        };

        MapTileBuilder lava5Tile = new MapTileBuilder(lava5Frames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lava5Tile);

        // bottom right lava (lava6)
        Frame[] lava6Frames = new Frame[] {
            new FrameBuilder(getSubImage(6,7), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(4,7), 65)
                    .withScale(tileScale)
                    .build()
        };

        MapTileBuilder lava6Tile = new MapTileBuilder(lava6Frames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lava6Tile);

        // top left wall corner (wall1)
        Frame wall1Frame = new FrameBuilder(getSubImage(4,0))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall1Tile = new MapTileBuilder(wall1Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wall1Tile);

        // top right wall corner (wall2)
        Frame wall2Frame = new FrameBuilder(getSubImage(4,2))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall2Tile = new MapTileBuilder(wall2Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wall2Tile);

        // bottom left wall corner (wall3)
        Frame wall3Frame = new FrameBuilder(getSubImage(5,1))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall3Tile = new MapTileBuilder(wall3Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wall3Tile);

        // bottom right wall corner (wall4)
        Frame wall4Frame = new FrameBuilder(getSubImage(5,2))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall4Tile = new MapTileBuilder(wall4Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wall4Tile);

        // horizontal wall (wall5)
        Frame wall5Frame = new FrameBuilder(getSubImage(4,1))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall5Tile = new MapTileBuilder(wall5Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wall5Tile);

        // vertical wall (wall6)
        Frame wall6Frame = new FrameBuilder(getSubImage(5,0))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall6Tile = new MapTileBuilder(wall6Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wall6Tile);

        // T wall (wall7)
        Frame wall7Frame = new FrameBuilder(getSubImage(1,4))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall7Tile = new MapTileBuilder(wall7Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wall7Tile);

        // plus wall (wall8)
        Frame wall8Frame = new FrameBuilder(getSubImage(2,4))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall8Tile = new MapTileBuilder(wall8Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wall8Tile);

        // perpendicular wall (wall9)
        Frame wall9Frame = new FrameBuilder(getSubImage(3,4))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall9Tile = new MapTileBuilder(wall9Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wall9Tile);

        // left H wall (wall10)
        Frame wall10Frame = new FrameBuilder(getSubImage(4,3))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall10Tile = new MapTileBuilder(wall10Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wall10Tile);

        // right H wall (wall11)
        Frame wall11Frame = new FrameBuilder(getSubImage(4,4))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall11Tile = new MapTileBuilder(wall11Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wall11Tile);

        // end wall (wall12)
        Frame wall12Frame = new FrameBuilder(getSubImage(5,3))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall12Tile = new MapTileBuilder(wall12Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wall12Tile);

        // light shade (lightBrown)
        Frame lightBrownFrame = new FrameBuilder(getSubImage(6,0))
                .withScale(tileScale)
                .build();

        MapTileBuilder lightBrownTile = new MapTileBuilder(lightBrownFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(lightBrownTile);

        // medium shade (mediumBrown)
        Frame mediumBrownFrame = new FrameBuilder(getSubImage(6,1))
                .withScale(tileScale)
                .build();

        MapTileBuilder mediumBrownTile = new MapTileBuilder(mediumBrownFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(mediumBrownTile);

        // dark shade (darkBrown)
        Frame darkBrownFrame = new FrameBuilder(getSubImage(6,2))
                .withScale(tileScale)
                .build();

        MapTileBuilder darkBrownTile = new MapTileBuilder(darkBrownFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(darkBrownTile);

        // black (black)
        Frame blackFrame = new FrameBuilder(getSubImage(6,3))
                .withScale(tileScale)
                .build();

        MapTileBuilder blackTile = new MapTileBuilder(blackFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(blackTile);

        // sandy ground sign (sign1)
        Frame sign1Frame = new FrameBuilder(getSubImage(0,9))
            .withScale(tileScale)
            .build();

        MapTileBuilder sign1Tile = new MapTileBuilder(sign1Frame)
                .withTileType(TileType.NOT_PASSABLE);
        
        mapTiles.add(sign1Tile);

        // wood ground sign (sign2)
        Frame sign2Frame = new FrameBuilder(getSubImage(1,9))
            .withScale(tileScale)
            .build();

        MapTileBuilder sign2Tile = new MapTileBuilder(sign2Frame)
                .withTileType(TileType.NOT_PASSABLE);
        
        mapTiles.add(sign2Tile);

        // horizontal wall sign (sign3)
        Frame sign3Frame = new FrameBuilder(getSubImage(2,9))
            .withScale(tileScale)
            .build();

        MapTileBuilder sign3Tile = new MapTileBuilder(sign3Frame)
                .withTileType(TileType.NOT_PASSABLE);
        
        mapTiles.add(sign3Tile);

        // perpendicular wall sign (sign4)
        Frame sign4Frame = new FrameBuilder(getSubImage(3,9))
            .withScale(tileScale)
            .build();

        MapTileBuilder sign4Tile = new MapTileBuilder(sign4Frame)
                .withTileType(TileType.NOT_PASSABLE);
        
        mapTiles.add(sign4Tile);

        return mapTiles;
    }
}
