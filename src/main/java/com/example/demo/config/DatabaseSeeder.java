package com.example.demo.config;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public DatabaseSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            userRepository.save(User.builder()
                    .firstName("Alice")
                    .lastName("Vance")
                    .email("alice.vance@example.com")
                    .role("ADMIN")
                    .status("ACTIVE")
                    .build());

            userRepository.save(User.builder()
                    .firstName("Bob")
                    .lastName("Miller")
                    .email("bob.miller@example.com")
                    .role("DEVELOPER")
                    .status("ACTIVE")
                    .build());

            userRepository.save(User.builder()
                    .firstName("Charlie")
                    .lastName("Davis")
                    .email("charlie.davis@example.com")
                    .role("DESIGNER")
                    .status("ACTIVE")
                    .build());

            userRepository.save(User.builder()
                    .firstName("Diana")
                    .lastName("Prince")
                    .email("diana.prince@example.com")
                    .role("MANAGER")
                    .status("ACTIVE")
                    .build());

            userRepository.save(User.builder()
                    .firstName("Evan")
                    .lastName("Wright")
                    .email("evan.wright@example.com")
                    .role("DEVELOPER")
                    .status("INACTIVE")
                    .build());

            System.out.println("⚡ H2 Database seeded with 5 user profiles successfully.");
        }
    }
// minor tweak: performance check updates
}

// minor tweak: update verification rules and configs

// minor tweak: update verification rules and configs at 5117
