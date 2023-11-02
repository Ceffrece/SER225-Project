package SkillTrees;

import Level.Player;

public class GrainSkillTree {

    SkillTree grain = new SkillTree();
   
    private SkillTreeNode centerSkill;

    private SkillTreeNode skill1;
    private SkillTreeNode skill2;
    private SkillTreeNode skill3;
    private SkillTreeNode skill4;

    private SkillTreeNode ultimateGrainSkill;

    private SkillTreeNode currentNode;

    public static SkillTreeNode[] array = new SkillTreeNode[6];

    public GrainSkillTree() {
        centerSkill = new SkillTreeNode("Flour", null, null, "+1AtkSpeed",1);
        skill1 = new SkillTreeNode("Ceres' Grain", null, null, "+1AtkSpeed",2);
        skill2 = new SkillTreeNode("Radegast's Rice", null, null, "+1AtkSpeed",3);
        skill3 = new SkillTreeNode("Freyr's Flax", null, null, "+1AtkSpeed",4);
        skill4 = new SkillTreeNode("Demeter's Wheat", null, null, "+1AtkSpeed",5);
        ultimateGrainSkill = new SkillTreeNode("Gaea's Blessing", null, null, "Go Stupid for 5 secs",6);

        array[0] = centerSkill;
        array[1] = skill1;
        array[2] = skill2;
        array[3] = skill3;
        array[4] = skill4;
        array[5] = ultimateGrainSkill;

        grain.insertInTree(centerSkill);
        grain.insertInTree(skill1);
        grain.insertInTree(skill2);
        grain.insertInTree(skill3);
        grain.insertInTree(skill4);
        grain.insertInTree(ultimateGrainSkill);

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
                Player.addAttackSpeed(1);
                centerSkill.setUnlockedStatus(true);
                unlock = true;
            }
            if(centerSkill.getUnlockedStatus()){
                if(node == skill1){
                    Player.addAttackSpeed(1);
                    skill1.setUnlockedStatus(true);
                    unlock = true;
                }
            }
            if(skill1.getUnlockedStatus()){
                if(node == skill2){
                    Player.addAttackSpeed(1);
                    skill2.setUnlockedStatus(true);
                    unlock = true;
                }
            }
            if(skill2.getUnlockedStatus()){
                if(node == skill3){
                    Player.addAttackSpeed(1);
                    skill3.setUnlockedStatus(true);
                    unlock = true;
                }
            }
            if(skill3.getUnlockedStatus()){
                if(node == skill4){
                    Player.addAttackSpeed(1);
                    skill4.setUnlockedStatus(true);
                    unlock = true;
                }
            }
            if(skill4.getUnlockedStatus()){
                if(node == ultimateGrainSkill){
                    ultimateGrainSkill.setUnlockedStatus(true);
                    unlock = true;
                }
            }
            if(!unlock){
                System.out.println("Level is high enough, but you haven't met the previous unlock requirements");
            }
        }
        else{
            System.out.println("Level not high enough");
        }
    }
}
