package SkillTrees;

public class SkillTreeNode {
    private String name;
    private SkillTreeNode rightSkill;
    private SkillTreeNode leftSkill;
    private SkillTreeNode parent;
    private String effect;
    private boolean isUnlocked;
    private int id;

    //constructor
    public SkillTreeNode() {
        this.name = null;
        this.rightSkill = null;
        this.leftSkill = null;
        this.effect = null;
        this.isUnlocked = false;
        this.id = 0;
        this.parent = null;
    }
    public SkillTreeNode(String name, SkillTreeNode rightSkill, SkillTreeNode leftSkill, String effect, int id){
        this.name = name;
        this.rightSkill = rightSkill;
        this.leftSkill = leftSkill;
        this.effect = effect;
        this.isUnlocked = false;
        this.id = id;
        this.parent = null;
    }

    //Getters and Setters
    public String getName(){
        return this.name;
    }

    public SkillTreeNode getRightSkill(){
        return this.rightSkill;
    }

    public void setRightSkill(SkillTreeNode right){
        this.rightSkill = right;
    }

    public SkillTreeNode getLeftSkill(){
        return this.leftSkill;
    }

    public void setLeftSkill(SkillTreeNode left){
        this.leftSkill = left;
    }

    public String getEffect(){
        return this.effect;
    }

    public boolean getUnlockedStatus(){
        return this.isUnlocked;
    }

    public void setUnlockedStatus(Boolean status){
        this.isUnlocked = status;
    }
    
    public int getId(){
        return this.id;
    }

    public void setParent(SkillTreeNode parent){
        this.parent = parent;
    }
    public SkillTreeNode getParent(){
        return this.parent;
    }
}
