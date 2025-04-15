import Methods.Sauvegarde;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SauvegardeUnitTest {

    File file;


    @Test
    public void testGetCurrentEvent() throws FileNotFoundException {
        Assertions.assertEquals(12,Sauvegarde.getCurrentEvent(0));
    }

    @Test
    public void testFirstEmptySlot() throws IOException {
        Assertions.assertEquals(1,Sauvegarde.firstEmptySlot());
        Sauvegarde.createSave(1);
        Assertions.assertEquals(2,Sauvegarde.firstEmptySlot());
    }


}
