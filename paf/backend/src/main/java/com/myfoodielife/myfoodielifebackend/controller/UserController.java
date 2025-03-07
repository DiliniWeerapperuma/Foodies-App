package com.myfoodielife.myfoodielifebackend.controller;


import com.myfoodielife.myfoodielifebackend.DTO.ApiResponse;
import com.myfoodielife.myfoodielifebackend.DTO.LoginDTO;
import com.myfoodielife.myfoodielifebackend.DTO.UserDto;
import com.myfoodielife.myfoodielifebackend.entity.User;
import com.myfoodielife.myfoodielifebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public User addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginDTO loginDto){
        return userService.login(loginDto);
    }

    @GetMapping("/profile/{id}")
    public Optional<User> getUserProfile(@PathVariable int id) {
        return userService.getProfileData(id);
    }

    @PatchMapping(value= "/profile/{id}")
    public ApiResponse updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @GetMapping("/accounts/count")
    public int getAccountsCount() {
        return userService.getAccountsCount();
    }

    @GetMapping("/profiles")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/admin/profiles")
    public List<User> getAllAdmins() {
        return userService.getAllAdmins();
    }

    @DeleteMapping("/account/{userId}")
    public ApiResponse deleteAccount(@PathVariable int userId) {
        return userService.deleteAccount(userId);
    }
}
