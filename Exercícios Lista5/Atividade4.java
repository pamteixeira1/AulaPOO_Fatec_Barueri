import java.util.Scanner;

public class Atividade4 {

    public static double lerNota(Scanner scanner) {
        System.out.print("Digite a nota: ");
        return scanner.nextDouble();
    }

    public static double calcularMedia(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3;
    }

    public static String verificarSituacao(double media) {
        if (media >= 6) {
            return "Aprovado";
        } else if (media >= 4) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    public static void mostrarResultado(double media, String situacao) {
        System.out.println("Média: " + media);
        System.out.println("Situação: " + situacao);
    }

    public static void main(String[] args) {
        // Lendo as 3 notas
        try (Scanner scanner = new Scanner(System.in)) {
            // Lendo as 3 notas
            double n1 = lerNota(scanner);
            double n2 = lerNota(scanner);
            double n3 = lerNota(scanner);
            
            // Calculando a média passando as notas coletadas
            double media = calcularMedia(n1, n2, n3);
            
            // Verificando a situação com base na média calculada
            String situacao = verificarSituacao(media);
            
            // Mostrando o resultado na tela
            mostrarResultado(media, situacao);
        }
    } // Aqui fecha o método main de verdade
} // Aqui fecha a classe Atividade4