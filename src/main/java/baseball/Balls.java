package baseball;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gutenlee
 * @since 2022/09/01
 */
public class Balls {

    List<Ball> balls;

    public Balls(List<Integer> answers) {
        this.balls = mapToBalls(answers);
    }

    private List<Ball> mapToBalls(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            balls.add(new Ball(i+1, answers.get(i)));
        }
        return balls;
    }

    public BallStatus plays(Ball userBall) {
        return this.balls.stream()
                .map(ball -> ball.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
