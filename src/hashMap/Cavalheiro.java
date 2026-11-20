public class Cavalheiro {

    String nome;
    int asa;

    public Cavalheiro(String nome, int asa) {
        this.nome = nome;
        this.asa = asa;
    }

    public String getNome() {
        return nome;
    }

    public int getAsa() {
        return asa;
    }

    public int hashCode() {
        return nome.hashCode();
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cavalheiro other = (Cavalheiro) obj;
        return nome.equals(other.nome);
    }
}