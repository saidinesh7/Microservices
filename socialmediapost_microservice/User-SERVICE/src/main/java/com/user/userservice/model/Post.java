package com.user.userservice.model;

import jakarta.persistence.Transient;
import lombok.Data;

import java.util.List;

@Data
public class Post {
    private String postId;
    private String postCaption;
    private int likes;
    private String userId;
    @Transient
    private List<Comment> commentList;
}
