package com.example.demo.service;
import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserProfileRepository repo;

    public UserService(UserProfileRepository repo) {
        this.repo = repo;
    }

    public List<UserProfile> getAll() {
        return repo.findAll();
    }

    public UserProfile save(UserProfile user) {
        return repo.save(user);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
// minor tweak: performance check updates
}
// minor tweak: update verification rules and configs
