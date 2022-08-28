package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import javax.swing.text.Utilities;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author gutenlee
 * @since 2022/08/26
 */
public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "3 + 2 + 2 * 2=14"},  delimiter = '=')
    void input_test(String input, String expected) throws Exception {

        assertInput(input);

        String[] expression = splitInput(input);

        Queue<String> operates = new LinkedList<>();
        Queue<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < expression.length; i++) {
            if (i % 2 != 0) {
                operates.add(expression[i]);
            } else {
                int num = Integer.parseInt(expression[i]);
                numbers.add(num);
            }
        }

        int foreNum = numbers.poll();
        while (!operates.isEmpty()) {
            String operate = operates.poll();
            int postNum = numbers.poll();
            switch (operate) {
                case "+":
                    foreNum = foreNum + postNum;
                    break;
                case "-":
                    foreNum = foreNum - postNum;
                    break;
                case "*":
                    foreNum = foreNum * postNum;
                    break;
                case "/":
                    foreNum = foreNum / postNum;
                    break;
            }
        }

        assertThat(foreNum).isEqualTo(Integer.parseInt(expected));
    }

    private String[] splitInput(String input) {
        if (input == null)
            throw new RuntimeException();

        return input.split(" ");
    }

    private void assertInput(String input) {
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner scanner = new Scanner(System.in);
            assertThat(scanner.nextLine()).isEqualTo(input);
        } finally {
            System.setIn(stdin);
        }
    }
}
