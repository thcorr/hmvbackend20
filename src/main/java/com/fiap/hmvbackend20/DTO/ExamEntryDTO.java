package com.fiap.hmvbackend20.DTO;

import com.fiap.hmvbackend20.Entities.ExamEntry;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExamEntryDTO {
    String examResult;
    LocalDateTime examDateTime;
    Long patientId;
    Long examTypeId;

    public ExamEntry transform(){
        return new ExamEntry(examResult, examDateTime);
    }

}
