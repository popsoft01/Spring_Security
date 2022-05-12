package com.example.springsecurityandjwttoken.controller;

import com.example.springsecurityandjwttoken.domain.AppUser;
import com.example.springsecurityandjwttoken.domain.Role;
import com.example.springsecurityandjwttoken.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @AllArgsConstructor
@RequestMapping("/api/v1")
public class UseResource {
    private final UserServiceImpl userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok().body(userService.getusers()); 
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.ok().body(userService.SaveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUser form ){
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

//    public ResponseEntity<>
//    @GetMapping()
//    public ResponseEntity<AppUser> getUser(String username){
//        return ResponseEntity.ok().body(userService.getUser())
//    }
}

@Data
class RoleToUser{
    private String username;
    private  String roleName;
}