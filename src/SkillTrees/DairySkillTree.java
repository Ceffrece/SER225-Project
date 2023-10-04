package SkillTrees;

import Level.Player;

public class DairySkillTree {
    private SkillTreeNode root;

    private SkillTreeNode centerSkill;

    private SkillTreeNode skill1;
    private SkillTreeNode skill2;
    private SkillTreeNode skill3;
    private SkillTreeNode skill4;
    private SkillTreeNode skill5;
    private SkillTreeNode skill6;

    private SkillTreeNode ultimateDairySkill;

    public DairySkillTree(){
        centerSkill = new SkillTreeNode("Mars' Milk Jug", null, null, "+1AtkRange");
        skill1 = new SkillTreeNode("Larvan's Lactose", null, null, "+1AtkRange");
        skill2 = new SkillTreeNode("Tyr's Yogurt", null, null, "+1AtkRange");
        skill3 = new SkillTreeNode("Bia's Butter", null, null, "+1AtkRange");
        skill4 = new SkillTreeNode("Satis' Soy", null, null, "+1AtkRange");
        skill5 = new SkillTreeNode("Chiyou's Cheese", null, null, "+1AtkRange");
        skill6 = new SkillTreeNode("Perseus' Parmesean", null, null, "+1AtkRange");

        ultimateDairySkill = new SkillTreeNode("Di Quing's Dairy Gifting", skill2, null, "Instant Kill to all enemies within a radius of the player");

        TreeLinker();
    }

    private void TreeLinker(){
        this.root = centerSkill;
        root.setLeftSkill(skill1);
        root.setRightSkill(skill2);
        skill1.setLeftSkill(skill3);
        skill2.setRightSkill(skill4);
        skill3.setLeftSkill(skill5);
        skill4.setLeftSkill(skill6);

        skill5.setLeftSkill(ultimateDairySkill);
        skill6.setLeftSkill(ultimateDairySkill);
    }

    public void unlockNode(SkillTreeNode node, Player player){
        if(player.getPlayerXPLevel() == 1){ //Dummy level number for now
            if(node == centerSkill) {
                player.addAttackRange(1);
                centerSkill.setUnlockedStatus(true);
            }
            if(centerSkill.getUnlockedStatus()){
                if(node == skill1) {
                    player.addAttackRange(1);
                    skill1.setUnlockedStatus(true);
                }
            }
            if(skill1.getUnlockedStatus()){
                if(node == skill2) {
                    player.addAttackRange(1);
                    skill2.setUnlockedStatus(true);
                }
            }
            if(skill2.getUnlockedStatus()){
                if(node == skill3) {
                    player.addAttackRange(1);
                    skill3.setUnlockedStatus(true);
                }
            }
            if(skill3.getUnlockedStatus()){
                if(node == skill4) {
                    player.addAttackRange(1);
                    skill4.setUnlockedStatus(true);
                }
            }
            if(skill4.getUnlockedStatus()){
                if(node == skill5) {
                    player.addAttackRange(1);
                    skill5.setUnlockedStatus(true);
                }
            }
            if(skill5.getUnlockedStatus()){
                if(node == skill6) {
                    player.addAttackRange(1);
                    skill6.setUnlockedStatus(true);
                }
            }
            if(skill6.getUnlockedStatus()){
                if(node == ultimateDairySkill){
                    //ulock ultimate dairy skill here
                }
            }
        }
        else{
            //ERROR MESSAGE HERE
        }
    }
}
