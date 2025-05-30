package com.edsonsarmiento.apiproductos.services;

import com.edsonsarmiento.apiproductos.entity.Usuarios;
import com.edsonsarmiento.apiproductos.repositories.UsuarioRespority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRespority usuarioRespority;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuarioRespority.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        Set<GrantedAuthority> authorities = usuario.getRoles().stream().map(roles -> new SimpleGrantedAuthority(roles.getNombre())).collect(Collectors.toSet());
        System.out.println(authorities);
        return new User(usuario.getUsername(), usuario.getPassword(), authorities);
    }
}
