package com.spring.testproject.ems.employeemanagementsystem.entities.user;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    @NotNull
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_roles",
//                joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//                inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
//    private List<UserRole> roles;
    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
    private List<Role> roles;

    public User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


}
