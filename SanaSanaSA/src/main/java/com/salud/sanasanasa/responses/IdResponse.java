package com.salud.sanasanasa.responses;

public class IdResponse {
    //ATRIBUTO PRINCIPAL DE RESPUESTA ID JSON
    private Long id;

    //CONSTRUCTOR DE CLASE

    public IdResponse(Long id) {
        this.id = id;
    }

    //GET AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
