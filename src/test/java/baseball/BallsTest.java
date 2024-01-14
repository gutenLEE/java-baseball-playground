package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BallsTest {

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
