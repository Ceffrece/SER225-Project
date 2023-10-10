package SkillTrees;

import Level.Player;

public class VeggieSkillTree {

    SkillTree veggie = new SkillTree();

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

    public static SkillTreeNode[] array = new SkillTreeNode[10];

    private SkillTreeNode currentNode;

    public VeggieSkillTree(){
        centerSkill = new SkillTreeNode("Victoria's Veggie Garden", null, null, "+10hp",6);

        leftSkill1 = new SkillTreeNode("Cao Lo's Cabbage Chestplate", null, null, "+1 Armor",5);
        leftSkill2 = new SkillTreeNode("Li Jing's Lettuce Helmet", null, null, "+1 Armor",4);
        leftSkill3 = new SkillTreeNode("Phobos' Pepper Pants", null, null, "+1 Armor",3);
        leftSkill4 = new SkillTreeNode("Bulub Chabtop's Broccoli Boots", null, null, "+1 Armor",2);
        leftSkill5 = new SkillTreeNode("Godly Green Bean Gloves", null, null, "+1 Armor",1);

        rightSkill1 = new SkillTreeNode("Makhai Mushrooms", null, null, "+10hp",7);
        rightSkill2 = new SkillTreeNode("Zeus' Zucchini", null, null, "+10hp",8);
        rightSkill3 = new SkillTreeNode("Pallas' Potatoes", null, null, "+10hp",9);

        ultimateVeggieSkill = new SkillTreeNode("Olympian Ambrosia", null, null, "Immortality for 10 secs",10);

        array[0] = centerSkill;
        array[1] = leftSkill1;
        array[2] = leftSkill2;
        array[3] = leftSkill3;
        array[4] = leftSkill4;
        array[5] = leftSkill5;
        array[6] = rightSkill1;
        array[7] = rightSkill2;
        array[8] = rightSkill3;
        array[9] = ultimateVeggieSkill;

        veggie.insertInTree(centerSkill);
        veggie.insertInTree(leftSkill1);
        veggie.insertInTree(leftSkill2);
        veggie.insertInTree(leftSkill3);
        veggie.insertInTree(leftSkill4);
        veggie.insertInTree(leftSkill5);
        veggie.insertInTree(rightSkill1);
        veggie.insertInTree(rightSkill2);
        veggie.insertInTree(rightSkill3);
        veggie.insertInTree(ultimateVeggieSkill);

        currentNode = centerSkill;
    }

    public void setCurrentNode(SkillTreeNode node){
        this.currentNode = node;
    }
    public SkillTreeNode getCurrentNode(){
        return this.currentNode;
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
                    player.addPlayerMaxHealth(1);
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
                    player.addPlayerMaxHealth(1);
                    rightSkill2.setUnlockedStatus(true);
                }
            }
            if(rightSkill2.getUnlockedStatus()){
                if(node == rightSkill3){
                    player.addPlayerMaxHealth(1);
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
