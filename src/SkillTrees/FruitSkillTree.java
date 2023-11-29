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

    public static SkillTreeNode ultimateFruitSkill;

    private SkillTreeNode currentNode;

    public SkillTreeNode[] array = new SkillTreeNode[12];

    //Constructor
    public FruitSkillTree() {
        centerSkill = new SkillTreeNode("Fruit Basket", null, null, "+1spd",6);
        //
        leftSkill1 = new SkillTreeNode("Organge Slice", null, null, "Unlocks Dash : +1 Dash",5);
        leftSkill2 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash",4);
        //use temp for diff bullets^
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

    public void goToUltimate(){
        this.currentNode = ultimateFruitSkill;
    }
    
    public SkillTreeNode getCurrentNode(){
        return this.currentNode;
    }

    public static SkillTreeNode getUltimate(){
        return ultimateFruitSkill;
    }
    public void unlockNode(SkillTreeNode node){
        if(Player.playerXPLevel >= 1){
            Boolean unlock = false;
            if(node == centerSkill){
                if(!centerSkill.getUnlockedStatus()){
                    Player.addWalkSpeed(1f);
                    centerSkill.setUnlockedStatus(true);
                    unlock = true;
                }
                else{
                    System.out.println("Already unlocked this skill!");
                    return;
                }
            }
            if(centerSkill.getUnlockedStatus()){
                if(node == leftSkill1){
                    if(!leftSkill1.getUnlockedStatus()){
                        Player.addDash(1);
                        leftSkill1.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
                if(node == rightSkill1){
                    if(!rightSkill1.getUnlockedStatus()){
                        Player.addWalkSpeed(10f);
                        rightSkill1.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(leftSkill1.getUnlockedStatus()){
                if(node == leftSkill2){
                    if(!leftSkill2.getUnlockedStatus()){
                        Player.addDash(1);
                        leftSkill2.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(leftSkill2.getUnlockedStatus()){
                if(node == leftSkill3){
                    if(!leftSkill3.getUnlockedStatus()){
                        Player.addDash(1);
                        leftSkill3.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(leftSkill3.getUnlockedStatus()){
                if(node == leftSkill4){
                    if(!leftSkill4.getUnlockedStatus()){
                        Player.addDash(1);
                        leftSkill4.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(leftSkill4.getUnlockedStatus()){
                if(node == leftSkill5){
                    if(!leftSkill5.getUnlockedStatus()){
                        Player.addDash(1);
                        leftSkill5.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(rightSkill1.getUnlockedStatus()){
                if(node == rightSkill2){
                    if(!leftSkill2.getUnlockedStatus()){
                        Player.addWalkSpeed(1f);
                        rightSkill2.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(rightSkill2.getUnlockedStatus()){
                if(node == rightSkill3){
                    if(!rightSkill3.getUnlockedStatus()){
                        Player.addWalkSpeed(1f);
                        rightSkill3.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(rightSkill3.getUnlockedStatus()){
                if(node == rightSkill4){
                    if(!rightSkill4.getUnlockedStatus()){
                        Player.addWalkSpeed(1f);
                        rightSkill4.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(rightSkill4.getUnlockedStatus()){
                if(node == rightSkill5){
                    if(!rightSkill5.getUnlockedStatus()){
                        Player.addWalkSpeed(1f);
                        rightSkill5.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(rightSkill5.getUnlockedStatus() && leftSkill5.getUnlockedStatus()){
                if(node == ultimateFruitSkill){
                    if(!ultimateFruitSkill.getUnlockedStatus()){
                        ultimateFruitSkill.setUnlockedStatus(true);
                        Player.playerUltimates.add(ultimateFruitSkill);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(!unlock){
                System.out.println("Level is high enough, but you haven't met the previous unlock requirements");
            }
            if(unlock){
                Player.playerXPLevel -= 1;
            }
        }
        else{
            System.out.println("Level not high enough");
        }
    }
    //Dev Tool
    public void unlockAll() {
        for(SkillTreeNode node : array){
            node.setUnlockedStatus(true);
        }
    } 
}
