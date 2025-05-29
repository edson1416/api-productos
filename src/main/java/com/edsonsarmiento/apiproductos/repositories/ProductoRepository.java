package com.edsonsarmiento.apiproductos.repositories;

import com.edsonsarmiento.apiproductos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
