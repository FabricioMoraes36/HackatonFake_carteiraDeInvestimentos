import java.util.Objects;

public class Investidor {
    private String nome, cpf;

    public Investidor(String nome, String cpf) { this.nome = nome; this.cpf = cpf; }
    public String getCpf() { return cpf; }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Investidor that = (Investidor) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() { return nome + " (CPF: " + cpf + ")"; }

}