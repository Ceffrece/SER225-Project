package SkillTrees;

import Level.Player;

public class FruitSkillTree {
    
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
    private SkillTreeNode rightSkill4;
    private SkillTreeNode rightSkill5;
    private SkillTreeNode ultimateFruitSkill;



    //Constructor
    public FruitSkillTree() {
        root = null;
        centerSkill = new SkillTreeNode("Fruit Basket", null, null, "+1spd");

        leftSkill1 = new SkillTreeNode("Organge Slice", null, null, "Unlocks Dash : +1 Dash");
        leftSkill2 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash");
        leftSkill3 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash");
        leftSkill4 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash");
        leftSkill5 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash");

        rightSkill1 = new SkillTreeNode("The Horn of Plenty", null, null, "+1spd");
        rightSkill2 = new SkillTreeNode("Momotaro's Peach", null, null, "+1spd");
        rightSkill3 = new SkillTreeNode("Maui's Coconut", null, null, "+1spd");
        rightSkill4 = new SkillTreeNode("Ulu's Breadfruit", null, null, "+1spd");
        rightSkill5 = new SkillTreeNode("Pomegranate of the Underworld", null, null, "+1spd");

        ultimateFruitSkill = new SkillTreeNode("Idunn Apple", null, null, "+20spd for 5 secs");

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
        rightSkill3.setRightSkill(rightSkill4);
        rightSkill4.setRightSkill(rightSkill5);
        
        leftSkill5.setLeftSkill(ultimateFruitSkill);
        rightSkill5.setRightSkill(ultimateFruitSkill);
    }

    public void unlockNode(SkillTreeNode node, Player player){
        if(player.getPlayerXPLevel() == 1){
            if(node == centerSkill){
                player.addWalkSpeed(1f);
                centerSkill.setUnlockedStatus(true);
            }
            if(centerSkill.getUnlockedStatus()){
                if(node == leftSkill1){
                    player.addDash(1);
                    leftSkill1.setUnlockedStatus(true);
                }
                if(node == rightSkill1){
                    player.addDash(1);
                    rightSkill1.setUnlockedStatus(true);
                }
            }
            if(leftSkill1.getUnlockedStatus()){
                if(node == leftSkill2){
                    player.addDash(1);
                    leftSkill2.setUnlockedStatus(true);
                }
            }
            if(leftSkill2.getUnlockedStatus()){
                if(node == leftSkill3){
                    player.addDash(1);
                    leftSkill3.setUnlockedStatus(true);
                }
            }
            if(leftSkill3.getUnlockedStatus()){
                if(node == leftSkill4){
                    player.addDash(1);
                    leftSkill4.setUnlockedStatus(true);
                }
            }
            if(leftSkill4.getUnlockedStatus()){
                if(node == leftSkill5){
                    player.addDash(1);
                    leftSkill5.setUnlockedStatus(true);
                }
            }
            if(rightSkill1.getUnlockedStatus()){
                if(node == rightSkill2){
                    player.addWalkSpeed(1f);
                    rightSkill2.setUnlockedStatus(true);
                }
            }
            if(rightSkill2.getUnlockedStatus()){
                if(node == rightSkill3){
                    player.addWalkSpeed(1f);
                    rightSkill3.setUnlockedStatus(true);
                }
            }
            if(rightSkill3.getUnlockedStatus()){
                if(node == rightSkill4){
                    player.addWalkSpeed(1f);
                    rightSkill4.setUnlockedStatus(true);
                }
            }
            if(rightSkill4.getUnlockedStatus()){
                if(node == rightSkill5){
                    player.addWalkSpeed(1f);
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
            //print out error
        }
    } 
}
