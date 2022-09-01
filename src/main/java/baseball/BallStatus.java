package baseball;

/**
 * @author gutenlee
 * @since 2022/08/31
 */
public enum BallStatus {
    BALL
    , STRIKE
    , NOTHING;

    public boolean isNotNothing() {
        return this != NOTHING;
    }
}
