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
@Table(name = "TB_PRESCRIPTIONS")
public class Prescription {

    private static final long serialVersionUID = 1L;

    public Prescription(){}

    public Prescription(String prescription, LocalDate prescriptionDate){
        this.prescription = prescription;
        this.prescriptionDate = prescriptionDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prescriptionId")
    Long prescriptionId;

    @Column
    String prescription;

    @Column
    LocalDate prescriptionDate;

    @ManyToOne
    @JoinColumn(name="userId")
    UserDetails patient;

    @ManyToOne
    @JoinColumn(name="drugId")
    Drug drug;


}
