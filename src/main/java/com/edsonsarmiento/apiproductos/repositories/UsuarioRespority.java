package com.edsonsarmiento.apiproductos.repositories;

import com.edsonsarmiento.apiproductos.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRespority extends JpaRepository<Usuarios, Integer> {
    Optional<Usuarios> findByUsername(String username);
}
