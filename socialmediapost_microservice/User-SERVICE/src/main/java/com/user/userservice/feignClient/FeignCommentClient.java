package com.user.userservice.feignClient;


import com.user.userservice.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "CommentClient",url = "http://localhost:8083/comment")
public interface FeignCommentClient {

    @GetMapping("/getCommentsByPostId/{id}")
    public List<Comment> getCommentsByPostId(@PathVariable String id);
}
