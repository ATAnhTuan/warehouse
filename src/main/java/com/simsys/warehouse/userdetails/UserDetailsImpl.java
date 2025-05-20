package com.simsys.warehouse.userdetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private final String username;
    private final String password;
    private final String roleName;
    private String gmail;
    private String contactInfo;
    private final boolean isActive;

    public UserDetailsImpl(String username, String password, String roleName, boolean isActive, String contactInfo, String gmail) {
        this.username = username;
        this.password = password;
        this.roleName = roleName;
        this.isActive = isActive;
        this.contactInfo = contactInfo;
        this.gmail = gmail;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(roleName));
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return isActive; }


    public String getGmail() {
        return gmail;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public boolean isActive() {
        return isActive;
    }
}
