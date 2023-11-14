package com.win.whitelist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.win.whitelist.Entity.Login;


@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {


    @Query("SELECT u FROM Login u WHERE u.usuario = :usuario AND u.password = :password")
    Login findByUsernameAndPassword(@Param("usuario") String usuario, @Param("password") String password);
    
} 
