package com.tchristofferson.newworldcommunitysite.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {

    private String content;

    public Comment(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
