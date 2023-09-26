package SkillTrees;

public class ProteinSkillTree {
    
    private SkillTreeNode root;
    private SkillTreeNode centerSkill;

    private SkillTreeNode leftSkill1;
    private SkillTreeNode leftSkill2;
    private SkillTreeNode leftSkill3;

    private SkillTreeNode rightSkill1;
    private SkillTreeNode rightSkill2;
    private SkillTreeNode rightSkill3;

    private SkillTreeNode ultimateProteinSkill;

    public ProteinSkillTree(){
        root = null;
        centerSkill = new SkillTreeNode("Pantheon of Protein", null, null, "+1AtkDmg +1% Crit Chance");

        leftSkill1 = new SkillTreeNode("Ares' A5 Meat", null , null, "+2% Crit Chance");
        leftSkill2 = new SkillTreeNode("Bellona's Beef", null, null, "+2% Crit Chance");
        leftSkill3 = new SkillTreeNode("Set's Steak", null, null, "+2% Crit Chance");
        
        rightSkill1 = new SkillTreeNode("Sobek's Salmon", null, null, "+1AtkDmg");
        rightSkill2 = new SkillTreeNode("Bast's Beans", null, null, "+1AtkDmg");
        rightSkill3 = new SkillTreeNode("Odin's Oeufs", null, null, "+1AtkDmg");

        ultimateProteinSkill = new SkillTreeNode("Thor's Tendies", null, null, "One-hit enemies for 7 secs");

        TreeLinker();
    }

    private void TreeLinker(){
        this.root = centerSkill;
        root.setLeftSkill(leftSkill1);
        root.setRightSkill(rightSkill1);

        leftSkill1.setLeftSkill(leftSkill2);
        leftSkill2.setLeftSkill(leftSkill3);

        rightSkill1.setRightSkill(rightSkill2);
        rightSkill2.setRightSkill(rightSkill3);

        rightSkill3.setRightSkill(ultimateProteinSkill);
        leftSkill3.setLeftSkill(ultimateProteinSkill);
    }
}
