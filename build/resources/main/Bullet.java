/**
 * this is the bullet object in the game
 */
abstract class Bullet extends GameObject implements DisplayData {

    /**
     * this is the initialization of the general data involved
     * @param size the size of the bullet circle
     * @param damage the damage may cause if some thing activate (add)
     * @param speed the speed of some thing move, could be 0.
     * @param side the side of the object.
     */
    public Bullet(int size, int damage, int speed, Side side) {
        super(size, damage, speed, side);
    }

    @Override
    public String toString() {//todo 补充数据
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

/**
 * this is the first bullet object in the game
 */
class BabyBullet extends Bullet {

    /**
     * this is the initialization of the general data involved
     * @param side the side of the object.
     */
    public BabyBullet(Side side) {
        super(1, 30, 3, side);
    }

    /**
     * this is the path of the object pic
     */
    @Override
    public void defineImageFile() {//todo
    }

    /**
     * this is the display of the object should include orientation of the pic
     * @param x the place parameter
     * @param y the place parameter
     * @param degree the orientation of the pic
     */
    @Override
    public void defineInitialPosition(int x, int y, double degree) {

    }

    /**
     * this defines the way to update the frame from the previous method
     * @param x the position parameter need update
     * @param y the position parameter need update
     * @param degree the orientation parameter need update
     */
    @Override
    public void displayUpdateMethod(int x, int y, double degree) {

    }

    /**
     * this defines the special skills of the game object.
     * different have different special skill and need a special to activate.
     */
    @Override
    void defineSpecialSkill() {
        super.speed *= 1.5;
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
