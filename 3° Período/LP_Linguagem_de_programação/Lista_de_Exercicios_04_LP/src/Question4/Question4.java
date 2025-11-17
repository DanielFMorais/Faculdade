package Question4;

import java.util.Scanner;

public class Question4 {

    public static void validarIdade (int idade) throws IdadeInvalidaException{
        if (idade < 0 || idade > 150){
            throw new IdadeInvalidaException ("Idade deve estar entre 0 e 150 anos");
        }
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
   
       try{
           System.out.print("Por favor me informe sua idade: ");
           int idade = sc.nextInt();

           validarIdade(idade);

           System.out.println("Idade Validada");
        } catch (IdadeInvalidaException e){
            System.out.printf("Erro: %s\n",e.getMessage());
        }

        sc.close();
    }
    
}
