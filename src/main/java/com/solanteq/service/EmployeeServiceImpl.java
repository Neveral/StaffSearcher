package com.solanteq.service;

import com.solanteq.model.Employee;
import com.solanteq.repository.EmployeeRepository;
import com.solanteq.repository.JdbcEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    JdbcEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmplyeesByParams(String firstName, String middleName, String lastName, String position, Date birthday) {
        return employeeRepository.gelAllEmployeesByParams(firstName, middleName, lastName, position, birthday);
    }
}
