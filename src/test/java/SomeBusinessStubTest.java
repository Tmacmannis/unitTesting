import data.SomeDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SomeDataServiceStubBasic implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}


class SomeDataServiceStubEmpty implements SomeDataService{
    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceStubOne implements SomeDataService{
    @Override
    public int[] retrieveAllData() {
        return new int[]{3};
    }
}

class SomeBusinessStubTest {

    @Test
    void calculateSumUsingDataService_basic() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubBasic());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        Assertions.assertEquals(actualResult, expectedResult);

    }

    @Test
    void calculateSumUsingDataService_empty() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubEmpty());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        Assertions.assertEquals(actualResult, expectedResult);

    }

    @Test
    void calculateSumUsingDataService_one() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubOne());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 3;

        Assertions.assertEquals(actualResult, expectedResult);

    }
}