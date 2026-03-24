public class Nodo {
    private int valor; 
    private Nodo proximo;

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

}
