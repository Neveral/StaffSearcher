package com.solanteq.controller;

import com.solanteq.controller.Exceptions.BadRequestParamsException;
import com.solanteq.controller.Exceptions.Error;
import com.solanteq.model.Employee;
import com.solanteq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ValidateOnExecution
    public ResponseEntity<List<Employee>> getAllUsers(@Valid @ModelAttribute Employee employee, BindingResult result) {

        if (result.hasErrors()) {
            throw new BadRequestParamsException(result.getAllErrors().get(result.getErrorCount()-1).getDefaultMessage());
        }

        Date date = employee.getBirthday() != null ? new Date(employee.getBirthday().getTime()) : null;


        List<Employee> employees = employeeService.findAllEmplyeesByParams(
                employee.getFirstName(), employee.getMiddleName(), employee.getLastName(),
                employee.getPosition(), date);

        if (employees == null || employees.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(employees, HttpStatus.OK);
    }
}
