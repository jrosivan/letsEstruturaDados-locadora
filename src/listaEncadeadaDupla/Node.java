package listaEncadeadaDupla;

public class Node {
    private int elemento;
    private Node proximo;

    public Node(int elemento){
        this.elemento = elemento;
        proximo = null;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
