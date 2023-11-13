package com.win.whitelist.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.win.whitelist.Entity.Techstaff;
import com.win.whitelist.Service.TechstaffService;

@RequestMapping("/api/")
@RestController
public class TechstaffRestController {
    @Autowired
     TechstaffService techstaffservice;


     @GetMapping("/techstaff")
    List<Techstaff> all(){
        return techstaffservice.getAllClientes();
    }
    
    @GetMapping("/techstaff/{id}")
    Techstaff buscarCliente(@PathVariable Long id){
        return techstaffservice.getById(id);
    }
    
    @PostMapping("/techstaff")
    Techstaff nuevoCliente(@RequestBody Techstaff staff){
        return techstaffservice.addCliente(staff);
    }
    
    @PutMapping("/techstaff")
    Techstaff actualizarTechStaff(@RequestBody Techstaff staff){
        return techstaffservice.addCliente(staff);
    }
    
    @DeleteMapping("/techstaff/{id}")
    void eliminarTechstaff(@PathVariable Long id){
        techstaffservice.deleteTechstaff(id);
    }


}
