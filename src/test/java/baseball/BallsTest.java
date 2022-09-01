package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/09/01
 */
public class BallsTest {

    private Balls com;

    @BeforeEach
    void setUp() {
        com = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void plays() throws Exception {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResults results = answers.plays(Arrays.asList(5, 6, 7));
        assertThat(results.getStrike()).isEqualTo(0);
        assertThat(results.getBall()).isEqualTo(0);
    }

    @Test
    void play_strike() throws Exception {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResults results = answers.plays(Arrays.asList(1,2,3));
        assertThat(results.isEndGame()).isTrue();
    }




    @Test
    void nothing() throws Exception {
        Balls userBall = new Balls(Arrays.asList(5, 6, 7));
        BallStatus status = userBall.plays(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() throws Exception {
        Balls userBall = new Balls(Arrays.asList(5, 1, 7));
        BallStatus status = userBall.plays(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() throws Exception {
        Balls userBall = new Balls(Arrays.asList(5, 1, 7));
        BallStatus status = userBall.plays(new Ball(1, 5));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }





}
