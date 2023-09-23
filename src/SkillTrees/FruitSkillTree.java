package SkillTrees;

public class FruitSkillTree {
    
    private SkillTreeNode root;
    private SkillTreeNode centerSkill;
    private SkillTreeNode leftSkill1;
    private SkillTreeNode leftSkill2;
    private SkillTreeNode leftSkill3;
    private SkillTreeNode leftSkill4;
    private SkillTreeNode leftSkill5;
    private SkillTreeNode rightSkill1;
    private SkillTreeNode rightSkill2;
    private SkillTreeNode rightSkill3;
    private SkillTreeNode rightSkill4;
    private SkillTreeNode rightSkill5;
    private SkillTreeNode ultimateFruitSkill;



    //Constructor
    public FruitSkillTree() {
        root = null;
        centerSkill = new SkillTreeNode("Fruit Basket", null, null, "+1spd");

        leftSkill1 = new SkillTreeNode("Organge Slice", null, null, "Unlocks Dash : +1 Dash");
        leftSkill2 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash");
        leftSkill3 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash");
        leftSkill4 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash");
        leftSkill5 = new SkillTreeNode("Orange Slice", null, null, "+1 Dash");

        rightSkill1 = new SkillTreeNode("The Horn of Plenty", null, null, "+1spd");
        rightSkill2 = new SkillTreeNode("Momotaro's Peach", null, null, "+1spd");
        rightSkill3 = new SkillTreeNode("Maui's Coconut", null, null, "+1spd");
        rightSkill4 = new SkillTreeNode("Ulu's Breadfruit", null, null, "+1spd");
        rightSkill5 = new SkillTreeNode("Pomegranate of the Underworld", null, null, "+1spd");

        ultimateFruitSkill = new SkillTreeNode("Idunn Apple", null, null, "+20spd for 5 secs");

        TreeLinker();

    }

    private void TreeLinker(){
        this.root = centerSkill;
        root.setLeftSkill(leftSkill1);
        root.setRightSkill(rightSkill1);
        leftSkill1.setLeftSkill(leftSkill2);
        leftSkill2.setLeftSkill(leftSkill3);
        leftSkill3.setLeftSkill(leftSkill4);
        leftSkill4.setLeftSkill(leftSkill5);
        
        rightSkill1.setRightSkill(rightSkill2);
        rightSkill2.setRightSkill(rightSkill3);
        rightSkill3.setRightSkill(rightSkill4);
        rightSkill4.setRightSkill(rightSkill5);
        
        leftSkill5.setLeftSkill(ultimateFruitSkill);
        rightSkill5.setRightSkill(ultimateFruitSkill);
    }

    
}
