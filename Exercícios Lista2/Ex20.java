import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o salário: ");
        double salário = sc.nextDouble();

        double imposto;

        if (salário <= 2000) {
            imposto = 0;
        }else if (salário <= 5000) {
            imposto = salário * 0.10;
        }else {
            imposto = salário * 0.20;
        }
        System.out.println("Imposto: R$ " + imposto);

        sc.close();
    }
}
