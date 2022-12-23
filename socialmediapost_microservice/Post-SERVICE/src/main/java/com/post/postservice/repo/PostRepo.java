package com.post.postservice.repo;

import com.post.postservice.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Posts,String>{
    public Posts findByPostId(String id);
    public List<Posts> findByUserId(String id);
}
