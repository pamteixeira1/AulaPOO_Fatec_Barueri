import java.util.Scanner;

public class Ex10Somaatedigitarzero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int soma = 0;
        int numero;

        do {
            System.out.print("Digite um número ou 0 para sair: ");
            numero = sc.nextInt();
            soma += numero;
        } while (numero != 0);

        System.out.println("Soma total: " + soma);

    }
}
