package com.user.userservice.feignClient;

import com.user.userservice.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        value = "userFeignClient",
        url = "http://localhost:8082/post"
)
public interface FeignUserClient {
    @GetMapping("/getByuserId/{id}")
    public List<Post> getPostByUserId(@PathVariable String id);
}
