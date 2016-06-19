package com.chaos.garden.controller.biz;

import com.chaos.garden.model.Advertisement;
import com.chaos.garden.service.biz.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zcfrank1st on 6/18/16.
 */
@RestController
public class AdsController {
    @Autowired
    private AdsService adsService;

    @RequestMapping(value = "/ads", method = RequestMethod.POST)
    public ResponseEntity flushAds (@RequestBody List<Advertisement> ads) {
        adsService.flushAds(ads);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/ads", method = RequestMethod.GET)
    public ResponseEntity getAds () {
        return new ResponseEntity<>(adsService.getAds(), HttpStatus.OK);
    }
}
