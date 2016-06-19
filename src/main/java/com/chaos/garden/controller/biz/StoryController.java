package com.chaos.garden.controller.biz;

import com.chaos.garden.model.Story;
import com.chaos.garden.service.biz.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zcfrank1st on 6/18/16.
 */
@RestController
public class StoryController {
    @Autowired
    private StoryService storyService;

    @RequestMapping(value = "/story", method = RequestMethod.POST)
    public ResponseEntity flushStory (@RequestBody Story story) {
        storyService.flushStory(story);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/story", method = RequestMethod.GET)
    public ResponseEntity getStory () {
        return new ResponseEntity<>(storyService.getStory(), HttpStatus.OK);
    }
}
