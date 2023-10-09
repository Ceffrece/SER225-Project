package GameObject;

import java.awt.Image;

public class Item {
    protected String name;
    protected int damage;
    protected int fireRate;
    protected Image picture;

    public Item() {
        name = "";
        damage = 0;
        fireRate = 0;
        picture = null;
    }
    public Item(String name, int damage, int fireRate, Image picture){
        this.name = name;
        this.damage = damage;
        this.fireRate = fireRate;
        this.picture = picture;
    }

    //Setters and Getters
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getDamage(){
        return this.damage;
    }

    public void setFireRate(int rate){
        this.fireRate = rate;
    }
    public int getFireRate(){
        return this.fireRate;
    }

    public void setPicture(Image picture){
        this.picture = picture;
    }
    public Image getPicture(){
        return this.picture;
    }
}
