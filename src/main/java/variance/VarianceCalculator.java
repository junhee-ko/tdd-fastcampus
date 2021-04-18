package variance;

public class VarianceCalculator {

  public static void main(String[] args) {

    switch (args.length) {
      case 0:
        System.out.println("입력된 데이터가 없습니다.");
        break;
      case 1:
        System.out.println("데이터가 부족해 분산을 계산할 수 없습니다. 2개 이상의 데이터를 입력해 주세요.");
        break;
      default:
        System.out.println("분산 : " + getVariance(args));
    }
  }

  private static double getVariance(String[] args) {
    double[] source = parseArguments(args);
    double mean = calculateMean(source);
    double sumOfSquares = calculateSumOfSquares(args, source, mean);

    return sumOfSquares / (args.length - 1);
  }

  private static double calculateSumOfSquares(String[] args, double[] source, double mean) {
    double sumOfSquares = 0.0;
    for (int i = 0; i < args.length; i++) {
      sumOfSquares += (source[i] - mean) * (source[i] - mean);
    }

    return sumOfSquares;
  }

  private static double calculateMean(double[] source) {
    double sum = 0.0;
    for (double value : source) {
      sum += value;
    }

    return sum / source.length;
  }

  private static double[] parseArguments(String[] args) {
    double[] source = new double[args.length];
    for (int i = 0; i < args.length; i++) {
      source[i] = Double.parseDouble(args[i]);
    }

    return source;
  }
}
