package com.yamen.EmployeeManager.Controller;

import com.yamen.EmployeeManager.Model.Employee;
import com.yamen.EmployeeManager.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Methods
    // to find all employee ( return all employee )  //
    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees , HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id ){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee newEmployee){
        Employee addedEmployee = employeeService.addEmployee(newEmployee);
        return new ResponseEntity<>(addedEmployee, HttpStatus.CREATED);

    }
    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee updatedEmployee){
        Employee updatedEmployeeObj = employeeService.updateEmployee(updatedEmployee);
        return new ResponseEntity<>(updatedEmployeeObj, HttpStatus.OK);

    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
