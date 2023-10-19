package SkillTrees;

import Level.Player;

public class ProteinSkillTree {
    
    SkillTree protein = new SkillTree();

    private SkillTreeNode centerSkill;

    private SkillTreeNode leftSkill1;
    private SkillTreeNode leftSkill2;
    private SkillTreeNode leftSkill3;

    private SkillTreeNode rightSkill1;
    private SkillTreeNode rightSkill2;
    private SkillTreeNode rightSkill3;

    private SkillTreeNode ultimateProteinSkill;

    public static SkillTreeNode[] array = new SkillTreeNode[8];

    private SkillTreeNode currentNode;

    public ProteinSkillTree(){
        centerSkill = new SkillTreeNode("Pantheon of Protein", null, null, "+1AtkDmg +1% Crit Chance",4);

        leftSkill1 = new SkillTreeNode("Ares' A5 Meat", null , null, "+2% Crit Chance",3);
        leftSkill2 = new SkillTreeNode("Bellona's Beef", null, null, "+2% Crit Chance",2);
        leftSkill3 = new SkillTreeNode("Set's Steak", null, null, "+2% Crit Chance",1);
        
        rightSkill1 = new SkillTreeNode("Sobek's Salmon", null, null, "+1AtkDmg",5);
        rightSkill2 = new SkillTreeNode("Bast's Beans", null, null, "+1AtkDmg",6);
        rightSkill3 = new SkillTreeNode("Odin's Oeufs", null, null, "+1AtkDmg",7);

        ultimateProteinSkill = new SkillTreeNode("Thor's Tendies", null, null, "One-hit enemies for 7 secs",8);

        array[0] = centerSkill;
        array[1] = leftSkill1;
        array[2] = leftSkill2;
        array[3] = leftSkill3;
        array[4] = rightSkill1;
        array[5] = rightSkill2;
        array[6] = rightSkill3;
        array[7] = ultimateProteinSkill;

        protein.insertInTree(centerSkill);
        protein.insertInTree(leftSkill1);
        protein.insertInTree(leftSkill2);
        protein.insertInTree(leftSkill3);
        protein.insertInTree(rightSkill1);
        protein.insertInTree(rightSkill2);
        protein.insertInTree(rightSkill3);
        protein.insertInTree(ultimateProteinSkill);

        currentNode = centerSkill;
    }

    public void resetCurrentNode(){
        this.currentNode = centerSkill;
    }
    public SkillTreeNode getCurrentNode(){
        return this.currentNode;
    }

    public void unlockNode(SkillTreeNode node){
        if(Player.playerXPLevel == 1){
            if(node == centerSkill){
                Player.addAttackDamage(1);
                Player.addCritChance(1);
                centerSkill.setUnlockedStatus(true);
            }
            if(centerSkill.getUnlockedStatus()){
                if(node == leftSkill1){
                    Player.addCritChance(2);
                    leftSkill1.setUnlockedStatus(true);
                }
                if(node == rightSkill1){
                    Player.addAttackDamage(1);
                    rightSkill1.setUnlockedStatus(true);
                }
            }
            if(leftSkill1.getUnlockedStatus()){
                if(node == leftSkill2){
                    Player.addCritChance(2);
                    leftSkill2.setUnlockedStatus(true);
                }
            }
            if(leftSkill2.getUnlockedStatus()){
                if(node == leftSkill3){
                    Player.addCritChance(2);
                    leftSkill3.setUnlockedStatus(true);
                }
            }
            if(rightSkill1.getUnlockedStatus()){
                if(node == rightSkill2){
                    Player.addAttackDamage(1);;
                    rightSkill2.setUnlockedStatus(true);
                }
            }
            if(rightSkill2.getUnlockedStatus()){
                if(node == rightSkill3){
                    Player.addAttackDamage(1);
                    rightSkill3.setUnlockedStatus(true);
                }
            }
            if(rightSkill3.getUnlockedStatus() && leftSkill3.getUnlockedStatus()){
                if(node == ultimateProteinSkill){
                    ultimateProteinSkill.setUnlockedStatus(true);
                }
            }
            else{
                System.out.println("Level is high enough, but you haven't met the previous unlock requirements");
            }
        }
        else{
            System.out.println("Level not high enough");
        }
    }

}
