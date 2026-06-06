import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o primeiro número: ");
        double a = sc.nextDouble();

        System.out.println("Digite o segundo número: ");
        double b = sc.nextDouble();

        System.out.println("Digite a operação (+, -, *, /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+':
                System.out.println("Resultado: " + (a + b));
                break;
            case '-':
                System.out.println("Resuldo: " + (a - b));
                break;
            case '*':
                System.out.println("Resultado: " + (a * b));
                break;
            case '/':
                System.out.println("Resultado: " + (a / b));
                
                if (b != 0) {
                    System.out.println("Resultado: " + (a / b));
                }
                else {
                    System.out.println("Divisão por zero não é permitida");
                }
                break;
            default:
                System.out.println("Operação inválida");

                }

    sc.close ();
    }

}
