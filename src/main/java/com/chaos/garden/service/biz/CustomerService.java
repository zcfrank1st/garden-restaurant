package com.chaos.garden.service.biz;

import com.chaos.garden.dao.CustomerDao;
import com.chaos.garden.model.gen.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcfrank1st on 6/19/16.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public void addCustomer (Customer customer) {
        customerDao.addCustomer(customer);
    }


    public void updateCustomer (Customer customer) {
        customerDao.updateCustomer(customer);
    }


    public void deleteCustomer (int id) {
        customerDao.deleteCustomer(id);
    }


    public List<Customer> getCustomers () {
        return customerDao.getCustomers();
    }

    public List<Customer> checkCustomer (Customer customer) {
        return customerDao.checkCustomer(customer);
    }
}
