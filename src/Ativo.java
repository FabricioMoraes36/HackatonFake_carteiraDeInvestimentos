public class Ativo {

        private String codigo;
        private int quantidade;
        private double precoMedio;

    public Ativo(String codigo, int quantidade, double precoMedio) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.precoMedio = precoMedio;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecoMedio() {
        return precoMedio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoMedio(double precoMedio) {
        this.precoMedio = precoMedio;
    }

    // Dica: ao comprar, recalcular precoMedio = (totalAnterior + totalCompra) / novaQtd

    }
