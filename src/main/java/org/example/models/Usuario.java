package org.example.models;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Usuario implements Asesoria {

    protected Long idUsuario;
    protected String nombreCompleto;
    protected String fechaNacimiento;
    protected Integer run;
    protected String tipo;

    public Usuario() {
    }

    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Long idUsuario, String nombreCompleto, String fechaNacimiento, Integer run, String tipo) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
        this.tipo = tipo;
    }

    public Usuario(String nombreCompleto, String fechaNacimiento, Integer run, String tipo) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
        this.tipo = tipo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getRun() {
        return run;
    }

    public void setRun(Integer run) {
        this.run = run;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", run=" + run +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public void analizarUsuario() {
        System.out.println("El nombre del usuario es: " + this.nombreCompleto + ", y el run es: " + this.run);
    }

    public void mostrarEdad(String fechaNacimiento){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimientoMetodo = LocalDate.parse(this.fechaNacimiento, formato);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimientoMetodo, ahora);
        System.out.println("El usuario tiene " + periodo.getYears() + "años.");
    }


}
