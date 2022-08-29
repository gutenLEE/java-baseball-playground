package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
            answer.append(Integer.toString(value));
        }
        return answer.toString();
    }

    @Test
    void createAnswerResult_should_be_3_letters() throws Exception {
        String answer = createAnswer();
        assertThat(answer.length()).isEqualTo(3);
    }




}
