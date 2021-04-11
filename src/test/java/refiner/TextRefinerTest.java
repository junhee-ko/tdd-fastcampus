package refiner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextRefinerTest {

  @ParameterizedTest
  @ValueSource(strings = {"hello  world", "hello   world", "hello    world", "hello     world"})
  void test(String source) {
    TextRefiner textRefiner = new TextRefiner();
    String expected = "hello world";

    String actual = textRefiner.refine(source);

    assertEquals(expected, actual);
  }
}