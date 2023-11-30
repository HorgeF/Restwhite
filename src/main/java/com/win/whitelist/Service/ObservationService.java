package com.win.whitelist.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.whitelist.Entity.ObservationStaff;
import com.win.whitelist.Repository.ObservationRepository;

import jakarta.transaction.Transactional;


@Service
public class ObservationService {

   @Autowired //Al usar Autowired habilitamos la inyección de dependencia.
    private ObservationRepository ObservationRepository;

    public ObservationStaff/*boolean*/ addObs(ObservationStaff cli){
        return ObservationRepository.save(cli);
        
    }
    
    public ObservationStaff/*boolean*/ updateObs(ObservationStaff cli){
        return ObservationRepository.save(cli);
        
    }
    
    public List<ObservationStaff> getAllObs(){
        return ObservationRepository.findAll();
    }

    @Transactional
    public List<ObservationStaff> getAllObsById(Long id){

        return ObservationRepository.sp_obtener_observaciones(id);
    }
    

    public ObservationStaff getById(Long id){
        return ObservationRepository.findById(id).orElse(new ObservationStaff());
    }
    
    
}
