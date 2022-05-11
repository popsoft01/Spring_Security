package com.example.springsecurityandjwttoken.service;

import com.example.springsecurityandjwttoken.Repository.RoleRepository;
import com.example.springsecurityandjwttoken.Repository.UserRepository;
import com.example.springsecurityandjwttoken.domain.AppUser;
import com.example.springsecurityandjwttoken.domain.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements AppUserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving user {} in database", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public Role SaveRole(Role role) {
        log.info("saving role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("saving role {} and {} to the database", roleName, username);
        AppUser user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);

    }

    @Override
    public AppUser getUser(String username) {
        log.info("fetching user {} to the database", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getusers() {
        log.info("fetching user to the database");
        return userRepository.findAll();
    }
}
