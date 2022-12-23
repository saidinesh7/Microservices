package com.comment.commentservice.controller;

import com.comment.commentservice.entity.Comment;
import com.comment.commentservice.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepo commentRepo;

    @PostMapping("/save")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        String id = UUID.randomUUID().toString();
        comment.setCommentId(id);
        return ResponseEntity.ok(commentRepo.save(comment));
    }

    @GetMapping("/getAllComments")
    public ResponseEntity<List<Comment>> getAllComments() {
        return ResponseEntity.ok(commentRepo.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable String id) {
        return ResponseEntity.ok(commentRepo.findByCommentId(id));
    }
    @GetMapping("/getCommentsByPostId/{id}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable String id){
        return ResponseEntity.ok(commentRepo.findByPostId(id));
    }
}
