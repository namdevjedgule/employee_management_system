package com.qsp.employee_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepository repo;
	
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
		
	}

	public List<Employee> saveAll(List<Employee> list) {
		return repo.saveAll(list);
	}
	
	public Employee findEmployee(int id) {
		Optional<Employee> optional=repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<Employee> findEmployees() {
		return repo.findAll();
	}
	
	public String updateEmployee(@RequestParam int id,@RequestBody Employee employee) 
	{
		Optional<Employee> optional=repo.findById(id);
		if(optional.isPresent())
		{
			employee.setId(id);
			repo.save(employee);
			return "update successful";
		}
		else {
			return "employee with id "+id+" not found";
		}
	}
	
	public List<Employee> salaryLessThan(double salary) {
		return repo.findBySalaryLessThan(salary);
	}

	public List<Employee> salaryGreaterThan(double salary) {
		return repo.findBySalaryGreaterThan(salary);
	}

	public List<Employee> findBySalaryBetween(double salary1,double salary2) {
		return repo.findBySalaryBetween(salary1, salary2);
	}
	
	public List<Employee> findEmployeeByName(String name) {
		return repo.findByName(name);
	}

	public Employee findByPhone(long phone) {
		return repo.findByPhone(phone);
	}

	public Employee findByEmail(String email) {
		return repo.getByEmail(email);
	}

	public List<Employee> findByAddress(String address) {
		return repo.findByAddress(address);
	}

	public List<Employee> findByDesignation(String designation) {
		return repo.findByDesignation(designation);
	}

	public List<Employee> findAll() {
		return repo.findAll();
	}

	public Employee updateName(int id, String name) {
		Employee employee = repo.findById(id).get();
		if (employee != null) {
			employee.setName(name);
			return repo.save(employee);
		} else {
			return null;
		}
	}

	public Employee updatePhone(int id, long phone) {
		Employee employee = repo.findById(id).get();
		if (employee != null) {
			employee.setPhone(phone);
			return repo.save(employee);
		} else {
			return null;
		}
	}

	public Employee updateAddress(int id, String address) {
		Employee employee = repo.findById(id).get();
		if (employee != null) {
			employee.setAddress(address);
			return repo.save(employee);
		} else {
			return null;
		}
	}

	public Employee updateEmail(int id, String email) {
		Employee employee = repo.findById(id).get();
		if (employee != null) {
			employee.setEmail(email);
			return repo.save(employee);
		} else {
			return null;
		}
	}

	public Employee updateDesignation(int id, String designation) {
		Employee employee = repo.findById(id).get();
		if (employee != null) {
			employee.setDesignation(designation);
			return repo.save(employee);
		} else {
			return null;
		}
	}

	public Employee updatePassword(int id, String password) {
		Employee employee = repo.findById(id).get();
		if (employee != null) {
			employee.setPassword(password);
			return repo.save(employee);
		} else {
			return null;
		}
	}

	public Employee updatePassword(long phone, String password) {
		Employee employee = repo.findByPhone(phone);
		if (employee != null) {
			employee.setPassword(password);
			return repo.save(employee);
		} else {
			return null;
		}
	}

	public Employee updatePassword(String email, String password) {
		Employee employee = repo.getByEmail(email);
		if (employee != null) {
			employee.setPassword(password);
			return repo.save(employee);
		} else {
			return null;
		}
	}

	public Employee updateAll(int id, Employee employee) {
		Optional<Employee> employee2 = repo.findById(id);
		if (employee2.isPresent()) {
			employee.setId(id);
			return repo.save(employee);
		} else {
			return null;
		}
	}

	public Employee deleteEmployee(int id) {
		Optional<Employee> employee = repo.findById(id);
		if (employee.isPresent()) {
			repo.deleteById(id);
			return employee.get();
		} else {
			return null;
		}
	}

	public Employee deleteEmployee(long phone) {
		Employee employee = repo.findByPhone(phone);
		if (employee != null) {
			repo.delete(employee);
			return employee;
		} else {
			return null;
		}
	}

	public Employee deleteEmployee(String email) {
		Employee employee = repo.getByEmail(email);
		if (employee != null) {
			repo.delete(employee);
			return employee;
		} else {
			return null;
		}
	}

	public List<Employee> deleteAllEmployee() {
		repo.deleteAll();
		return null;
	}

	public List<Employee> deleteAllEmployeeByAddress(String address) {
		List<Employee> list = repo.findByAddress(address);
		if (list.isEmpty()) {
			return null;
		} else {
			repo.deleteAll(list);
			return list;
		}
	}

	public List<Employee> deleteAllEmployeeByDesignation(String designation) {
		List<Employee> list = repo.findByDesignation(designation);
		if (list.isEmpty()) {
			return null;
		} else {
			repo.deleteAll(list);
			return list;
		}
	}

	public List<Employee> deleteAllEmployeeByName(String name) {
		List<Employee> list = repo.findByName(name);
		if (list.isEmpty()) {
			return null;
		} else {
			repo.deleteAll(list);
			return list;
		}
	}

	public Employee loginEmployee(String userName) {
		try {
			long phone=Long.parseLong(userName);
			
			return repo.findByPhone(phone);
		} catch (Exception e) {
					
			return repo.getByEmail(userName);		
		}
	}
	
}
