import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private int rollScore;
    private List<Integer> prevScore = new ArrayList<Integer>();
    private int currentRoll = 0;
    private int currentFrame = 0;

    public void roll(int pins) {
        prevScore.add(pins);
    }

    public int getScore() {

        while (currentFrame < 10) {
            rollScore = rollScore + prevScore.get(currentRoll);
            if (isSpare()) {
                handleSpare();
            }

            else if (isStrike()) {
                handleStrike();
            }

            else {

            }

            currentRoll++;
        }

        return rollScore;
    }

    private void handleStrike() {
        if (isStrike()) {
            rollScore = rollScore + prevScore.get(currentRoll + 1) + prevScore.get(currentRoll + 2);
            currentFrame++;
        }
    }

    private boolean isStrike() {
        if (currentRoll < prevScore.size() - 2) {
            return prevScore.get(currentRoll) == 10;
        }
        return false;
    }

    private void handleSpare() {
        if (isSpare()) {
            rollScore = rollScore + prevScore.get(currentRoll + 1)*2;
            currentFrame++;
            currentRoll++;
        }
    }

    private boolean isSpare() {
        if (currentRoll > 0 && currentRoll < prevScore.size() - 1) {
            return prevScore.get(currentRoll) + (int) prevScore.get(currentRoll - 1) == 10;
        }
        return false;
    }

}
