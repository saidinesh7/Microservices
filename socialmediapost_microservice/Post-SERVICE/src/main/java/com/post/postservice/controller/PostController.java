package com.post.postservice.controller;

import com.post.postservice.entity.Posts;
import com.post.postservice.feignpostsclient.FeignPostClient;
import com.post.postservice.model.Comment;
import com.post.postservice.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private FeignPostClient feignPostClient;

    @PostMapping("/save")
    public ResponseEntity<Posts> savePosts(@RequestBody Posts posts){
        String id= UUID.randomUUID().toString();
        posts.setPostId(id);
        return ResponseEntity.ok(postRepo.save(posts));
    }
    @GetMapping("/getAllPosts")
    public ResponseEntity<List<Posts>> getAllPosts(){

        return ResponseEntity.ok(postRepo.findAll());
    }
//    @GetMapping("/id/{id}")
//    public ResponseEntity<Posts> getPostById(@PathVariable String id){
//        return ResponseEntity.ok(postRepo.findByPostId(id));
//    }
    @GetMapping("/getByuserId/{id}")
    public ResponseEntity<List<Posts>> getByuserId(@PathVariable String id){
        return ResponseEntity.ok(postRepo.findByUserId(id));
    }
    @GetMapping("/getByPostId/{id}")
    public ResponseEntity<Posts> getByPostId(@PathVariable String id){
        Posts posts=postRepo.findByPostId(id);
        List<Comment> commentList=feignPostClient.getAllCommentById(id);
        posts.setCommentList(commentList);
        return ResponseEntity.ok(posts);
    }
}
