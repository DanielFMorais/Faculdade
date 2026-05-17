public class Pilha {
    private Nodo topo;
    private int quantidade;
    /* ----------- Métodos auxiliares */
    
    private boolean vazia () {
        return topo == null;
    }
    //MÉTODOS DE AÇÃO--------------------------------------------------------------------------------------------------
    //=================================================================================================================

    /* Criação da Pilha vazia, vulso seu contrutor */
    public Pilha () {
        this.topo = null;
        this.quantidade = 0;
    }


    /* Para adicionar um valor na Pilha */
    public void push (int valor) {
        Nodo novo = new Nodo(valor);

        if (vazia()) {
            topo = novo;
            quantidade++;
            System.out.println("==ADICIONADO==");  
            return;
        }

        novo.setProximo(topo);
        topo = novo;

        quantidade++;
        System.out.println("==ADICIONADO==");        
    }   

    /* Para Remover um valor da Pilha */
    public void pop () {
        if (vazia()) {
            System.out.println("Sua Pilha esta vazia! Muito Obrigado");
            return;
        }
        
        /* Aux para informar qual valor esta sendo removido */
        int valor = topo.getValor();

        topo = topo.getProximo();
        quantidade --;

        System.out.printf("==REMOVIDO [%d]==\n", valor);
    }

    /* Para exibir toda a Pilha */
    public void exibirPilha(){
        if (vazia()) {
            System.out.println("Sua Pilha  esta vazia, não tem o que exibir.");
            return;
        }
        
        System.out.print("[ ");
    
        Nodo atual = topo;

        while (atual != null) {
            System.out.print(atual.getValor() + " ");
            atual = atual.getProximo();
        }
    
        System.out.println("]");
    }

    /* Para retornar a quantidade de itens na Pilha */
    public void exibirQuantidade () {
        System.out.printf("A pilha tem %s elementos", quantidade);
    }
}   
