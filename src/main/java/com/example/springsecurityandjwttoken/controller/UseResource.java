package com.example.springsecurityandjwttoken.controller;

import com.example.springsecurityandjwttoken.domain.AppUser;
import com.example.springsecurityandjwttoken.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @AllArgsConstructor
@RequestMapping("/api/v1")
public class UseResource {
    private final UserServiceImpl userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok().body(userService.getusers()); 
    }
//    public ResponseEntity<>
//    @GetMapping()
//    public ResponseEntity<AppUser> getUser(String username){
//        return ResponseEntity.ok().body(userService.getUser())
//    }
}
 