package com.edsonsarmiento.apiproductos.services.interfaces;

import com.edsonsarmiento.apiproductos.entity.Producto;
import com.edsonsarmiento.apiproductos.entity.dto.ProductoDTO;

import java.util.List;

public interface ProductoServiceInterface {
    List<ProductoDTO> getProductos();
    ProductoDTO getProducto(int id);
    ProductoDTO createProducto(ProductoDTO productoDTO);
    ProductoDTO updateProducto(int id,ProductoDTO productoDTO);
    void deleteProducto(int id);
}
