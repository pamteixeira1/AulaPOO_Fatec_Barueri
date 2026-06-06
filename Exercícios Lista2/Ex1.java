import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número inteiro: ");
        int número = sc.nextInt();

        if (número > 0) {
            System.out.println("positivo");
            }else if (número < 0) {
            System.out.println("negativo");
            }else
            System.err.println("Zero");  
            sc.close();
              
    }
}
