package com.example.cineflix_api.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "user_password")
    private String password;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Set<RoleUser> roleUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleUser> getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(Set<RoleUser> roleUser) {
        this.roleUser = roleUser;
    }
}
