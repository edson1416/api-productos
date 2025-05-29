package com.edsonsarmiento.apiproductos.controllers;

import com.edsonsarmiento.apiproductos.entity.Producto;
import com.edsonsarmiento.apiproductos.entity.dto.ProductoDTO;
import com.edsonsarmiento.apiproductos.services.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public List<ProductoDTO> getProductos() {
        return this.productoService.getProductos();
    }

    @GetMapping("/{id}")
    public ProductoDTO getProducto(@PathVariable Integer id) {
        return this.productoService.getProducto(id);
    }

    @PostMapping()
    public ProductoDTO createProducto(@Valid @RequestBody ProductoDTO productoDTO) {
        return this.productoService.createProducto(productoDTO);
    }

    @PutMapping("/{id}")
    public ProductoDTO updateProducto(@PathVariable int id, @RequestBody ProductoDTO productoDTO) {
        return this.productoService.updateProducto(id, productoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Integer id) {
        this.productoService.deleteProducto(id);
        return ResponseEntity.ok("Producto eliminado");
    }
}
