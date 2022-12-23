package com.post.postservice.feignpostsclient;

import com.post.postservice.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "postClient",
url="http://localhost:8083/comment")
public interface FeignPostClient {

    @GetMapping("/getCommentsByPostId/{id}")
    public List<Comment> getAllCommentById(@PathVariable String id);
}
