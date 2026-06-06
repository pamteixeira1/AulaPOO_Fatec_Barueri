public class Atividade2 {
    public static int somar (int a,  int b) {
        return a + b; 
    }
    public static void mostrarResultado(int resultado){ 
        System.out.println("Resultado: " + resultado); 
    }

    public static void main (String[] args){
        int resultado = somar(10,20); 
        mostrarResultado(resultado); 
    }
}


