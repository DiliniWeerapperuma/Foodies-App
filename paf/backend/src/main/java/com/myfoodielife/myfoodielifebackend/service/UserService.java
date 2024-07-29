package com.myfoodielife.myfoodielifebackend.service;

import com.myfoodielife.myfoodielifebackend.DTO.ApiResponse;
import com.myfoodielife.myfoodielifebackend.DTO.LoginDTO;
import com.myfoodielife.myfoodielifebackend.DTO.UserDto;
import com.myfoodielife.myfoodielifebackend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User addUser(UserDto userDTO);

    ApiResponse login(LoginDTO loginDTO);

    Optional<User> getProfileData(int id);

    ApiResponse updateUser(int id, UserDto userDTO);

    int getAccountsCount();

    List<User> getAllUsers();

    List<User> getAllAdmins();

    ApiResponse deleteAccount(int userId);
}
