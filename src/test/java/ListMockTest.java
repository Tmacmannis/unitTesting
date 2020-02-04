import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDiffValues(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParams(){
        when(mock.get(0)).thenReturn("testing");
        assertEquals("testing", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenParams(){
        when(mock.get(anyInt())).thenReturn("testing");
        assertEquals("testing", mock.get(0));
        assertEquals("testing", mock.get(1));
    }

    @Test
    public void verifyBasics(){
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, never()).get(2);

    }

    @Test
    public void argumentCatcher(){
        mock.add("SomeString");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());

    }

    @Test
    public void multArgumentCatcher(){
        mock.add("SomeString");
        mock.add("SomeString2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(mock, atLeast(1)).add(captor.capture());

        assertEquals("SomeString", captor.getAllValues().get(0));
        assertEquals("SomeString2", captor.getAllValues().get(1));

    }

    @Test
    public void spying(){

        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.get(0);
        arrayListSpy.size();
        arrayListSpy.add("Test");
        arrayListSpy.add("Test2");
        arrayListSpy.size();

        when(arrayListSpy.size()).thenReturn(5);
        arrayListSpy.size();






    }

}
