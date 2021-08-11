package com.thoughtworks.springbootemployee.service;


import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @InjectMocks
    private  EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;



    @Test
    void should_return_all_employees_when_get_all_employees_given_all_employees(){
            // Given
            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee(1, "Yuto", 23, "Male", 15000));
            employees.add(new Employee(2, "JC", 22, "Male", 10000));
            employees.add(new Employee(3, "Khali", 21, "Female", 10000));
            employees.add(new Employee(4, "Donald", 21, "Male", 104400));
            employees.add(new Employee(5, "Bob", 69, "Male", 10000));
            employees.add(new Employee(6, "Zagu", 25, "Female", 16900));
            given(employeeRepository.getEmployees()).willReturn(employees);

            // When
                List<Employee> actualEmployees = employeeService.getAllEmployees();

            // Then
            assertEquals(employees.size(),actualEmployees.size());
            assertIterableEquals(employees,actualEmployees);
    }
    @Test
    void should_return_an_employee_by_id_when_get_employee_by_id_given_id_of_an_employee(){
        //Given
        List <Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Yuto", 23, "Male", 15000));
        employees.add(new Employee(2, "JC", 22, "Male", 10000));
        given(employeeRepository.getEmployeeById(2)).willReturn(employees.get(1));
        //When
       ;
        Employee actualEmployee = employeeService.getEmployeeById(2);
        //Then
        assertEquals(actualEmployee,employees.get(1));
    }
    @Test
    void should_return_employees_when_get_employee_by_pagination_given_page_index_and_page_size(){
        //Given
        List <Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Yuto", 23, "Male", 15000));
        employees.add(new Employee(2, "YUTA", 23, "Male", 10000));
        employees.add(new Employee(3, "YUTI", 25, "Male", 10000));
        employees.add(new Employee(4, "YUTHREE", 27, "Female", 10000));
        employees.add(new Employee(5, "YUFOUR", 22, "Male", 10000));
        employees.add(new Employee(6, "YU5", 22, "Male", 10000));
        given(employeeRepository.getEmployeesByPagination(1L,5L)).willReturn(employees);
        //When

        List <Employee> actualEmployee = employeeService.getEmployeesByPagination(1L,5L);
        //Then
        assertIterableEquals(actualEmployee,employees);
    }
    @Test
    void should_return_specific_gender_employees_when_get_all_employees_by_gender_given_gender(){
        //Given
        List <Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Yuto", 23, "Male", 15000));
        employees.add(new Employee(2, "YUTA", 23, "Male", 10000));
        employees.add(new Employee(3, "YUTI", 25, "Male", 10000));
        employees.add(new Employee(4, "YUTHREE", 27, "Female", 10000));
        employees.add(new Employee(5, "YUFOUR", 22, "Male", 10000));
        employees.add(new Employee(6, "YU5", 22, "Male", 10000));
        given(employeeRepository.getAllEmployeesByGender("Male")).willReturn(employees);
        //When
        List <Employee> actualEmployee = employeeService.getAllEmployeesByGender("Male");
        //Then
        assertIterableEquals(actualEmployee,employees);
    }
    @Test
    void should_return_nothing_specific_gender_employees_when_add_an_employee_given_id_name_age_gender_salary(){
        //Given
        Employee employee = new Employee(7,"Kayle",24,"Male",25000);
        when(employeeRepository.addEmployee(employee)).thenReturn(employee);
        //When
        Employee actualEmployee = employeeService.addEmployee(employee);
        //Then
        assertEquals(actualEmployee,employee);
    }
}
