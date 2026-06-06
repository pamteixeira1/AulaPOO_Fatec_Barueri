import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor da compra");
        double valor = sc.nextDouble();
        double valorFinal;

        if (valor >= 100){
            valorFinal = valor * 0.9;
        }else{
            valorFinal = valor;
        }
        System.out.println("Valor final: R$ " + valorFinal);

        sc.close();
        
    }
}
