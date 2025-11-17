import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        int [] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100);
        }

        for (int n : array){
            System.out.printf("%d ",n);
        }

        System.out.println("\n\nPor favor me informe um número para achar no array: ");

        try {
            int valor = sc.nextInt();
            System.out.printf("Valor digitado = %d\n", valor);
            System.out.printf("Valor referente em tal campo = %d\n", array[valor]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ERRO: O ARRAY NÃO VAI ATE ESTE VALOR");
            System.out.println("Valor máximo do Array = 4");
        }catch(InputMismatchException e){
            System.out.println("ERRO: VOCÊ DIGITOU UMA LETRA E NÃO UM INDICE QUE TEM QUE SER OBRIGATORIAMENTE UM NÚMERO");
        }
        finally{
            System.out.println("\n\n\nCódigo esta sendo finalizado!!!!");
        }

        sc.close();
    }

}
