package refiner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextRefinerTest {

  @ParameterizedTest
  @ValueSource(strings = {"hello  world", "hello   world", "hello    world", "hello     world", "hello      world"})
  void givenStringWithSpace_whenRefined_thenGetStringWithOneSpace(String source) {
    TextRefiner textRefiner = new TextRefiner();
    String expected = "hello world";

    String actual = textRefiner.refine(source);

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(strings = {"hello\t world", "hello \tworld"})
  void givenStringWithSpaceAndTab_whenRefined_thenGetStringWithOneSpace(String source) {
    TextRefiner textRefiner = new TextRefiner();
    String expected = "hello world";

    String actual = textRefiner.refine(source);

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({"hello mockist,hello *******", "hello purist,hello ******"})
  void givenStringWithBannedWords_whenRefined_thenGetStringWithMasking(String source, String expected) {
    TextRefiner textRefiner = new TextRefiner();

    String actual = textRefiner.refine(source);

    assertEquals(expected, actual);
  }
}