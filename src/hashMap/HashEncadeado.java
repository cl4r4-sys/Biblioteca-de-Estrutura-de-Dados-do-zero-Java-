import java.util.*;

public class HashEncadeado {
    
    private ArrayList<Cavalheiro>[] tabela;
    private static final int TAMANHO_DEFAULT = 5; // Número primo;
    private static final double FATOR_CARGA = 0.75;
    private int size;
    private int[] kays;
    private Cavalheiro[] values;

    /**
     * Construtor da classe HashEncadeado.
     * Inicializa a tabela de hash com o tamanho padrão.
     */
    @SuppressWarnings("unchecked")
    public HashEncadeado() {
        this.tabela = new ArrayList[TAMANHO_DEFAULT];
        this.size = 0;
        this.kays = new int[TAMANHO_DEFAULT];
        this.values = new Cavalheiro[TAMANHO_DEFAULT];
    }

    /*
     * Construtor da classe HashEncadeado.
     * Inicializa a tabela de hash com o tamanho especificado.
     */
    @SuppressWarnings("unchecked")
    public HashEncadeado(int tamanho) {
        this.tabela = new ArrayList[tamanho];
        this.size = 0;
        this.kays = new int[tamanho];
        this.values = new Cavalheiro[tamanho];
    }

    /**
     * Utiliza o método da divisão por primo para calcular o índice da tabela de hash 
     * para uma determinada chave, reduzindo a probabilidade de colisões.
     * @param chave A chave para a qual o índice da tabela de hash será calculado.
     * @return O índice da tabela de hash correspondente à chave fornecida.
     */
    public int hash(int chave) {
        return chave % this.tabela.length;
    }

    /**
     * Função put que verifica antes se o tamanho excedeu o fator de carga ou se a tabela está cheia, 
     * caso sim, redimensiona a tabela e redefine os arrays de chaves e valores.
     * @param novaChave -> A chave do novo Cavalheiro a ser adicionado.
     * @param novoCavalheiro -> O novo Cavalheiro a ser adicionado à tabela de hash.
     */
    public void put(int novaChave, Cavalheiro novoCavalheiro) {
        if ((this.size + 1) / this.tabela.length >= FATOR_CARGA || 
            this.size == this.tabela.length) {
            resize();
            redefinir();
        }

        put(novaChave, novoCavalheiro, this.tabela);
    }

    /**
     * Redefine os arrays de chaves e valores, reiniciando o tamanho da tabela de hash.
     */
    public void redefinir() {
        this.size = 0;
        this.kays = new int[this.tabela.length];
        this.values = new Cavalheiro[this.tabela.length];
    }

    /**
     * Insere um novo Cavalheiro na tabela de hash encadeada, lidando com colisões por meio de listas encadeadas,
     * garantindo que o acréscimo estará dentro do limite de capacidade.
     * Se a chave já existir, o valor correspondente será atualizado.
     * @param novaChave -> A chave do novo Cavalheiro a ser adicionado.
     * @param novoCavalheiro -> O novo Cavalheiro a ser adicionado à tabela de hash.
     * @param tabela -> A tabela de hash onde o novo Cavalheiro será inserido.
     */
    public void put(int novaChave, Cavalheiro novoCavalheiro, ArrayList<Cavalheiro>[] tabela) {
        int hash = hash(novaChave);

        if (tabela[hash] == null) {
            tabela[hash] = new ArrayList<>();
        } else {
            for (int i = 0; i < tabela[hash].size(); i++) {
                if (tabela[hash].get(i).getAsa() == novaChave) {
                    tabela[hash].set(i, novoCavalheiro);
                    return;
                }
            }
        }

        tabela[hash].add(novoCavalheiro);
        this.kays[this.size] = novaChave;
        this.values[this.size] = novoCavalheiro;
        this.size++;
    }

    /**
     * Redimensiona a tabela de hash, invocando o rehash.
     */
    @SuppressWarnings("unchecked")
    public void resize() {
        ArrayList<Cavalheiro>[] novaTabela = new ArrayList[this.tabela.length * 2];
        this.size = 0;
        rehash(novaTabela);
        this.tabela = novaTabela;
    }

    /**
     * Rehash os elementos da tabela de hash para uma nova tabela, garantindo que todos os elementos sejam redistribuídos de forma uniforme.
     * @param novaTabela -> A nova tabela de hash para onde os elementos serão rehashados.
     */
    public void rehash(ArrayList<Cavalheiro>[] novaTabela) {
        for (int i = 0; i < this.tabela.length; i++) {
            if (this.tabela[i] != null) {
                for (Cavalheiro cavalheiro : this.tabela[i]) {
                    put(cavalheiro.getAsa(), cavalheiro, novaTabela);
                }
            }
        }
    }

    /**
     * Retorna o Cavalheiro associado à chave especificada, ou null se a chave não existir.
     * @param chave -> A chave do Cavalheiro a ser retornado.
     * @return O Cavalheiro associado à chave, ou null se a chave não existir.
     */
    public Cavalheiro get(int chave) {
        int hash = hash(chave);

        if (this.tabela[hash] != null) {
            for (Cavalheiro cavalheiro : this.tabela[hash]) {
                if (cavalheiro.getAsa() == chave) {
                    return cavalheiro;
                }
            }
        }
        return null;
    }

    /**
     * Remove o Cavalheiro associado à chave especificada.
     * @param chave -> A chave do Cavalheiro a ser removido.
     */
    public void remove(int chave) {
        int hash = hash(chave);
        ArrayList<Cavalheiro> lista = this.tabela[hash];

        Iterator<Cavalheiro> iterator = lista.iterator();
        Cavalheiro aux = null;

        int i = 0;
        while (iterator.hasNext()) {
            aux = iterator.next();
            if (aux.getAsa() == chave) {
                iterator.remove();

                this.kays[i] = 0; 
                this.values[i] = null;

                i++;
                this.size--;
                return;
            }
        }
    }

    /**
     * @return Uma string representando o conjunto de entradas.
     */
    public String entrySet() {
        return Arrays.toString(tabela);
    }

    /**
     * @return Uma string representando o conjunto de chaves.
     */
    public String keySet() {
        return Arrays.toString(kays);
    }

    /**
     * @return Uma string representando o conjunto de valores.
     */
    public String values() {
        return Arrays.toString(values);
    }
}