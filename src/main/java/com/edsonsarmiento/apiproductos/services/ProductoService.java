package com.edsonsarmiento.apiproductos.services;

import com.edsonsarmiento.apiproductos.entity.Producto;
import com.edsonsarmiento.apiproductos.entity.dto.ProductoDTO;
import com.edsonsarmiento.apiproductos.entity.mappers.ProductoMapper;
import com.edsonsarmiento.apiproductos.repositories.ProductoRepository;
import com.edsonsarmiento.apiproductos.services.interfaces.ProductoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements ProductoServiceInterface {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<ProductoDTO> getProductos() {
        return this.productoRepository.findAll().stream().map(productoMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProductoDTO getProducto(int id) {
        Producto producto = this.productoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return this.productoMapper.toDTO(producto);
    }

    @Override
    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        Producto producto = this.productoMapper.toEntity(productoDTO);
        Producto newProducto = this.productoRepository.save(producto);
        return this.productoMapper.toDTO(newProducto);
    }

    @Override
    public ProductoDTO updateProducto(int id, ProductoDTO productoDTO) {
        Producto productoExistente = this.productoRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        productoExistente.setNombre(productoDTO.getNombre());
        productoExistente.setDescripcion(productoDTO.getDescripcion());
        productoExistente.setPrecio(productoDTO.getPrecio());

        return this.productoMapper.toDTO(productoRepository.save(productoExistente));
    }

    @Override
    public void deleteProducto(int id) {
        Producto producto = this.productoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        producto.setDeleted_at(new Date());
        this.productoRepository.save(producto);
    }
}
