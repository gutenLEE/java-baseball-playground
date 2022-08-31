package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author gutenlee
 * @since 2022/08/31
 */
public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 2);
    }

    @Test
    void nothing() throws Exception {

       BallStatus status = com.play(new Ball(1, 1));
       assertEquals(BallStatus.NOTHING, status);
    }

    @Test
    void ball() throws Exception {
        BallStatus status = com.play(new Ball(2, 2));
        assertEquals(BallStatus.BALL, status);
    }

    @Test
    void strike() throws Exception {
        BallStatus status = com.play(new Ball(1, 2));
        assertEquals(BallStatus.STRIKE, status);
    }




}
