package com.chaos.garden.service.biz;

import com.chaos.garden.dao.ReserveDao;
import com.chaos.garden.model.ReserveQuery;
import com.chaos.garden.model.gen.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcfrank1st on 6/20/16.
 */
@Service
public class ReserveService {
    @Autowired
    private ReserveDao reserveDao;

    public void addReserve (Reserve reserve) {
        reserveDao.addReserve(reserve);
    }

    public List<Reserve> getSelfReserves (int customerId) {
        return reserveDao.getSelfReserves(customerId);
    }

    public void updateReserve (Reserve reserve) {
        reserveDao.updateReserve(reserve);
    }

    public void deleteReserve (int id) {
        reserveDao.deleteReserve(id);
    }

    public List<Reserve> getReserves (ReserveQuery query) {
        return reserveDao.getReserves(query);
    }
}
