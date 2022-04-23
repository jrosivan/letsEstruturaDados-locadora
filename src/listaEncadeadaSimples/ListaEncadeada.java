package listaEncadeadaSimples;

public class ListaEncadeada {
    private Node primeiro, ultimo;

    public ListaEncadeada(){
        primeiro = null;
        ultimo = null;
    }

    public Node getPrimeiro() {
        return primeiro;
    }
    public void setPrimeiro(Node primeiro) {
        this.primeiro = primeiro;
    }
    public Node getUltimo() {
        return ultimo;
    }
    public void setUltimo(Node ultimo) {
        this.ultimo = ultimo;
    }

    public Node getNode(int index) {
        int posicao = 0;
        Node nodeTemp = primeiro;
        while (nodeTemp != null) {
            if (index == posicao)
                return nodeTemp;
            nodeTemp = nodeTemp.getProximo();
            posicao++;
        }
        return null;
    }

    public boolean listaVazia(){
        return (primeiro == null);
    }


    public void inserirInicio(Object elemento) {
        Node newNode = new Node(elemento);
        if(listaVazia()){
            this.ultimo = newNode;
        } else {
            newNode.setProximo(this.primeiro);
        }
        this.primeiro = newNode;
    }

    public void inserirFinal(Object elemento) {
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

    //REMOVER NODE: Rosivan

    public void remover(Object elemento){
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
            tamanho++;
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
