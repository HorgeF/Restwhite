package com.win.whitelist.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.whitelist.Entity.Techstaff;
import com.win.whitelist.Repository.TechstaffRepository;

@Service
public class TechstaffService {
    
    @Autowired //Al usar Autowired habilitamos la inyección de dependencia.
    private TechstaffRepository TechstaffRepository;

    public Techstaff/*boolean*/ addStaff(Techstaff cli){
        return TechstaffRepository.save(cli);
        
    }
    
    public Techstaff/*boolean*/ updateStaff(Techstaff cli){
        return TechstaffRepository.save(cli);
        
    }
    
    public List<Techstaff> getAllStaff(){
        return TechstaffRepository.findAll();
    }
    
    public Techstaff getById(Long id){
        return TechstaffRepository.findById(id).orElse(new Techstaff());
    }
    
    public void deleteTechstaff(Long cod){
        TechstaffRepository.deleteById(cod);
    }



}
