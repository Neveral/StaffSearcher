package com.solanteq.repository;

import com.solanteq.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository {


    List<Employee> gelAllEmployeesByParams(String firstName, String middleName, String lastName, String position, java.sql.Date birthday);
}
