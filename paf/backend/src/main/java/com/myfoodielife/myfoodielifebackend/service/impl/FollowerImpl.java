package com.myfoodielife.myfoodielifebackend.service.impl;

import com.myfoodielife.myfoodielifebackend.DTO.ApiResponse;
import com.myfoodielife.myfoodielifebackend.entity.User;
import com.myfoodielife.myfoodielifebackend.repository.FollowerRepository;
import com.myfoodielife.myfoodielifebackend.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerImpl implements FollowerService {

    @Autowired
    private FollowerRepository followerRepository;

    @Override
    public List<User> getAllFollowers(int uid) {
        List<User> users = followerRepository.findAllByTo_Id(uid);
        return users;
    }

    @Override
    public ApiResponse followUser(int uid, int followUID) {
        followerRepository.insertFollowUser(uid,followUID);
        return new ApiResponse(200, "User followed successfully", false);
    }
}
