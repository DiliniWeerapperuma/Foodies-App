package com.myfoodielife.myfoodielifebackend.service;

import com.myfoodielife.myfoodielifebackend.DTO.ApiResponse;
import com.myfoodielife.myfoodielifebackend.DTO.PostDto;
import com.myfoodielife.myfoodielifebackend.entity.Post;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface PostService {
    ApiResponse savePost(int id, PostDto postDto) throws IOException;

    List<Post> getUserPosts(int id);

    List<Post> getAllPosts();

    ApiResponse deletePost(int postID);

    ApiResponse updatePost(int postId, PostDto postDto) throws IOException;

    ApiResponse addLikeUnlike(int postId, int userId);

    int getAllLikes(int postId);

    int getPostsCount();
}
