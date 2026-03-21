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
        MetodoLista lista = new MetodoLista(10);
        Scanner sc = new Scanner(System.in);

        
        do {
            System.out.printf("""
            ----------
            Olá, vamos começar com nossa lista\n
            Por favor escolhar uma das opções a seguir:
                [1] -INSERIR- elemento no início da lista.
                [2] -INSERIR- elemento no final da lista.
                [3] -INSERIR- elemento no meio da lista.
                [4] -REMOVER- elemento no início da Lista.
                [5] -REMOVER- elemento no final da lista.
                [6] -REMOVER- elemento em posição específica.
                [7] -REMOVER- elemento específico da lista.
                [8] -PESQUISAR- em qual posição um elemento específico esta.
                [9] -EXIBIR- quantidade de elementos na lista
                [0] -EXIBIR- A LISTA-
    
            [DIGITE QUALQUER LETRA PARA SAIR DO PROGRAMA]
            """);

            int op = -1;

            try { //irá tentar pegar um numero, caso não seja numero, ou seja decimal, ele irá encerrar o programa
                op = sc.nextInt();
                sc.nextLine(); // limpa buffer do Enter
            } catch (Exception e) {
                System.out.println("Obrigado por usar nosso programa! ATE MAIS!");
                sc.nextLine(); // limpa buffer do valor inválido
                break;
            }

            if (op == 1) { //Para entrada da função de adição no incio com tratativa de valores sem ser inteiros
                int a = lerInteiro(sc, "Qual valor você gostaria de adicionar no INICIO: ");
                lista.inserirInicio(a);
            } else if (op == 2) { //Para entrada da função de adição no final  com tratativa de valores sem ser inteiros
                int a = lerInteiro(sc, "Qual valor você gostaria de adicionar no FINAL: ");
                lista.inserirFinal(a);
            } else if (op == 3) { //Para entrada da função de adição no Meio com tratativa de valores  e posição sem ser inteiros
                int a = lerInteiro(sc, "Qual valor você gostaria de adicionar no Meio: ");
                int b = lerInteiro(sc, "Qual posição você gostaria de adicionar o valor: ");
                lista.inserirNoMeio(a, b);
            } else if (op == 4) { //Para entrada da função de remover do incio 
                lista.removerInicio();
            } else if (op == 5) { //Para entrada da função de remover do final
                lista.removerFinal();
            } else if (op == 6) { //Para entrada da função de remover do meio com validação da posição se é inteiro
                int a = lerInteiro(sc, "Qual posição você gostaria de remover: ");
                lista.removerMeio(a);
            } else if (op == 7) { //Para entrada da função de remover especifico com validação de valor inteiro
                int a = lerInteiro(sc, "Qual Valor você gostaria de remover: ");
                lista.removerValorEspecifico(a);
            } else if (op == 8) { //Para entrada da função de remover da posição com validação de posição se é inteiro 
                int a = lerInteiro(sc, "Qual Valor você gostaria de saber onde esta: ");
                lista.posicaoElementoEspecifico(a);
            } else if (op == 9) { //Para entrada da função mostrar qtd de elementos
                lista.quantidadeElementos();
            } else if (op == 0) { //Para entrada da função de mostrar a lista toda
                lista.exibirLista();
            }
            
        } while (true);

        sc.close();
    }
}