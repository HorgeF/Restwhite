package com.win.whitelist.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.win.whitelist.Entity.Techstaff_list;
@Repository
public interface TechstaffListRepository extends JpaRepository<Techstaff_list, Long> {

    @Procedure(name = "sp_listar_allstaff")
    List<Techstaff_list> sp_listar_allstaff(@Param("p_descripcion") String nombre , 
                                            @Param("p_id_contrata") int id_contrata);
}
