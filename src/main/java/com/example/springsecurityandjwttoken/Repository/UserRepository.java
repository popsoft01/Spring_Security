package com.example.springsecurityandjwttoken.Repository;

import com.example.springsecurityandjwttoken.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
