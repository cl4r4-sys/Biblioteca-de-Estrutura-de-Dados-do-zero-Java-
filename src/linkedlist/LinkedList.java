import java.util.*;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    /**
     * Construtor da classe LinkedList.
     * Inicializa a lista como vazia e o head e o tail como nulos.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Verifica se a lista está vazia.
     * @return true caso esteja, false caso contrário.
     */
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * Adiciona um elemento no início da lista.
     * @param v -> valor a ser adicionado.
     */
    public void addFirst(int v) {
        Node aux = new Node(v);
        
        if (isEmpty()) {
            this.head = aux;
            this.tail = aux;
        } else {
            this.head.prev = aux;
            aux.next = this.head;
            this.head = aux;
        }

        this.size++;
    }

    /**
     * Adiciona um elemento no final da lista.
     * @param v -> valor a ser adicionado.
     */
    public void addLast(int v) {
        Node aux = new Node(v);
        
        if (isEmpty()) {
            this.head = aux;
            this.tail = aux;
        } else {
            this.tail.next = aux;
            aux.prev = this.tail;
            this.tail = aux;
        }

        this.size++;
    }

    /**
     * Adiciona um elemento em um índice específico da lista.
     * @param index -> índice onde o elemento será adicionado.
     * @param v -> valor a ser adicionado.
     * @throws IndexOutOfBoundsException caso o índice seja inválido.
     */
    public void add(int index, int v) {
        if (index < 0 || index >= this.size()) throw new IndexOutOfBoundsException();

        if (index == 0) addFirst(v);
        else if (index == this.size - 1) addLast(v);
        else {
            Node novo = new Node(v);
            Node aux = this.head;
            for (int i = 0; i < index - 1; i++) aux = aux.next;

            novo.next = aux.next;
            aux.next = novo;
            novo.prev = aux;
            novo.next.prev = novo;

            this.size++;
        }
    }

    /**
     * Retorna o primeiro elemento da lista.
     * @return o valor do primeiro elemento.
     * @throws NoSuchElementException caso a lista esteja vazia.
     */
    public int getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.head.value;
    }

    /**
     * Retorna o último elemento da lista.
     * @return o valor do último elemento.
     * @throws NoSuchElementException caso a lista esteja vazia.
     */
    public int getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.tail.value;
    }

    /**
     * Retorna o elemento de um índice específico da lista.
     * @param index -> índice do elemento a ser retornado.
     * @return o valor do elemento no índice especificado.
     * @throws IndexOutOfBoundsException caso o índice seja inválido.
     * @throws NoSuchElementException caso a lista esteja vazia.
     */
    public int get(int index) {
        if (index < 0 || index >= this.size()) throw new IndexOutOfBoundsException();
        if (isEmpty()) throw new NoSuchElementException();

        if (index == 0) getFirst();
        else if (index == this.size - 1) getLast();
        else {
            Node aux = this.head;
            for (int i = 0; i < index - 1; i++) aux = aux.next;
            return aux.value;
        }

        return -1;
    }

    /**
     * Remove o primeiro elemento da lista.
     * @return o valor do elemento removido.
     * @throws NoSuchElementException caso a lista esteja vazia.
     */
    public int removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        int retorno = this.head.value;

        this.head.next.prev = null;
        this.head = this.head.next;
        this.size--;
        return retorno;
    }

    /**
     * Remove o último elemento da lista.
     * @return o valor do elemento removido.
     * @throws NoSuchElementException caso a lista esteja vazia.
     */
    public int removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        int retorno = this.tail.value;

        this.tail.prev.next = null;
        this.tail = this.tail.prev;
        this.size--;
        return retorno;
    }

    /**
     * Remove o elemento de um índice específico da lista.
     * @param index -> índice do elemento a ser removido.
     * @return o valor do elemento removido.
     * @throws IndexOutOfBoundsException caso o índice seja inválido.
     * @throws NoSuchElementException caso a lista esteja vazia.
     */
    public int remove(int index) {
        if (index < 0 || index >= this.size()) throw new IndexOutOfBoundsException();
        if (isEmpty()) throw new NoSuchElementException();

        if (index == 0) return removeFirst();
        else if (index == this.size - 1) return removeLast();
        else {
            Node aux = this.head;
            for (int i = 0; i < index - 1; i++) aux = aux.next;

            int retorno = aux.next.value;
            aux.next = aux.next.next;
            aux.next.prev = aux;

            this.size--;
            return retorno;
        }
    }

    /**
     * Remove o elemento com um valor específico da lista.
     * @param v -> valor do elemento a ser removido.
     * @return true se o elemento foi removido, false caso contrário.
     * @throws NoSuchElementException caso a lista esteja vazia.
     */
    public boolean removeByValue(int v) {
        if (isEmpty()) throw new NoSuchElementException();

        if (v == this.head.value) {
            removeFirst();
            return true;
        }
        else if (v == this.tail.value) {
            removeLast();
            return true;
        } else {
            Node aux = this.head;
            for (int i = 0; i < this.size - 2; i++) {
                aux = aux.next;
                if (aux.value == v) {

                    aux.next = aux.next.next;
                    aux.next.prev = aux;

                    this.size--;
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * Retorna a primeira ocorrência de um elemento em específico da lista.
     * @param v -> valor do elemento a ser analisado.
     * @return o índice do elemento, ou -1 se não encontrado.
     * @throws NoSuchElementException caso a lista esteja vazia.
     */
    public int indexOf(int v) {
        if (isEmpty()) throw new NoSuchElementException();

        Node aux = this.head;
        for (int i = 0; i < this.size; i++) {
            if (aux.value == v) return i;
            aux = aux.next;
        }

        return -1;
    }

    /**
     * Verifica se um elemento específico está presente na lista.
     * @param v -> valor do elemento a ser verificado.
     * @return true se o elemento estiver presente, false caso contrário.
     * @throws NoSuchElementException caso a lista esteja vazia.
     */
    public boolean contains(int v) {
        if (isEmpty()) throw new NoSuchElementException();

        Node aux = this.head;
        for (int i = 0; i < this.size; i++) {
            if (aux.value == v) return true;
            aux = aux.next;
        }

        return false;
    }

    /**
     * Retorna a última ocorrência de um elemento em específico da lista.
     * @param v -> valor do elemento a ser analisado.
     * @return o índice do elemento, ou -1 se não encontrado.
     * @throws NoSuchElementException caso a lista esteja vazia.
     */
    public int lastIndexOf(int v) {
        if (isEmpty()) throw new NoSuchElementException();

        Node aux = this.tail;
        for (int i = this.size - 1; i >= 0; i--) {
            if (aux.value == v) return i;
            aux = aux.prev;
        }

        return -1;
    }

    /**
     * @return uma representação em string da lista.
     */
    public String toString() {
        String retorno = "";
        Node aux = this.head;
        for (int i = 0; i < this.size; i++) {
            if (aux != null) retorno += Integer.toString(aux.value) + ", ";
            aux = aux.next;
        }

        return retorno.equals("") ? retorno : retorno.substring(0, retorno.length() - 2);
    }

    /**
     * @return o número de elementos na lista.
     */
    public int size() {
        return this.size;
    }
}

class Node {

    int value;
    Node prev;
    Node next;

    public Node(int v) {
        this.value = v;
        this.prev = null;
        this.next = null;
    }
}