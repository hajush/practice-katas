import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BowlingTest {

    BowlingGame bowlingGame;

    @Before
    public void init() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void scoreGutterGame() {
        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(0);
        }
        assertEquals(0, bowlingGame.getScore());

    }

    @Test
    public void rollTwentyOnce() {
        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(1);
        }
        assertEquals(20, bowlingGame.getScore());

    }


    @Test
    public void rollSpareTest() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        for (int i = 3; i < 20; i++) {
            bowlingGame.roll(0);
        }
        assertEquals(20, bowlingGame.getScore());

    }

    @Test
    public void rollSpareTest2() {
        bowlingGame.roll(8);
        bowlingGame.roll(2);
        bowlingGame.roll(2);
        for (int i = 3; i < 20; i++) {
            bowlingGame.roll(0);
        }
        assertEquals(14, bowlingGame.getScore());

    }

    @Test
    public void rollStrikeTest() {
        bowlingGame.roll(10);
        bowlingGame.roll(2);
        bowlingGame.roll(5);
        for (int i = 3; i < 20; i++) {
            bowlingGame.roll(0);
        }
        assertEquals(24, bowlingGame.getScore());

    }

    @Test
    public void rollStrikeTest2() {
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(5);
        bowlingGame.roll(2);
        for (int i = 4; i < 20; i++) {
            bowlingGame.roll(0);
        }
        assertEquals(49, bowlingGame.getScore());

    }

    @Test
    public void perfectGame() throws Exception {
        for (int i = 0; i < 12; i++) {
            bowlingGame.roll(10);
        }
        assertEquals(300, bowlingGame.getScore());
        //Thread.sleep(120000);
        //fail("forcing a failure to test project-monitor");
    }

}
