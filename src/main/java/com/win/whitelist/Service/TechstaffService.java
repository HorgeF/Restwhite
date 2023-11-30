package com.win.whitelist.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.win.whitelist.Entity.Techstaff;
import com.win.whitelist.Entity.Techstaff_list;
import com.win.whitelist.Repository.TechstaffListRepository;
import com.win.whitelist.Repository.TechstaffRepository;

import jakarta.transaction.Transactional;

@Service
public class TechstaffService {
    
    @Autowired //Al usar Autowired habilitamos la inyección de dependencia.
    private TechstaffRepository TechstaffRepository;
    @Autowired 
    private TechstaffListRepository TechListstaffRepository;

    public Techstaff/*boolean*/ addStaff(Techstaff cli){
        return TechstaffRepository.save(cli);        
    }
    @Transactional
     public Techstaff/*boolean*/ addStaff_SP(Techstaff cli){
        return TechstaffRepository.sp_insert_update_techstaff(  cli.codigo,
                                                                cli.nombre,
                                                                cli.apepaterno,
                                                                cli.apematerno,
                                                                cli.dni,
                                                                cli.celular,
                                                                cli.fechaingreso,
                                                                cli.fechacese,
                                                                cli.comentarios,
                                                                cli.idestado,
                                                                cli.idcontrata,
                                                                1);        
    }
    
    public Techstaff/*boolean*/ updateStaff(Techstaff cli){
        return TechstaffRepository.save(cli);
        
    }
    @Transactional
   public Techstaff/*boolean*/ updateStaff_SP(Techstaff cli){
                return TechstaffRepository.sp_insert_update_techstaff(  cli.codigo,
                                                                cli.nombre,
                                                                cli.apepaterno,
                                                                cli.apematerno,
                                                                cli.dni,
                                                                cli.celular,
                                                                cli.fechaingreso,
                                                                cli.fechacese,
                                                                cli.comentarios,
                                                                cli.idestado,
                                                                cli.idcontrata,
                                                                2); 
        
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

    @Transactional
    public ResponseEntity<String>  actualizarEstado(int idestado, Long codigo) {

        try {            
            TechstaffRepository.actualizarEstado(idestado,codigo);
            // La actualización fue exitosa
            return ResponseEntity.ok("Operación completada correctamente");
        } catch (Exception ex) {
            // Manejar la excepción (por ejemplo, registrar un error)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al realizar la operación");
        }

    }

    @Transactional
    public List<Techstaff_list> getAllStaff_SP(String p_descripcion , int id_contrata){

        return TechListstaffRepository.sp_listar_allstaff(p_descripcion,id_contrata);
    }

}
