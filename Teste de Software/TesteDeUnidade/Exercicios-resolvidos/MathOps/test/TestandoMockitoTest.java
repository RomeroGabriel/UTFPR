/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.junit.Test;
import org.mockito.InOrder;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Aluno
 */
public class TestandoMockitoTest {
    
    public TestandoMockitoTest() {
    }

    @Test
    public void test1() {
        List mockedList = mock(List.class);
        
        //a interacao acontece aqui
        mockedList.add("um");
        mockedList.add("dois");
        mockedList.add("tres");
        mockedList.clear();
        //termina aqui
        
        //verifico se tais metodos foram invocados
        verify(mockedList).add("um");
        verify(mockedList).add("dois");
        verify(mockedList).clear();
    }

    @Test
    public void test2() {
        List mockedList = mock(List.class);
        
        //a interacao acontece aqui
        mockedList.add("um");
        mockedList.add("um");
        mockedList.add("dois");
        mockedList.add("tres");
        mockedList.clear();
        //termina aqui
        
        //verifico se tais metodos foram invocados
        verify(mockedList, times(2)).add("um");
        verify(mockedList, times(4)).add( anyString() );
    }

    @Test
    public void test3() {
        List mockedList = mock(List.class);
        
        //a interacao acontece aqui
        mockedList.add("um");
        mockedList.add("dois");
        mockedList.add("tres");
        //termina aqui
        
        //verifico se tais metodos foram invocados na ordem
        InOrder inOrder = inOrder(mockedList);
        inOrder.verify(mockedList).add("um");
        inOrder.verify(mockedList).add("dois");
        inOrder.verify(mockedList).add("tres");
    }

    @Test
    public void test4() {
        List mockedList = mock(List.class);
        
        when(mockedList.get(0)).thenReturn("zero");
        when( mockedList.contains(any()) ).thenReturn(Boolean.TRUE);
        
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(10));
        System.out.println(mockedList.contains("joaozinho"));
        
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.contains(new Exception("abc")));
    }
    
   //@Test(expected = IndexOutOfBoundsException.class)
    @Test(expected = Exception.class)
    public void test5() {
        List mockedList = mock(List.class);
        
        when(mockedList.get(30))
                .thenThrow(new IndexOutOfBoundsException());
        
        mockedList.get(30);
    }    
}
