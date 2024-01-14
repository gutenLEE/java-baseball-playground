package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BallsTest {

    @Test
    public void play_test() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = computer.play(Arrays.asList(1, 3, 4));
        Assertions.assertThat(result.getStrike()).isEqualTo(1);
        Assertions.assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    public void strike_test() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        Assertions.assertThat(computer.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    public void ball_test() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        Assertions.assertThat(computer.play(new Ball(1, 2))).isEqualTo(BallStatus.BALL);
    }

    @Test
    public void nothing_test() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        Assertions.assertThat(computer.play(new Ball(4, 1))).isEqualTo(BallStatus.NOTHING);
    }



}
