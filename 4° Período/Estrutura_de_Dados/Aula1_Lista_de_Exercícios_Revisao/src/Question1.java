import java.util.Random;

public class Question1 {
    public static void main(String[] args) throws Exception {

        Random r = new Random();

        int vetor1[] = new int[10];
        int vetor2[] = new int[10];
        double vetor3[] = new double[10];
        
        for (int i=0; i < vetor1.length; i++){
            vetor1[i] = r.nextInt(100);
        }
        
        for (int i=0; i < vetor1.length; i++){
            vetor2[i] = r.nextInt(100);
        }

        System.out.print("1: ");
        for (int item : vetor1){
            System.out.print(" " + item);
        }
        System.out.print("\n2: ");
        for (int item : vetor2){
            System.out.print(" " + item);
        }
        
        for (int i=0; i < vetor3.length; i++){
            vetor3[i] = (vetor1[i] + vetor2[i]) / 2.0;
        }
        
        System.out.print("\n3: ");
        for (double item : vetor3){
            System.out.print(" " + item);
        }
    }
}
