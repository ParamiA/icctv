package com.example.redis.model;

import java.io.Serializable;

public class Video implements Serializable {



    private String videoId;
    private String agentId;
    private String status;

    Video(){}

    public Video(String videoId, String agentId, String status) {
        this.videoId = videoId;
        this.agentId = agentId;
        this.status = status;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }




    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String name) {
        this.agentId = agentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
