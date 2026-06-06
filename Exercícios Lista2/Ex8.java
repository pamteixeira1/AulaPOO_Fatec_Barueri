import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Digite o usuário");
        String usuario = sc.nextLine();

        System.out.println("Digite a senha");
        String senha = sc.nextLine();

        if (usuario.equals ("admin") && senha.equals ("1234")){
            System.out.println("Acesso Permitido");
        }else {
            System.out.println("Acesso Negado");
        }
        sc.close();
    }
}
