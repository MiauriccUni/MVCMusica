package com.mvc.mvcmusica.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "1177_MVC_Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String telephone;
    private String rol;
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;
}
