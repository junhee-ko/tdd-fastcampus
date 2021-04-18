package refiner;

import java.util.stream.Stream;

public class TextRefiner {

  public String refine(String source, String[] bannedWords) {
    source = normalizeWhiteSpaces(source);
    source = compactWithSpace(source);
    source = maskBannedWords(source, bannedWords);

    return source;
  }

  private String normalizeWhiteSpaces(String source) {
    return source.replace("\t", " ");
  }

  private String compactWithSpace(String source) {
    return source.contains("  ") ? compactWithSpace(source.replace("  ", " ")) : source;
  }

  private String maskBannedWords(String source, String[] bannedWords) {
    return Stream.of(bannedWords).reduce(source, this::maskBannedWord);
  }

  private String maskBannedWord(String source, String bannedWord) {
    return source.replace(bannedWord, "*".repeat(bannedWord.length()));
  }
}