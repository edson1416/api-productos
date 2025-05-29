package com.edsonsarmiento.apiproductos.entity.mappers;

import com.edsonsarmiento.apiproductos.entity.Producto;
import com.edsonsarmiento.apiproductos.entity.dto.ProductoDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public Producto toEntity(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setIdProducto(productoDTO.getId());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setCreated_at(productoDTO.getCreated_at());
        producto.setUpdated_at(productoDTO.getUpdated_at());
        producto.setDeleted_at(productoDTO.getDeleted_at());
        return producto;
    }

    public ProductoDTO toDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getIdProducto());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setCreated_at(producto.getCreated_at());
        productoDTO.setUpdated_at(producto.getUpdated_at());
        productoDTO.setDeleted_at(producto.getDeleted_at());
        return productoDTO;
    }
}
