import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * this is the parent class of all object in the game
 */
public abstract class GameObject {

    @Override
    public String toString() {
        return "this is a test";
    }

    abstract void defineSize();
    abstract void defineDamage();
    abstract void defineSpeed();
    abstract void defineSpecialSkill();
}
