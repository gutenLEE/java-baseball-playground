package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateNoTest {
    @Test
    public void validate_no_1_9() {

        Assertions.assertTrue(ValidateNoUtil.validate(1));
        Assertions.assertFalse(ValidateNoUtil.validate(0));
        Assertions.assertTrue(ValidateNoUtil.validate(9));
        Assertions.assertFalse(ValidateNoUtil.validate(10));

    }

}
