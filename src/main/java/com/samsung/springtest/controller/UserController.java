package com.samsung.springtest.controller;

import com.samsung.springtest.domain.User;
import com.samsung.springtest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public User add(@RequestBody User user){
        return userService.add(user);
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PutMapping("/users")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable long id){
        userService.deleteById(id);
    }
}
