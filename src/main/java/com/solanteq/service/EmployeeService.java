package com.solanteq.service;

import com.solanteq.model.Employee;

import java.sql.Date;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmplyeesByParams(String firstName, String middleName, String lastName, String position, Date birthday);
}
