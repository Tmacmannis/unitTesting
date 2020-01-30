import data.SomeDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class SomeBusinessMockTest {

    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    @Test
    void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        Assertions.assertEquals(actualResult, expectedResult);
    }

    @Test
    void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        Assertions.assertEquals(actualResult, expectedResult);
    }

    @Test
    void calculateSumUsingDataService_one() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {3});
        business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 3;
        Assertions.assertEquals(actualResult, expectedResult);
    }
}