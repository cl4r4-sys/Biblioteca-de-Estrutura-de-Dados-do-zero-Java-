package src.FIFO;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class AssertsFila {

    static Fila fila;

    @BeforeEach
    public void setup() {
        fila = new Fila(3);
    }
    
    @Test
    public void isEmptyTest() {
        assertTrue(fila.isEmpty());
        assertFalse(!fila.isEmpty());
        
        fila.addLast(1);
        fila.addLast(2);
        assertFalse(fila.isEmpty());
        
        fila.removeFirst();
        fila.removeFirst();
        assertTrue(fila.isEmpty());
    }

    @Test
    public void isFullTest() {
        fila.addLast(1);
        fila.addLast(2);
        fila.addLast(3);
        assertTrue(fila.isFull());
        assertEquals(3, fila.size());

        fila.removeFirst();
        assertFalse(fila.isFull());

        fila.addLast(null);
        assertTrue(fila.isFull());
    }

    @Test
    public void removeFirstTest() {
        fila.addLast(1);
        assertEquals(fila.getFirst(), 1);
        assertEquals(fila.getLast(), 1);
        
        fila.removeFirst();
        assertTrue(fila.isEmpty());

        fila.addLast(1);
        fila.addLast(3);
        fila.addLast(4);
        assertTrue(fila.isFull());

        fila.removeFirst();
        fila.removeFirst();
        fila.removeFirst();
        assertTrue(fila.isEmpty());
    }

    @Test
    public void addLastTest() {
        fila.addLast(1);
        assertEquals(1, fila.size());

        fila.addLast(3);
        fila.addLast(4);
        assertTrue(fila.isFull());
        assertEquals(3, fila.size());
        assertEquals("1, 3, 4", fila.toString());

        try {
            fila.addLast(5);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Fila cheia.");
        }

        fila.removeFirst();
        fila.removeFirst();
        assertEquals(1, fila.size());

        fila.addLast(5);
        fila.addLast(6);
        assertEquals("7, 5, 6", fila.toString());
        assertEquals(7, fila.getFirst());
        assertEquals(6, fila.getLast());
    }

}