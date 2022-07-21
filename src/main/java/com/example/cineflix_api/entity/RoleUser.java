package com.example.cineflix_api.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "role_user")
public class RoleUser {
//    @Id
//    private int role_id;
//
//    @Id
//    private int user_id;

//    @ManyToOne()
//    @MapsId
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    private Users users;
//
//    public Users getUsers() {
//        return users;
//    }
//
//    public void setUsers(Users users) {
//        this.users = users;
//    }

    @EmbeddedId
    private  RoleUserId id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name= "user_id")
    private Users users;

    @ManyToOne
    @MapsId("role_id")
    @JoinColumn(name= "role_id")
    private Roles roles;

//    public int getRole_id() {
//        return role_id;
//    }
//
//    public void setRole_id(int role_id) {
//        this.role_id = role_id;
//    }
//
//    public int getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }

    public RoleUserId getId() {
        return id;
    }

    public void setId(RoleUserId id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
