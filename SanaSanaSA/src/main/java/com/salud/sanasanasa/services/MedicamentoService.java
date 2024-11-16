package com.salud.sanasanasa.services;

import com.salud.sanasanasa.entity.Medicamento;

import java.util.List;

public interface MedicamentoService {

    //METODO PARA SALVAR NUEVO MEDICAMENTO
    public Long saveMedicamento(Medicamento medicamentoNuevo);

    //METODO PARA ACTUALIZAR MEDICAMENTO
    public boolean updateMedicamento(Medicamento medicamentoNuevo);

    //METODO PARA ENCONTRAR MEDICAMENTO POR MEDIO DE ID UNICO
    public Medicamento getMedicamento(Long id);

    // LISTADO DE BUSQUEDA DE TODOS LOS MEDICAMENTOS POR MEDIO PARAMETROS DE PAGINADO, INICIO DE ID
    // NOMBRE COMERCIAL Y PRINCIPIO ACTIVO
    public List<Medicamento> getMedicamentos(Integer pagesize, Integer startAt,String nombrecomercial,String principioactivo);

    //METODO DE BORRADO DE MEDICAMENTO
    public Boolean deleteMedicamento(Long id);

    //METODO DE BORRADO DE CONTEO DE MEDICAMENTOS
    public Long getMedicamentoCount();


    //ESTOS METODOS  SON FUNCIONALES, PERO NO DE FORMA OPTIMA PERO QUEDAN COMO EJEMPLO

//    //METODO PARA BUSQUEDA DE PROXIMIDAD DE NOMBRE COMERCIAL PERO REALIZADO DESDE EL PROGRAMA
//    public List<Medicamento> busquedaNombreComercial(List<Medicamento> Medicamentos,String nombrecomercial);
//
//    //METODO PARA BUSQUEDA DE PROXIMIDAD DE NOMBRE COMERCIAL PERO REALIZADO DESDE EL PROGRAMA
//    public List<Medicamento> busquedaPrincipioActivo(List<Medicamento> Medicamentos,String principioactivo);
}
