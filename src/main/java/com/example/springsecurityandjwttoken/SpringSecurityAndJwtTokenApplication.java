package com.example.springsecurityandjwttoken;

import com.example.springsecurityandjwttoken.domain.AppUser;
import com.example.springsecurityandjwttoken.domain.Role;
import com.example.springsecurityandjwttoken.service.AppUserService;
import com.example.springsecurityandjwttoken.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityAndJwtTokenApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAndJwtTokenApplication.class, args);
    }
//    @Autowired
//    AppUserService userService;

    @Bean
    CommandLineRunner run(AppUserService userService){
        return args -> {
            userService.SaveRole(new Role(null, "ROLE_USER"));
            userService.SaveRole(new Role(null, "ROLE_MANAGER"));
            userService.SaveRole(new Role(null, "ROLE_ADMIN"));
            userService.SaveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new AppUser(null, "love okele", "love", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "lov akele", "lov", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "love ele", "ele", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "love omole", "omole", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Ojo omole", "Ojo", "1234", new ArrayList<>()));

            userService.addRoleToUser("love","ROLE_USER");
            userService.addRoleToUser("love","ROLE_ADMIN");
            userService.addRoleToUser("ele","ROLE_USER");
            userService.addRoleToUser("Ojo","ROLE_MANAGER");
        };
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        userService.SaveRole(new Role(null, "ROLE_USER"));
//        userService.SaveRole(new Role(null, "ROLE_MANAGER"));
//        userService.SaveRole(new Role(null, "ROLE_ADMIN"));
//        userService.SaveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//        implements CommandLineRunner
//
//        userService.saveUser(new AppUser(null, "love okele", "love", "1234", new ArrayList<>()));
//        userService.saveUser(new AppUser(null, "lov akele", "lov", "1234", new ArrayList<>()));
//        userService.saveUser(new AppUser(null, "love ele", "ele", "1234", new ArrayList<>()));
//        userService.saveUser(new AppUser(null, "love omole", "omole", "1234", new ArrayList<>()));
//
//        userService.addRoleToUser("love","ROLE_USER");
//        userService.addRoleToUser("love","ROLE_ADMIN");
//        userService.addRoleToUser("ele","ROLE_USER");
    }
}
