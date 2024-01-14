package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> answers;

    public Balls(List<Integer> balls) {
        this.answers = mapBall(balls);
    }

    public PlayResult plays(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();
        for (Ball answer : answers) {
            BallStatus ballStatus = userBalls.play(answer);
            result.score(ballStatus);
        }
        return result;
    }
    public BallStatus play(Ball inputBall) {
        return answers.stream()
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
