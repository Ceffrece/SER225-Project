package SkillTrees;

import Level.Player;

public class VeggieSkillTree {
    private SkillTreeNode root;

    private SkillTreeNode centerSkill;

    private SkillTreeNode leftSkill1;
    private SkillTreeNode leftSkill2;
    private SkillTreeNode leftSkill3;
    private SkillTreeNode leftSkill4;
    private SkillTreeNode leftSkill5;
    
    private SkillTreeNode rightSkill1;
    private SkillTreeNode rightSkill2;
    private SkillTreeNode rightSkill3;

    private SkillTreeNode ultimateVeggieSkill;

    public VeggieSkillTree(){
        root = null;
        centerSkill = new SkillTreeNode("Victoria's Veggie Garden", null, null, "+10hp");

        leftSkill1 = new SkillTreeNode("Cao Lo's Cabbage Chestplate", null, null, "+1 Armor");
        leftSkill2 = new SkillTreeNode("Li Jing's Lettuce Helmet", null, null, "+1 Armor");
        leftSkill3 = new SkillTreeNode("Phobos' Pepper Pants", null, null, "+1 Armor");
        leftSkill4 = new SkillTreeNode("Bulub Chabtop's Broccoli Boots", null, null, "+1 Armor");
        leftSkill5 = new SkillTreeNode("Godly Green Bean Gloves", null, null, "+1 Armor");

        rightSkill1 = new SkillTreeNode("Makhai Mushrooms", null, null, "+10hp");
        rightSkill2 = new SkillTreeNode("Zeus' Zucchini", null, null, "+10hp");
        rightSkill3 = new SkillTreeNode("Pallas' Potatoes", null, null, "+10hp");

        ultimateVeggieSkill = new SkillTreeNode("Olympian Ambrosia", null, null, "Immortality for 10 secs");

        TreeLinker();
    }

    private void TreeLinker(){
        this.root = centerSkill;

        root.setLeftSkill(leftSkill1);
        root.setRightSkill(rightSkill1);

        leftSkill1.setLeftSkill(leftSkill2);
        leftSkill2.setLeftSkill(leftSkill3);
        leftSkill3.setLeftSkill(leftSkill4);
        leftSkill4.setLeftSkill(leftSkill5);

        rightSkill1.setRightSkill(rightSkill2);
        rightSkill2.setRightSkill(rightSkill3);

        rightSkill3.setRightSkill(ultimateVeggieSkill);
        leftSkill5.setLeftSkill(ultimateVeggieSkill);
    }

    public void unlockNode(SkillTreeNode node, Player player){
        if(player.getPlayerXPLevel() == 1){
            if(node == centerSkill){
                player.addPlayerHealth(10);
                centerSkill.setUnlockedStatus(true);
            }
            if(centerSkill.getUnlockedStatus()){
                if(node == leftSkill1){
                    player.addPlayerArmor(1);
                    leftSkill1.setUnlockedStatus(true);
                }
                if(node == rightSkill1){
                    player.addPlayerHealth(10);
                    rightSkill1.setUnlockedStatus(true);
                }
            }
            if(leftSkill1.getUnlockedStatus()){
                if(node == leftSkill2){
                    player.addPlayerArmor(1);
                    leftSkill2.setUnlockedStatus(true);
                }
            }
            if(leftSkill2.getUnlockedStatus()){
                if(node == leftSkill3){
                    player.addPlayerArmor(1);
                    leftSkill3.setUnlockedStatus(true);
                }
            }
            if(leftSkill3.getUnlockedStatus()){
                if(node == leftSkill4){
                    player.addPlayerArmor(1);
                    leftSkill4.setUnlockedStatus(true);
                }
            }
            if(leftSkill4.getUnlockedStatus()){
                if(node == leftSkill5){
                    player.addPlayerArmor(1);
                    leftSkill5.setUnlockedStatus(true);
                }
            }
            if(rightSkill1.getUnlockedStatus()){
                if(node == rightSkill2){
                    player.addPlayerHealth(10);
                    rightSkill2.setUnlockedStatus(true);
                }
            }
            if(rightSkill2.getUnlockedStatus()){
                if(node == rightSkill3){
                    player.addPlayerHealth(10);
                    rightSkill3.setUnlockedStatus(true);
                }
            }
            if(rightSkill3.getUnlockedStatus() && leftSkill5.getUnlockedStatus()){
                if(node == ultimateVeggieSkill){
                    //unlock ultimate skill
                }
            }
        }
        else{
            //print error message
        }
    }
}
