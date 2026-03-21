public class MetodoLista {
    private int[] dados;
    private int quantidade;

    private boolean vazia(){
        return quantidade == 0;
    }
    private boolean cheia(){
        return quantidade == dados.length;
    }
    private boolean posInvalidaRemovBusc(int pos){
        return pos < 0 || pos >= quantidade;
    }
    private void aumentarTamanho(){
        int novo[] = new int[dados.length + 10];

        for (int i = 0; i < quantidade; i++){
            novo[i] = dados[i];
        }

        dados = novo;
    }
    

    //Criando uma lista vazia, é o construtor pois a lista sempre começa vazia
    public MetodoLista (int capacidade) {
        this.dados = new int[capacidade];
        quantidade = 0;
    }

    //Método para adicionar itens no inicio, basicamente pega o ultimo valor e joga para frente, e faz isso ate que o primeiro espaço esteja vazio para receber o novo valor
    public void inserirInicio (int valor){

        if(cheia()){
            aumentarTamanho();
        }
        
        for(int i=quantidade; i > 0; i--){
            dados[i] = dados[i-1];
        }

        dados[0] = valor;
        quantidade++;

        System.out.println("-INSERIDO-");
    }

    //Método para inserir no final da lista, pega o indice da ultima posição e adiciona o valor lá atualizando tamb o tamanho da lista.
    public void inserirFinal (int valor){
        
        if (cheia()) {
            aumentarTamanho();
        }

        dados[quantidade] = valor;
        quantidade++;
        
        System.out.println("-INSERIDO-");
    }

    //Método para inseriro no meio do vetor, realoca todos de tal posição em diante para frente e no local da posição, adiciona-se o valor. 
    //Testes de verificação se a posição é válida, se ele colocar no zero chama a função de inicio e se no final, chama a função de final. caso seja invalido ele quebra o programa.
    public void inserirNoMeio (int valor, int posicao){
        
        if (posicao < 0 || posicao > quantidade) {
            System.out.printf("Você digitou uma posição inválida, digite uma posição entre 0 e %d\n", quantidade);
            return ;
        }
        
        if(posicao == 0){
            inserirInicio(valor);
            return;
        }

        if (posicao == quantidade) {
            inserirFinal(valor);
            return;
        }
        
        if (cheia()) {
            aumentarTamanho();
        }
        
        for (int i = quantidade; i > posicao; i--){
            dados[i] = dados[i-1];
        }
        dados[posicao] = valor;
        quantidade++;

        
        System.out.println("-INSERIDO-");
    }

    //Método para remover um valor do inicio, basicamente pegando todos os outros valores que estão na frente e tranzendo 1 casa para trás.
    //função de verificar se esta vazia, se estiver vazia não faz sentido remover nada
    public void removerInicio () {
        if (vazia()) {
            System.out.println("Olá, Sua lista já esta vazia, não tem o que excluir.");
            return;
        }

        for (int i=1; i < quantidade; i++){
            dados[i-1] = dados[i];
        }
        quantidade--;

        
        System.out.println("-REMOVIDO-");
    }

    //Método para remover um valor do Final, basicamente diminuindo a quantidade de elementos, assim ignora-se o ultimo valor.
    //função de verificar se esta vazia, se estiver vazia não faz sentido remover nada
    public void removerFinal (){
        if (vazia()) {
            System.out.println("Olá, Sua lista já esta vazia, não tem o que excluir.");
            return;
        }

        quantidade--;

        
        System.out.println("-REMOVIDO-");
    }

    //Método para remover um valor do Meio, basicamente verifica sé é no inicio ou final, se for já chama o método específico e se estiver no meio basicamente pega tudo que esta na frente e joga 1 casa para trás.
    //função de verificar se esta vazia, se estiver vazia não faz sentido remover nada
    public void removerMeio(int posicao){
        if (vazia()) {
            System.out.println("Olá, Sua lista já esta vazia, não tem o que excluir.");
            return;
        }

        if (posInvalidaRemovBusc(posicao)) {
            System.out.printf("Você digitou uma posição inválida, digite uma posição entre 0 e %d\n", quantidade);
            return;
        }

        if (posicao == 0) {
            removerInicio();
            return;
        }
        if (posicao == (quantidade-1)) {
            removerFinal();
            return;
        }

        for (int i = posicao; i < quantidade - 1; i++ ){
            dados[i] = dados[i+1];
        }
        quantidade--;

        System.out.println("-REMOVIDO-");
    }
    
    //Método que busca na lista ate achar o valor informado e assim que localizado chama o método de remover no meio para que sera feita a remoção.
    //função de verificar se esta vazia, se estiver vazia não faz sentido remover nada
    public void removerValorEspecifico(int valor){
        if (vazia()) {
            System.out.println("Olá, Sua lista já esta vazia, não tem o que excluir.");
            return;
        }

        
        for(int i=0; i < quantidade; i++){
            if(dados[i] == valor){
                removerMeio(i);
                return;
            }
        }

        System.out.printf("O valor selecionado não esta presente na lista.");
    }

    //Imprime a lista
    public void exibirLista(){
        if(vazia()){
            System.out.println("Lista vazia");
            return;
        }
    
        System.out.print("[ ");
    
        for(int i=0; i<quantidade; i++){
            System.out.print(dados[i] + " ");
        }
    
        System.out.println("]");
    }
    

    public void posicaoElementoEspecifico(int valor){
        if (vazia()) {
            System.out.println("Olá, Sua lista já esta vazia, não tem o que procurar.");
            return;
        }

        for(int i=0; i<quantidade; i++ ){
            if (dados[i] == valor) {
                System.out.printf("A posição do valor %d é %d", valor, i);
                return;
            }
        }

        System.out.printf("O valor selecionado não esta presente na lista.");
    }

    public void quantidadeElementos(){
        System.out.printf("A lista possui um total de %d elementos.\n", quantidade);
    }
}
