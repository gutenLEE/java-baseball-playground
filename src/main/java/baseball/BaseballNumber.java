package baseball;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class BaseballNumber {

    private String answer;
    public BaseballNumber() {
        createNumber();
    }

    private void createNumber() {
        int number = ThreadLocalRandom.current().nextInt(100, 1000);
        answer = Integer.toString(number);
    }

    public boolean match(String input) {
        int strike = 0;
        int ball = 0;
        int nothing = 0;
        for (int i = 0; i < 3; i++) {
            if(answer.charAt(i) == input.charAt(i)) {
                strike++;
                continue;
            } else if (answer.contains(Character.toString(input.charAt(i)))) {
                ball++;
                continue;
            }
            nothing++;
        }
        printMatch(strike, ball, nothing);
        return strike == 3;
    }

    private void printMatch(int strike, int ball, int nothing) {
        System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
    }
}
