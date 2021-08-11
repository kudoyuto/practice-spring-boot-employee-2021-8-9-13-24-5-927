package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    public List<Employee> getAllEmployees() {
        return employeeRepository.getEmployees();
    }

    public Employee getEmployeeById(Integer employeeID){
        return employeeRepository.getEmployeeById(employeeID);
    }
    public List<Employee> getAllEmployeesByGender(String gender) {
        return employeeRepository.getAllEmployeesByGender(gender);
    }
    public List<Employee> getEmployeesByPagination( Long pageIndex, Long pageSize) {
        return employeeRepository.getEmployeesByPagination(pageIndex,pageSize);
    }
    public Employee addEmployee(Employee employee) {
         return employeeRepository.addEmployee(employee);

    }

    public Employee updateEmployeeInformation(Integer employeeId,Employee employeeToBeUpdated) {
        return employeeRepository.updateEmployeeInformation(employeeId,employeeToBeUpdated);
    }

    public void deleteEmployeeID(Integer employeeID) {
        employeeRepository.deleteEmployeeID(employeeID);

    }


}
