package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.validator.EmployeeInputValidator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
/**
 * Implementation class for employee resource.
 */

@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeInputValidator employeeInputValidator;
	
    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {

    	Optional<Employee> employee = employeeService.findEmployeeByEmployeeId(id);
    	
        return employee.isPresent() ? new ResponseEntity<>(employee.get(),HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    
    @Override
    public ResponseEntity<Object> createEmployee(final Employee employee) {

    	if(employee.getId()!=null)
    	{
            Optional<Employee> newEmployee = employeeService.findEmployeeByEmployeeId(employee.getId().toString());
            if(newEmployee.isPresent())
                return new ResponseEntity<>("Employee Already Exists in Table..",HttpStatus.FORBIDDEN);
        }
    	
    	Optional<List<String>> error = employeeInputValidator.getErrorInEmployee(employee);
        if(error.isPresent())
        {
        	 return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
        }
        
    	return employeeService.createEmployee(employee) ? new ResponseEntity<>("Employee Created Successfully",HttpStatus.CREATED) :
            new ResponseEntity<>("Error Occured while creating Employee", HttpStatus.EXPECTATION_FAILED);
            

    }
}
