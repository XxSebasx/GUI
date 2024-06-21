package refugioAnimales.model;

public enum VacunaGato implements Vacuna {
    
    HERPES("Moquillo canino", true, 36),CALICIVIRUS("Parvovirus canino", true, 36),
    PANLEUCOPENIA("Rabia", true, 12),FCORONAVIRUS("Adenovirus canino tipo I y II", true, 36),
    PERITONITIS  ("Coronavirus", false, 0);

    private String nombre;
    private boolean esencial;
    private int meses;

    private VacunaGato(String nombre, boolean esencial, int meses) {
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
