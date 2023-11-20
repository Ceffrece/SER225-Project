package MapEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    JMenu options;
    JCheckBoxMenuItem showNpcs;
    JCheckBoxMenuItem showEnchancedMapTiles;
    JCheckBoxMenuItem showTriggers;
    JCheckBoxMenuItem showEnemies;
    JCheckBoxMenuItem showPickups;

    public MenuBar(TileBuilder tileBuilder) {
        options = new JMenu("Options");
        showNpcs = new JCheckBoxMenuItem("Show NPCs");
        showNpcs.setSelected(true);
        showNpcs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tileBuilder.setShowNPCs(!tileBuilder.getShowNPCs());
            }
        });
        options.add(showNpcs);
        showEnchancedMapTiles = new JCheckBoxMenuItem("Show Enhanced Map Tiles");
        showEnchancedMapTiles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tileBuilder.setShowEnhancedMapTiles(!tileBuilder.getShowEnhancedMapTiles());
            }
        });
        options.add(showEnchancedMapTiles);
        showTriggers = new JCheckBoxMenuItem("Show Triggers");
        showTriggers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tileBuilder.setShowTriggers(!tileBuilder.getShowTriggers());
            }
        });
        options.add(showTriggers);
        showEnemies = new JCheckBoxMenuItem("Show Enemies");
        showEnemies.setSelected(true);
        showEnemies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tileBuilder.setShowEnemies(!tileBuilder.getShowEnemies());
            }
        });
        options.add(showEnemies);
        showPickups = new JCheckBoxMenuItem("Show Pickups");
        showPickups.setSelected(true);
        showPickups.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tileBuilder.setShowPickups(!tileBuilder.getShowPickups());
            }
        });
        options.add(showPickups);
        add(options);
    }
}
