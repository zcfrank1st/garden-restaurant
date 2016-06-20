package com.chaos.garden.dao;

import com.chaos.garden.dao.mapper.gen.OrderMapper;
import com.chaos.garden.model.OrderQuery;
import com.chaos.garden.model.gen.Order;
import com.chaos.garden.model.gen.OrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcfrank1st on 6/20/16.
 */
@Repository
public class OrderDao {
    @Autowired
    private OrderMapper orderMapper;

    public void addOrder (Order order) {
        orderMapper.insertSelective(order);
    }

    public void updateOrder (Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    public void deleteOrder (int id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    public List<Order> getSelfOrders (int customer) {
        OrderExample example = new OrderExample();
        example.or().andCustomerIdEqualTo(customer);

        return orderMapper.selectByExampleWithBLOBs(example);
    }

    public List<Order> getOrders (OrderQuery orderQuery) {
        // TODO
        return null;
    }
}
