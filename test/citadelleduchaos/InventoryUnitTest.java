import Methods.Player;
import Tools.Spells;
import Tools.Stuff;
import Visual.Affichage;
import Visual.Inventory;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;

import static Visual.Inventory.displayInventory;

public class InventoryUnitTest {

    @Test
    public void testDisplayInventory() throws FileNotFoundException {
        Player ply = new Player();
        new Affichage();
        new Stuff();
        new Spells();

        ply.setMagic(4);
        ply.setSpellBook();
        for (int i = 0; i < 4; i++) {
            ply.setSpelltInGrimoire(i,i);
        }

        ply.setInventory(1);
        ply.setInventory(3);
        ply.setInventory(5);

        Assertions.assertEquals(2 , displayInventory(ply));
    }
}
