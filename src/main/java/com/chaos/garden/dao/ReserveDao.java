package com.chaos.garden.dao;

import com.chaos.garden.dao.mapper.gen.ReserveMapper;
import com.chaos.garden.model.ReserveQuery;
import com.chaos.garden.model.gen.Reserve;
import com.chaos.garden.model.gen.ReserveExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcfrank1st on 6/20/16.
 */
@Repository
public class ReserveDao {
    @Autowired
    private ReserveMapper reserveMapper;

    public void addReserve (Reserve reserve) {
        reserveMapper.insertSelective(reserve);
    }

    public void updateReserve (Reserve reserve) {
        reserveMapper.updateByPrimaryKeySelective(reserve);
    }

    public void deleteReserve (int id) {
        reserveMapper.deleteByPrimaryKey(id);
    }

    public List<Reserve> getSelfReserves (int customerId) {
        ReserveExample example = new ReserveExample();
        example.or().andCustomerIdEqualTo(customerId);

        return reserveMapper.selectByExampleWithBLOBs(example);
    }

    public List<Reserve> getReserves (ReserveQuery query) {
        // TODO
        return null;
    }
}
