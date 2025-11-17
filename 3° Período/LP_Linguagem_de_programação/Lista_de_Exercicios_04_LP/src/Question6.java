import java.util.InputMismatchException;
import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{

            //Dividindo dous números
            System.out.print("Por favor me informe o valor 1: ");  
            int valor1 = sc.nextInt();
            System.out.print("Por favor me informe o valor 2: ");
            int valor2 = sc.nextInt();

            double divisão = (double) valor1 / valor2;

            System.out.printf("A divisão de %d e %d = %.2f\n\n",valor1, valor2, divisão);

            //Operação com Array
            int [] teste = {10,20,30,40};

            for (int n : teste){
                System.out.printf("%d ", n);
            }

            System.out.println("\n\nVocê quer acessar qual posição do vetor?");
            int posicao = sc.nextInt();
            System.out.printf("A posição %d possui o valor: %d", posicao, teste[posicao -1]);

        } catch (ArithmeticException e) {
            System.out.println("ERRO: !!Não é possivel realizar divisões por zero!!");
        } catch (InputMismatchException e){
            System.out.println("ERRO: !!O o valor digitado não é um valor numérico!!");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("O valor para o Array digitado é inválido, o array possui somente 4 posições (1-4)");
        }

        sc.close();
    }
}
