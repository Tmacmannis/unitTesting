import org.junit.jupiter.api.*;


class SomeBusinessImplTest {

    @Test
    void calculateSum_basic() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1,2,3});
        int expectedResult = 6;

        Assertions.assertEquals(actualResult, expectedResult);

    }

    @Test
    void calculateSum_empty() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {});
        int expectedResult = 0;

        Assertions.assertEquals(actualResult, expectedResult);

    }

    @Test
    void calculateSum_one() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {3});
        int expectedResult = 3;

        Assertions.assertEquals(actualResult, expectedResult);

    }
}