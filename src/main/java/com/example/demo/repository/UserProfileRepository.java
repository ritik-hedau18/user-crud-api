package com.example.demo.repository;
import com.example.demo.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUsername(String username);
}
// minor tweak: update verification rules and configs

// minor tweak: update verification rules and configs at 7635
