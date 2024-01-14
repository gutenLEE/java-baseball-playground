package baseball;

public class PlayResult {

    private int strike = 0;
    private int ball = 0;
    private int nothing = 0;


    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }

    public void score(BallStatus ballStatus) {
        if (BallStatus.STRIKE == ballStatus) {
            strike++;
        } else if (BallStatus.BALL == ballStatus) {
            ball++;
        } else {
            nothing++;
        }
    }
}
