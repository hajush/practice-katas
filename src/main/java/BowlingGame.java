import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private int rollScore;
    private List<Integer> prevScore = new ArrayList<Integer>();
    private int currentRoll = 0;
    private int currentFrame;
    private boolean isFirstRollForCurrentFrame=true;
    public void roll(int pins) {
        prevScore.add(pins);
    }

    public int getScore() {
        currentFrame = 0;
        while (currentFrame < 10) {
            if (isStrike()) {
                rollScore = rollScore + prevScore.get(currentRoll + 1) + prevScore.get(currentRoll + 2);
                currentFrame++;
            }
           else if (isSpare()) {
                rollScore = rollScore + prevScore.get(currentRoll + 1);
                currentFrame++;
            }
           else {
                rollScore = rollScore + prevScore.get(currentRoll);
                if(isFirstRollForCurrentFrame) {
                    isFirstRollForCurrentFrame=false;
                }
                else{
                    isFirstRollForCurrentFrame=true;
                    currentFrame++;
                }
            }
            currentRoll++;
        }
        return rollScore;
    }

    private boolean isStrike() {
        if (currentRoll < prevScore.size() - 2) {
            return prevScore.get(currentRoll) == 10;
        }
        return false;
    }

    private boolean isSpare() {
        if (currentRoll > 0 && currentRoll < prevScore.size() - 1) {
            return prevScore.get(currentRoll) + (int) prevScore.get(currentRoll - 1) == 10;
        }
        return false;
    }

}
