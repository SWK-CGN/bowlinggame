package bowling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private List<Integer> rolls = new ArrayList<>();

    public Game() {
        this(Collections.emptyList());
    }

    private Game(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public Game afterRolling(int pinsDown) {
        ArrayList<Integer> newRolls = new ArrayList<>(rolls);
        newRolls.add(pinsDown);
        return new Game(newRolls);
    }

    public int getScore() {
        int sum = 0;
        for (int frame = 0; frame < 10; frame++) {
            int sumOfFrame = firstScoreOfFrame(frame) + secondScoreOfFrame(frame);
            if (sumOfFrame == 10)
                sum += sumOfFrame + firstScoreOfFrame(frame+1);
            else
                sum += sumOfFrame;
        }
        return sum;
    }

    private Integer secondScoreOfFrame(int frame) {
        return rolls.get(secondRollOf(frame));
    }

    private Integer firstScoreOfFrame(int frame) {
        return rolls.get(firstRollOf(frame));
    }

    private int secondRollOf(int frame) {
        return firstRollOf(frame) +1;
    }

    private int firstRollOf(int frame) {
        return frame*2;
    }
}
