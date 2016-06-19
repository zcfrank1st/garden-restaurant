package com.chaos.garden.controller.biz;

import com.chaos.garden.model.gen.Employee;
import com.chaos.garden.service.biz.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zcfrank1st on 6/18/16.
 */
@RestController
public class EmployeeController {
    @Autowired private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity addEmployee (@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public ResponseEntity updateEmployee (@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployee (@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity getEmployees () {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }
}
