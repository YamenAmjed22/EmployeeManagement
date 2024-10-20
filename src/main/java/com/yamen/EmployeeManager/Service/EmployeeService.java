package com.yamen.EmployeeManager.Service;

import com.yamen.EmployeeManager.Exceptions.userNotFoundException;
import com.yamen.EmployeeManager.Model.Employee;
import com.yamen.EmployeeManager.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // Methods
    public Employee addEmployee(Employee newEmployee){
        newEmployee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(newEmployee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee updatedEmployee){
        return employeeRepo.save(updatedEmployee);
    }

    public void deleteEmployee(Long employeeId){
        employeeRepo.deleteById(employeeId);
    }

    public Employee findEmployeeById(Long employeeId){
        return employeeRepo.findById(employeeId).orElseThrow(() -> new userNotFoundException("User by id " +"was not found  "));
    }
}
