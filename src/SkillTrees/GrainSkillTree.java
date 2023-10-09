package SkillTrees;

import Level.Player;

public class GrainSkillTree {
    
    private SkillTreeNode root;
    private SkillTreeNode centerSkill;
    private SkillTreeNode skill1;
    private SkillTreeNode skill2;
    private SkillTreeNode skill3;
    private SkillTreeNode skill4;
    private SkillTreeNode ultimateGrainSkill;

    public GrainSkillTree() {
        root = null;
        centerSkill = new SkillTreeNode("Flour", null, null, "+1AtkSpeed");
        skill1 = new SkillTreeNode("Ceres' Grain", null, null, "+1AtkSpeed");
        skill2 = new SkillTreeNode("Radegast's Rice", null, null, "+1AtkSpeed");
        skill3 = new SkillTreeNode("Freyr's Flax", null, null, "+1AtkSpeed");
        skill4 = new SkillTreeNode("Demeter's Wheat", null, null, "+1AtkSpeed");
        ultimateGrainSkill = new SkillTreeNode("Gaea's Blessing", null, null, "Go Stupid for 5 secs");

        TreeLinker();
    }

    private void TreeLinker(){
        this.root = centerSkill;
        root.setLeftSkill(skill1);
        root.setRightSkill(skill2);
        skill1.setLeftSkill(skill3);
        skill2.setRightSkill(skill4);
        skill3.setLeftSkill(ultimateGrainSkill);
        skill4.setRightSkill(ultimateGrainSkill);
    }

    public void unlockNode(SkillTreeNode node, Player player){
        if(player.getPlayerXPLevel() == 1){
            if(node == centerSkill){
                player.addAttackSpeed(1);
                centerSkill.setUnlockedStatus(true);
            }
            if(centerSkill.getUnlockedStatus()){
                if(node == skill1){
                    player.addAttackSpeed(1);
                    skill1.setUnlockedStatus(true);
                }
            }
            if(skill1.getUnlockedStatus()){
                if(node == skill2){
                    player.addAttackSpeed(1);
                    skill2.setUnlockedStatus(true);
                }
            }
            if(skill2.getUnlockedStatus()){
                if(node == skill3){
                    player.addAttackSpeed(1);
                    skill3.setUnlockedStatus(true);
                }
            }
            if(skill3.getUnlockedStatus()){
                if(node == skill4){
                    player.addAttackSpeed(1);
                    skill4.setUnlockedStatus(true);
                }
            }
            if(skill4.getUnlockedStatus()){
                if(node == ultimateGrainSkill){
                    //unlock ultimate
                }
            }
        }
        else{
            //print out error
        }
    }
}
