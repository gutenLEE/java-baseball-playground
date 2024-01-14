package baseball;

import java.util.Objects;
import java.util.SimpleTimeZone;

public class Ball {

    private final int no;
    private final int position;

    public Ball(int no, int position) {
        this.no = validate(no);
        this.position = position;
    }


    public BallStatus play(Ball userBall) {
        if (this.equals(userBall)) {
            return BallStatus.STRIKE;
        } else if(matchNo(userBall)){
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchNo(Ball userBall) {
        return this.no == userBall.no;
    }

    private static int validate(int no) {
        if(!ValidateNoUtil.validate(no)){
            throw new IllegalStateException("no is not in range 1 ~ 9 : " + no);
        }
        return no;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return no == ball.no && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, position);
    }
}
