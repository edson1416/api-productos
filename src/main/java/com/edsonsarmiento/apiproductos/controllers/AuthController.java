package com.edsonsarmiento.apiproductos.controllers;

import com.edsonsarmiento.apiproductos.entity.Usuarios;
import com.edsonsarmiento.apiproductos.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody Usuarios usuario) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword())
            );

        }catch (BadCredentialsException e){
            System.out.println(e.getMessage());
            throw new Exception("Invalid username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getUsername());
        final String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(token);
    }
}
