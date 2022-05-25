package com.idat.MayoServicioPrueba.service;

import java.util.List;
import java.util.Optional;

import com.idat.MayoServicioPrueba.model.Producto;

public interface ProductoService {
	void guardarProducto(Producto producto);
	void actualizarProducto(Producto producto);
	void eliminarProducto(Integer id);
	List<Producto> listarProducto();
	Optional<Producto> obtenerProductoId(Integer id);
}
