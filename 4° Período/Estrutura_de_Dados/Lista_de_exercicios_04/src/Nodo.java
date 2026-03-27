public class Nodo {
    private int valor; 
    private Nodo proximo;
    private Nodo anterior;

    //Mostra o valor que esta no Nodo
    public int getValor(){
        return valor;
    }

    //Adiciona/substitui determinado valor no Nodo
    public void setValor(int valor){
        this.valor = valor;
    }


    //Mostra o valor do proximo Nodo
    public Nodo getProximo(){
        return proximo;
    }

    //Adiciona/substitui o Proximo valor do Nodo
    public void setProximo(Nodo proximo){
        this.proximo = proximo;
    }

    //Adiciona um valor na posição anterior do Nodo
    public void setAnterior(Nodo anterior){
        this.anterior = anterior;
    }

    //Retorna o valor anterior do Nodo atual
    public Nodo getAnteriro(){
        return anterior;
    }

}