package bitacoras.model;

public enum Categoria {
    N("Ninguna"),I("Informacion"),A("Advertencia"),S("Seguimiento"),E("Error"),F("Fatal");

    private String nombre;

    private Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return nombre;
    }



    
}
