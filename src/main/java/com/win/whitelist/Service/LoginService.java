package com.win.whitelist.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.whitelist.Entity.Login;
import com.win.whitelist.Repository.LoginRepository;


@Service
public class LoginService {
    
    @Autowired //Al usar Autowired habilitamos la inyección de dependencia.
    private LoginRepository loginRepository;

    public Login/*boolean*/ addLogin(Login cli){
        return loginRepository.save(cli);
        
    }
        
    public Login authenticate(String username, String password) {
        return loginRepository.findByUsernameAndPassword(username, password);
    }

}
