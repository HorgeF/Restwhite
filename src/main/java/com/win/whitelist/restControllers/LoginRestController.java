package com.win.whitelist.restControllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.win.whitelist.Entity.Login;
import com.win.whitelist.Service.LoginService;


import java.util.Map;


@RequestMapping("/api/")
@RestController
public class LoginRestController {
    
     @Autowired
     LoginService loginservice;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Login loginrequest) {
        
        // Realiza la autenticación utilizando el servicio de autenticación
        String username = loginrequest.getUsuario();
        String password = loginrequest.getPassword();

        Login authenticatedUser = loginservice.authenticate(username, password);

        if (authenticatedUser != null) {
            // Usuario autenticado, puedes devolver un token JWT u otra información relevante
                   String token = generateJwtToken(authenticatedUser); // Implementa tu propia lógica para generar un token
                   // Devuelve un objeto JSON con el token y código 1 (éxito)
                   Map<String, Object> response = new HashMap<>();
                   response.put("token", token);
                   response.put("code", 1);
                   response.put("id_contrata", authenticatedUser.id_contrata);
                   response.put("razonsocial", authenticatedUser.razon_social);
                   return ResponseEntity.ok().body(response);

        } else {
            // Usuario no autenticado
                    Map<String, Object> response = new HashMap<>();
                    response.put("token", null);
                    response.put("code", 0);
                    response.put("id_contrata", "" );
                    response.put("razonsocial", "");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    // Método para generar un token JWT (puedes implementar tu propia lógica aquí)
    private String generateJwtToken(Login user) {
        // Implementa tu lógica para generar un token JWT aquí
        // Este método es solo un ejemplo y necesitarás una implementación real.
        return "jwt-token";
    }


    @PostMapping("/adduser")
    Login nuevoUsuario(@RequestBody Login user){
        return loginservice.addLogin(user);
    }

}
