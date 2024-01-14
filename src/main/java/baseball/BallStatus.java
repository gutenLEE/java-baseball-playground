package baseball;

import java.util.Arrays;

public enum BallStatus {
    BALL,
    STRIKE,
    NOTHING
    ;


    public boolean isNotNothing() {
        return this != NOTHING;
    }
}
