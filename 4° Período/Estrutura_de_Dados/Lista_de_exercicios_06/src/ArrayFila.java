public class ArrayFila {
    private int[] fila;
    private int tamanho;
    private int inicio; 
    private int fim; 

    private boolean vazia () {
        return tamanho == 0;
    }
    private boolean cheia () {
        return tamanho == fila.length;
    }
    
    private void reorganizarFila() {
        int j = 0;
        for (int i = inicio; i < fim; i++) {

            fila[j] = fila[i];

            j++;
        }

        inicio = 0;
        fim = tamanho;

        System.out.println("Fila reorganizada!");
    }

    private void aumentarTamanho() {

        int novo[] = new int[fila.length + 5];

        int j = 0;

        for (int i = inicio; i < fim; i++) {

            novo[j] = fila[i];

            j++;
        }

        fila = novo;

        inicio = 0;
        fim = tamanho;
    }


    //Criando uma fila vazia, é o construtor pois a fila sempre começa vazia
    public ArrayFila (int capacidade) {
        this.fila = new int[capacidade];
        tamanho = 0;
        inicio = 0;
        fim = 0;
    }

    public void inserir (int valor) {
        
        if (cheia()) {
            if (inicio > 0) {
                reorganizarFila();
            } else {
                aumentarTamanho();
            }
        }

        fila[fim] = valor;

        fim ++;
        tamanho++;

        System.out.println("Adicionado: " + valor);
    }

    public void remover () {
        if (vazia()) {
            System.out.println("Sua fila esta vazia");
            return;
        }

        int valor = fila [inicio];
        inicio ++;
        tamanho --;

        if (tamanho == 0) {
            inicio = 0;
            fim = 0;
        }

        System.out.printf("==REMOVIDO [%d]==", valor);
    }

    // EXIBIR FILA
    public void exibir() {

        if (vazia()) {
            System.out.println("Fila vazia!");
            return;
        }

        System.out.print("[ ");

        for (int i = inicio; i < fim; i++) {

            System.out.print(fila[i] + " ");
        }

        System.out.println("]");
    }

    // QUANTIDADE
    public void tamanho() {
        System.out.printf("A fila tem: %d valores", tamanho);
    }

    // VERIFICA SE UM VALOR EXISTE NA FILA
    public void contem(int valor) {

        if (vazia()) {
            System.out.println("Fila vazia! Não tem valor algum");
            return;
        }

        for (int i = inicio; i < fim; i++) {

            if (fila[i] == valor) {

                System.out.printf(
                    "A lista possui o valor: %d",
                    valor
                );

                return;
            }
        }

        System.out.printf(
            "A lista NÃO possui o valor: %d",
            valor
        );
    }
}
