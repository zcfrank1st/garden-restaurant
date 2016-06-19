package com.chaos.garden.service.biz;

import com.chaos.garden.model.Advertisement;
import com.chaos.garden.service.CacheService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcfrank1st on 6/18/16.
 */
@Service
public class AdsService {
    @Autowired
    private CacheService cacheService;
    @Autowired
    private Gson gson;

    public void flushAds (List<Advertisement> ads) {
        cacheService.setOrUpdateCache("ADVERTISEMENTS", gson.toJson(ads));
    }

    public List<Advertisement> getAds () {
        return gson.fromJson(cacheService.getCacheValue("ADVERTISEMENTS"), new TypeToken<List<Advertisement>>(){}.getType());
    }
}
