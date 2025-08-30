import java.util.*;

public class Main {
    private static Set<Investidor> investidores = new HashSet<>();
    private static Map<Integer, Carteira> carteiras = new HashMap<>();
    private static int numeroCarteira = 2001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== MENU CARTEIRA DE INVESTIMENTOS ===");
            System.out.println("1 - Cadastrar Investidor");
            System.out.println("2 - Criar Carteira");
            System.out.println("3 - Comprar Ativo");
            System.out.println("4 - Vender Ativo");
            System.out.println("5 - Consultar Valor da Carteira");
            System.out.println("6 - Histórico de Operações");
            System.out.println("7 - Listar Investidores");
            System.out.println("8 - Sair");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: //cadastrarInvestidor(sc);ok
                    System.out.println("Digite o nome do cliente");
                    String nome = sc.nextLine();
                    System.out.println("Digite o CPF do cliente: ");
                    String cpf = sc.nextLine();
                    Investidor investidor = new Investidor(nome,cpf);
                    investidores.add(investidor);
                    System.out.println("Cliente cadastrado com sucesso! Agora você faz parte do time de investidores!!");


                 break;
                case 2: //criarCarteira(sc);ok
                    System.out.println("Digite seu CPF: ");
                    for (Investidor inv : investidores) {
                        if (inv.getCpf().equals(sc.nextLine())) {
                            System.out.println("Perfeito!! Checamos que você ja faz parte do time de investidores");
                            System.out.println("Digite quanto quer colocar na sua carteira inicialmente:");
                            double valor = sc.nextDouble();
                            Carteira carteira = new Carteira(numeroCarteira,inv,valor);
                            carteiras.put(numeroCarteira,carteira);
                            System.out.println("Perfeito!! sua carteira tem o numero: " + numeroCarteira + " E tem o saldo inicial de: " + valor);
                            numeroCarteira++;
                        }else {
                            System.out.println("Não fez o cadastro ainda ;-; tente novamente apos realizar o cadastro!!");
                            continue;
                        }
                    }
                    break;
                case 3: //comprarAtivo(sc);ok
                    System.out.println("Digite o numero da sua carteira:");
                    int num = sc.nextInt();
                    Carteira carteira = carteiras.get(num);
                    System.out.println("Digite o codigo do ativo");
                    String codigo = sc.nextLine();
                    sc.nextLine();
                    System.out.println("DIgite a quantidade que deseja comprar");
                    int quantidade = sc.nextInt();
                    System.out.println("Digite o valor do ativo que quer comprar");
                    double valor = sc.nextDouble();
                    carteira.compararAtivo(codigo,quantidade,valor);
                    System.out.println("Ativo comprado com sucesso!");

                    break;
                case 4: //venderAtivo(sc);ok
                    System.out.println("Digite o numero da sua carteira:");
                    int numC = sc.nextInt();
                    Carteira carteira1 = carteiras.get(numC);
                    System.out.println("Digite o codigo do ativo");
                    String codigo1 = sc.nextLine();
                    System.out.println("DIgite a quantidade que deseja vender");
                    int quantidade1 = sc.nextInt();
                    System.out.println("Digite por quanto que vender");
                    double valor1 = sc.nextDouble();
                    carteira1.venderAtivo(codigo1,quantidade1,valor1);
                    System.out.println("Ativo vendido com sucesso!");
                    break;
                case 5: //consultarValorCarteira(sc);ok
                    System.out.println("Digite o numero da sua carteira:");
                    int numC2 = sc.nextInt();
                    if (carteiras.containsKey(numC2)) {
                        Carteira carteira2 = carteiras.get(numC2);
                        System.out.println("O valor da sua carteira está em: " + carteira2.calcularValorTotal());
                    }
                    break;
                case 6: //historicoOperacoes(sc);ok
                    System.out.println("Digite o numero da sua carteira: ");
                    int numC3 = sc.nextInt();
                    if (carteiras.containsKey(numC3)) {
                        Carteira carteira3 = carteiras.get(numC3);
                        carteira3.mostrrarHistorico();
                    }
                    break;
                case 7: //listarInvestidores();
                    for (Investidor i : investidores) {
                        System.out.println(i);
                    }
                    break;
                case 8:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }

}