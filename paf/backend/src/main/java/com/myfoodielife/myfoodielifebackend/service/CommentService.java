package com.myfoodielife.myfoodielifebackend.service;

import com.myfoodielife.myfoodielifebackend.DTO.ApiResponse;
import com.myfoodielife.myfoodielifebackend.DTO.CommentDto;
import com.myfoodielife.myfoodielifebackend.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

     Comment createComment(int postId, CommentDto comment);

     ApiResponse deleteComment(int commentId);

     ApiResponse updateComment(int commentId, CommentDto commentDto);
}
