package com.example.redis;

import com.example.redis.model.Video;

import java.util.Map;

public interface VideoRepository {

    void save(Video user);
    Map<String, Video> findAll();
    Video findById(String videoId);
    void update(Video user);
    void delete(String videoId);


}
