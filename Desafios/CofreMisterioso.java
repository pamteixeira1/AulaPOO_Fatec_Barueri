import java.util.Random;
import java.util.Scanner;

public class CofreMisterioso {

    // Adicionado 'final' para limpar o aviso amarelo (warning) da linha 7
    private static final Scanner scanner = new Scanner(System.in);
    private static int pontuacaoTotal = 0; 

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("🔒 BEM-VINDO AO DESAFIO DO COFRE MISTERIOSO! 🔒");
        System.out.println("=========================================");

        boolean jogarNovamente = true;

        // Laço 'while' para manter o jogo ativo
        while (jogarNovamente) {
            int maxIntervalo = escolherDificuldade();
            int numeroSecreto = 1 + new Random().nextInt(maxIntervalo);
            int totalTentativas = 5;
            boolean acertou = false;
            int pontosRodada = 10; 

            System.out.println("\n🔐 O cofre foi trancado! Um número de 1 a " + maxIntervalo + " foi gerado.");
            System.out.println("Você tem " + totalTentativas + " tentativas para decifrar o código.");

            // Laço 'for' para controlar as tentativas
            for (int tent = 1; tent <= totalTentativas; tent++) {
                System.out.print("\n[Tentativa " + tent + "/" + totalTentativas + "] Seu palpite: ");
                int palpite = lerNumeroValido();

                if (palpite == numeroSecreto) {
                    acertou = true;
                    pontuacaoTotal += pontosRodada; 
                    exibirFeedbackVitoria(tent);
                    break; 
                } else {
                    pontosRodada = Math.max(0, pontosRodada - 2); 
                    
                    int restam = totalTentativas - tent;
                    if (restam > 0) {
                        if (palpite < numeroSecreto) {
                            System.out.println("🔺 O código secreto é MAIOR que " + palpite + ".");
                        } else {
                            System.out.println("🔻 O código secreto é MENOR que " + palpite + ".");
                        }
                        System.out.println("Restam " + restam + " tentativas.");
                    }
                }
            }

            if (!acertou) {
                System.out.println("\n💥 Blam! As tentativas acabaram. O cofre bloqueou permanentemente!");
                System.out.println("🕵️‍♂️ O código secreto era: " + numeroSecreto);
            }

            System.out.println("🏆 Pontuação atual: " + pontuacaoTotal + " pontos.");

            // Laço 'do-while' para validar a resposta de jogar novamente
            char resposta;
            do {
                System.out.print("\nDeseja jogar novamente? (s/n): ");
                String entrada = scanner.next().trim().toLowerCase();
                resposta = entrada.isEmpty() ? ' ' : entrada.charAt(0);

                if (resposta != 's' && resposta != 'n') {
                    System.out.println("❌ Entrada inválida. Por favor, digite apenas 's' para sim ou 'n' para não.");
                }
            } while (resposta != 's' && resposta != 'n');

            if (resposta == 'n') {
                jogarNovamente = false;
            }
        }

        System.out.println("\n=========================================");
        System.out.println("🎮 FIM DE JOGO!");
        System.out.println("🌟 Pontuação final consolidada: " + pontuacaoTotal + " pontos.");
        System.out.println("Obrigado por jogar! Até a próxima.");
        System.out.println("=========================================");
    }

    private static int escolherDificuldade() {
        while (true) {
            System.out.println("\nEscolha a dificuldade:");
            System.out.println("1 - Fácil (1 a 20)");
            System.out.println("2 - Médio (1 a 50)");
            System.out.println("3 - Difícil (1 a 100)");
            System.out.print("Sua opção [1-3]: ");
            
            int opcao = lerNumeroValido();
            if (opcao == 1) return 20;
            if (opcao == 2) return 50;
            if (opcao == 3) return 100;
            
            System.out.println("❌ Opção inválida! Escolha 1, 2 ou 3.");
        }
    }

    private static int lerNumeroValido() {
        while (!scanner.hasNextInt()) {
            System.out.println("❌ Entrada inválida! Letras ou símbolos não são permitidos.");
            System.out.print("Digite um número inteiro válido: ");
            scanner.next(); 
        }
        return scanner.nextInt();
    }

    private static void exibirFeedbackVitoria(int tentativa) {
        System.out.println("\n🎉 SUCESSO! O COFRE FOI ABERTO! 🎉");
        if (tentativa == 1) {
            System.out.println("🔮 Inacreditável! Você leu a mente do cofre? Acertou de primeira!");
        } else if (tentativa <= 3) {
            System.out.println("⚡ Excelente raciocínio lógico! Você é um mestre arrombador de cofres.");
        } else {
            System.out.println("😮 Ufa! Foi por pouco, mas sua persistência valeu a pena!");
        }
    }
}