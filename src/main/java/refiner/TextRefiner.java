package refiner;

public class TextRefiner {

  public String refine(String s){
    return s.replace("    ", " ").replace("  ", " ");
  }
}