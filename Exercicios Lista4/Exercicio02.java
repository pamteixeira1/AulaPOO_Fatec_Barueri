import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        
      try (Scanner sc = new Scanner(System.in)) {
        int soma = 0;

        for (int i = 0; i < 10; i++) {
            soma += sc.nextInt();
}

        System.out.println(soma);
        sc.close();
        }
    }
}

