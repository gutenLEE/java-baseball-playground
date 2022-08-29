package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    private boolean isStrike(String mockAnswer, String tryAnswer) {
        for (int i = 0; i < 3; i++) {
            char answerChar = mockAnswer.charAt(i);
            char tryChar = tryAnswer.charAt(i);
            if (answerChar == tryChar)
                return true;
        }
        return false;
    }

    private boolean isBall(String mockAnswer, String tryAnswer) {
        for (int i = 0; i < 3; i++) {
            char answerChar = mockAnswer.charAt(i);
            char tryChar = tryAnswer.charAt(i);
            String aLetter = tryAnswer.substring(i, i + 1);
            if (answerChar != tryChar && mockAnswer.contains(aLetter))
                return true;
        }
        return false;
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




}
