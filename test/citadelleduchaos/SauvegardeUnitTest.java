import Methods.Sauvegarde;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;

public class SauvegardeUnitTest {

    @Test
    public void testGetCurrentEvent() throws FileNotFoundException {
        Sauvegarde save = new Sauvegarde();
        Assertions.assertEquals(12,save.getCurrentEvent(0));
    }


}
