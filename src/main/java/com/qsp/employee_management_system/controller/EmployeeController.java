package com.qsp.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.service.EmployeeService;
import com.qsp.employee_management_system.util.ResponseStructure;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//	@Autowired
//	private EmployeeDao dao;

	@Autowired
	private EmployeeService service;

	@PostMapping
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PostMapping("/all")
	public ResponseStructure<List<Employee>> saveEmployee(@RequestBody List<Employee> list) {
		return service.saveAll(list);
	}

	@GetMapping("/find/id")
	public ResponseStructure<Employee> findEmployee(@RequestParam int id) {
		return service.findEmployeeById(id);
	}

	@GetMapping("/find/all")
	public ResponseStructure<List<Employee>> findAll() {
		return service.findAll();
	}

	@GetMapping("/salary/lessthan")
	public ResponseStructure<List<Employee>> findBySalaryLessThan(double salary) {
		return service.findBySalaryLessThan(salary);
	}

	@GetMapping("/salary/greaterthan")
	public ResponseStructure<List<Employee>> findBySalaryGreaterThan(double salary) {
		return service.findBySalaryGreaterThan(salary);
	}

	@GetMapping("/salary/between")
	public ResponseStructure<List<Employee>> findBySalaryBetween(double salary1, double salary2) {
		return service.findBySalaryBetween(salary1, salary2);
	}

	@GetMapping("/find/name")
	public ResponseStructure<List<Employee>> findEmployeeByName(@RequestParam String name) {
		return service.findEmployeeByName(name);
	}

	@GetMapping("/find/phone")
	public ResponseStructure<Employee> findByPhone(@RequestParam long phone) {
		return service.findByPhone(phone);
	}

	@GetMapping("/find/email")
	public ResponseStructure<Employee> findByEmail(@RequestParam String email) {
		return service.findByEmail(email);
	}

	@GetMapping("/find/address")
	public ResponseStructure<List<Employee>> findByAddress(@RequestParam String address) {
		return service.findByAddress(address);
	}

	@GetMapping("/find/designation")
	public ResponseStructure<List<Employee>> findByDesignation(@RequestParam String designation) {
		return service.findByDesignation(designation);
	}

	@PatchMapping("/update/name")
	public ResponseStructure<Employee> updateName(@RequestParam int id, @RequestParam String name) {
		return service.updateName(id, name);
	}

	@PatchMapping("/update/phone")
	public ResponseStructure<Employee> updatePhone(@RequestParam int id, @RequestParam long phone) {
		return service.updatePhone(id, phone);
	}

	@PatchMapping("/update/address")
	public ResponseStructure<Employee> updateAddress(@RequestParam int id, @RequestParam String address) {
		return service.updateAddress(id, address);
	}

	@PatchMapping("/update/email")
	public ResponseStructure<Employee> updateEmail(@RequestParam int id, @RequestParam String email) {
		return service.updateEmail(id, email);
	}

	@PatchMapping("/update/designation")
	public ResponseStructure<Employee> updateDesignation(@RequestParam int id, @RequestParam String designation) {
		return service.updateDesignation(id, designation);
	}

	@PatchMapping("/update/password")
	public ResponseStructure<Employee> updatePassword(@RequestParam int id, @RequestParam String password) {
		return service.updatePassword(id, password);
	}

	@PatchMapping("/update/password/byphone")
	public ResponseStructure<Employee> updatePassword(@RequestParam long phone, @RequestParam String password) {
		return service.updatePassword(phone, password);
	}

	@PatchMapping("/update/password/byemail")
	public ResponseStructure<Employee> updatePassword(@RequestParam String email, @RequestParam String password) {
		return service.updatePassword(email, password);
	}

	@PutMapping("/update/all")
	public ResponseStructure<Employee> updateAll(@RequestParam int id, @RequestBody Employee employee) {
		return service.updateAll(id, employee);
	}

	@DeleteMapping("/delete/byid")
	public ResponseStructure<Employee> deleteEmployee(@RequestParam int id) {
		return service.deleteEmployee(id);
	}

	@DeleteMapping("/delete/byphone")
	public ResponseStructure<Employee> deleteEmployee(@RequestParam long phone) {
		return service.deleteEmployeeByPhone(phone);
	}

	@DeleteMapping("/delete/byemail")
	public ResponseStructure<Employee> deleteEmail(@RequestParam String email) {
		return service.deleteEmployeeByEmail(email);
	}

	@DeleteMapping("/delete/all")
	public ResponseStructure<List<Employee>> deleteAllEmployee() {
		return service.deleteAllEmployee();
	}

	@DeleteMapping("/delete/all/address")
	public ResponseStructure<List<Employee>> deleteAllEmployeeByAddress(@RequestParam String address) {
		return service.deleteAllEmployeeByAddress(address);
	}

	@DeleteMapping("/delete/all/designation")
	public ResponseStructure<List<Employee>> deleteAllEmployeeByDesignation(@RequestParam String designation) {
		return service.deleteAllEmployeeByDesignation(designation);
	}

	@DeleteMapping("/delete/all/name")
	public ResponseStructure<List<Employee>> deleteAllEmployeeByName(@RequestParam String name) {
		return service.deleteAllEmployeeByName(name);
	}

	@GetMapping("/login")
	public ResponseStructure<Employee> loginEmployee(@RequestParam String userName, @RequestParam String password) {
		return service.loginEmployee(userName, password);
	}

}
