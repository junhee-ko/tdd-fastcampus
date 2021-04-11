package refiner;

public class TextRefiner {

  public String refine(String s, String[] bannedWords) {
    s = s
        .replace("    ", " ")
        .replace("\t", " ")
        .replace("  ", " ")
        .replace("  ", " ")
        .replace("  ", " ")
        .replace("mockist", "*******")
        .replace("purist", "******");

    for (String bannedWord : bannedWords) {
      s = s.replace(bannedWord, "*".repeat(bannedWord.length()));
    }

    return s;
  }
}