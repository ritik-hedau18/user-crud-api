package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String name;
// minor tweak: performance check updates
// minor tweak: performance check updates
// minor tweak: performance check updates
// minor tweak: performance check updates
}