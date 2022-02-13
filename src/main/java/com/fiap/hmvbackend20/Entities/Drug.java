package com.fiap.hmvbackend20.Entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "TB_DRUGS")
public class Drug {

    private static final long serialVersionUID = 1L;

    public Drug(){}

    public Drug(String drugName){
        this.drugName = drugName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "drugId")
    Long drugId;

    @Column
    String drugName;

}
