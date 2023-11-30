package com.win.whitelist.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //@Entity es una anotación (o decorador) de JPA (Java Persistence API)
@Table(name = "obs_techstaff")
@Data //@Data es un decorador que autogenera los getters y setters
public class ObservationStaff {

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_obs;
    public Long codigo;
    public String observacion;
    
}
