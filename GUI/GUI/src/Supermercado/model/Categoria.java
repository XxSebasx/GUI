package Supermercado.model;

public enum Categoria {
    CATEGORIA1(1),CATEGORIA2(2),CATEGORIA3(3),CATEGORIA4(4),CATEGORIA5(5);
    private int valor;

    private Categoria(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    


}
