package com.employee.Service;
import com.employee.Entity.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> fetchAllEmployees();
    Employee findById(Long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    String deleteEmployee(Long id);
}
