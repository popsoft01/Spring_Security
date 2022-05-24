package com.example.springsecurityandjwttoken.service;

import com.example.springsecurityandjwttoken.Repository.RoleRepository;
import com.example.springsecurityandjwttoken.Repository.UserRepository;
import com.example.springsecurityandjwttoken.domain.AppUser;
import com.example.springsecurityandjwttoken.domain.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements AppUserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
     private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username);
        if (user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else{
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(user.getUsername(),user.getPassword(), authorities);
    }

    @Override
    public AppUser saveUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving user {} in database", user.getUsername());
        return userRepository.save( user);
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
