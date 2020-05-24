import org.junit.*;

import static org.junit.Assert.*;

public class BabyPlaneTest {

    private BabyPlane planeA;
    private BabyPlane planeB;
    private BabyPlane planeC;

    @Before
    public void setUp() throws Exception {
        planeA = new BabyPlane(Side.Hero);
        planeB = new BabyPlane(Side.Middle);
        planeC = new BabyPlane(Side.Hero);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void imageFile() {
    }

    @Test
    public void display() {
    }

    @Test
    public void defineSpecialSkill() {
        planeA.defineSpecialSkill();
        assertEquals(4 * planeC.shield, planeA.shield);
        assertEquals(3 * planeC.speed, planeA.speed);
        assertEquals(3 * planeC.shootingSpeed, planeA.shootingSpeed);
    }

    @Test
    public void ifActiveSkill() {
    }

    @Test
    public void testToString() {
        assertEquals("Hello, where am I?", planeA.toString());
    }
}