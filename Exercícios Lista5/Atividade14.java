import java.util.Scanner;

public class Atividade14 {

    // Função para exibir as opções do menu
    public static void mostrarMenu() {
        System.out.println("\n===== CAIXA ELETRÔNICO =====");
        System.out.println("1. Verificar Saldo");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Função para realizar o depósito (retorna o saldo atualizado)
    public static double depositar(double saldoAtual, Scanner scanner) {
        System.out.print("Digite o valor do depósito: R$ ");
        double valor = scanner.nextDouble();
        
        if (valor > 0) {
            saldoAtual += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
        return saldoAtual;
    }

    // Função para realizar o saque (retorna o saldo atualizado)
    public static double sacar(double saldoAtual, Scanner scanner) {
        System.out.print("Digite o valor do saque: R$ ");
        double valor = scanner.nextDouble();
        
        if (valor > saldoAtual) {
            System.out.println("Saldo insuficiente para realizar o saque.");
        } else if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
        } else {
            saldoAtual -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        }
        return saldoAtual;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double saldo = 0.0; // Saldo inicial do cliente
            int opcao;
            
            do {
                mostrarMenu();
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1 -> System.out.println("Seu saldo atual é: R$ " + saldo);
                    case 2 -> saldo = depositar(saldo, scanner);
                    case 3 -> saldo = sacar(saldo, scanner);
                    case 4 -> System.out.println("Encerrando o sistema. Obrigado por utilizar o nosso caixa eletrônico!");
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 4);
        } // Saldo inicial do cliente
    }
}