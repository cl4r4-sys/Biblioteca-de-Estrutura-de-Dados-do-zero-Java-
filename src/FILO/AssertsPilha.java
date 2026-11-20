public class AssertsPilha {

    public static void main(String[] args) {
        Pilha pilha = new Pilha(3);
        assert pilha.isEmpty();
        assert !pilha.isFull();
        assert pilha.size() == 0; 
        
        pilha.push(1);
        assert 1 == pilha.peek();
        assert pilha.size() == 1; 

        pilha.push(2);
        assert 2 == pilha.peek();
        assert 2 == pilha.size();

        assert pilha.pop() == 2;
        assert 1 == pilha.size();
        assert 1 == pilha.peek();

        pilha.push(3);
        pilha.push(4);

        assert pilha.peek() == 4;
        assert 3 == pilha.size();
        assert pilha.pop() == 4;
        assert pilha.pop() == 3;
        assert pilha.pop() == 1;
        assert pilha.isEmpty();

    }
}