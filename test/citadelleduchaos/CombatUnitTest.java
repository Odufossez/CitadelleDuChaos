import citadelleduchaos.Combat;
import citadelleduchaos.Dice;
import citadelleduchaos.Monster;
import citadelleduchaos.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;


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
}
