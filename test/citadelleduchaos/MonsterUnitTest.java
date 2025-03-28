import Methods.Monster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonsterUnitTest {
    Monster mst = new Monster();

    @BeforeEach
    void setUp() {
        mst.setVitality(3);
        mst.setHability(4);
        mst.setName("MonsterTest");
    }

    @Test
    public void testIsDead() {
        Assertions.assertFalse(mst.isDead());
        mst.setVitality(0);
        Assertions.assertTrue(mst.isDead());
    }

    @Test
    public void testGetName(){
        Assertions.assertEquals("MonsterTest", mst.getName());
    }

    @Test
    public void testGetHability(){
        Assertions.assertEquals(4, mst.getHability());
    }

    @Test
    public void testGetVitality(){
        Assertions.assertEquals(3, mst.getVitality());
    }

    @Test
    public void testIsTouchedInCombat(){
        Assertions.assertEquals(3,mst.getVitality());
        mst.isTouchedInCombat();
        Assertions.assertEquals(1,mst.getVitality());
    }

}
