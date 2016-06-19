package com.chaos.garden.dao;

import com.chaos.garden.dao.mapper.gen.CustomerMapper;
import com.chaos.garden.model.gen.Customer;
import com.chaos.garden.model.gen.CustomerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcfrank1st on 6/19/16.
 */
@Repository
public class CustomerDao {
    @Autowired
    private CustomerMapper customerMapper;

    public void addCustomer (Customer customer) {
        customerMapper.insertSelective(customer);
    }


    public void updateCustomer (Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }


    public void deleteCustomer (int id) {
        customerMapper.deleteByPrimaryKey(id);
    }


    public List<Customer> getCustomers () {
        CustomerExample example = new CustomerExample();
        return customerMapper.selectByExampleWithBLOBs(example);
    }

    public List<Customer> checkCustomer(Customer customer) {
        CustomerExample example = new CustomerExample();
        example.or().andPasswordEqualTo(customer.getPassword()).andNameEqualTo(customer.getName());
        return customerMapper.selectByExampleWithBLOBs(example);
    }
}
