/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.win.whitelist.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author UPN
 */
//la clase Cliente es un Java Bean


@Entity //@Entity es una anotación (o decorador) de JPA (Java Persistence API)
@Table(name = "usuario")
@Data //@Data es un decorador que autogenera los getters y setters
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long codigo;
    public String usuario;
    public String password;

}
