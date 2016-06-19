package com.chaos.garden.service.biz;

import com.chaos.garden.model.Advertisement;
import com.chaos.garden.model.Story;
import com.chaos.garden.service.CacheService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcfrank1st on 6/19/16.
 */
@Service
public class StoryService {
    @Autowired
    private CacheService cacheService;
    @Autowired
    private Gson gson;

    public void flushStory (Story story) {
        cacheService.setOrUpdateCache("STORY", gson.toJson(story));
    }

    public Story getStory () {
        return gson.fromJson(cacheService.getCacheValue("STORY"), Story.class);
    }
}
