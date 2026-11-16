import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;


public class AssertsLinkedList {

    @BeforeEach
    public void setup() {
    }
    
    @Test
    public void testAddRemoveLast() {
        
        // lista vazia
        LinkedList lista = new LinkedList();
        assertTrue(lista.isEmpty());
        assertEquals(0, lista.size());
    
        try {
            lista.getLast();
            fail("Lista vazia.");
        } catch (NoSuchElementException e){}
        
        
        // lista: [1]
        lista.addLast(5);
        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        assertEquals(5, (int)lista.getFirst());
        assertEquals(5, (int)lista.getLast());
        
        // lista: [1, 2]
        lista.addLast(10);
        assertEquals(5, (int)lista.getFirst());
        assertEquals(10, (int)lista.getLast());
        assertEquals(2, lista.size());
        
        // lista: [1, 2, 9, 11]
        lista.addLast(9);
        lista.addLast(11);
        assertEquals(5, (int)lista.getFirst());
        assertEquals(11, (int)lista.getLast());
        assertEquals(4, lista.size());
                
        // removendo. lista: [1, 2, 9]
        assertEquals((int)lista.removeLast(), 11);
        assertEquals(5, (int)lista.getFirst());
        assertEquals(9, (int)lista.getLast());
        assertEquals(3, lista.size());
        
        // removendo. lista: [1]
        assertEquals((int)lista.removeLast(), 9);
        assertEquals((int)lista.removeLast(), 2);
        assertEquals(1, (int)lista.getFirst());
        assertEquals(1, (int)lista.getLast());
        
        // removendo. lista: []
        assertEquals((int)lista.removeLast(), 1);
        assertTrue(lista.isEmpty());
        assertEquals(0, lista.size());
        
        // testando novamente após lista vazia
        // lista: [1]
        lista.addLast(5);
        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        assertEquals(5, (int)lista.getFirst());
        assertEquals(5, (int)lista.getLast());
        
        // lista: [1, 2]
        lista.addLast(10);
        assertEquals(5, (int)lista.getFirst());
        assertEquals(10, (int)lista.getLast());
        
        // lista: [1, 2, 9, 11]
        lista.addLast(9);
        lista.addLast(11);
        assertEquals(5, (int)lista.getFirst());
        assertEquals(11, (int)lista.getLast());
    }
    
    @Test
    public void testAddRemoveFirst() {
        
        LinkedList lista = new LinkedList();
        
        // no such element
        try {
            lista.getFirst();
            fail("Linha vazia.");
        } catch (NoSuchElementException e){}
        
        
        // lista: [1]
        lista.addFirst(5);
        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        assertEquals(5, (int)lista.getFirst());
        
        // lista: [2, 1]
        lista.addFirst(10);
        assertEquals(10, (int)lista.getFirst());
        assertEquals(5, (int)lista.getLast());
        
        // lista: [11, 9, 2, 1]
        lista.addFirst(9);
        lista.addFirst(11);
        assertEquals(11, (int)lista.getFirst());
        assertEquals(1, (int)lista.getLast());
                
        // removendo. lista: [9, 2, 1]
        assertEquals((int)lista.removeFirst(), 11);
        assertEquals(9, (int)lista.getFirst());
        assertEquals(1, (int)lista.getLast());
        
        // removendo. lista: [1]
        assertEquals((int)lista.removeFirst(), 9);
        assertEquals((int)lista.removeFirst(), 2);
        assertEquals(1, (int)lista.getFirst());
        assertEquals(1, (int)lista.getLast());
        assertTrue(lista.size() == 1);
        
        // removendo. lista: []
        assertEquals((int)lista.removeFirst(), 1);
        assertTrue(lista.isEmpty());
        assertTrue(lista.size() == 0);
        
        // testando novamente após lista vazia
        // lista: [1]
        lista.addFirst(5);
        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        assertEquals(5, (int)lista.getFirst());
        
        // lista: [2, 1]
        lista.addFirst(10);
        assertEquals(10, (int)lista.getFirst());
        assertEquals(5, (int)lista.getLast());
        
        // lista: [11, 9, 2, 1]
        lista.addFirst(9);
        lista.addFirst(11);
        assertEquals(11, (int)lista.getFirst());
        assertEquals(1, (int)lista.getLast());
    }
    
    @Test
    public void testAddGet() {
        LinkedList lista = new LinkedList();
        
        
        // índices inválidos.
        try {
            lista.add(1, 5);
            fail("Linha vazia.");
        } catch (IndexOutOfBoundsException e){}
        
        try {
            lista.add(0, 5);
            fail("Linha vazia.");
        } catch (IndexOutOfBoundsException e){}
        
        try {
            lista.add(-1, 5);
            fail("Linha vazia.");
        } catch (IndexOutOfBoundsException e){}
        
        
        // em head
        lista.addLast(5);
        lista.add(0, 10);
        assertEquals(10, (int)lista.getFirst());
        assertEquals(5, (int)lista.getLast());
        assertEquals(10, (int)lista.get(0));
        lista.add(0, 3);
        assertEquals(3, (int)lista.getFirst());
        assertEquals(5, (int)lista.getLast());
        assertEquals(3, (int)lista.get(0));
        assertEquals(10, (int)lista.get(1));
        assertEquals(5, (int)lista.get(2));
        
        // no meio
        lista.add(1, 4);
        assertEquals(3, (int)lista.get(0));
        assertEquals(4, (int)lista.get(1));
        assertEquals(2, (int)lista.get(2));
        assertEquals(1, (int)lista.get(3));
        assertEquals(3, (int)lista.getFirst());
        assertEquals(1, (int)lista.getLast());
        
        // em tail
        lista.add(3, 5);
        assertEquals(3, (int)lista.getFirst());
        assertEquals(5, (int)lista.getLast());
        
        // contains e indexOf
        assertTrue(lista.contains(5));
        assertEquals(-1, lista.indexOf(404));
        assertEquals(0, lista.indexOf(3));
        assertEquals(1, lista.indexOf(4));
        assertEquals(2, lista.indexOf(2));
        assertEquals(3, lista.indexOf(1));
        assertEquals(4, lista.indexOf(5));
        
    }
    
    @Test
    public void testRemove() {
        LinkedList lista = new LinkedList();
        
        
        // índices inválidos.
        try {
            lista.remove(0);
            fail("Linha vazia.");
        } catch (IndexOutOfBoundsException e){}
        
        try {
            lista.remove(1);
            fail("Linha vazia.");
        } catch (IndexOutOfBoundsException e){}
        
        try {
            lista.remove(-1);
            fail("Linha vazia.");
        } catch (IndexOutOfBoundsException e){}
        
        // aluno não está na lista e a lista está vazia
        assertFalse(lista.removeByValue(0));
        
        lista.addLast(1);
        // aluno não está na lista
        assertFalse(lista.removeByValue(7));
        
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(4);

        assertTrue(lista.removeByValue(1));
        assertFalse(lista.contains(1));
        assertEquals(2, (int)lista.getFirst());
        
        assertTrue(lista.removeByValue(4));
        assertFalse(lista.contains(4));
        assertEquals(4, (int)lista.getLast());
        
        assertTrue(lista.removeByValue(3));
        assertFalse(lista.contains(3));
        assertEquals(4, (int)lista.getLast());
        assertEquals(2, lista.size());
        
        // limpando
        lista.remove(4);
        assertEquals(2, (int)lista.getLast());
        assertEquals(2, (int)lista.getLast());
        lista.remove(2);
        
        assertTrue(lista.isEmpty());
        
        // adicionando novamente
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(4);
        lista.addLast(5);
        
        // removendo o primeiro
        lista.remove(0);
        assertFalse(lista.contains(1));
        assertEquals(2, (int)lista.getFirst());
        
        // removendo o último
        lista.remove(lista.size() - 1);
        assertFalse(lista.contains(5));
        assertEquals(4, (int)lista.getLast());
        
        // removendo o último
        lista.remove(1);
        assertFalse(lista.contains(3));
        assertEquals(2, (int)lista.getFirst());
        assertEquals(4, (int)lista.getLast());
        
        // limpando
        lista.remove(0);
        lista.remove(0);
        
        assertTrue(lista.isEmpty());
        assertTrue(lista.size() == 0);
        
        try {
            lista.getFirst();
            fail("Linha vazia.");
        } catch(NoSuchElementException e){}
        
        try {
            lista.getLast();
            fail("Linha vazia.");
        } catch(NoSuchElementException e){}   
    }
}