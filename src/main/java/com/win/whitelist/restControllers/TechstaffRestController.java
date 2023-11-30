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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.win.whitelist.Entity.Techstaff;
import com.win.whitelist.Entity.Techstaff_list;
import com.win.whitelist.Service.TechstaffService;

@RequestMapping("/api/")
@RestController
public class TechstaffRestController {


        @Autowired  
        TechstaffService techstaffservice;


        @GetMapping("/techstaff")
        List<Techstaff> all(){
            return techstaffservice.getAllStaff();
        }
    
    @GetMapping("/techstaff/{id}")
    Techstaff buscarStaff(@PathVariable Long id){
        return techstaffservice.getById(id);
    }
    
    @PostMapping("/techstaff")
    Techstaff nuevoStaff(@RequestBody Techstaff staff){
        return techstaffservice.addStaff_SP(staff);
    }
    
    @PutMapping("/techstaff")
    Techstaff actualizarTechStaff(@RequestBody Techstaff staff){
        return techstaffservice.addStaff(staff);
    }
    
    @DeleteMapping("/techstaff/{id}")
    void eliminarTechstaff(@PathVariable Long id){
        techstaffservice.deleteTechstaff(id);
    }
     
    @GetMapping("/techstaff_estado/{id}")
    boolean actualizarEstadoTechStaff(@PathVariable Long id)
    {
        try {
            techstaffservice.actualizarEstado(3, id);
            return true;  // Si la actualización fue exitosa
        } catch (Exception ex) {
            // Manejar la excepción (por ejemplo, registrar un error)
            return false;  // Si hubo un error durante la actualización
        }
         
    }

    @GetMapping("/techstaff_observar/{id}")
    boolean ObservarEstadoTechStaff(@PathVariable Long id)
    {
        try {
            techstaffservice.actualizarEstado(2, id);
            return true;  // Si la actualización fue exitosa
        } catch (Exception ex) {
            // Manejar la excepción (por ejemplo, registrar un error)
            return false;  // Si hubo un error durante la actualización
        }
         
    }

    @GetMapping("/techstaff_sp")
    List<Techstaff_list> techstaff_sp(@RequestParam("descripcion") String descripcion,
                                      @RequestParam("id_contrata") int idContrata){
        return techstaffservice.getAllStaff_SP(descripcion,idContrata);
    }

}
