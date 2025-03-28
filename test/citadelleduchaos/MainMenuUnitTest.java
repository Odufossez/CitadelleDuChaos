import Visual.MainMenu;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;

import static Tools.PathsTo.savePath;

public class MainMenuUnitTest {

    @Test
    public void testSavesExist() throws IOException {
        Assertions.assertFalse(MainMenu.savesExist());
        File file = new File(savePath+ "2.txt");
        file.createNewFile();
        Assertions.assertTrue(MainMenu.savesExist());
    }
}
