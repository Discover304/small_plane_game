public abstract class Plane extends GameObject implements Judge, Display{

}

class BabyPlane extends Plane {

    @Override
    public String toString() {
        return "我真的只是一个小不点";
    }
}