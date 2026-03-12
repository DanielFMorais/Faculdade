import java.util.Random;

public class Question2 {
    public static void main(String[] args) {
        Random r = new Random();

        int[] vetor = new int[10];

        for (int i=0; i <vetor.length; i++){
            vetor[i] = r.nextInt(100) ;
        }

        //Mostrar Vetor
        System.out.print("Vetor: ");
        for (int item : vetor){
            System.out.print(item + " ");
        }

        int menor = vetor[0];
        int posicaoMenor = 0;
        int soma = 0;
        for (int i=0; i<vetor.length;i++){
            if (vetor[i] < menor ){
                menor = vetor[i];
                posicaoMenor = i;
            }

            soma+= vetor[i];
        }

        System.out.println("\n\nA soma dos valores do vetor = " + soma);
        System.out.printf("O vator com menor valor esta na posição %d, sendo o valor %d\n\n", posicaoMenor, vetor[posicaoMenor]);

        int vetor2[] = new int[(vetor.length/2)];

        for (int i = 0; i < vetor2.length; i++){
            vetor2[i] = (vetor[i] + vetor[vetor.length - 1 - i]) ;
        }

        System.out.println("Vetor 2:");
        for (int item : vetor2){
            System.out.print(item + " ");
        }
        
    }

}
