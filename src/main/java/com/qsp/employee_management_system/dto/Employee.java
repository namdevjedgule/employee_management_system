package com.qsp.employee_management_system.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="employee_info")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employeeId")
	private int id;
	
	@Column(name="employeeName")
//	@NotNull(message = "name can't be null")
//	@NotBlank(message = "name cant be blank")
	@NotEmpty(message = "name cant be empty")
	private String name;
	
	@Column(name="employeePhone", unique = true)
	@Min(value = 6000000000L)
	@Max(value = 9999999999L)
	private long phone;
	
	@Column(name="employeeAddress")
	@NotEmpty(message = "address can't be empty")
	private String address;
	
	@Column(name="employeeEmail", unique = true)
	@NotEmpty(message = "email can't be empty")
	@Email(regexp = "[a-z0-9._$]+@[a-z]+\\.[a-z]{2,3}")
	private String email;
	
	@Column(name="employeePassword")
	private String password;
	
	@Column(name="employeeSalary")
	private double salary;
	
	@Column(name="employeeDesignation")
	private String designation;
	
	@Column(name="employeeGrade")
	private char grade;
}
