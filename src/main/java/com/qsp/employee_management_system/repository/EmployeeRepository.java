package com.qsp.employee_management_system.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.employee_management_system.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
		Employee findByPhone(long phone);
		
		Employee getByEmail(String email);
		
		List<Employee> findBySalaryLessThan(double salary);
		
		List<Employee> findBySalaryGreaterThan(double salary);
		
		List<Employee> findBySalaryBetween(double salary1,double salary2);
		
		List<Employee> findByName(String name);
		
		List<Employee> findByAddress(String address);

		List<Employee> findByDesignation(String designation);

//		@Query("SELECT e FROM Employee e WHERE e.address=?1")
//		List<Employee> employeeByAddress(String address);

//		@Query("SELECT e FROM Employee e WHERE e.name=?1")
//		List<Employee> personByName(String name);



		
}
