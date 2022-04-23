package listaEncadeadaDupla;

public class ListaEncadeadaDupla {
    private Node primeiro, ultimo;

    public ListaEncadeadaDupla(){
        primeiro = null;
        ultimo = null;
    }

    public boolean listaVazia(){
        //return primeiro == null ? true : false;
        if(this.primeiro == null){
            return true;
        } else {
            return false;
        }
    }

    public void inserirInicio(int elemento) {
        Node newNode = new Node(elemento);

        if(listaVazia()){
            this.ultimo = newNode;
        } else {
            newNode.setProximo(this.primeiro);
        }

        this.primeiro = newNode;
    }

    public void inserirFinal(int elemento) {
        Node newNode = new Node(elemento);

        if(listaVazia())
            this.primeiro = newNode;
        else
            this.ultimo.setProximo(newNode);

        this.ultimo = newNode;
    }

    //REMOVER NODE
    //Implementar um método para remover da lista um elemento informado.
    // Exemplo: Em uma lista com [1,5,20,3,15], quero conseguir remover o elemento "20"
    // A lista deverá continuar sendo impressa, excluindo apenas o elemento informado.

    //REMOVER NODE

    public void remover(int elemento){
        Node nodeTemp = primeiro;
        // 1º elemento...
        if (nodeTemp != null && nodeTemp.getElemento() == elemento ) {
            this.primeiro = nodeTemp.getProximo();
            return;
        }
        while (nodeTemp != null && nodeTemp.getProximo() != null) {
            if (nodeTemp.getProximo().getElemento() == elemento ) {
                nodeTemp.setProximo(nodeTemp.getProximo().getProximo());
                if (nodeTemp.getProximo() == null)
                    this.ultimo = nodeTemp; 
                return;
            }
            nodeTemp = nodeTemp.getProximo();
        }
        System.out.println("Elemento " + elemento + " não localizado!");
    }

    public int contarNodes() {
        int tamanho = 0;
        Node nodeTemp = primeiro;

        while (nodeTemp != null) {
            tamanho = tamanho + 1;
            nodeTemp = nodeTemp.getProximo();
        }

        return tamanho;
    }

    public void visualizarLista() {
        Node nodeTemp = primeiro;
        while (nodeTemp != null){
            System.out.println("Elemento " + nodeTemp.getElemento());
            nodeTemp = nodeTemp.getProximo();
        }
    }
}
