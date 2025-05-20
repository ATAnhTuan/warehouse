package com.simsys.warehouse.controller;

import com.simsys.warehouse.config.JwtTokenProvider;
import com.simsys.warehouse.responsedto.AuthResponse;
import com.simsys.warehouse.userdetails.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestParam String username, @RequestParam String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);

        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();

        AuthResponse response = new AuthResponse(
                user.getUsername(),
                token,
                user.getGmail(),
                user.getContactInfo()
        );

        return ResponseEntity.ok(response);
    }
}
