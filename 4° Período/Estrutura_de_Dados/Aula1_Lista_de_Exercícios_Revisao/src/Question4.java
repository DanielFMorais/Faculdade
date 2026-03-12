import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Question4 {

    public static int buscaBinaria(int[] vetor, int valor){
        int inicio = 0;
        int fim = vetor.length -1;
        
        while (inicio <= fim) {
            int meio = (inicio + fim) /2;

            if (vetor[meio] == valor){
                return meio;
            }
            
            if (valor < vetor[meio]){
                fim = meio -1;
            } else {
                inicio = meio +1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int vet[] = new int[20];

        for (int i = 0; i < vet.length; i++){
            vet[i] = r.nextInt(100);
        }

        Arrays.sort(vet);

        for (int i : vet){
            System.out.print(i + " ");
        }

        System.out.println("\n\nQual valor você quer encontrar?");
        int v = sc.nextInt();

        if (buscaBinaria(vet, v) == -1){
            System.out.println("O valor informado não esta presente no vetor.");
        } else {
            System.out.printf("O valor %d esta na posição %d do vetor.",v,buscaBinaria(vet, v));
        }

        sc.close();
    }

}
