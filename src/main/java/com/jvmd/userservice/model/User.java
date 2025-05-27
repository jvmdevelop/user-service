package com.jvmd.userservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true , nullable = false)
    private String name;
    @Column(unique = true , nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    private Double balance;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

}
