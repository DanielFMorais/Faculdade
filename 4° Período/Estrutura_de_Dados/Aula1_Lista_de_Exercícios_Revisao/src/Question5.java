import java.util.Random;

public class Question5 {
    public static void main(String[] args) {
        Random r = new Random();
        int vetorAle[] = new int[100];
        int vetorDec[] = new int[100];
        int trocasAle=0;
        int trocasDec=0;
        //Preenchimento e visualização de vetor
        for (int i=0; i<vetorAle.length;i++){
            vetorAle[i] = r.nextInt(100);
        }
        for (int i = 0; i < vetorDec.length; i++){
        vetorDec[i] = 100 - i;
        }   
    
        
        //Preenchimento e visualização de vetor
        for(int i:vetorAle){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
        for(int i:vetorDec){
            System.out.print(i + " ");
        }
        
        //Ordenação do aleatório com contagem
        for(int i=0; i<vetorAle.length; i++){
            for(int j=0; j<vetorAle.length - 1 - i; j++ ){
                if(vetorAle[j] > vetorAle[j+1]){
                    int temp = vetorAle[j];
                    vetorAle[j] =vetorAle[j +1];
                    vetorAle[j+1] = temp;
                    trocasAle++;;//Realiza a contagem
                }
            }
        }

        //ordenação do 100 -1
        for(int i=0; i<vetorDec.length; i++){
            for(int j=0; j<vetorDec.length - 1 - i; j++ ){
                if(vetorDec[j] > vetorDec[j+1]){
                    int temp = vetorDec[j];
                    vetorDec[j] =vetorDec[j +1];
                    vetorDec[j+1] = temp;
                    trocasDec++;//Realiza a contagem
                }
            }
        }

        System.out.printf("\n\n\nTrocas do vetor ALEATÓRIO: %d\nTroca do vetor de 100 á 1: %d",trocasAle,trocasDec);
        


    }

}
