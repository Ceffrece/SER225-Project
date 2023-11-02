package SkillTrees;

import Level.Player;

public class DairySkillTree {
    SkillTree dairy = new SkillTree();

    private SkillTreeNode centerSkill;

    private SkillTreeNode skill1;
    private SkillTreeNode skill2;
    private SkillTreeNode skill3;
    private SkillTreeNode skill4;
    private SkillTreeNode skill5;
    private SkillTreeNode skill6;

    private SkillTreeNode ultimateDairySkill;

    public SkillTreeNode currentNode;
    public static SkillTreeNode[] array1 = new SkillTreeNode[8];

    public DairySkillTree(){
        centerSkill = new SkillTreeNode("Mars' Milk Jug", null, null, "+1AtkRange",1);
        skill1 = new SkillTreeNode("Laran's Lactose", null, null, "+1AtkRange",2);
        skill2 = new SkillTreeNode("Tyr's Yogurt", null, null, "+1AtkRange",3);
        skill3 = new SkillTreeNode("Bia's Butter", null, null, "+1AtkRange",4);
        skill4 = new SkillTreeNode("Satis' Soy", null, null, "+1AtkRange",5);
        skill5 = new SkillTreeNode("Chiyou's Cheese", null, null, "+1AtkRange",6);
        skill6 = new SkillTreeNode("Perseus' Parmesean", null, null, "+1AtkRange",7);

        ultimateDairySkill = new SkillTreeNode("Di Quing's Dairy Gifting", skill2, null, "Instant Kill to all enemies within a radius of the player",8);

        array1[0] = centerSkill;
        array1[1] = skill1;
        array1[2] = skill2;
        array1[3] = skill3;
        array1[4] = skill4;
        array1[5] = skill5;
        array1[6] = skill6;
        array1[7] = ultimateDairySkill;

        dairy.insertInTree(centerSkill);
        dairy.insertInTree(skill1);
        dairy.insertInTree(skill2);
        dairy.insertInTree(skill3);
        dairy.insertInTree(skill4);
        dairy.insertInTree(skill5);
        dairy.insertInTree(skill6);
        dairy.insertInTree(ultimateDairySkill);
        currentNode = centerSkill;
    }

    public void resetCurrentNode(){
        this.currentNode = centerSkill;
    }
    public SkillTreeNode getCurrentNode(){
        return this.currentNode;
    }

    public void unlockNode(SkillTreeNode node){
        if(Player.playerXPLevel >= 1){ //Dummy level number for now
            boolean unlock = false;
            if(node == centerSkill) {
                Player.addAttackRange(1);
                centerSkill.setUnlockedStatus(true);
                unlock = true;
            }
            if(centerSkill.getUnlockedStatus()){
                if(node == skill1) {
                    Player.addAttackRange(1);
                    skill1.setUnlockedStatus(true);
                    unlock = true;
                }
            }
            if(skill1.getUnlockedStatus()){
                if(node == skill2) {
                    Player.addAttackRange(1);
                    skill2.setUnlockedStatus(true);
                    unlock = true;
                }
            }
            if(skill2.getUnlockedStatus()){
                if(node == skill3) {
                    Player.addAttackRange(1);
                    skill3.setUnlockedStatus(true);
                    unlock = true;
                }
            }
            if(skill3.getUnlockedStatus()){
                if(node == skill4) {
                    Player.addAttackRange(1);
                    skill4.setUnlockedStatus(true);
                    unlock = true;
                }
            }
            if(skill4.getUnlockedStatus()){
                if(node == skill5) {
                    Player.addAttackRange(1);
                    skill5.setUnlockedStatus(true);
                    unlock = true;
                }
            }
            if(skill5.getUnlockedStatus()){
                if(node == skill6) {
                    Player.addAttackRange(1);
                    skill6.setUnlockedStatus(true);
                    unlock = true;
                }
            }
            if(skill6.getUnlockedStatus()){
                if(node == ultimateDairySkill){
                    ultimateDairySkill.setUnlockedStatus(true);
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
