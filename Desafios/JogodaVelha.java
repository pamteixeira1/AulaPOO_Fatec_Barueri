import java.util.Scanner;

public class JogodaVelha {

    // CORREÇÃO: Removido o 'util' incorreto e adicionado 'final' para limpar o warning do VS Code
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (scanner) {
            char[][] tabuleiro = new char[3][3];
            inicializarTabuleiro(tabuleiro);
            
            char jogadorAtual = 'X';
            boolean jogoAtivo = true;
            
            System.out.println("=== BEM-VINDO AO JOGO DA VELHA ===");
            
            while (jogoAtivo) {
                imprimirTabuleiro(tabuleiro);
                System.out.println("\nJogador atual: " + jogadorAtual);
                
                int[] jogada = lerJogada(tabuleiro);
                int linha = jogada[0];
                int coluna = jogada[1];
                
                tabuleiro[linha - 1][coluna - 1] = jogadorAtual;
                
                if (verificarVitoria(tabuleiro, jogadorAtual)) {
                    imprimirTabuleiro(tabuleiro);
                    System.out.println("\n🎉 Parabéns! O jogador " + jogadorAtual + " venceu!");
                    jogoAtivo = false;
                } else if (verificarEmpate(tabuleiro)) {
                    imprimirTabuleiro(tabuleiro);
                    System.out.println("\n⚖️ O jogo empatou! Deu velha!");
                    jogoAtivo = false;
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            }
        }
    }

    public static void inicializarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public static void imprimirTabuleiro(char[][] tabuleiro) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.printf(" (%c) | (%c) | (%c) \n", tabuleiro[i][0], tabuleiro[i][1], tabuleiro[i][2]);
            if (i < 2) {
                System.out.println("-----+-----+-----");
            }
        }
    }

    public static int[] lerJogada(char[][] tabuleiro) {
        int linha = 0;
        int coluna = 0;

        while (true) {
            try {
                System.out.print("Digite a linha (1-3): ");
                linha = scanner.nextInt();
                System.out.print("Digite a coluna (1-3): ");
                coluna = scanner.nextInt();

                if (linha < 1 || linha > 3 || coluna < 1 || coluna > 3) {
                    System.out.println("❌ Erro: Posição inválida! Escolha números de 1 a 3.");
                    continue;
                }

                if (tabuleiro[linha - 1][coluna - 1] != ' ') {
                    System.out.println("❌ Erro: Essa posição já está ocupada! Tente outra.");
                    continue;
                }

                break;

            } catch (Exception e) {
                System.out.println("❌ Erro: Entrada inválida! Digite apenas números inteiros.");
                scanner.nextLine();
            }
        }

        return new int[]{linha, coluna};
    }

    public static boolean verificarVitoria(char[][] tabuleiro, char jogador) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogador && tabuleiro[1][j] == jogador && tabuleiro[2][j] == jogador) {
                return true;
            }
        }

        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;
        }

        // CORREÇÃO: Simplificado o retorno para remover o warning de "if statement is redundant" na linha 126
        return tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador;
    }

    public static boolean verificarEmpate(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}