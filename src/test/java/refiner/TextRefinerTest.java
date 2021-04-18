package refiner;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextRefinerTest {

  @ParameterizedTest
  @ValueSource(strings = {"hello  world", "hello   world", "hello    world", "hello     world", "hello      world"})
  void givenStringWithSpace_whenRefined_thenGetStringWithOneSpace(String source) {
    TextRefiner textRefiner = new TextRefiner();
    String expected = "hello world";

    String actual = textRefiner.refine(source, new String[]{});

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(strings = {"hello\t world", "hello \tworld"})
  void givenStringWithSpaceAndTab_whenRefined_thenGetStringWithOneSpace(String source) {
    TextRefiner textRefiner = new TextRefiner();
    String expected = "hello world";

    String actual = textRefiner.refine(source, new String[]{});

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({"hello mockist,hello *******", "hello purist,hello ******"})
  void givenStringWithBannedWords_whenRefined_thenGetStringWithMasking(String source, String expected) {
    TextRefiner textRefiner = new TextRefiner();

    String actual = textRefiner.refine(source, new String[]{source.split(" ")[1]});

    assertEquals(expected, actual);
  }

  @Test
  void givenStringWithRandomBannedWords_whenRefined_thenGetStringWithMasking() {
    int size = new Random().nextInt(10);
    String bannedWord = RandomStringUtils.randomAlphabetic(size);
    String source = "hello " + bannedWord;
    String expected = "hello " + "*".repeat(size);

    TextRefiner textRefiner = new TextRefiner();
    String actual = textRefiner.refine(source, new String[]{bannedWord});

    assertEquals(expected, actual);
  }
}