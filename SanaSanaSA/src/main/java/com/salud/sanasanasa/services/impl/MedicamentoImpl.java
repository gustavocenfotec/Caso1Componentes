package com.salud.sanasanasa.services.impl;

import com.salud.sanasanasa.controller.MedicamentoController;
import com.salud.sanasanasa.entity.Medicamento;
import com.salud.sanasanasa.repo.MedicamentoRepo;
import com.salud.sanasanasa.services.MedicamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// EL PRESENTE DOCUMENTO ES LA IMPLEMENTACION DEL SERVICE
@Service
public class MedicamentoImpl implements MedicamentoService {

    Logger logger = LoggerFactory.getLogger(MedicamentoController.class);

    @Autowired
    MedicamentoRepo medicamentoRepo;

    //SALVADO DE MEDICAMENTO
    @Override
    public Long saveMedicamento(Medicamento medicamentoNuevo) {
        return medicamentoRepo.save(medicamentoNuevo).getId();
    }


    //BUSQUEDA DE MEDICAMENTO ESPECIFICO POR ID
    @Override
    public Medicamento getMedicamento(Long id) {
        Optional<Medicamento> medicamento = medicamentoRepo.findById(id);
        if (medicamento.isPresent()) {
            return medicamento.get();
        } else {
            return null;
        }
    }

    //BUSQUEDA DE TODOS LOS MEDICAMENTOS

    @Override
    public List<Medicamento> getMedicamentos(Integer pagesize, Integer startAt,String nombrecomercial, String principioactivo) {
        List<Medicamento> todos;

        todos=medicamentoRepo.findAll(pagesize, startAt);
// CASOS DIFERENTES DE BUSQUEDA DE MEDICAMENTOS Y SU RESPECTIVO NIVEL

        //NO HAY PARAMETROS DE BUSQUEDA ESPECIFICA SE ENVIA TODO
        if (nombrecomercial.equals("nada") && principioactivo.equals("nada")) {
            logger.info("ESTOY EN NINGUN REQUEST");
            return todos;
        }

        // SE BUSCA QUE EL PARAMETRO NOMBRE COMERCIAL SEA REQUERIDO SERA EL PRIMERO EN BUSCAR
        if (!nombrecomercial.equals("nada")) {

            List<Medicamento> busquedaespefica=busquedaNombreComercial(todos,nombrecomercial);
            return busquedaespefica;
//            return medicamentoRepo.findNombreComercial(pagesize, startAt,nombrecomercial);
        }

        // SE BUSCA QUE EL PARAMETRO PRINCIPIO ACTIVO SEA REQUERIDO SERA EL SEGUNDO EN BUSCAR
        // PERO SI SE BUSCO EL NOMBRE COMERCIAL NUNCA LLEGARA A ESTE
        List<Medicamento> busquedaespefica=busquedaPrincipioActivo(todos,principioactivo);
        return busquedaespefica;
//        return medicamentoRepo.findPrincipioActivo(pagesize, startAt,principioactivo);
    }


    @Override
    public List<Medicamento> busquedaNombreComercial(List<Medicamento> Medicamentos, String nombrecomercial) {
        logger.info("NOMBRE COMERCIAL TIENE UN QUERY");
        logger.info("Nombre Comercial: "+nombrecomercial+" Nombre Comercial:");

        List<Medicamento> busquedaespefica=new ArrayList<>();

        for(Medicamento medicamento :Medicamentos) {
            if(medicamento.getNombreComercial().contains(nombrecomercial)){
                busquedaespefica.add(medicamento);
            }
        }
        return busquedaespefica;
    }

    @Override
    public List<Medicamento> busquedaPrincipioActivo(List<Medicamento> Medicamentos, String principioactivo) {
        List<Medicamento> busquedaespefica=new ArrayList<>();
        logger.info("PRINCIPIO ACTIVO TIENE UN QUERY");
        logger.info("principioactivo: "+principioactivo+" principioactivo:");
        for(Medicamento medicamento :Medicamentos) {
            if(medicamento.getNombreComercial().contains(principioactivo)){
                busquedaespefica.add(medicamento);
            }
        }
        return busquedaespefica;
    }

    @Override
    public Boolean deleteMedicamento(Long id) {
        try {
            medicamentoRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Long getMedicamentoCount() {
        return medicamentoRepo.count();
    }

    @Override
    public boolean updateMedicamento(Medicamento medicamentoActualizado) {

        try {
            medicamentoRepo.save(medicamentoActualizado);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
