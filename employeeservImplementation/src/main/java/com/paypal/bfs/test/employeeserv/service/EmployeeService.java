package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.mapper.EmployeeMapper;
import com.paypal.bfs.test.employeeserv.model.EmployeeTable;
import com.paypal.bfs.test.employeeserv.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmployeeService {
 
	 @Autowired
	 private EmployeeMapper employeeMapper;
	 
	 @Autowired
	 private EmployeeRepository employeeRepository;
	
	 /* To Store Employees*/
	 private final ConcurrentHashMap<Integer, Employee> employeeMap = new ConcurrentHashMap<>();
	 
	 public Optional<Employee> findEmployeeByEmployeeId(String id){

		    Employee employee = employeeMap.get(Integer.valueOf(id));
		    
	        if(employee!=null)
	            return Optional.of(employee);

	        Optional<EmployeeTable> employeeTable = employeeRepository.findById(Integer.valueOf(id));
	        if(employeeTable.isPresent())
	        {
	            Employee newEmployee = employeeMapper.employeeTableMapToEmployee(employeeTable.get());
	            if(newEmployee!=null)
	            {
	                employeeMap.put(newEmployee.getId(),newEmployee);
	                return Optional.of(newEmployee);
	            }

	        }
	        return Optional.empty();
	    }

	    @SuppressWarnings("finally")
		public boolean createEmployee(Employee employee)
	    {
	    	 EmployeeTable employeeTable = null;
	         try
	         {
	             employeeTable = employeeRepository.save(employeeMapper.employeeMapToEmployeeTable(employee));
	             if(employeeTable!=null)
	            	 	return true;
	         }
	         catch(Exception e)
	         {
	             System.out.println("Error occured while creating Employee");
	         }
	         finally
	         {
	        	 return false;
	         }
	    }
	    
	
}
