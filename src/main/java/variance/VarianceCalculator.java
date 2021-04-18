package variance;

public class VarianceCalculator {

  public static void main(String[] args) {
    int n = args.length;

    if (n == 0) {
      System.out.println("입력된 데이터가 없습니다.");
      return;
    }

    if (n == 1) {
      System.out.println("데이터가 부족해 분산을 계산할 수 없습니다. 2개 이상의 데이터를 입력해 주세요.");
      return;
    }

    double[] source = new double[n];
    for (int i = 0; i < n; i++) {
      source[i] = Double.parseDouble(args[i]);
    }

    double sum = 0.0;
    for (int i = 0; i < n; i++) {
      sum += source[i];
    }

    double sumOfSquares = 0.0;
    double mean = sum / n;
    for (int i = 0; i < n; i++) {
      sumOfSquares += (source[i] - mean) * (source[i] - mean);
    }

    double variance = sumOfSquares / (n - 1);

    System.out.println("분산 : " + variance);
  }
}
