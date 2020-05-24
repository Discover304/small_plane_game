public class Stater {
    public static void main(String[] args) {
        GameObject heroUnit = new BabyPlane(Side.Hero);
        System.out.println(heroUnit.toString());
    }
}
