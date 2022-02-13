package com.fiap.hmvbackend20.DTO;

import com.fiap.hmvbackend20.Entities.Drug;
import lombok.Getter;

@Getter
public class DrugDTO {

    String drugName;

    public Drug transform(){
        return new Drug(drugName);
    }
}
