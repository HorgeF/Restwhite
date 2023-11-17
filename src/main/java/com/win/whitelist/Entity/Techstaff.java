package com.win.whitelist.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //@Entity es una anotación (o decorador) de JPA (Java Persistence API)
@Table(name = "techstaff")
@Data //@Data es un decorador que autogenera los getters y setters
public class Techstaff {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long codigo;
    public String nombre;
    public String apepaterno;
    public String apematerno;
    public String dni;
    public String celular;
    public Date fechaingreso;
    public Date fechacese;
    public String comentarios;
    public Long idestado;
    public Long idcontrata;  
    
}
