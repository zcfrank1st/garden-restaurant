package com.chaos.garden.dao;

import com.chaos.garden.dao.mapper.gen.EmployeeMapper;
import com.chaos.garden.model.gen.Employee;
import com.chaos.garden.model.gen.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcfrank1st on 6/19/16.
 */
@Repository
public class EmployeeDao {
    @Autowired private EmployeeMapper employeeMapper;

    public void addEmployee (Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    public void updateEmployee (Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deleteEmployee (int id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public List<Employee> getEmployees () {
        EmployeeExample employeeExample = new EmployeeExample();
        return employeeMapper.selectByExampleWithBLOBs(employeeExample);
    }
}
