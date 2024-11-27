package com.company.project.register.user.model;

import com.company.project.register.role.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @jakarta.persistence.Id
    @GeneratedValue(generator = "UUID")
    private UUID Id;

    @Column(unique = true)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Boolean enabled;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean admin;

    @PrePersist
    public void perPersis(){
        enabled = true;
        admin = false;
    }

    @JsonIgnoreProperties({"users", "handler", "hibernateLazyInitializer"})// evita la recursividad ingnnrando la propiedad user en los roles
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = { @UniqueConstraint( columnNames = {"user_id", "role_id"} )}
    )
    private List<Role> roles;

    public User() {
        roles = new ArrayList<>();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
