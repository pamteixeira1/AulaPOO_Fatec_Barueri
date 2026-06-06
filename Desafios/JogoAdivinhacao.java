import java.util.Scanner;

public class JogoAdivinhacao {

    private static final int REVELAR_NUMERO = 100; 
    private static final int MAX_TENTATIVAS = 10; 

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numeroSecreto = (int) (Math.random() * REVELAR_NUMERO) + 1;
            
            System.out.println("==============================================");
            System.out.println("🎯 BEM-VINDO AO JOGO DA ADIVINHAÇÃO NUMÉRICA! 🎯");
            System.out.println("==============================================");
            System.out.println("O computador pensou em um número entre 1 e 100.");
            System.out.println("Você tem " + MAX_TENTATIVAS + " tentativas para acertar.");
            
            System.out.println("\nEscolha a versão do laço que deseja testar:");
            System.out.println("1 - Versão com laço 'FOR'");
            System.out.println("2 - Versão com laço 'WHILE'");
            System.out.println("3 - Versão com laço 'DO/WHILE'");
            System.out.print("Sua opção: ");
            int opcao = scanner.nextInt();
            
            System.out.println("\n--- INICIANDO A PARTIDA ---");
            
            // CORREÇÃO: Chamadas batendo exatamente com o nome dos métodos abaixo
            switch (opcao) {
                case 1 -> executarVersaoFor(scanner, numeroSecreto);
                case 2 -> executarVersaoWhile(scanner, numeroSecreto);
                case 3 -> executarVersaoDoWhile(scanner, numeroSecreto);
                default -> {
                    System.out.println("Opção inválida! Executando a versão padrão (FOR)...");
                    executarVersaoFor(scanner, numeroSecreto);
                }
            }
        }
    }

    /**
     * VERSÃO 1: Usando laço 'FOR'
     */
    public static void executarVersaoFor(Scanner scanner, int numeroSecreto) {
        System.out.println("[Modo: Laço FOR]");
        boolean acertou = false;

        for (int tentativa = 1; tentativa <= MAX_TENTATIVAS; tentativa++) {
            int palpite = obterPalpiteValido(scanner, tentativa);

            if (palpite == numeroSecreto) {
                System.out.println("🎉 Você acertou! Parabéns!");
                acertou = true;
                break; 
            } else {
                fornecerDica(palpite, numeroSecreto);
            }
        }

        if (!acertou) {
            System.out.println("\n😢 Fim das tentativas! O número secreto era: " + numeroSecreto);
        }
    }

    /**
     * VERSÃO 2: Usando laço 'WHILE'
     */
    public static void executarVersaoWhile(Scanner scanner, int numeroSecreto) {
        System.out.println("[Modo: Laço WHILE]");
        int tentativa = 1;
        boolean acertou = false;

        while (tentativa <= MAX_TENTATIVAS && !acertou) {
            int palpite = obterPalpiteValido(scanner, tentativa);

            if (palpite == numeroSecreto) {
                System.out.println("🎉 Você acertou! Parabéns!");
                acertou = true;
            } else {
                fornecerDica(palpite, numeroSecreto);
                tentativa++; 
            }
        }

        if (!acertou) {
            System.out.println("\n😢 Fim das tentativas! O número secreto era: " + numeroSecreto);
        }
    }

    /**
     * VERSÃO 3: Usando laço 'DO/WHILE'
     */
    public static void executarVersaoDoWhile(Scanner scanner, int numeroSecreto) {
        System.out.println("[Modo: Laço DO/WHILE]");
        int tentativa = 1;
        boolean acertou = false;

        do {
            int palpite = obterPalpiteValido(scanner, tentativa);

            if (palpite == numeroSecreto) {
                System.out.println("🎉 Você acertou! Parabéns!");
                acertou = true;
            } else {
                fornecerDica(palpite, numeroSecreto);
                tentativa++; 
            }

        } while (tentativa <= MAX_TENTATIVAS && !acertou);

        if (!acertou) {
            System.out.println("\n😢 Fim das tentativas! O número secreto era: " + numeroSecreto);
        }
    }

    private static void fornecerDica(int palpite, int numeroSecreto) {
        if (palpite > numeroSecreto) {
            System.out.println("❌ O número secreto é menor!");
        } else {
            System.out.println("❌ O número secreto é maior!");
        }
    }

    private static int obterPalpiteValido(Scanner scanner, int tentativa) {
        int palpite;
        while (true) {
            System.out.print("\n[Tentativa " + tentativa + "/" + MAX_TENTATIVAS + "] Digite seu palpite (1-100): ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("⚠ Entrada inválida! Digite apenas números inteiros.");
                System.out.print("[Tentativa " + tentativa + "/" + MAX_TENTATIVAS + "] Digite seu palpite (1-100): ");
                scanner.next();
            }
            
            palpite = scanner.nextInt();

            if (palpite >= 1 && palpite <= 100) {
                break; 
            } else {
                System.out.println("⚠ Atenção! Seu palpite deve estar EXATAMENTE entre 1 e 100.");
            }
        }
        return palpite;
    }
}