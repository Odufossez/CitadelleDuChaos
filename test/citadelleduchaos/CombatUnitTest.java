import Methods.Combat;
import Methods.Monster;
import Methods.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

class CombatUnitTest {
    Combat cmb;
    Player ply = new Player();
    Monster mst = new Monster();

    @BeforeEach
    void setUp() {
        ply.setHability(10);
        mst.setHability(6);
        cmb = new Combat(ply, mst);
    }

    @Test
    public void testPlayerTurn(){
        Assertions.assertEquals(16,cmb.playerTurn(6));
    }

    @Test
    public void testMonsterTurn(){
        Assertions.assertEquals(12,cmb.monsterTurn(6));
    }

    /**
     * Les paramètres sont passés dans des méthodes à l'intérieur de fight donc il faut prendre en compte
     * l'habilité de ply et mst donc :
     * pour le premier : mst=6+5 et ply = 10
     * snd : mst = 6 ply=10+2
     * third : mst=6+4 ply=10
     */
    @Test
    public void testFight(){
        Assertions.assertEquals("Le monstre vous a touché !" , cmb.fight(5,0));
        Assertions.assertEquals("Vous avez touché le monstre !" , cmb.fight(0,2));
        Assertions.assertEquals("Vous avez paré vos attaques mutuelles ! " , cmb.fight(4,0));
    }
}
