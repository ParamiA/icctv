package com.example.redis;

import com.example.redis.model.Video;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/video")

public class VideoResource {
    private VideoRepository videoRepository;

    public VideoResource(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public Video add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name) {
        videoRepository.save(new Video(id, name,"viewed"));
        return videoRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public Video update(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        videoRepository.update(new Video(id, name, "viewed"));
        return videoRepository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<String, Video> delete(@PathVariable("id") final String id) {
        videoRepository.delete(id);
        return all();
    }

    @GetMapping("/all")
    public Map<String, Video> all() {
        return videoRepository.findAll();
    }




}






