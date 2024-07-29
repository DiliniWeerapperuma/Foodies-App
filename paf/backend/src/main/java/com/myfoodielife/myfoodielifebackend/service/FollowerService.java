package com.myfoodielife.myfoodielifebackend.service;


import com.myfoodielife.myfoodielifebackend.DTO.ApiResponse;
import com.myfoodielife.myfoodielifebackend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FollowerService {
    List<User> getAllFollowers(int id);

    ApiResponse followUser(int id, int followUID);
}
