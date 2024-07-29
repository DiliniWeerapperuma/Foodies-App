package com.myfoodielife.myfoodielifebackend.service.impl;

import com.myfoodielife.myfoodielifebackend.DTO.ApiResponse;
import com.myfoodielife.myfoodielifebackend.DTO.CommentDto;
import com.myfoodielife.myfoodielifebackend.entity.Comment;
import com.myfoodielife.myfoodielifebackend.entity.Post;
import com.myfoodielife.myfoodielifebackend.repository.CommentRepository;
import com.myfoodielife.myfoodielifebackend.repository.PostRepository;
import com.myfoodielife.myfoodielifebackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment createComment(int postId, CommentDto commentDto) {
        Post post = postRepository.findPostById(postId);
        Comment newComment = new Comment();
        newComment.setPost(post);
        newComment.setComment(commentDto.getComment());
        return commentRepository.save(newComment);
    }

    @Override
    public ApiResponse deleteComment(int commentId) {
        commentRepository.deleteById(commentId);
        return new ApiResponse(200, "Comment deleted successfully", false);
    }

    @Override
    public ApiResponse updateComment(int commentId, CommentDto commentDto) {
        Comment comment = commentRepository.findById(commentId).get();
        if(comment == null) {
            return new ApiResponse(404,"Comment does not exist.", false);
        }else {
            comment.setComment(commentDto.getComment());
            commentRepository.save(comment);
            return new ApiResponse(200,"Comment updated successfully", false);
        }
    }
}
