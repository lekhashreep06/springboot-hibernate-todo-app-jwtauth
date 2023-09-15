package com.app.todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    private String username;
    private String password;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @OneToMany(targetEntity = Login.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ul_fk", referencedColumnName = "username")
    private List<Login> login;
}
