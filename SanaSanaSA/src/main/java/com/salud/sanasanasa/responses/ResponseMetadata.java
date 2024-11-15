package com.salud.sanasanasa.responses;

public class ResponseMetadata {

    //MAIN ATRIBUTOS DE RESPUESTA JSON
    long total;
    long currentPage;
    long lastPage;
    long pageSize;
    long currentIndex;

    //CONSTRUCTOR METADATA PARA RESPUESTA JSON

    public ResponseMetadata(long total, long currentPage, long lastPage, long pageSize, long currentIndex) {
        this.total = total;
        this.currentPage = currentPage;
        this.lastPage = lastPage;
        this.pageSize = pageSize;
        this.currentIndex = currentIndex;
    }

    //GET AND SETTERS

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getLastPage() {
        return lastPage;
    }

    public void setLastPage(long lastPage) {
        this.lastPage = lastPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(long currentIndex) {
        this.currentIndex = currentIndex;
    }
}
