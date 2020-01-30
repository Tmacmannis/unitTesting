import data.SomeDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SomeDataServiceStub implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}


class SomeBusinessStubTest {

    @Test
    void calculateSumUsingDataService_basic() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
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