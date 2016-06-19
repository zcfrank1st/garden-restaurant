package com.chaos.garden.service.biz;

import com.chaos.garden.dao.EmployeeDao;
import com.chaos.garden.model.gen.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcfrank1st on 6/19/16.
 */
@Service
public class EmployeeService {
    @Autowired private EmployeeDao employeeDao;

    public void addEmployee (Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void updateEmployee (Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee (int id) {
        employeeDao.deleteEmployee(id);
    }

    public List<Employee> getEmployees () {
        return employeeDao.getEmployees();
    }
}
