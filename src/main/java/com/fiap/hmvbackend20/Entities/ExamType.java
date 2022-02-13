package com.fiap.hmvbackend20.Entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "TB_EXAMTYPES")
public class ExamType {

    private static final long serialVersionUID = 1L;

    public ExamType(){}

    public ExamType(String examName){
        this.examName = examName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "examTypeId")
    Long examTypeId;

    @Column
    String examName;

}
