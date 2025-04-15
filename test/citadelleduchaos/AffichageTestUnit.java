import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class AffichageTestUnit {

    @Test
    public void testTttReturnCurrentEvent() throws IOException {
        Assertions.assertEquals("no save to load",Affichage.traitementReturnCurrentEvent(-1));
        Assertions.assertEquals("0",Affichage.traitementReturnCurrentEvent(0));
        Assertions.assertEquals("3",Affichage.traitementReturnCurrentEvent(3));
    }
}
