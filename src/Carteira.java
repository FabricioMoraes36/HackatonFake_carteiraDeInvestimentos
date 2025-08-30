import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carteira {
    private int numero;
    private Investidor titular;
    private double saldo;
    private Map<String, Ativo> ativos = new HashMap<>();
    private List<Operacao> operacoes = new ArrayList<>();

    public Carteira(int numero, Investidor titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    // Métodos:
    // - comprarAtivo(String codigo, int qtd, double preco)
    public void compararAtivo(String codigo,int quantidade,double preco) {
        Operacao op = new Operacao("Compra", codigo, quantidade, preco);
        double valor = quantidade * preco;
        if (saldo >= valor) {
            saldo -= valor;
        }else {
            System.out.println("Saldo insuficiente");
        }

        if (ativos.get(codigo) != null) {
            ativos.get(codigo);
            double precoMedio = ativos.get(codigo).getPrecoMedio();
            double precoMedioCalculo = ((ativos.get(codigo).getQuantidade() * ativos.get(codigo).getPrecoMedio())+(quantidade * preco))/(ativos.get(codigo).getQuantidade() + quantidade);
            precoMedio = precoMedioCalculo;
            ativos.get(codigo).setQuantidade(ativos.get(codigo).getQuantidade() + quantidade);
            ativos.get(codigo).setPrecoMedio(precoMedio);
            operacoes.add(op);
        } else {
            Ativo ativo = new Ativo(codigo, quantidade, preco);
            ativos.put(codigo, ativo);
            operacoes.add(op);
        }
    }
    // - venderAtivo(String codigo, int qtd, double preco)
    public void venderAtivo(String codigo,int quantidade,double preco){
        Ativo ativo = ativos.get(codigo);
        if (ativos.get(codigo) != null && ativos.get(codigo).getQuantidade() >= quantidade) {
            System.out.println("Você tem: " + ativo.getQuantidade() + " desse ativo");
            double valor = quantidade * preco;
            saldo += valor;
            ativo.setQuantidade(ativos.get(codigo).getQuantidade() - quantidade);
            if (ativo.getQuantidade() == 0) {
                ativos.remove(codigo);
            }
        }else {
            System.out.println("Não há ativos com esse codigo na carteira de ativos ou seu saldo não é suficiente!!");
        }


    }
    // - calcularValorTotal()
    public double calcularValorTotal(){
        double soma = 0;
        for (Ativo ativo : ativos.values()){
            soma += ativo.getQuantidade() * ativo.getPrecoMedio();
        }
        return soma;

    }
    // - mostrarHistorico()
    public void mostrrarHistorico(){
        for(Operacao op : operacoes){
            System.out.println(op.toString());
        }
    }
}
