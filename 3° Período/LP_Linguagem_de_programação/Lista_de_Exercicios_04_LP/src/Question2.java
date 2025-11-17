import java.util.InputMismatchException;
import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor me informe um número: ");

        try {
            int valor = sc.nextInt();
            System.out.printf("Valor digitado = %d", valor);
        } catch (InputMismatchException e){
            System.out.println("ERRO: VALOR DIGITADO NÃO É UM NÚMERO");
        }finally{
            System.out.println("\n\n\nCódigo esta sendo finalizado!!!!");
        }

        sc.close();
    }

}
