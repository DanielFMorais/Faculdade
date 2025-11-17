import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor me informe o primeiro valor");
        int v1 = sc.nextInt();
        System.out.println("Por favor me informe o segundo valor");
        int v2 = sc.nextInt();

        try {
            double divisao = (double) v1 / v2;
            System.out.printf("O resultado da divisão = %.2f%n", divisao);
        } catch (ArithmeticException e) {
            System.out.println("ERRO: Valor dividido por zero");
        } finally {
            System.out.println("Finalizando código");
        }

        sc.close();
    }
}
