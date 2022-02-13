package com.fiap.hmvbackend20.DTO;

import com.fiap.hmvbackend20.Entities.ExamType;
import lombok.Getter;

@Getter
public class ExamTypeDTO {
    String examName;

    public ExamType transform(){
        return new ExamType(examName);
    }
}
