package com.salud.sanasanasa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//ENTIDAD GENERAL DE TODA LA ESTRUCTURA
@Entity
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombreComercial;
    private String principioActivo;
    private Presentacion presentacion;

    private int unidades;
    private String medida;
    private String descripcion;


//METODS DE GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }


    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "id=" + id +
                ", nombreComercial='" + nombreComercial + '\'' +
                ", principioActivo='" + principioActivo + '\'' +
                ", presentacion=" + presentacion +
                ", unidades=" + unidades +
                ", medida='" + medida + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
