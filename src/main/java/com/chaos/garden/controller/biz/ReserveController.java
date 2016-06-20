package com.chaos.garden.controller.biz;

import com.chaos.garden.model.ReserveQuery;
import com.chaos.garden.model.gen.Reserve;
import com.chaos.garden.service.biz.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zcfrank1st on 6/18/16.
 */
@RestController
public class ReserveController {
    @Autowired
    private ReserveService reserveService;

    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public ResponseEntity addReserve (@RequestBody Reserve reserve) {
        reserveService.addReserve(reserve);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/reserve", method = RequestMethod.PUT)
    public ResponseEntity updateReserve (@RequestBody Reserve reserve) {
        reserveService.updateReserve(reserve);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/reserve/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteReserve (@PathVariable("id") int id) {
        reserveService.deleteReserve(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/self/reserves", method = RequestMethod.GET)
    public ResponseEntity getSelfReserves () {
        // TODO get id from token
        return new ResponseEntity<>(reserveService.getSelfReserves(1), HttpStatus.OK);
    }

    @RequestMapping(value = "/reserves", method = RequestMethod.POST)
    public ResponseEntity getReserves (@RequestBody ReserveQuery query) {
        // TODO  be care with time partition
        return new ResponseEntity<>(reserveService.getReserves(query), HttpStatus.OK);
    }
}
