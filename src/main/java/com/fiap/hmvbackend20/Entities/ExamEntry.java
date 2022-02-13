package com.fiap.hmvbackend20.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "TB_EXAMENTRIES")
public class ExamEntry {

    private static final long serialVersionUID = 1L;

    public ExamEntry(){}

    public ExamEntry(String examResult, LocalDateTime examDateTime){
        this.examResult = examResult;
        this.examDateTime = examDateTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "examEntryId")
    Long examEntryId;

    @Column
    String examResult;

    @Column
    LocalDateTime examDateTime;

    @ManyToOne
    @JoinColumn(name="userId")
    UserDetails patient;

    @ManyToOne
    @JoinColumn(name="examTypeId")
    ExamType examType;
}
