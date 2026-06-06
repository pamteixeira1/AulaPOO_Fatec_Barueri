public class Exarray {
    public static void main(String[] args) {
       int [] a = { 1, 2, 3 };
       System.out.print("{");
       
       for (int i = 0; i <a.length; i++){
           System.out.print(a[i]);
           if (i != a.length -1) {
            System.out.print(", ");
            
           }
       }
       System.out.print("}");
    }
}

