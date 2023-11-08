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
        centerSkill = new SkillTreeNode("Victoria's Veggie Garden", null, null, "+1hp",6);

        leftSkill1 = new SkillTreeNode("Cao Lo's Cabbage Chestplate", null, null, "+1 Armor",5);
        leftSkill2 = new SkillTreeNode("Li Jing's Lettuce Helmet", null, null, "+1 Armor",4);
        leftSkill3 = new SkillTreeNode("Phobos' Pepper Pants", null, null, "+1 Armor",3);
        leftSkill4 = new SkillTreeNode("Bulub Chabtop's Broccoli Boots", null, null, "+1 Armor",2);
        leftSkill5 = new SkillTreeNode("Godly Green Bean Gloves", null, null, "+1 Armor",1);

        rightSkill1 = new SkillTreeNode("Makhai Mushrooms", null, null, "+1hp",7);
        rightSkill2 = new SkillTreeNode("Zeus' Zucchini", null, null, "+1hp",8);
        rightSkill3 = new SkillTreeNode("Pallas' Potatoes", null, null, "+1hp",9);

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

    public void resetCurrentNode(){
        this.currentNode = centerSkill;
    }
    public SkillTreeNode getCurrentNode(){
        return this.currentNode;
    }


    public void unlockNode(SkillTreeNode node){
        if(Player.playerXPLevel >= 1){
            Boolean unlock = false;
            if(node == centerSkill){
                if(!centerSkill.getUnlockedStatus()){
                    Player.addPlayerMaxHealth(1);
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
                        Player.addPlayerArmor(1);
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
                        Player.addPlayerMaxHealth(1);
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
                        Player.addPlayerArmor(1);
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
                        Player.addPlayerArmor(1);
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
                        Player.addPlayerArmor(1);
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
                        Player.addPlayerArmor(1);
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
                    if(!rightSkill2.getUnlockedStatus()){
                        Player.addPlayerMaxHealth(1);
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
                        Player.addPlayerMaxHealth(1);
                        rightSkill3.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(rightSkill3.getUnlockedStatus() && leftSkill5.getUnlockedStatus()){
                if(node == ultimateVeggieSkill){
                    if(!ultimateVeggieSkill.getUnlockedStatus()){
                        ultimateVeggieSkill.setUnlockedStatus(true);
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
                Player.playerXPLevel-= 1;
            }
        }
        else{
            System.out.println("Level not high enough");
        }
    }
}
