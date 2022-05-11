package com.example.springsecurityandjwttoken.service;

import com.example.springsecurityandjwttoken.domain.AppUser;
import com.example.springsecurityandjwttoken.domain.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    Role SaveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getusers();
}
