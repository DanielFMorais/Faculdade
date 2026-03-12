import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vetorPar[] = new int[5];
        int vetorImpar[] = new int[5];
        int par = 0;
        int impar = 0;
        
        while (true) {
            
            System.out.println("Por favor digite um valor para ser armazenado em um dos vetores");
            System.out.println("[PARA SAIR DIGITE QUALQUER COISA QUE NÃO SEJA UM NUMERO]\n");
            int v;

            try {
                v = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Muito obrigado! Encerrando programa.");
                break;
            }


            
            if (par == vetorPar.length & impar == vetorImpar.length){
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("\n\nAmbos os vetores estão cheios, muito obrigado!");
                System.out.println("Segue os dois vetores");
                System.out.println("-------------------------------------------------------------------------------");                
                break;
            }
            else if(par == vetorPar.length & v % 2 ==0){
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("O vetor de Pares já esta cheio, por favor escolha outro numero ou pare operação.");
                System.out.println("-------------------------------------------------------------------------------");
                continue;
            } else if (impar == vetorImpar.length & v % 2 != 0){
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("O vetor de Impares já esta cheio, por favor escolha outro numero ou pare operação.");
                System.out.println("-------------------------------------------------------------------------------");                
                continue;
            }
            
            if (v % 2 == 0){
                vetorPar[par] = v;
                par++;
            } else {
                vetorImpar[impar] = v;
                impar++;
            }

        }
        
        System.out.println("\n\nVetor Pares:");
        for(int i : vetorPar){
            System.out.print(i + " ");
        }
        
        System.out.println("\n\nVetor Impar:");
        for(int i : vetorImpar){
            System.out.print(i + " ");
        }
        
        sc.close();
    }
}
