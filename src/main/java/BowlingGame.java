import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private int rollScore;
    private List<Integer> prevScore = new ArrayList<Integer>();
    private int currentRoll = 0;
    private int currentFrame;
    public void roll(int pins) {
        prevScore.add(pins);
    }

    public int getScore() {
        currentFrame = 0;
        while (currentFrame < 10) {
            rollScore = rollScore + prevScore.get(currentRoll);
            if (isStrike()) {
                rollScore = rollScore + prevScore.get(currentRoll + 1) + prevScore.get(currentRoll + 2);
            }
            else if (isSpare()) {
                rollScore = rollScore + prevScore.get(currentRoll + 1) + prevScore.get(currentRoll + 2);
                currentRoll++;
            }
            else {
                rollScore = rollScore + prevScore.get(currentRoll + 1);
                currentRoll++;
            }
            currentRoll++;
            currentFrame++;
        }
        return rollScore;
    }

    private boolean isStrike() {
        return prevScore.get(currentRoll) == 10;
    }

    private boolean isSpare() {
        return prevScore.get(currentRoll) + prevScore.get(currentRoll + 1) == 10;
    }

}
