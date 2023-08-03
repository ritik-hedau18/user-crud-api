package com.example.demo.controller;
import com.example.demo.model.UserProfile;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserProfile> getAll() {
        return service.getAll();
    }

    @PostMapping
    public UserProfile save(@RequestBody UserProfile u) {
        return service.save(u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
// minor tweak: update verification rules and configs
