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

    public static SkillTreeNode ultimateDairySkill;

    public SkillTreeNode currentNode;
    public SkillTreeNode[] array1 = new SkillTreeNode[8];

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

    public static SkillTreeNode getUltimate(){
        return ultimateDairySkill;
    }

    public void unlockNode(SkillTreeNode node){
        if(Player.playerXPLevel >= 1){ //Dummy level number for now
            boolean unlock = false;
            if(node == centerSkill) {
                if(!centerSkill.getUnlockedStatus()){
                    Player.addAttackRange(1);
                    centerSkill.setUnlockedStatus(true);
                    unlock = true;
                }
                else{
                    System.out.println("Already unlocked this skill!");
                    return;
                }
            }
            if(centerSkill.getUnlockedStatus()){
                if(node == skill1) {
                    if(!skill1.getUnlockedStatus()){
                        Player.addAttackRange(1);
                        skill1.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(skill1.getUnlockedStatus()){
                if(node == skill2) {
                    if(!skill2.getUnlockedStatus()){
                        Player.addAttackRange(1);
                        skill2.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(skill2.getUnlockedStatus()){
                if(node == skill3) {
                    if(!skill3.getUnlockedStatus()){
                        Player.addAttackRange(1);
                        skill3.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(skill3.getUnlockedStatus()){
                if(node == skill4) {
                    if(!skill4.getUnlockedStatus()){
                        Player.addAttackRange(1);
                        skill4.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(skill4.getUnlockedStatus()){
                if(node == skill5) {
                    if(!skill5.getUnlockedStatus()){
                        Player.addAttackRange(1);
                        skill5.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(skill5.getUnlockedStatus()){
                if(node == skill6) {
                    if(!skill6.getUnlockedStatus()){
                        Player.addAttackRange(1);
                        skill6.setUnlockedStatus(true);
                        unlock = true;
                    }
                    else{
                        System.out.println("Already unlocked this skill!");
                        return;
                    }
                }
            }
            if(skill6.getUnlockedStatus()){
                if(node == ultimateDairySkill){
                    if(!ultimateDairySkill.getUnlockedStatus()){
                        ultimateDairySkill.setUnlockedStatus(true);
                        Player.playerUltimates.add(ultimateDairySkill);
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
}
