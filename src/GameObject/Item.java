package GameObject;

public class Item extends GameObject{

    protected int damage;

    public Item(float x, float y, Frame frame, int damage){
        super(x, y, frame);
        this.damage = damage;
    }

    public void setDamage(int dmg){
        this.damage = dmg;
    }
    public int getDamage(){
        return this.damage;
    }

}
