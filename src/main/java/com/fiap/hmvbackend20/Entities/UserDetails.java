package com.fiap.hmvbackend20.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.catalina.User;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "TB_USERDETAILS")
public class UserDetails {

    private static final long serialVersionUID = 1L;

    public UserDetails(){}

    public UserDetails(String name, String email, String cpf, String password){
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    Long userId;

    @Column
    String name;

    @Column
    String email;

    @Column
    String cpf;

    @Column
    String password;

 }
