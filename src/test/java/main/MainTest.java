package main;
import org.assertj.core.data.Percentage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class MainTest {
  Main main;
    @DataProvider(name = "dataForTestCalcF")
    public Object[][] dataForTestCalcF() {
        return new Object[][] {
                {1, 6.4},
                {1.4, 3.65},
                {2, 0.94}
        };
    }
    @BeforeClass
    public void beforeClass () {
      main = new Main();
    }

    @Test(dataProvider = "dataForTestCalcF")
    public void testCalcF (double x, double expectedY) {
        assertThat(main.calcF(x)).isCloseTo(expectedY, Percentage.withPercentage(0.1));
    }
    @DataProvider (name = "dataForCalcSteps")
    public Object[][] dataForCalcF () {
        return new Object[][] {
                {0, 1, 0.1, 11},
                {-1, 1, 0.1, 21}
        };
    }
    @Test (dataProvider = "dataForCalcSteps")
    public void testCalcSteps (double start, double end, double step, int expected) {
        assertThat(main.calcSteps(start, end, step)).isEqualTo(expected);
    }

    @Test
    public void testCalcF1() {
        double x = 1;
        assertThat(main.calcF(x))
                .isCloseTo(6.4, Percentage.withPercentage(0.1));
    }

    @Test
    public void testCalcF2() {
        double x = 1.4;
        assertThat(main.calcF(x))
                .isCloseTo(3.65, Percentage.withPercentage(0.1));
    }

    @Test
    public void testCalcF3() {
        double x = 2;
        assertThat(main.calcF(x))
                .isCloseTo(0.94, Percentage.withPercentage(0.1));
    }
    @DataProvider (name = "dataForCreateX")
    public Object[][] dataForCreateX() {
        return new Object[][] {
                {0, 1, 0.1, 0, 0.0},
                {0, 1, 0.1, 5, 0.5},
                {0, 1, 0.1, 10, 1.0},
                {0.0, 2.0, 0.002, 0, 0},
                {0.0, 2.0, 0.002, 700, 1.4},
                {0.0, 2.0, 0.002, 1000, 2.0},
        };
    }

    @Test (dataProvider = "dataForCreateX")
    public void testCreateX(double start, double end, double step, int index, double expected) {
        assertThat(main.createX(start, end, step)[index]).isCloseTo(expected, Percentage.withPercentage(0.1));
     }

    @DataProvider (name = "dataForCreateY")
    public Object[][] dataForCreateY() {
        return new Object[][] {
                {0.0, 2.0, 0.002, 0, 4.0},
                {0.0, 2.0, 0.002, 700, 3.65},
                {0.0, 2.0, 0.002, 1000, 0.94},
        };
    }
    @Test (dataProvider = "dataForCreateY")
    public void testCreateY(double start, double end, double step, int index, double expected) {
        double[] x = main.createX(start, end, step);
        double[] y = main.createY(x);
        System.out.println("x " + "> " + x[index]);
        System.out.println("y " + "> " + y[index]);
        assertThat(y[index]).isCloseTo(expected, Percentage.withPercentage(0.1));
    }

    @DataProvider (name = "dataForTestNumOfMaxX")
    public Object[][] dataForTestNumOfMaxX() {
        return new Object[][] {
                {0.0, 1.0, 0.1, 10},
                {0.0, 2.0, 0.002, 1000}
        };
    }
    @Test (dataProvider = "dataForTestNumOfMaxX")
    public void testNumOfMaxX(double start, double end, double step, int expectedIndex) {
        double[] x = main.createX(start, end, step);
        assertEquals(expectedIndex, main.numOfMaxX(x), 0);
    }

    @DataProvider (name = "dataForTestNumOfMaxY")
    public Object[][] dataForTestNumOfMaxY() {
        return new Object[][] {
                {0.0, 1.0, 0.1, 10},
                {0.0, 2.0, 0.002, 699}
        };
    }
    @Test (dataProvider = "dataForTestNumOfMaxY")
    public void testNumOfMaxY(double start, double end, double step, int expectedIndex) {
        double[] x = main.createX(start, end, step);
        double[] y = main.createY(x);
        assertEquals(expectedIndex, main.numOfMaxY(y), 0);
    }

    @DataProvider (name = "dataForTestNumOfMinX")
    public Object[][] dataForTestNumOfMinX() {
        return new Object[][] {
                {0.0, 1.0, 0.1, 0},
                {0.0, 2.0, 0.002, 0}
        };
    }
    @Test (dataProvider = "dataForTestNumOfMinX")
    public void testNumOfMinX(double start, double end, double step, int expectedIndex) {
        double[] x = main.createX(start, end, step);
        assertEquals(expectedIndex, main.numOfMinX(x), 0);
    }

    @DataProvider (name = "dataForTestNumOfMinY")
    public Object[][] dataForTesNumOfMinY() {
        return new Object[][] {
                {0.0, 1.0, 0.1, 1},
                {0.0, 2.0, 0.002, 1000}
        };
    }
    @Test (dataProvider = "dataForTestNumOfMinY")
    public void testNumOfMinY(double start, double end, double step, int expectedIndex) {
        double[] x = main.createX(start, end, step);
        double[] y = main.createY(x);
        assertEquals(expectedIndex, main.numOfMinY(y), 0);
    }

    @DataProvider (name = "dataForTestSumX")
    public Object[][] dataForTestSumX() {
        return new Object[][] {
                {0.0, 1.0, 0.1, 5.50},
                {0.0, 2.0, 0.002, 1001}
        };
    }
    @Test (dataProvider = "dataForTestSumX")
    public void testSumX(double start, double end, double step, double expectedSum) {
            double[] x = main.createX(start, end, step);
            assertThat(main.sumX(x)).isCloseTo(expectedSum, Percentage.withPercentage(0.1));
    }

    @DataProvider (name = "dataForTestSumY")
    public Object[][] dataForTestSumY() {
        return new Object[][] {
                {0.0, 1.0, 0.1, 52.75},
                {0.0, 2.0, 0.002, 4224.11}
        };
    }
    @Test (dataProvider = "dataForTestSumY")
    public void testSumY(double start, double end, double step, double expectedSum) {
        double[] x = main.createX(start, end, step);
        double[] y = main.createY(x);
        assertThat(main.sumY(y)).isCloseTo(expectedSum, Percentage.withPercentage(0.1));
    }

    @DataProvider (name = "dataForTestArithmeticMeanX")
    public Object[][] dataForTestArithmeticMeanX() {
        return new Object[][] {
                {0.0, 1.0, 0.1, 0.5},
                {0.0, 2.0, 0.002, 1.0}
        };
    }
    @Test (dataProvider = "dataForTestArithmeticMeanX")
    public void testArithmeticMeanX(double start, double end, double step, double expectedArithmeticMeanX) {
        double[] x = main.createX(start, end, step);
        assertThat(main.arithmeticMeanX(x)).isCloseTo(expectedArithmeticMeanX, Percentage.withPercentage(0.1));
    }

    @DataProvider (name = "dataForTestArithmeticMeanY")
    public Object[][] dataForTestArithmeticMeanY() {
        return new Object[][] {
                {0.0, 1.0, 0.1, 4.795},
                {0.0, 2.0, 0.002, 4.219}
        };
    }
    @Test (dataProvider = "dataForTestArithmeticMeanY")
    public void testArithmeticMeanY(double start, double end, double step, double expectedArithmeticMeanY) {
        double[] x = main.createX(start, end, step);
        double[] y = main.createY(x);
        assertThat(main.arithmeticMeanY(y)).isCloseTo(expectedArithmeticMeanY, Percentage.withPercentage(0.1));
    }
}
