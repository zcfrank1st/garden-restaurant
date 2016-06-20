package com.chaos.garden.service.biz;

import com.chaos.garden.dao.OrderDao;
import com.chaos.garden.model.OrderQuery;
import com.chaos.garden.model.gen.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcfrank1st on 6/20/16.
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public void addOrder (Order order) {
        orderDao.addOrder(order);
    }

    public void updateOrder (Order order) {
        orderDao.updateOrder(order);
    }

    public void deleteOrder (int id) {
        orderDao.deleteOrder(id);
    }

    public List<Order> getSelfOrders (int customerId) {
        return orderDao.getSelfOrders(customerId);
    }

    public List<Order> getOrders (OrderQuery orderQuery) {
        return orderDao.getOrders(orderQuery);
    }
}
