package com.qsp.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.exception.AddressNotFoundException;
import com.qsp.employee_management_system.exception.EmailNotFoundException;
import com.qsp.employee_management_system.exception.NoDataAvailableException;
import com.qsp.employee_management_system.exception.PhoneNotFoundException;
import com.qsp.employee_management_system.util.ResponseStructure;
import com.qsp.student_management_system.exception.IdNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public ResponseStructure<Employee> saveEmployee(Employee employee) {
		double salary = employee.getSalary();
		if (salary <= 10000) {
			employee.setGrade('D');
		} else if (salary > 10000 && salary <= 20000) {
			employee.setGrade('C');
		} else if (salary > 20000 && salary <= 40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("saved successfull");
		structure.setData(dao.saveEmployee(employee));

		return structure;
	}

	public ResponseStructure<List<Employee>> saveAll(@RequestBody List<Employee> list) {
		for (Employee employee : list) {
			double salary = employee.getSalary();
			if (salary <= 10000) {
				employee.setGrade('D');
			} else if (salary > 10000 && salary <= 20000) {
				employee.setGrade('C');
			} else if (salary > 20000 && salary <= 40000) {
				employee.setGrade('B');
			} else {
				employee.setGrade('A');
			}
		}
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("saved successfull");
		structure.setData(dao.saveAll(list));

		return structure;
	}

	public ResponseStructure<Employee> findEmployeeById(@RequestParam int id) {
		Employee employee = dao.findEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("found successfull");
			structure.setData(employee);

			return structure;
		} else {
			throw new IdNotFoundException("Student with id " +id+" not found");
		}
	}

	public ResponseStructure<List<Employee>> findAll() {
		List<Employee> list = dao.findEmployees();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (list.isEmpty()) {
			throw new NoDataAvailableException("No Employee Available");
		} else {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("found successfull");
			structure.setData(list);

			return structure;
		}
	}

	public ResponseStructure<List<Employee>> findBySalaryLessThan(double salary) {
		List<Employee> list = dao.salaryLessThan(salary);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (list.isEmpty()) {
			throw new NoDataAvailableException("No Employee Available");
		} else {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("found successfull");
			structure.setData(list);

			return structure;
		}
	}

	public ResponseStructure<List<Employee>> findBySalaryGreaterThan(double salary) {
		List<Employee> list = dao.salaryGreaterThan(salary);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (list.isEmpty()) {
			throw new NoDataAvailableException("No Employee Available");
		} else {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("found successfull");
			structure.setData(list);

			return structure;
		}
	}

	public ResponseStructure<List<Employee>> findBySalaryBetween(double salary1, double salary2) {
		List<Employee> list = dao.findBySalaryBetween(salary1, salary2);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (list.isEmpty()) {
			throw new NoDataAvailableException("No Employee Available");
		} else {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("found successfull");
			structure.setData(list);

			return structure;
		}
	}

	public ResponseStructure<List<Employee>> findEmployeeByName(String name) {
		List<Employee> list = dao.findEmployeeByName(name);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (list.isEmpty()) {
			throw new NoDataAvailableException("No Employee Available");
		} else {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("found successfull");
			structure.setData(list);
			return structure;
		}
	}

	public ResponseStructure<Employee> findByPhone(long phone) {
		Employee employee = dao.findByPhone(phone);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("found successfull");
			structure.setData(employee);
			return structure;
		} else {
			throw new PhoneNotFoundException("No employee with "+phone+" number.");
		}

	}

	public ResponseStructure<Employee> findByEmail(String email) {
		Employee employee = dao.findByEmail(email);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("found successfull");
			structure.setData(employee);

			return structure;
		} else {
			throw new EmailNotFoundException("no employee with "+email+" email id.");
		}
	}

	public ResponseStructure<List<Employee>> findByAddress(String address) {
		List<Employee> list = dao.findByAddress(address);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (list.isEmpty()) {
			throw new AddressNotFoundException("Address not found.");
		} else {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("found successfull");
			structure.setData(list);

			return structure;
		}
	}

	public ResponseStructure<List<Employee>> findByDesignation(String designation) {
		List<Employee> list = dao.findByDesignation(designation);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (list.isEmpty()) {
			throw new NoDataAvailableException("No Employee found");
		} else {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("found successfull");
			structure.setData(list);

			return structure;
		}
	}

	public ResponseStructure<Employee> updateName(@RequestParam int id, @RequestParam String name) {
		Employee employee = dao.updateName(id, name);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("update successfull");
		structure.setData(employee);

		return structure;
	}

	public ResponseStructure<Employee> updatePhone(@RequestParam int id, @RequestParam long phone) {
		Employee employee = dao.updatePhone(id, phone);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("update successfull");
		structure.setData(employee);

		return structure;
	}

	public ResponseStructure<Employee> updateAddress(@RequestParam int id, @RequestParam String address) {
		Employee employee = dao.updateAddress(id, address);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("update successfull");
		structure.setData(employee);

		return structure;
	}

	public ResponseStructure<Employee> updateEmail(@RequestParam int id, @RequestParam String email) {
		Employee employee = dao.updateEmail(id, email);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("update successfull");
		structure.setData(employee);

		return structure;
	}

	public ResponseStructure<Employee> updateDesignation(@RequestParam int id, @RequestParam String designation) {
		Employee employee = dao.updateDesignation(id, designation);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("update successfull");
		structure.setData(employee);

		return structure;
	}

	public ResponseStructure<Employee> updatePassword(@RequestParam int id, @RequestParam String password) {
		Employee employee = dao.updatePassword(id, password);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("update successfull");
		structure.setData(employee);

		return structure;
	}

	public ResponseStructure<Employee> updatePassword(@RequestParam long phone, @RequestParam String password) {
		Employee employee = dao.updatePassword(phone, password);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("update successfull");
		structure.setData(employee);

		return structure;
	}

	public ResponseStructure<Employee> updatePassword(@RequestParam String email, @RequestParam String password) {
		Employee employee = dao.updatePassword(email, password);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("update successfull");
		structure.setData(employee);

		return structure;
	}

	public ResponseStructure<Employee> updateAll(@RequestParam int id, @RequestBody Employee employee) {
		Employee employee2 = dao.updateAll(id, employee);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("update successfull");
		structure.setData(employee2);

		return structure;
	}

	public ResponseStructure<Employee> deleteEmployee(@RequestParam int id) {
		Employee employee = dao.deleteEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee!=null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("deleted successfully");
			structure.setData(employee);
			return structure;
		} else {
			throw new NoDataAvailableException("No data availale in the database.");
		}
	}

	public ResponseStructure<Employee> deleteEmployeeByPhone(@RequestParam long phone) {
		Employee employee = dao.deleteEmployee(phone);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee!=null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("deleted successfully");
			structure.setData(employee);
			return structure;
		} else {
			throw new PhoneNotFoundException("No employee found by "+phone+" number");
		}
	}

	public ResponseStructure<Employee> deleteEmployeeByEmail(@RequestParam String email) {
		Employee employee = dao.deleteEmployee(email);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee!=null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("deleted successfully");
			structure.setData(employee);
			return structure;
		} else {
			throw new EmailNotFoundException("Email not found.");
		}
	}

	public ResponseStructure<List<Employee>> deleteAllEmployee() {
		List<Employee> list=dao.deleteAllEmployee();
		ResponseStructure<List<Employee>> structure=new ResponseStructure<List<Employee>>();
		if (list.isEmpty()) {
			throw new NoDataAvailableException("No Employee found");
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("deleted successfully");
			structure.setData(list);
			return structure;
		}
	}

	public ResponseStructure<List<Employee>> deleteAllEmployeeByAddress(@RequestParam String address) {
		List<Employee> list=dao.deleteAllEmployeeByAddress(address);
		ResponseStructure<List<Employee>> structure=new ResponseStructure<List<Employee>>();
		if (list.isEmpty()) {
			throw new AddressNotFoundException("Address Not found.");
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("deleted successfully");
			structure.setData(list);
			return structure;
		}
	}

	public ResponseStructure<List<Employee>> deleteAllEmployeeByDesignation(@RequestParam String designation) {
		List<Employee> list=dao.deleteAllEmployeeByDesignation(designation);
		ResponseStructure<List<Employee>> structure=new ResponseStructure<List<Employee>>();
		if (list.isEmpty()) {
			throw new NoDataAvailableException("No Employee found with designation: "+designation);
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("deleted successfully");
			structure.setData(list);
			return structure;
		}
	}

	public ResponseStructure<List<Employee>> deleteAllEmployeeByName(@RequestParam String name) {
		List<Employee> list=dao.deleteAllEmployeeByName(name);
		ResponseStructure<List<Employee>> structure=new ResponseStructure<List<Employee>>();
		if (list.isEmpty()) {
			throw new NoDataAvailableException("No Employee found with name: "+name);
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("deleted successfully");
			structure.setData(list);
			return structure;
		}
	}

	public ResponseStructure<Employee> loginEmployee(@RequestParam String userName, @RequestParam String password) {
		Employee employee = dao.loginEmployee(userName);
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		if (employee != null) {
			if (employee.getPassword().equals(password)) {
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setMessage("Login successful");
				structure.setData(employee);
				return structure;

			} else {
				throw new NoDataAvailableException("Invalid password");
			}
		} else {
			throw new NoDataAvailableException("No Employee found");
		}
	}
}
