package com.win.whitelist.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.win.whitelist.Entity.ObservationStaff;
import com.win.whitelist.Service.ObservationService;


@RequestMapping("/api/")
@RestController
public class ObservationRestController {
    
    @Autowired  
    ObservationService obsservice;

     @GetMapping("/obs")
        List<ObservationStaff> all(){
            return obsservice.getAllObs();
        }
    

    @GetMapping("/obs/{id}")
    ObservationStaff buscarObs(@PathVariable Long id){
        return obsservice.getById(id);
    }

    @GetMapping("/obsall/{id}")
    List<ObservationStaff> allObsById(@PathVariable Long id){
        return obsservice.getAllObsById(id);
    }

    @PostMapping("/obs")
    ObservationStaff nuevoObs(@RequestBody ObservationStaff obs){
        return obsservice.addObs(obs);
    }

    @PutMapping("/obs")
    ObservationStaff actualizarObs(@RequestBody ObservationStaff staff){
        return obsservice.addObs(staff);
    }



}
