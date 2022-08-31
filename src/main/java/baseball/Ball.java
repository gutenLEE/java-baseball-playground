package baseball;

import java.util.Objects;

/**
 * @author gutenlee
 * @since 2022/08/31
 */
public class Ball {
    private final int position;
    private final int number;
    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public BallStatus play(Ball userBall) {
        if (this.equals(userBall))
            return BallStatus.STRIKE;
        if (this.matchBallNo(userBall.getNumber()))
            return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(int userBallNumber) {
        return this.number == userBallNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this, number);
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }
}
