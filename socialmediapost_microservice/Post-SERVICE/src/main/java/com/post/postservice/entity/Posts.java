package com.post.postservice.entity;

import com.post.postservice.model.Comment;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Posts {
    @Id
    private String postId;
    private String postCaption;
    private int likes;
    private String userId;

    @Transient
    private List<Comment> commentList;
}
// 698ef3a6-0cf6-4220-8524-2a2f7e936f46 userID