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
            System.out.printf("Posição INVALIDA! Escolha um valor entre 0 e %d para ser válido", tamanho);
        }
    }

    private void adicionarVazia(int valor){//facilitador para que quando a lista estiver vazia e desejar realizar uma adição, sempre chame um unico método que adiciona ela no inicio (já que se estiver vazia a lista, sempre será uma adição no incio)
        Nodo novo = new Nodo();
        novo.setValor(valor);
        inicio = novo;
        fim = novo;
        tamanho++;
        System.out.println("~~ADICIONADO~~");
        return;
    }

    private void removerValUnic(){//facilitador de caso você vá remover uma lista com somente um elemento, é basicamente o inicio e fim ser null alem de diminuir o tamanho 
        inicio = null;
        fim = null;
        tamanho --;
        System.out.println("~~REMOVIDO~~");
    }

    private void validacaoadd(int valor){
        if (vazia()) {
            adicionarVazia(valor);
            return;
        }
    }

    private void validacaoRemov(){
        if (vazia()) {
            System.out.println("~~REMOVIDO~~");
            return;
        }

        if (tamanho == 1) {
            removerValUnic();
            return;
        }
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

        validacaoadd(valor);

        Nodo novo = new Nodo();
        novo.setValor(valor);
        
        novo.setProximo(inicio.getProximo());
        inicio.getProximo().setAnterior(novo);
        inicio = novo;
        tamanho++;
        System.out.println("~~ADICIONADO~~");
    }

    //Adição no fim da lista com verificador de vazia, se estiver vazia vai chamar imediatamente um método de adição vazia.
    public void adicionarFim(int valor){
        
       validacaoadd(valor);
        
        Nodo novo = new Nodo();
        novo.setValor(valor);

        fim.getAnteriro().setProximo(novo);
        novo.setAnterior(fim.getAnteriro());
        fim = novo;
        tamanho++;
        System.out.println("~~ADICIONADO~~");
    }

    //Adição no meio da lista com verificador de vazia, se estiver vazia vai chamar imediatamente um método de adição vazia. e verifica se a adição é no meio ou  no fim
    public void adicionarMeio(int pos, int valor){

        posInvalida(pos);
        
        validacaoadd(valor);

        if (pos == 0) {
            adicionarInicio(valor);
            return;
        }

        if (pos == tamanho) {
            adicionarFim(valor);
        }

        Nodo novo = new Nodo();
        novo.setValor(valor);

        Nodo aux;

        if (pos > (tamanho - pos)) {
            aux = fim;
            for (int i = tamanho; i < pos ; i--) {
                aux = aux.getAnteriro();
            } 
            
            aux.getAnteriro().setProximo(novo);
            novo.setProximo(aux);
            novo.setAnterior(aux.getAnteriro());
            aux.setAnterior(novo);
            tamanho++;
            System.out.println("~~ADICIONADO~~");
            return;
        }

        aux = inicio;
        for(int i = 1; i < pos; i++ ){
            aux = aux.getProximo();
        }
        
        aux.getAnteriro().setProximo(novo);
        novo.setProximo(aux);
        novo.setAnterior(aux.getAnteriro());
        aux.setAnterior(novo);
        tamanho++;   
        System.out.println("~~ADICIONADO~~");
    }

    //Remoção de valores no inicio da lista, com verificador de vazia e reutilização de outros métodos já prontos
    public void removerInicio(){
        validacaoRemov();

        inicio.getProximo().setAnterior(null);
        inicio = inicio.getProximo();
        tamanho--;
        System.out.println("~~REMOVIDO~~");
    }

    //Remoção de valores no final da lista, com verificador de vazia e reutilização de outros métodos já prontos
    public void removerFim(){
        validacaoRemov();

        fim.getAnteriro().setProximo(null);
        fim = fim.getAnteriro();
        tamanho--;
        System.out.println("~~REMOVIDO~~");
    }

    //Remoção de valores no meio da lista, com verificador de vazia e reutilização de outros métodos já prontos
    public void removerMeio(int pos){
        posInvalida(pos);

        validacaoRemov();

        if (pos == 1){
            removerInicio();
            return;
        }

        if (pos == tamanho) {
            removerFim();
            return;
        }

        Nodo aux;

        if (pos > (tamanho - pos)) {
            aux = fim;
            for (int i = tamanho; i < pos ; i--) {
                aux = aux.getAnteriro();
            } 
            
            aux.getAnteriro().setProximo(aux.getProximo());
            aux.getProximo().setAnterior(aux.getAnteriro());            
            tamanho--;
            System.out.println("~~REMOVIDO~~");
            return;
        }

        aux = inicio;
        for(int i = 1; i < pos; i++ ){
            aux = aux.getProximo();
        }
        aux.getAnteriro().setProximo(aux.getProximo());
        aux.getProximo().setAnterior(aux.getAnteriro());            
        tamanho--;
        System.out.println("~~REMOVIDO~~");      
    }

    public void removerEspecifico(int valor){

        validacaoRemov();

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

    








}
