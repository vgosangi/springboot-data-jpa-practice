package com.AshvFinanceInternPractice.springbootdatajpapractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private Long studentId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String gaurdianName;
    private String gauardianEmail;
    private String getGaurdianMobile;
}
