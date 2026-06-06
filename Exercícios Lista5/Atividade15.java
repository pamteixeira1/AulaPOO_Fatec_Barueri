import java.util.Random;
import java.util.Scanner;

public class Atividade15 {

    // Função para iniciar e dar as boas-vindas
    public static void iniciarJogo() {
        System.out.println("=========================================");
        System.out.println("   BEM-VINDO AO JOGO DE ADIVINHAÇÃO!   ");
        System.out.println("=========================================");
        System.out.println("Eu pensei em um número entre 1 e 50.");
        System.out.println("Você tem 5 tentativas para adivinhar.");
        System.out.println("-----------------------------------------");
    }

    // Função para exibir o menu de opções após o fim de uma rodada
    public static void mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Jogar novamente");
        System.out.println("2. Sair do jogo");
        System.out.print("Escolha uma opção: ");
    }

    // Função para coletar o nome do jogador
    public static String criarJogador(Scanner scanner) {
        System.out.print("Digite o seu nome de jogador: ");
        return scanner.nextLine();
    }

    // Função que executa um turno (pede o palpite e dá as dicas)
    // Retorna true se o jogador acertar e false se errar
    public static boolean executarTurno(int numeroSecreto, int tentativaAtual, Scanner scanner) {
        System.out.print("Tentativa [" + tentativaAtual + "/5] - Digite seu palpite: ");
        int palpite = scanner.nextInt();

        if (palpite == numeroSecreto) {
            return true;
        } else if (palpite < numeroSecreto) {
            System.out.println("Dica: O número secreto é MAIOR!");
        } else {
            System.out.println("Dica: O número secreto é MENOR!");
        }
        return false;
    }

    // Função que verifica se o jogador ganhou ou perdeu e mostra o resultado
    public static void verificarVitoria(boolean acertou, String nomeJogador, int numeroSecreto) {
        System.out.println("\n-----------------------------------------");
        if (acertou) {
            System.out.println("PARABÉNS, " + nomeJogador + "!!! Você acertou!");
        } else {
            System.out.println("Que pena, " + nomeJogador + "... Suas tentativas acabaram.");
            System.out.println("O número secreto era: " + numeroSecreto);
        }
        System.out.println("-----------------------------------------");
    }

    // Função para finalizar o programa
    public static void encerrarJogo() {
        System.out.println("\nObrigado por jogar! Até a próxima.");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            int opcaoMenu;
            
            // Criação do jogador (executa apenas uma vez no início)
            String jogador = criarJogador(scanner);
            
            do {
                // Configurações iniciais da rodada
                iniciarJogo();
                int numeroSecreto = random.nextInt(50) + 1; // Gera um número de 1 a 50
                int tentativas = 1;
                boolean acertou = false;
                
                // Loop das tentativas do turno (máximo 5)
                while (tentativas <= 5 && !acertou) {
                    acertou = executarTurno(numeroSecreto, tentativas, scanner);
                    if (!acertou) {
                        tentativas++;
                    }
                }
                
                // Verifica e exibe o resultado da rodada
                verificarVitoria(acertou, jogador, numeroSecreto);
                
                // Pergunta se deseja continuar
                mostrarMenu();
                opcaoMenu = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do teclado
                
            } while (opcaoMenu == 1);
            
            encerrarJogo();
        }
    }
}