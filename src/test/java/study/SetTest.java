package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

/**
 * @author gutenlee
 * @since 2022/08/26
 */
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void size_return_the_size_of_set() throws Exception {
         assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void contains_return_boolean() throws Exception {
         assertThat(numbers.contains(2)).isTrue();
         assertThat(numbers.contains(1)).isTrue();
         assertThat(numbers.contains(3)).isTrue();
         assertThat(numbers.contains(200)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains_return_true_test(int number){
        assertThat(numbers.contains(number)).isTrue();
    }


    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "200:false"}, delimiter = ':')
    void contains_return_true_false_test(String input, String expected) {
        int number = Integer.parseInt(input);
        boolean expectedBool = Boolean.parseBoolean(expected);

        assertThat(numbers.contains(number)).isEqualTo(expectedBool);
    }

}
