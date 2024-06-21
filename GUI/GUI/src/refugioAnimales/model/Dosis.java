package refugioAnimales.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Dosis {
    private LocalDate fecha;
    private LocalDateTime tiempo;
    private Vacuna vacuna;

    public Dosis(Vacuna vacuna) {
        this.fecha = LocalDate.now();
        this.tiempo = LocalDateTime.now();
        this.vacuna = vacuna;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalDateTime getTiempo() {
        return tiempo;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }
}
