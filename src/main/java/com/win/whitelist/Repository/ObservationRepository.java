package com.win.whitelist.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.win.whitelist.Entity.ObservationStaff;


public interface ObservationRepository extends JpaRepository<ObservationStaff, Long>  {
    
    @Procedure(name = "sp_obtener_observaciones")
     List<ObservationStaff> sp_obtener_observaciones(@Param("codigox") Long codigo);

}
