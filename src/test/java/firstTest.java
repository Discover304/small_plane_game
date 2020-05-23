import org.junit.Test;
import static org.junit.Assert.*;

public class FirstTest {

    @Test
    public void mainTest(){
        First a = new First();
        assertEquals("what ever this is hi", a.toString());
    }
}
