package com.paypal.bfs.test.employeeserv.mapper;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.model.EmployeeTable;
import org.springframework.stereotype.Component;


@Component
public class EmployeeMapper {

	public EmployeeTable employeeMapToEmployeeTable(Employee employee)
	{
        EmployeeTable employeeTable = new EmployeeTable();
        employeeTable.setId(Integer.valueOf(employee.getId()));
        employeeTable.setFirst_name(employee.getFirstName());
        employeeTable.setLast_name(employee.getLastName());
        employeeTable.setDate_of_birth(employee.getDateOfBirth());
        employeeTable.setAddress_line1(employee.getAddressLine1());
        employeeTable.setAddress_line2(employee.getAddressLine2());
        employeeTable.setCity(employee.getCity());
        employeeTable.setState(employee.getState());
        employeeTable.setCountry(employee.getCountry());
        employeeTable.setZip_code(employee.getZipCode());
        return employeeTable;
    }

    public Employee employeeTableMapToEmployee(EmployeeTable employeeTable)
    {
        Employee employee = new Employee();
        employee.setId(Integer.valueOf(employeeTable.getId()));
        employee.setFirstName(employeeTable.getFirst_name());
        employee.setLastName(employeeTable.getLast_name());
        employee.setDateOfBirth(employeeTable.getDate_of_birth());
        employee.setAddressLine1(employeeTable.getAddress_line1());
        employee.setAddressLine2(employeeTable.getAddress_line2());
        employee.setCity(employeeTable.getCity());
        employee.setState(employeeTable.getState());
        employee.setCountry(employeeTable.getCountry());
        employee.setZipCode(employeeTable.getZip_code());
        return employee;

    }
}
