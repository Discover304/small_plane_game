import java.io.File;

public abstract class Trap extends GameObject implements Display{

    /**
     * this is the initialization of the general data involved
     * @param size the size of the bullet circle
     * @param damage the damage may cause if some thing activate (add)
     * @param speed the speed of some thing move, could be 0.
     * @param side the side of the object.
     */
    public Trap(int size, int damage, int speed, Side side) {
        super(size, damage, speed, side);
    }

    @Override
    public String toString() {//todo 补充数据列表
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}

class BabyTrap extends Trap{

    /**
     * this is the initialization of the general data involved
     * @param side the side of the object.
     */
    public BabyTrap(Side side) {
        super(5, 50, 1, side);
    }

    /**
     * this is the path of the object pic
     * @return the file
     */
    @Override
    public File imageFile() {//todo
        return null;
    }

    /**
     * this is the display of the object should include orientation of the pic
     * @param x the place parameter
     * @param y the place parameter
     */
    @Override
    public void display(int x, int y) {//todo

    }

    /**
     * this defines the special skills of the game object.
     * different have different special skill and need a special to activate.
     */
    @Override
    void defineSpecialSkill() {//todo

    }

    /**
     * this is for judge if some thing cause damage by others.
     * @param gameObject this is a collection of all object of this game
     *
     * @return a boolean value to change something.
     */
    @Override
    boolean ifCauseDamage(GameObject[] gameObject) {//todo
        return false;
    }

    /**
     * this is for judge if some thing can activate their special skill.
     * @param gameObject this is a collection of all object of this game
     *
     * @return a boolean value to change something.
     */
    @Override
    boolean ifActiveSkill(GameObject[] gameObject) {//todo
        return false;
    }

    /**
     * this defines how the special feature of the plane
     */
    @Override
    void special() {//todo

    }

    @Override
    public String toString() {//todo 介绍
        return super.toString();
    }
}
