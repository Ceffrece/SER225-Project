package SkillTrees;

import Level.Player;

public class FruitSkillTree {
    SkillTree fruit = new SkillTree();

    private SkillTreeNode centerSkill;

    private SkillTreeNode leftSkill1;
    private SkillTreeNode leftSkill2;
    private SkillTreeNode leftSkill3;
    private SkillTreeNode leftSkill4;
    private SkillTreeNode leftSkill5;

    private SkillTreeNode rightSkill1;
    private SkillTreeNode rightSkill2;
    private SkillTreeNode rightSkill3;
    private SkillTreeNode rightSkill4;
    private SkillTreeNode rightSkill5;

    private SkillTreeNode ultimateFruitSkill;

    private SkillTreeNode currentNode;

    public SkillTreeNode[] array = new SkillTreeNode[12];

    //Constructor
    public FruitSkillTree() {
        centerSkill = new SkillTreeNode("Fruit Basket", null, null, "+1spd",6);

        leftSkill1 = new SkillTreeNode("Organge Slice", null, null, "Unlocks Dash : +1 Dash",5);
        leftSkill2 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash",4);
        leftSkill3 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash",3);
        leftSkill4 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash",2);
        leftSkill5 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash",1);

        rightSkill1 = new SkillTreeNode("The Horn of Plenty", null, null, "+1spd",7);
        rightSkill2 = new SkillTreeNode("Momotaro's Peach", null, null, "+1spd",8);
        rightSkill3 = new SkillTreeNode("Maui's Coconut", null, null, "+1spd",9);
        rightSkill4 = new SkillTreeNode("Ulu's Breadfruit", null, null, "+1spd",10);
        rightSkill5 = new SkillTreeNode("Pomegranate of the Underworld", null, null, "+1spd",11);

        ultimateFruitSkill = new SkillTreeNode("Idunn Apple", null, null, "+20spd for 5 secs",12);

        array[0] = centerSkill;
        array[1] = leftSkill1;
        array[2] = leftSkill2;
        array[3] = leftSkill3;
        array[4] = leftSkill4;
        array[5] = leftSkill5;
        array[6] = rightSkill1;
        array[7] = rightSkill2;
        array[8] = rightSkill3;
        array[9] = rightSkill4;
        array[10] = rightSkill5;
        array[11] = ultimateFruitSkill;

        fruit.insertInTree(centerSkill);
        fruit.insertInTree(leftSkill1);
        fruit.insertInTree(leftSkill2);
        fruit.insertInTree(leftSkill3);
        fruit.insertInTree(leftSkill4);
        fruit.insertInTree(leftSkill5);
        fruit.insertInTree(rightSkill1);
        fruit.insertInTree(rightSkill2);
        fruit.insertInTree(rightSkill3);
        fruit.insertInTree(rightSkill4);
        fruit.insertInTree(rightSkill5);
        fruit.insertInTree(ultimateFruitSkill);
        currentNode = centerSkill;
    }

    public void resetCurrentNode(){
        this.currentNode = centerSkill;
    }
    public SkillTreeNode getCurrentNode(){
        return this.currentNode;
    }

    public void unlockNode(SkillTreeNode node){
        System.out.println("unlocking");
        if(Player.playerXPLevel >= 1){
            if(node == centerSkill){
                Player.addWalkSpeed(10f);
                centerSkill.setUnlockedStatus(true);
            }
            if(centerSkill.getUnlockedStatus()){
                if(node == leftSkill1){
                    Player.addDash(1);
                    leftSkill1.setUnlockedStatus(true);
                }
                if(node == rightSkill1){
                    Player.addDash(1);
                    rightSkill1.setUnlockedStatus(true);
                }
            }
            if(leftSkill1.getUnlockedStatus()){
                if(node == leftSkill2){
                    Player.addDash(1);
                    leftSkill2.setUnlockedStatus(true);
                }
            }
            if(leftSkill2.getUnlockedStatus()){
                if(node == leftSkill3){
                    Player.addDash(1);
                    leftSkill3.setUnlockedStatus(true);
                }
            }
            if(leftSkill3.getUnlockedStatus()){
                if(node == leftSkill4){
                    Player.addDash(1);
                    leftSkill4.setUnlockedStatus(true);
                }
            }
            if(leftSkill4.getUnlockedStatus()){
                if(node == leftSkill5){
                    Player.addDash(1);
                    leftSkill5.setUnlockedStatus(true);
                }
            }
            if(rightSkill1.getUnlockedStatus()){
                if(node == rightSkill2){
                    Player.addWalkSpeed(10f);
                    rightSkill2.setUnlockedStatus(true);
                }
            }
            if(rightSkill2.getUnlockedStatus()){
                if(node == rightSkill3){
                    Player.addWalkSpeed(10f);
                    rightSkill3.setUnlockedStatus(true);
                }
            }
            if(rightSkill3.getUnlockedStatus()){
                if(node == rightSkill4){
                    Player.addWalkSpeed(10f);
                    rightSkill4.setUnlockedStatus(true);
                }
            }
            if(rightSkill4.getUnlockedStatus()){
                if(node == rightSkill5){
                    Player.addWalkSpeed(10f);
                    rightSkill5.setUnlockedStatus(true);
                }
            }
            if(rightSkill5.getUnlockedStatus() && leftSkill5.getUnlockedStatus()){
                if(node == ultimateFruitSkill){
                    //unlock fruit skill here
                }
            }
        }
        else{
            System.out.println("Level not high enough");
        }
    } 
}
