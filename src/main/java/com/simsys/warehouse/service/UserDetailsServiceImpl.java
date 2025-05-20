package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.UsersEntity;
import com.simsys.warehouse.entity.RoleEntity;
import com.simsys.warehouse.repository.UsersRepository;
import com.simsys.warehouse.repository.RoleRepository;
import com.simsys.warehouse.userdetails.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        RoleEntity role = roleRepository.findByGuid(user.getRoleGuid())
                .orElseThrow(() -> new UsernameNotFoundException("Role not found"));

        return new UserDetailsImpl(user.getUsername(), user.getPassword(), role.getRoleName(), Boolean.TRUE.equals(user.getIsActive()),user.getEmail(),user.getContactInfo());
    }
}
