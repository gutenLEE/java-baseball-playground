package baseball;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author gutenlee
 * @since 2022/08/28
 */
public class BaseballTest {

    private String createAnswer() {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            double random = Math.random();
            int value = (int) (random * 10);
            answer.append(value);
        }
        return answer.toString();
    }

    private boolean isStrike(String actualAnswer, String tryAnswer) {
        for (int i = 0; i < 3; i++) {
            char answerChar = actualAnswer.charAt(i);
            char tryChar = tryAnswer.charAt(i);
            if (answerChar == tryChar)
                return true;
        }
        return false;
    }

    private boolean isBall(String actualAnswer, String tryAnswer) {
        for (int i = 0; i < 3; i++) {
            char answerChar = actualAnswer.charAt(i);
            char tryChar = tryAnswer.charAt(i);
            String aLetter = tryAnswer.substring(i, i + 1);
            if (answerChar != tryChar && actualAnswer.contains(aLetter))
                return true;
        }
        return false;
    }

    private boolean isNothing(String actualAnswer, String tryAnswer) {
        return !isStrike(actualAnswer, tryAnswer) && !isBall(actualAnswer, tryAnswer);
    }

    private String createLog(int ballCount, int strikeCount){
        return String.format("%d볼 %d스트라이크", ballCount, strikeCount);
    }

    private String createNothingLog() {
        String log = "낫싱";
        return log;
    }

    private boolean isCorrect(String answer, String userAnswer) {
        return answer.equals(userAnswer);
    }

    @Test
    void createAnswerResult_should_be_3_letters() throws Exception {
        String answer = createAnswer();
        assertThat(answer.length()).isEqualTo(3);
    }

    @Test
    void returnStrike_test() throws Exception {
        String mockAnswer = "352";
        String tryAnswer = "153";
        assertTrue(isStrike(mockAnswer, tryAnswer));

        mockAnswer = "123";
        tryAnswer = "456";
        assertFalse(isStrike(mockAnswer, tryAnswer));
    }

    @Test
    void returnBall_test() throws Exception {
        String mockAnswer = "123";
        String tryAnswer = "367";
        assertTrue(isBall(mockAnswer, tryAnswer));

        // 예외 케이스 - 스트라이크인 경우
        mockAnswer = "123";
        tryAnswer = "523";
        assertFalse(isBall(mockAnswer, tryAnswer));
    }

    @Test
    void returnNothing_test() throws Exception {
        String mockAnswer = "123";
        String tryAnswer = "678";
        assertTrue(isNothing(mockAnswer, tryAnswer));

        // given strike
        mockAnswer = "123";
        tryAnswer = "527";
        assertFalse(isNothing(mockAnswer, tryAnswer));

        // given ball
        mockAnswer = "123";
        tryAnswer = "516";
        assertFalse(isNothing(mockAnswer, tryAnswer));
    }

    @Test
    void createLog_test() throws Exception {
        String log = createLog(1, 2);
        assertEquals("1볼 2스트라이크", log);
    }

    @Test
    void nothingTest() throws Exception {
        assertTrue(isNothing("123", "456"));
        assertFalse(isNothing("123", "123"));
    }



    @Test
    void game_test() throws Exception {

        int strikeCount = 0, ballCount = 0;
        String answer = "123";
        String[] givenInputAnswers = {"156", "345", "567", "123"};
        for (String userAnswer : givenInputAnswers) {
            if (isCorrect(answer, userAnswer)) {
                break;
            }
            if (isStrike(answer, userAnswer))
                strikeCount++;
            else if (isBall(answer, userAnswer))
                ballCount++;
            else if (isNothing(answer, userAnswer)) {
                System.out.println(createNothingLog());
                continue;
            }
            System.out.println(createLog(ballCount, strikeCount));
        }
    }


}
