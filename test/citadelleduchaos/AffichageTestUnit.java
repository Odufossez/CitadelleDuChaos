import citadelleduchaos.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class AffichageTestUnit {

    @Test
    public void testAfficheResume() throws IOException {
        Player player = new Player();
        new Spells();
        player = new Player(5,10,12 , 0 , 9);
        for (int i = 0; i < 12 ; i++) {
            player.setSpelltInGrimoire(i,i);
        }
        Affichage.paramAffichage();
        //Affichage.confirmScreen(player);
        Assertions.assertEquals('x' , StdDraw.nextKeyTyped());
    }

    @Test
    public void testTttReturnCurrentEvent() throws IOException {
        Assertions.assertEquals("no save to load",Affichage.traitementReturnCurrentEvent(-1));
        Assertions.assertEquals("0",Affichage.traitementReturnCurrentEvent(0));
        Assertions.assertEquals("3",Affichage.traitementReturnCurrentEvent(3));
    }
}
