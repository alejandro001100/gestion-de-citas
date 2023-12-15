package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;
import java.time.LocalDateTime;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;


@Entity
@Table(name = "citas")
public class Cita extends AbstractEntity {

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Doctor doctor;

    private LocalDateTime fechaHora;
    private String especialidad;

    // Constructor por defecto
    public Cita() {}

    // Constructor con parámetros, getters y setters

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cita cita)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getPaciente(), cita.getPaciente()) && Objects.equals(getDoctor(), cita.getDoctor()) && Objects.equals(getFechaHora(), cita.getFechaHora()) && Objects.equals(getEspecialidad(), cita.getEspecialidad());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPaciente(), getDoctor(), getFechaHora(), getEspecialidad());
    }

    @Override
    public String toString() {
        return "Cita{" +
                "paciente=" + paciente +
                ", doctor=" + doctor +
                ", fechaHora=" + fechaHora +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
