package baseball;

import java.io.*;

public class BaseballGameProgram {

    public static void main(String[] args) throws IOException {

        BaseballNumber computerNumber = new BaseballNumber();
        boolean finished = false;
        do {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("숫자를 입력해주세요 : ");
            String input = br.readLine();
            System.out.println(input);

            while (computerNumber.match(input)) {
                finished = true;
                break;
            }
        } while (!finished);

    }
}
