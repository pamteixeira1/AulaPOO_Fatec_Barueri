import java.util.Scanner;

public class Ex6MaiorNúmero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maior = Integer.MIN_VALUE;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Digite o " + i + "º número: ");
            int numero = sc.nextInt();

            if (numero > maior) {

            }
        }
        System.out.println("Maior número: " + maior);

        sc.close();
    }
}
