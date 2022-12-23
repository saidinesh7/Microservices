package com.comment.commentservice.repo;

import com.comment.commentservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, String> {
     Comment findByCommentId(String id);
     List<Comment> findByPostId(String id);
}
