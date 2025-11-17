import java.util.Scanner;

public class Question5 {

    public static double raizQuadrada (double valor){

        if (valor < 0){
            throw new IllegalArgumentException("Valor negativo não possui raíz quadrada");
        }
            
        return Math.sqrt(valor);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, me informe o número que deseja saber a raiz quadrada");
        double valor = sc.nextDouble();
        
        
        try{
            System.out.printf("A raiz quadrada de %.2f = %.2f\n", valor, raizQuadrada(valor));
        } catch (IllegalArgumentException e){
            System.out.printf("Erro: %s", e.getMessage());
        }

        sc.close();
    }

}
