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
        if (ballStatus.isStrike()) {
            strike++;
        } else if (ballStatus.isBall()) {
            ball++;
        } else {
            nothing++;
        }
    }
}
