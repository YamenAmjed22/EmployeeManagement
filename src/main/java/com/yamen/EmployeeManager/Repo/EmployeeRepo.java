package com.yamen.EmployeeManager.Repo;

import com.yamen.EmployeeManager.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {


}
