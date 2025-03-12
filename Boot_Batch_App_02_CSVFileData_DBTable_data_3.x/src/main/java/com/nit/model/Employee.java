package com.nit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Batch_Employee")
public class Employee {

    @Id
    private Integer id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30)
    private String address;

    @Column(nullable = false)
    private Double salary;

    @Column(nullable = true)
    private Double grossSalary;

    @Column(nullable = true)
    private Double netSalary;

}
