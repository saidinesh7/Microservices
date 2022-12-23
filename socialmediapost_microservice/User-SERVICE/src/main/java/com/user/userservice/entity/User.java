package com.user.userservice.entity;

import com.user.userservice.model.Post;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data
public class User {
    @Id
    private String userId;
    private String userName;
    private String status;

    @Transient
    private List<Post> postList;
}
