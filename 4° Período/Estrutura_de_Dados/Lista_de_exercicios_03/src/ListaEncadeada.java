public class ListaEncadeada {
    private Nodo inicio; //Primeiro valor da Lista
    private Nodo fim;
    private int quantidade = 0;

    private boolean vazia (){
        return inicio == null;
    }

    private boolean posInvalidaRemovBusc(int pos){
        return pos < 0 || pos > quantidade - 1;
    }
    

    public ListaEncadeada(){
        this.inicio = null; //Iniciamos a lista vazia, por isso foi adicionado logo no construtor
        this.fim = null;
        this.quantidade = 0;
    } 

    public void adicionarInicio(int valor){
        Nodo novo = new Nodo(); //Cria um novo Nodo
        novo.setValor(valor); //Adiciona um valor ao Nodo

        if (vazia()) { //Se estiver vazio, o inicio se torna o novo Nodo e o fim se torna este novo nodo também, já que como ele é único ele é tanto inicio quanto fim.
            inicio = novo;
            fim = novo;
            System.out.println("==ADICIONADO==");
            return;
        }
        novo.setProximo(inicio); //Referencia que o proximo valor do nodo era o que era o antigo inicio (em caso de lista com elemento, o antigo primeiro)
        inicio = novo; //Transforma ele efetivamente no primeiro elemento, já que o primeiro elemento é o inicio (se a lista estiver vazia, o primeiro elemento é null)
    
        quantidade++;

        System.out.println("==ADICIONADO==");
    }

    public void adicionarFim(int valor){
        Nodo novo = new Nodo();
        novo.setValor(valor);

        if (vazia()) {
            inicio = novo;
            fim = novo;
            System.out.println("==ADICIONADO==");
        }
        fim.setProximo(novo); //O Proximo do fim que era Null se torna o novo valor;
        fim = novo;//O fim agora é atualizado para o Nodo novo;
    
        quantidade++;

        System.out.println("==ADICIONADO==");
    }

    public void adicionarMeio(int valor, int pos){
        
        if (pos < 0 || pos > quantidade) {//Caso não esteja no escopo, deve-se retornar erro falando do erro.
            System.out.println("A posição selecionada não esta no escopo da lista.");
            return;
        }

        if (pos == 0) {//Se a posição escolhida for 0 quer dizer que esta adicionando no incio.
            adicionarInicio(valor);
            return;
        }

        if (pos == quantidade) { //Se a posição escolhida for a quantidade, quer dizer que esta adicionando no final.
            adicionarFim(valor);
            return;
        }

        Nodo novo = new Nodo();
        novo.setValor(valor);

        Nodo atual = inicio;

        for (int i = 0; i < pos -1; i++) {
            atual = atual.getProximo();
        }

        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);

        quantidade++;

        System.out.println("==ADICIONADO==");
    }

    public void removerInicio(){
        if (vazia()) {
            System.out.println("Sua lista já esta vazia, não tem o que remover.");
            return;
        }

        inicio = inicio.getProximo();//Simplesmente muda o incio para a posição da frente do inicio.

        if (inicio == null) {
            fim = null; //Caso removendo o inicio exclua o unico valor da lista, o fim deve ser atualizado
        }
        quantidade--;

        System.out.println("==REMOVIDO==");
    }

    public void removerFim(){
        if (vazia()) {
            System.out.println("Sua lista já esta vazia, não tem o que remover.");
            return;
        }

        if (quantidade == 1) { //se tiver apenas 1 elemente, removendo o ultimo, remove simplesmente tudo
            inicio = null;
            fim = null;
            quantidade--;
            System.out.println("==REMOVIDO==");
            return;
        }

        Nodo atual = inicio;

        while (atual.getProximo() != fim) {//Enquanto o proximo valor não for null ele executa, assim que o ultimo valor aprecer tendo seu proximo null, o codigo para e nem sequer pega ele, pegando o anterior
            atual = atual.getProximo();
        }

        atual.setProximo(null);//Atualiza o penultimo valor com seu proximo sendo null
        fim = atual; //atualiza o marcador de final, para o novo final
        quantidade--;

        System.out.println("==REMOVIDO==");
    }

    public void removerMeio(int pos){
        if (vazia()) {
            System.out.println("Sua lista já esta vazia, não tem o que remover.");
            return;
        }
        
        if (posInvalidaRemovBusc(pos)) {//Caso não esteja no escopo, deve-se retornar erro falando do erro.
            System.out.println("A posição selecionada não esta no escopo da lista.");
            return;
        }


        if (pos == 0) {
            removerInicio();
            return;
        }

        if (pos == quantidade -1) {
            removerFim();
            return;
        }

        Nodo atual = inicio; //nodo de apoio

        for (int i = 0; i < pos - 1; i++) {
            atual = atual.getProximo();
        }

        atual.setProximo(atual.getProximo().getProximo());//com a remoção do valor do meio, basta selecionar o set proximo do proximo do proximo valor

        quantidade --; 
        System.out.println("==REMOVIDO==");       
    }

    public void removerEspecifico(int valor){
        if (vazia()) {
            System.out.println("Sua lista já esta vazia, não tem o que remover.");
            return;
        }

        Nodo atual = inicio;

        for (int i = 0; i < quantidade; i++) {
            if (atual.getValor() == valor) {
                removerMeio(i);//chama a chamada de remover do meio com a atualização
                return;
            }
            atual = atual.getProximo();//atualiza pro proximo caso não seja ele
        }

        System.out.printf("O valor selecionado não esta presente na lista.");    

    }

    public void exibirLista(){
        if (vazia()) {
            System.out.println("Sua lista  esta vazia, não tem o que exibir.");
            return;
        }
        
        System.out.print("[ ");
    
        Nodo atual = inicio;

        while (atual != null) {
            System.out.print(atual.getValor() + " ");
            atual = atual.getProximo();
        }
    
        System.out.println("]");
    }

    public void pesquisaPosicao(int valor){
        if (vazia()) {
            System.out.println("Sua lista  esta vazia, não tem o que exibir.\n");
            return;
        }

        Nodo atual = inicio;

        for (int i = 0; i < quantidade; i++) {
            if (atual.getValor() == valor) {
                System.out.printf("O valor %d esta localizado na posição(índice) %d\n", valor, i);
                return;
            }
            atual = atual.getProximo();
        }
        System.out.println("O valor desejado NÃO ESTA na lista. ");
    }
    
    public void quantidadeElementos(){
        System.out.printf("A lista possui um total de %d elementos.\n", quantidade);
    }
}
