package SkillTrees;

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
}
