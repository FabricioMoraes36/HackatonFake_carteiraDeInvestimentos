import java.time.LocalDateTime;

public class Operacao {
        private String tipo;
        private String ativo;
        private int quantidade;
        private double precoUnitario;
        private LocalDateTime data;

        public Operacao(String tipo, String ativo, int quantidade, double precoUnitario) {
            this.tipo = tipo;
            this.ativo = ativo;
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.data = LocalDateTime.now();
        }

        @Override
        public String toString() {
            return data + " | " + tipo + " | " + ativo +
                    " | Qtd: " + quantidade +
                    " | Preço: " + precoUnitario;
        }
    }
