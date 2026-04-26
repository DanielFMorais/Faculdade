public class ListaDuplamenteEncadeada {
    private Nodo inicio;
    private Nodo fim;
    private int tamanho; 

    //---------Metodos auxiliares ---------
    private boolean vazia(){//Verificar se a lista esta vazia
        return inicio == null;
    }

    private void posInvalida(int pos){
        if (pos < 0 || pos > tamanho) {
            throw new IllegalArgumentException("Posição INVALIDA! Escolha um valor entre 0 e " + tamanho);
        }
    }

    private void adicionarVazia(int valor){//facilitador para que quando a lista estiver vazia e desejar realizar uma adição, sempre chame um unico método que adiciona ela no inicio (já que se estiver vazia a lista, sempre será uma adição no incio)
        Nodo novo = new Nodo();
        novo.setValor(valor);
        inicio = novo;
        fim = novo;
        tamanho++;
        System.out.println("~~ADICIONADO~~");
    }

    private void removerValUnic(){//facilitador de caso você vá remover uma lista com somente um elemento, é basicamente o inicio e fim ser null alem de diminuir o tamanho 
        inicio = null;
        fim = null;
        tamanho --;
        System.out.println("~~REMOVIDO~~");
    }

    private boolean validacaoRemov(){
        if (vazia()) {
            System.out.println("Lista vazia");
            return false;
        }

        if (tamanho == 1) {
            removerValUnic();
            return false;
        }
        return true;
    }

    //MÉTODOS DE AÇÃO--------------------------------------------------------------------------------------------------
    //=================================================================================================================
    //=================================================================================================================
    //=================================================================================================================
    

    //Construturo da classe, para sempre que ela for inicializada, garantir que determinados valoes estejam prontos
    public ListaDuplamenteEncadeada(){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    //Adição no inicio da lista com verificador de vazia, se estiver vazia vai chamar imediatamente um método de adição vazia.
    public void adicionarInicio(int valor){

        if (vazia()) {
            adicionarVazia(valor);
            return;
        }

        Nodo novo = new Nodo();
        novo.setValor(valor);
        
        novo.setProximo(inicio);
        inicio.setAnterior(novo);
        inicio = novo;
        tamanho++;
        System.out.println("~~ADICIONADO~~");
    }

    //Adição no fim da lista com verificador de vazia, se estiver vazia vai chamar imediatamente um método de adição vazia.
    public void adicionarFim(int valor){
        
        if (vazia()) {
            adicionarVazia(valor);
            return;
        }
        
        Nodo novo = new Nodo();
        novo.setValor(valor);

        fim.setProximo(novo);
        novo.setAnterior(fim);
        fim = novo;
        tamanho++;
        System.out.println("~~ADICIONADO~~");
    }

    //Adição no meio da lista com verificador de vazia, se estiver vazia vai chamar imediatamente um método de adição vazia. e verifica se a adição é no meio ou  no fim
    public void adicionarMeio(int pos, int valor){

        posInvalida(pos);
        
        if (vazia()) {
            adicionarVazia(valor);
            return;
        }

        if (pos == 0) {
            adicionarInicio(valor);
            return;
        }

        if (pos == tamanho) {
            adicionarFim(valor);
            return;
        }

        Nodo novo = new Nodo();
        novo.setValor(valor);

        Nodo aux;

        if (pos > (tamanho / 2)) {
            aux = fim;
            for (int i = tamanho - 1; i > pos; i--) {
                aux = aux.getAnterior();
            } 
        } else {
            aux = inicio;
            for(int i = 0; i < pos; i++ ){
                aux = aux.getProximo();
            }
        }
        
        novo.setAnterior(aux.getAnterior());
        novo.setProximo(aux);
        aux.getAnterior().setProximo(novo);
        aux.setAnterior(novo);

        tamanho++;   
        System.out.println("~~ADICIONADO~~");
    }

    //Remoção de valores no inicio da lista, com verificador de vazia e reutilização de outros métodos já prontos
    public void removerInicio(){
        if (!validacaoRemov()) return;

        inicio = inicio.getProximo();
        inicio.setAnterior(null);
        tamanho--;
        System.out.println("~~REMOVIDO~~");
    }

    //Remoção de valores no final da lista, com verificador de vazia e reutilização de outros métodos já prontos
    public void removerFim(){
        if (!validacaoRemov()) return;

        fim = fim.getAnterior();
        fim.setProximo(null);
        tamanho--;
        System.out.println("~~REMOVIDO~~");
    }

    //Remoção de valores no meio da lista, com verificador de vazia e reutilização de outros métodos já prontos
    public void removerMeio(int pos){
        posInvalida(pos);

        if (!validacaoRemov()) return;

        if (pos == 0){
            removerInicio();
            return;
        }

        if (pos == tamanho - 1) {
            removerFim();
            return;
        }

        Nodo aux;

        if (pos > (tamanho / 2)) {
            aux = fim;
            for (int i = tamanho - 1; i > pos; i--) {
                aux = aux.getAnterior();
            } 
        } else {
            aux = inicio;
            for(int i = 0; i < pos; i++ ){
                aux = aux.getProximo();
            }
        }

        aux.getAnterior().setProximo(aux.getProximo());
        aux.getProximo().setAnterior(aux.getAnterior());            
        tamanho--;
        System.out.println("~~REMOVIDO~~");      
    }

    public void removerEspecifico(int valor){

        if (vazia()) {
            System.out.println("Lista vazia");
            return;
        }

        Nodo aux = inicio;

        for (int i = 0; i < tamanho; i++){
            if (aux.getValor() == valor){
                removerMeio(i);
                return;
            }
            aux = aux.getProximo();
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

        for (int i = 0; i < tamanho; i++) {
            if (atual.getValor() == valor) {
                System.out.printf("O valor %d esta localizado na posição(índice) %d\n", valor, i);
                return;
            }
            atual = atual.getProximo();
        }
        System.out.println("O valor desejado NÃO ESTA na lista. ");
    }
    
    public void quantidadeElementos(){
        System.out.printf("A lista possui um total de %d elementos.\n", tamanho);
    }
}
