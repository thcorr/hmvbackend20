package com.fiap.hmvbackend20.DTO;

import com.fiap.hmvbackend20.Entities.UserDetails;
import lombok.Getter;

@Getter
public class UserDetailsDTO {

    String name;
    String email;
    String cpf;
    String password;

    public UserDetails transform(){
        return new UserDetails(name, email, cpf, password);
    }
}
