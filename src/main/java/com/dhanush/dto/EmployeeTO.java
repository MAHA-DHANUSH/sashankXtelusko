package com.dhanush.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
//annotation from lombok genereates getter and setter
@Builder
//generates a builder pattern for the class.
public class EmployeeTO {

    private String id;
    private String empName;
    private String location;
    private BigDecimal salary;
}
