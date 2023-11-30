package com.win.whitelist.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.win.whitelist.Entity.Techstaff;


@Repository
public interface TechstaffRepository extends JpaRepository<Techstaff, Long>   {
    // update techstaff set idestado = 2 where codigo = 1
    @Modifying
    @Query("UPDATE Techstaff u set u.idestado = :idestado WHERE u.codigo = :codigo")
    void actualizarEstado(@Param("idestado") int idestado, @Param("codigo") Long codigo);



     @Procedure(name = "sp_insert_update_techstaff")
     Techstaff sp_insert_update_techstaff(@Param("p_codigo") Long codigo , 
                                                @Param("p_nombre") String nombre,
                                                @Param("p_apepaterno") String apepaterno,
                                                @Param("p_apematerno") String apematerno,
                                                @Param("p_dni") String dni,
                                                @Param("p_celular") String celular,
                                                @Param("p_fechaingreso") String fechaingreso,
                                                @Param("p_fechacese") String fechacese,
                                                @Param("p_comentarios") String comentarios,
                                                @Param("p_idestado") int idestado,
                                                @Param("p_idcontrata") int idcontrata,
                                                @Param("p_accion") int id_accion);

}
