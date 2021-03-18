package com.paypal.bfs.test.employeeserv.validator;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class EmployeeInputValidator {
	
	 private static final int MAX_LENGTH = 255;
	 
	 public Optional<List<String>> getErrorInEmployee(Employee employee) 
	 {
	        List<String> errorList = new ArrayList<>();

	        checkFieldRequiredPresentOrNot(employee, errorList);

	        checkLengthValidOrNot(employee, errorList);

	        return errorList.size() > 0 ? Optional.of(errorList) : Optional.empty();

	 }
	 private boolean isEmpty(String value)
	 {
	        return value==null;
	 }
	 private boolean isMaxLength(String value,int maxLength)
	 {
	        return !isEmpty(value) && value.length() > maxLength;
	 }
	 private void checkLengthValidOrNot(Employee employee, List<String> errorList)
	 {
	        if(isMaxLength(employee.getFirstName(),MAX_LENGTH)){
	        	errorList.add("MAX LENGTH ALLOWED IS "+MAX_LENGTH+" FOR FIRST NAME");
	        }
	        if(isMaxLength(employee.getLastName(),MAX_LENGTH)){
	        	errorList.add("MAX LENGTH ALLOWED IS "+MAX_LENGTH+" FOR LAST NAME");
	        }
	        if(isMaxLength(employee.getAddressLine1(),MAX_LENGTH)){
	        	errorList.add("MAX LENGTH ALLOWED IS "+MAX_LENGTH+" FOR ADDRESS LINE 1");
	        }
	        if(isMaxLength(employee.getAddressLine2(),MAX_LENGTH)){
	        	errorList.add("MAX LENGTH ALLOWED IS "+MAX_LENGTH+" FOR ADDRESS LINE 2");
	        }
	        if(isMaxLength(employee.getCity(),MAX_LENGTH)){
	        	errorList.add("MAX LENGTH ALLOWED IS "+MAX_LENGTH+" FOR CITY");
	        }
	        if(isMaxLength(employee.getState(),MAX_LENGTH)){
	        	errorList.add("MAX LENGTH ALLOWED IS "+MAX_LENGTH+" FOR STATE");
	        }
	        if(isMaxLength(employee.getCountry(),MAX_LENGTH)){
	        	errorList.add("MAX LENGTH ALLOWED IS "+MAX_LENGTH+" FOR COUNTRY");
	        }
	       
	        if(isMaxLength(employee.getZipCode(),8)){
	        	errorList.add("MAX LENGTH ALLOWED IS 8 FOR FIRST NAME");
	        }
	    }
	 
	 private void checkFieldRequiredPresentOrNot(Employee employee, List<String> errorList) 
	 {
		 
	        if(isEmpty(employee.getFirstName())){
	        	errorList.add("FIRST NAME IS REQUIRED");
	        }

	        if(isEmpty(employee.getLastName())){
	        	errorList.add("LAST NAME IS REQUIRED");
	        }

	        if(isEmpty(employee.getDateOfBirth())){
	        	errorList.add("DATE OF BIRTH IS REQUIRED");
	        }

	        if(isEmpty(employee.getAddressLine1())){
	        	errorList.add("ADDRESS LINE 1 IS REQUIRED");
	        }

	        if(isEmpty(employee.getCity())){
	        	errorList.add("CITY IS REQUIRED");
	        }
	        if(isEmpty(employee.getState())){
	        	errorList.add("STATE IS REQUIRED");
	        }
	        if(isEmpty(employee.getCountry())){
	        	errorList.add("COUNTRY IS REQUIRED");
	        }
	        
	        if(isEmpty(employee.getZipCode())){
	        	errorList.add("ZIP CODE IS REQUIRED");
	        }
	    }
	 
}
