package com.example.redis;

import com.example.redis.model.Video;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public class VideoRepositoryImpl implements VideoRepository {
    private RedisTemplate<String, Video> redisTemplate;

    private HashOperations hashOperations;


    public VideoRepositoryImpl(RedisTemplate<String, Video> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Video video) {
        hashOperations.put("VIDEO", video.getVideoId(), video);
    }

    @Override
    public Map<String, Video> findAll() {
        return hashOperations.entries("VIDEO");
    }

    @Override
    public Video findById(String videoId) {
        return (Video) hashOperations.get("VIDEO", videoId);
    }

    @Override
    public void update(Video video) {
        save(video);
    }

    @Override
    public void delete(String videoId) {

        hashOperations.delete("VIDEO", videoId);
    }
}
