package SkillTrees;

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
}
