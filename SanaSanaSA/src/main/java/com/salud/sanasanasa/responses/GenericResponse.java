package com.salud.sanasanasa.responses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GenericResponse {

    //ATRINUTOS DE CLASE GENERIC RESPONSE
    LocalDateTime dateTime;
    List<Object> data;
    ResponseMetadata metadata;

    //CONSTRUCTORES DE LA CLASE
    public GenericResponse(List<Object> data, ResponseMetadata metadata) {
        this.dateTime = LocalDateTime.now();
        this.data = data;
        this.metadata = metadata;
    }

    public GenericResponse(Object data) {
        this.dateTime = LocalDateTime.now();
        this.data = new ArrayList<>();
        this.metadata = null;
        this.data.add(data);
    }

    //GET AND SETTERS

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public ResponseMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ResponseMetadata metadata) {
        this.metadata = metadata;
    }
}
