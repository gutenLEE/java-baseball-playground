package study;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    
    @Test 
    void split_string_test() throws Exception {
        String target = "1,2";
        assertThat(target.split(",")).containsExactly("1","2");
    }

    @Test
    void when_split_regex_not_matched_test() throws Exception {
        String target = "1";
        assertThat(target.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("charAt()은 해당 인덱스의 문자를 리턴한다.")
    void charAt_return_target_index_of_character_test() throws Exception {
        String str = "abc";
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThrows(StringIndexOutOfBoundsException.class, () -> str.charAt(100));
    }

}
