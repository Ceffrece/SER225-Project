package SkillTrees;

public class SkillTree {
    SkillTreeNode root;

    public SkillTree(){
        root = null;
    }

    public void insertInTree(SkillTreeNode node){
        if(isEmpty()){
            this.root = node;
        }
        else{
            insert(root,node);
        }
    }

    private void insert(SkillTreeNode node, SkillTreeNode newNode){
        if(newNode.getId() < node.getId()){
            if(node.getLeftSkill() == null){
                node.setLeftSkill(newNode);
                newNode.setParent(node);
            }
            else{
                insert(node.getLeftSkill(), newNode);
            }
        }
        else{
            if(node.getRightSkill() == null){
                node.setRightSkill(newNode);
                newNode.setParent(node);
            }
            else{
                insert(node.getRightSkill(),newNode);
            }
        }
    }

    public boolean isEmpty(){
        return this.root==null;
    }
}
