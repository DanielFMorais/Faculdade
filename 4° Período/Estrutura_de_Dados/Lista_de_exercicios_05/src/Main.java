import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // Função auxiliar para ler inteiro de forma segura
    public static int lerInteiro(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                int valor = sc.nextInt();
                sc.nextLine(); // limpa buffer após leitura do inteiro
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Valor digitado INVÁLIDO! Tente Novamente...");
                sc.nextLine(); // limpa buffer do valor inválido
            }
        }
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Scanner sc = new Scanner(System.in);

        boolean executando = true;
        while (executando) {
            
            System.out.printf("""
            ----------
            Olá, vamos começar com nossa Pilha\n
            Por favor escolhar uma das opções a seguir:
                [1] -INSERIR- elemento na Pilha.
                [2] -REMOVER- elemento da Pilha.
                [3] -EXIBIR- quantidade de elementos na lista
                [4] -EXIBIR- A LISTA-
    
            [DIGITE QUALQUER LETRA PARA SAIR DO PROGRAMA]
            """);

            int op = -1;

            while (true) {

                try {
                    op = sc.nextInt();
                    sc.nextLine();

                    // validação
                    if (op < 1 || op > 4) {
                        System.out.println("Digite apenas valores entre 1 e 4!");
                        continue;
                    }

                    // valor válido -> sai do loop
                    break;

                } catch (Exception e) {

                    System.out.println("Obrigado por usar nosso programa! ATÉ MAIS!");
                    executando = false;
                    break;
                }
            }

            if (op == 1) { //Para entrada da função de adição no incio com tratativa de valores sem ser inteiros.
                int a = lerInteiro(sc, "Qual valor você gostaria de adicionar na Pilha: ");
                pilha.push(a);
            } else if (op == 2) { //Para entrada da função de aremoção.
                pilha.pop();
            } else if (op == 3) { //Para entrada da função de verificar quantidade.
                pilha.exibirQuantidade();
            } else if (op == 4) { //Para entrada da função de exibir tudo.
                pilha.exibirPilha();
            }
        }
        
        sc.close();
    }
}