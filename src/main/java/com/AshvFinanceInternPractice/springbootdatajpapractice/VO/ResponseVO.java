package com.AshvFinanceInternPractice.springbootdatajpapractice.VO;

import com.AshvFinanceInternPractice.springbootdatajpapractice.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO {
    private Student student;
    private Department department;
}
