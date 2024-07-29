package com.myfoodielife.myfoodielifebackend.controller;

import com.myfoodielife.myfoodielifebackend.DTO.ApiResponse;
import com.myfoodielife.myfoodielifebackend.DTO.CommentDto;
import com.myfoodielife.myfoodielifebackend.entity.Comment;
import com.myfoodielife.myfoodielifebackend.repository.CommentRepository;
import com.myfoodielife.myfoodielifebackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentService commentService;

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getAllCommentsByPostId(@PathVariable(value = "postId") int postId) {
        return commentRepository.findByPostId(postId);
    }

    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable(value = "postId") int postId, @RequestBody CommentDto commentDto) {
        return commentService.createComment(postId, commentDto);
    }

    @DeleteMapping("/posts/comment/{commentId}")
    public ApiResponse deleteComment(@PathVariable int commentId) {
        return commentService.deleteComment(commentId);
    }

    @PatchMapping("/posts/comment/{commentId}")
    public ApiResponse updateComment(@PathVariable int commentId, @RequestBody CommentDto commentDto) {
        return commentService.updateComment(commentId, commentDto);
    }
}
