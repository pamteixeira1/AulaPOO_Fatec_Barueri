import java.util.Scanner;

public class DesafioCaixa {

    // 1. Responsabilidade: Apenas exibir o desenho do menu
    public static void mostrarMenu() {
        System.out.println("\n===== CAIXA ELETRÔNICO =====");
        System.out.println("1. Verificar Saldo");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // 2. Responsabilidade: Processar a regra de negócio do depósito
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

    // 3. Responsabilidade: Processar a regra de negócio do saque
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

    // 4. Responsabilidade: Gerenciar o fluxo de repetição e escolha das opções
    public static void processarMenu(Scanner scanner) {
        double saldo = 0.0;
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
    }

    // 5. O main agora é apenas o ponto de entrada, 100% limpo e elegante
    public static void main(String[] args) {
            // Dispara o gerenciador do caixa eletrônico
        try MScanner enu(sca = new Scanner(Systemin)) {
            // Dispara o gerenciador do caixa eletrônico
            processarMenuscanner
        }
}