import java.util.Random;

public class TestDemo {
  public int addPositive(int a, int b) {
if (a < 0 || b < 0) {
      throw new IllegalArgumentException("Only positive numbers allowed");
    }
    return a + b;
  }
  public int multiplyPositive(int a, int b) {
    if (a > 0 && b > 0) {
      return a * b;
    } else {
      throw new IllegalArgumentException("Both parameters must be positive");
    }
  }
  // Assuming this method uses another method to get a random number
  public int randomNumberSquared() {
    int randomNum = getRandomNumber();
    return randomNum * randomNum;
  }

  // Mocked in tests
  public int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(10)+1;
  }


}

