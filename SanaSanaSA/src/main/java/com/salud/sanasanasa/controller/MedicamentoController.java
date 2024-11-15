package com.salud.sanasanasa.controller;


import com.salud.sanasanasa.entity.Medicamento;
import com.salud.sanasanasa.responses.GenericResponse;
import com.salud.sanasanasa.responses.IdResponse;
import com.salud.sanasanasa.responses.ResponseMetadata;
import com.salud.sanasanasa.services.MedicamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    Logger logger = LoggerFactory.getLogger(MedicamentoController.class);

    @Autowired
    private MedicamentoService medicamentoService;

    //METODO DE CREACION DE MEDICAMENTO
    @PostMapping
    public ResponseEntity<GenericResponse> createMedicamento(@RequestBody Medicamento medicamentoNuevo) {
        logger.info(medicamentoNuevo.toString());
        IdResponse createdMedicamentoId = new IdResponse(medicamentoService.saveMedicamento(medicamentoNuevo));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new GenericResponse(createdMedicamentoId));
    }

    // METODO PARA LLAMADO DE TODOS LOS OBJETOS
    @GetMapping
    public ResponseEntity<GenericResponse> getAllMedicamentos(
            // PARAMETROS DEL HTTP QUE SE REQUIEREN PARA LAS CONSULTAS
            //TODOS TIENEN VALORES QUEMADOS
            @RequestParam(name="nombrecomercial", required = false, defaultValue = "nada")String nombrecomercial,
            @RequestParam(name="principioactivo", required = false, defaultValue = "nada")String principioactivo,
            @RequestParam(name="pagesize", required = false, defaultValue = "25") Integer pagesize,
            @RequestParam(name="startAt", required = false, defaultValue = "0") Integer startAt){
//        if (pagesize > 25) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }

        //METODO PARA LLENAR LA LISTA DE MEDICAMENTOS
        List<Medicamento> medicamentos = medicamentoService.getMedicamentos(pagesize, startAt,nombrecomercial,principioactivo);

        //PUNTOS PARA FORMAR LA METADA DE INFORMACION DEL JSON DE RESPUESTA
        Long totalMedicamentos = medicamentoService.getMedicamentoCount();
        Long lastPage = (totalMedicamentos / pagesize) + 1L;
        Long currentPage = ((startAt + 1) / pagesize) + 1L;
        return ResponseEntity.status(HttpStatus.OK)
                .body(new GenericResponse(new ArrayList<>(medicamentos),
                        new ResponseMetadata(totalMedicamentos, currentPage,lastPage,pagesize,startAt)));
    }

    //METODO PARA BORRAR MEDICAMENTO POR MEDIO DE ID UNICO
    @DeleteMapping("/{id}")
    public boolean deleteMedicamento(@PathVariable Long id) {
        return medicamentoService.deleteMedicamento(id);
    }

//METODO DE BUSQUEDA DE MEDICAMENTO EN ESENCIAL POR ID UNICO
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> findMedicamentoById(@PathVariable Long id) {
        Medicamento found = medicamentoService.getMedicamento(id);
        if ( found == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new GenericResponse(new ArrayList<Medicamento>()));
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new GenericResponse(found));
        }
    }

    // ACTUALIZACION DEL OBJETO POR EL METODO PUT DE HTTP
    @PutMapping("/{id}")
    public boolean updateMedicamento(@PathVariable Long id,@RequestBody Medicamento medicamentoActualizado) {
        Medicamento found = medicamentoService.getMedicamento(id);
        if (found == null) {
            return false;
        } else {
            found.setNombreComercial(medicamentoActualizado.getNombreComercial());
            found.setPrincipioActivo(medicamentoActualizado.getPrincipioActivo());
            found.setPresentacion(medicamentoActualizado.getPresentacion());
            found.setUnidades(medicamentoActualizado.getUnidades());
            found.setMedida(medicamentoActualizado.getMedida());
            found.setDescripcion(medicamentoActualizado.getDescripcion());

            boolean respuesta=medicamentoService.updateMedicamento(found);

            return respuesta;
        }
    }

}
