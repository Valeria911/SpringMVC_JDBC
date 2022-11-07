package org.example.models;

public class Capacitacion extends Evento{
    private Long idCapacitacion;
    private String duracion;
    private Integer cantidadAsistentes;

    public Capacitacion(){
    }

    public Capacitacion(Integer rutCliente, String dia, String hora, String lugar, Long idCapacitacion, String duracion, Integer cantidadAsistentes) {
        super(rutCliente, dia, hora, lugar);
        this.idCapacitacion = idCapacitacion;
        this.duracion = duracion;
        this.cantidadAsistentes = cantidadAsistentes;
    }

    public Capacitacion(Integer rutCliente, String dia, String hora, String lugar, String duracion, Integer cantidadAsistentes) {
        super(rutCliente, dia, hora, lugar);
        this.duracion = duracion;
        this.cantidadAsistentes = cantidadAsistentes;
    }

    public Long getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(Long idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public Integer getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(Integer cantidadAsistentes) {
        this.cantidadAsistentes = cantidadAsistentes;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Capacitacion{" +
                "idCapacitacion=" + idCapacitacion +
                ", duracion='" + duracion + '\'' +
                ", cantidadAsistentes=" + cantidadAsistentes +
                ", rutCliente=" + rutCliente +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                "} ";
    }

    public void mostrarDetalle(){
        System.out.println("La capacitación será en " + lugar + " a las " + hora + "\n" +
                "del día " + dia + " y durará " + duracion + " minutos.");
    }
}
