package com.salud.sanasanasa.repo;

import com.salud.sanasanasa.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicamentoRepo extends JpaRepository<Medicamento, Long> {

// METODO PARA RETORNAR TODO PERO CON EL LIMITE DEL TAMANO DE PAGINA Y EL INICIO DEL ID DEL PRIMER OBJETO
    @Query(value="Select me from Medicamento me order by me.id limit :pageSize offset :startAt ")
    List<Medicamento> findAll(Integer pageSize, Integer startAt);

    //METODO IMPLEMENTADO PARA BUSQUEDA EXACTA DE PALABRA DE NOMBRE COMERCIAL
//    @Query("Select me from Medicamento me where me.nombreComercial=:nombreComercial order by me.id limit :pageSize offset :startAt")

    //METODO IMPLEMENTADO PARA BUSQUEDA INEXACTA DE PALABRA DE NOMBRE COMERCIAL
    @Query(value="Select me from Medicamento me where me.nombreComercial LIKE %:nombrecomercial% order by me.id limit :pageSize offset :startAt")

    List<Medicamento> findNombreComercial (Integer pageSize, Integer startAt,@Param("nombrecomercial")String nombrecomercial);

//METODO IMPLEMENTADO PARA BUSQUEDA DE PALABRA EXACTA DE PRINCIPIO ACTIVO
//    @Query("Select me from Medicamento me where me.principioActivo=:principioactivo order by me.id limit :pageSize offset :startAt")
//METODO IMPLEMENTADO PARA BUSQUEDA INEXACTA DE PALABRA DE NOMBRE COMERCIAL
    @Query(value="Select me from Medicamento me where me.principioActivo LIKE %:principioactivo% order by me.id limit :pageSize offset :startAt")
    List<Medicamento> findPrincipioActivo(Integer pageSize, Integer startAt,@Param("principioactivo") String principioactivo);

}
