import java.util.Scanner;

public class Atividade5 {
    public static void mostrarMenu() {
        System.out.println("1 - Somar");
        System.out.println("2 - Subtrair");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");
    }
    public static double lerNumero(Scanner scanner) {
    System.out.print("Digite um número: ");
            return scanner.nextDouble();
}
    public static double somar(double a, double b) {
    return a + b;
}
    public static double subtrair(double a, double b) {
    return a - b;
}
    public static double multiplicar(double a, double b) {
    return a * b;
}
    public static double dividir(double a, double b) {
        if (b == 0) {
        System.out.println("Erro: divisão por zero.");
    return 0;
}
    return a / b;
}
        public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            mostrarMenu();
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            double n1 = lerNumero(scanner);
            double n2 = lerNumero(scanner);
            switchitch (o {
                case 1:
                    case 1 -> System.out.println("Resultado: " + somar
                    break;
                case .:
                    case 3 -> System.out.println("Resultado: " + multipli
                    break;
                case .:
                    default -> System.out.println("Opção inválida.");
                    break
}  case 4:
                    System.out.println("Resultado: " + dividir(n1, n2));
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
 }

