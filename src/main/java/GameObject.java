import java.util.Objects;

/**
 * this is the parent class of all object in the game
 */
public abstract class GameObject {

    /**
     * this is an initialisation of the size of all game object.
     */
    public int size;

    /**
     * this is an initialisation of the damage cause of all game object.
     */
    public int damage;

    /**
     * this is an initialisation of the speed of all game object.
     */
    public int speed;

    /**
     * this is the side of the object
     */
    Side side;

    /**
     * this is the initialization of the general data involved
     * @param size the size of the bullet circle
     * @param damage the damage may cause if some thing activate (add)
     * @param speed the speed of some thing move, could be 0.
     * @param side the side of the object.
     */
    public GameObject(int size, int damage, int speed, Side side) {
        this.size = size;
        this.damage = damage;
        this.speed = speed;
        this.side = side;
    }

    /**
     * this defines the special skills of the game object.
     * different have different special skill and need a special to activate.
     */
    abstract void defineSpecialSkill();

    /**
     * this is for judge if some thing cause damage by others.
     * @param gameObject this is a collection of all object of this game
     *
     * @return a boolean value to change something.
     */
    abstract boolean ifCauseDamage(GameObject[] gameObject);

    /**
     * this is for judge if some thing can activate their special skill.
     * @param gameObject this is a collection of all object of this game
     *
     * @return a boolean value to change something.
     */
    abstract boolean ifActiveSkill(GameObject[] gameObject);

    /**
     * this defines how the special feature of the plane
     */
    abstract void special();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameObject)) return false;
        GameObject that = (GameObject) o;
        return size == that.size &&
                damage == that.damage &&
                speed == that.speed &&
                side == that.side;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, damage, speed, side);
    }

    @Override
    public String toString() {//todo 列表
        return super.toString();
    }
}
