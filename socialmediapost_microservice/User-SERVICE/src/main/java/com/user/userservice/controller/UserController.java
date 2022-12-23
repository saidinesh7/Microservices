package com.user.userservice.controller;

import com.user.userservice.entity.User;
import com.user.userservice.feignClient.FeignCommentClient;
import com.user.userservice.feignClient.FeignUserClient;
import com.user.userservice.model.Comment;
import com.user.userservice.model.Post;
import com.user.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FeignUserClient feignUserClient;

    @Autowired
    private FeignCommentClient feignCommentClient;

    @PostMapping("/save")
    public ResponseEntity<User> postUser(@RequestBody User user){
        String id=UUID.randomUUID().toString();

        user.setUserId(id);
        return ResponseEntity.ok(userRepo.save(user));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userRepo.findAll());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        return ResponseEntity.ok(userRepo.findByUserId(id));
    }
    @GetMapping("/getDataByUserId/{id}")
    public ResponseEntity<User> getAllData(@PathVariable String id){
        User user=userRepo.findByUserId(id);
        List<Post> postList=feignUserClient.getPostByUserId(id);
        List<Post> postWithComments=postList.stream().map(pList->{
            List<Comment> commentList= feignCommentClient.getCommentsByPostId(pList.getPostId());
            pList.setCommentList(commentList);
            return pList;

        }).collect(Collectors.toList());
        user.setPostList(postWithComments);
        return ResponseEntity.ok(user);

    }

}
