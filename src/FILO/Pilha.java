public class Pilha {

    private int[] pilha;
    private int top;

    /**
     * Construtor da classe Pilha.
     * @param capacidade A capacidade máxima da pilha.
     */
    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.top = -1;
    }

    /**
     * Verifica se a pilha está vazia.
     * @return true se a pilha estiver vazia, false caso contrário.
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * Verifica se a pilha está cheia.
     * @return true se a pilha estiver cheia, false caso contrário.
     */
    public boolean isFull() {
        return this.top == this.pilha.length - 1;
    }

    /**
     * Adiciona um elemento ao topo da pilha.
     * @param value O valor a ser adicionado.
     */
    public void push(int value) {
        if (isFull())  throw new RuntimeException("Pilha cheia.");
        this.pilha[++this.top] = value;
    }

    /**
     * Remove e retorna o elemento do topo da pilha.
     * @return O elemento do topo da pilha.
     */
    public int pop() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia.");
        return this.pilha[this.top--];
    }

    /**
     * Retorna o elemento do topo da pilha sem removê-lo.
     * @return O elemento do topo da pilha.
     */
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia");
        return this.pilha[this.top];
    }

    /**
     * @return o tamanho atual da pilha.
     */
    public int size() {
        return this.top + 1;
    }
}