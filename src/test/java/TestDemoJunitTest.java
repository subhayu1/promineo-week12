
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestDemoJunitTest {

  private TestDemo testDemo;

  @BeforeEach
  void setup() throws Exception {
    testDemo = new TestDemo();
  }

  @ParameterizedTest
  @CsvSource({
      "1, 2, 3,false",
      "2, 1, 3,false",
      "-1, 2, 0,true",
      "2, -1, 0,true",
  })
  void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected,
      boolean exceptException) {
    if (!exceptException) {
      assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
    } else {
      assertThatThrownBy(() -> {
        testDemo.addPositive(a, b);
      }).isInstanceOf(IllegalArgumentException.class);
    }
  }
  @Test
  void testAddPositive() {
assertThat(testDemo.addPositive(4,4)).isEqualTo(8);  }
  @Test
  void testMultiplyPositive() {
    assertEquals(6, testDemo.multiplyPositive(2, 3), "2 * 3 should equal 6");
  }
  @Test
  void testRandomNumberSquared() {
    // Mock the getRandomNumber method
    TestDemo mockDemo = spy(testDemo);
    doReturn(5).when(mockDemo).getRandomNumber();
    int fiveSquared = mockDemo.randomNumberSquared();
    assertEquals(25, fiveSquared, "5 squared should equal 25");

    };
  }


