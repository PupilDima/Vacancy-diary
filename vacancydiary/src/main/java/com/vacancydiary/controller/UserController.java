package com.vacancydiary.controller;

import com.vacancydiary.entity.dto.UserDto;
import com.vacancydiary.mapper.UserMapper;
import com.vacancydiary.service.UserService;
import com.vacancydiary.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserServiceImpl userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/user/{id}")
    public UserDto findById(@PathVariable int id) {
        return userMapper.map(userService.findById(id));
    }

    @PostMapping("/user/register")
    public UserDto register(@RequestBody UserDto userDto) {
        return userMapper.map(userService.save(userMapper.map(userDto)));
    }

    @PutMapping("/user/{id}")
    public UserDto update(@RequestBody UserDto userDto, @PathVariable int id) {
        return userMapper.map(userService.update(userMapper.map(userDto), id));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        userService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
