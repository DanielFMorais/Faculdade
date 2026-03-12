import java.util.Random;

public class Question5 {
    public static void main(String[] args) {
        Random r = new Random();
        int vetorAle[] = new int[100];
        int vetorDec[] = new int[100];
        
        for (int i=0; i<vetorAle.length;i++){
            vetorAle[i] = r.nextInt(100);
        }
        for (int i = 0; i < vetorDec.length; i++){
        vetorDec[i] = 100 - i;
        }   
        
        for(int i:vetorAle){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
        for(int i:vetorDec){
            System.out.print(i + " ");
        }
        
        


    }

}
