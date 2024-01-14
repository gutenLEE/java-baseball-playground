package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> balls) {
        this.balls = mapBall(balls);
    }

    public BallStatus play(Ball inputBall) {
        return balls.stream()
                .map(answer -> answer.play(inputBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    private static List<Ball> mapBall(List<Integer> balls) {
        List<Ball> toBalls = new ArrayList<>();
        int size = balls.size();
        for (int pos = 0; pos < size; pos++) {
            toBalls.add(new Ball(balls.get(pos), pos + 1));
        }
        return toBalls;
    }
}
