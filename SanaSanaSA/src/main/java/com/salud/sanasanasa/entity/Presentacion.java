package com.salud.sanasanasa.entity;

import com.fasterxml.jackson.annotation.JsonValue;

//CLASE ENUM QUE LLEGA LA PRESENTACION DEL MEDICAMENTO
public enum Presentacion {
//SOLO ACEPTA ESTOS 3 PARAMTROS
    inyeccion("inyeccion"),
    pastilla("pastilla"),
    supositorio("supositorio");

    private String presentacion;


    //CONSTRUCTOR

    Presentacion(String presentacion) {
        this.presentacion = presentacion;
    }


    //ANOTACION QUE DEJA SERIALIZAR EL STRING DE PRESENTACION EN FORMATO JSON
    @JsonValue
    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }


}
