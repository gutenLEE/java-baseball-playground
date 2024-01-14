package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    void create_숫자() {
        Ball computer = new Ball(1, 3);
    }

    @Test
    public void play_1_ball_test() {
        Ball answer = new Ball(1, 1);
        Ball userBall = new Ball(1, 2);

        Assertions.assertEquals(BallStatus.BALL, answer.play(userBall));
    }

    @Test
    public void play_strike_test() {
        Assertions.assertEquals(BallStatus.STRIKE, new Ball(1, 1).play(new Ball(1, 1)));
    }

    @Test
    public void play_nothing_test() {
        Assertions.assertEquals(BallStatus.NOTHING, new Ball(2, 1).play(new Ball(3, 1)));

    }



}
