package refugioAnimales.model;

public enum VacunaPerro implements Vacuna  {
    
    MOQUILLO("Moquillo canino", true, 36),PARVOVIRUS("Parvovirus canino", true, 36),
    RABIA("Rabia", true, 12),ADENOVIRUS("Adenovirus canino tipo I y II", true, 36),
    CCORONAVIRUS ("Coronavirus", false, 0),LEPTOSPIRA ("Leptopirosis", false, 12);

    private String nombre;
    private boolean esencial;
    private int meses;

    private VacunaPerro(String nombre, boolean esencial, int meses) {
        this.nombre = nombre;
        this.esencial = esencial;
        this.meses = meses;
    }

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public boolean esEsencial() {
        return esencial;
    }
    
}
