package src.FIFO;

import java.util.Arrays;

public class Fila {
    
    private int[] fila;
    private int head;
    private int tail;
    private int size;

    /**
     * Construtor da classe Fila.
     * @param capacidade -> Capacidade máxima da fila.
     */
    public Fila(int capacidade) {
        this.fila = new int[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    /**
     * Verifica se a fila está vazia.
     * @return true se a fila estiver vazia, false caso contrário.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Verifica se a fila está cheia.
     * @return true se a fila estiver cheia, false caso contrário.
     */
    public boolean isFull() {
        return this.size == this.fila.length;
    }

    /**
     * Adiciona um elemento no final da fila.
     * @param v -> Valor a ser adicionado na fila.
     */
    public void addFirst(int v) {
        if (isFull()) this.head = (this.head + 1) % this.fila.length;
        else {
            if (isEmpty()) this.head = 0;
            this.size++;
        }

        this.tail = (this.tail + 1) % this.fila.length;
        this.fila[this.tail] = v;
    }

    /**
     * @return O valor do primeiro elemento removido.
     */
    public int removeFirst() {
        if (isEmpty()) throw new RuntimeException();
        
        int v = this.fila[this.head];
        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else this.head = (this.head + 1) % this.fila.length;

        this.size--;
        return v;
    }

    /**
     * @return O valor do primeiro elemento da fila sem removê-lo.
     */
    public int getFirst() {
        if (isEmpty()) throw new RuntimeException();
        return this.fila[this.head];
    }

    /**
     * @return O valor do último elemento da fila sem removê-lo.
     */
    public int getLast() {
        if (isEmpty()) throw new RuntimeException();
        return this.fila[this.tail];
    }

    /**
     * Verifica se a fila contém um determinado valor.
     * @param v -> Valor a ser verificado.
     * @return true se a fila contiver o valor, false caso contrário.
     */
    public boolean contains(int v) {
        if (isEmpty()) return false;

        for (int i = 0; i < this.size; i++) {
            int index = (this.head + i) % this.fila.length;
            if (this.fila[index] == v) return true;
        }

        return false;
    }

    /**    
     * @return Uma representação em string da fila.
     */
    public String toString() {
       return Arrays.toString(this.fila);
    }

    /**
     * @return O tamanho atual da fila.
     */
    public int size() {
        return this.size;
    }

    /**
     * Retorna o índice da primeira ocorrência com o valor solicitado.
     * @param v -> Valor a ser procurado.
     * @return O índice do primeiro elemento com o valor especificado, ou -1 se não encontrado.
     */
    public int indexOf(int v) {
        if (isEmpty()) return -1;

        for (int i = 0; i < this.size; i++) {
            int index = (this.head + i) % this.fila.length;
            if (this.fila[index] == v) return index;
        }

        return -1;
    }
}
