package bowling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void allZero() {
        int testInput[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        Game game = rollGame(testInput);

        assertEquals(0, game.getScore());
    }

    @Test
    public void onePinDownThenOnlyZero() {
        int testInput[] = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        Game game = rollGame(testInput);

        assertEquals(1, game.getScore());
    }

    @Test
    public void onePinDownThenOnePinDownThenOnlyZero() {
        int testInput[] = {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        Game game = rollGame(testInput);

        assertEquals(2, game.getScore());
    }


    @Test
    public void oneSpareWithAdditionalScoreInNextFrameThenOnlyZero() {
        int testInput[] = {5, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        Game game = rollGame(testInput);

        assertEquals(12, game.getScore());
    }
    @Test
    public void looksLikeASpareWithAdditionalScoreInNextFrameThenOnlyZero() {
        int testInput[] = {0, 5, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        Game game = rollGame(testInput);

        assertEquals(11, game.getScore());
    }



    private Game rollGame(int[] testInput) {
        Game game = new Game();
        for (int pinsDown : testInput) {
            game = game.afterRolling(pinsDown);
        }
        return game;
    }


}
