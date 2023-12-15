package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "doctores")
public class Doctor extends AbstractEntity {

    @NotEmpty
    @Size(min = 1, max = 255)
    private String nombre;

    @NotEmpty
    @Size(min = 1, max = 255)
    private String apellidos;

    @NotEmpty
    private String especialidad;

    // Constructor por defecto requerido por JPA
    public Doctor() {}

    // Constructor con parámetros
    public Doctor(String nombre, String apellidos, String especialidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
    }

    // Getters y setters para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters para apellidos
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Getters y setters para especialidad
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        return Objects.equals(getNombre(), doctor.getNombre()) && Objects.equals(getApellidos(), doctor.getApellidos()) && Objects.equals(getEspecialidad(), doctor.getEspecialidad());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getApellidos(), getEspecialidad());
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }


    public String getNombreCompleto() {
        return nombre + " " + apellidos + " (" + especialidad + ")" ;
    }

}
