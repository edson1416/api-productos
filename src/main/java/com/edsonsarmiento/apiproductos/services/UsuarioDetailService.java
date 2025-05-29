package com.edsonsarmiento.apiproductos.services;

import com.edsonsarmiento.apiproductos.entity.Usuarios;
import com.edsonsarmiento.apiproductos.repositories.UsuarioRespority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRespority usuarioRespority;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuarioRespority.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new User(usuario.getUsername(), usuario.getPassword(), new ArrayList<>());
    }
}
