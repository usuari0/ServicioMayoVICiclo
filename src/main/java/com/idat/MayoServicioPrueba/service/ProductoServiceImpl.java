package com.idat.MayoServicioPrueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioPrueba.model.Producto;
import com.idat.MayoServicioPrueba.repository.ProductoRepositoryImpl;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepositoryImpl repository;
	
	@Override
	public void guardarProducto(Producto producto) {
		repository.guardarProducto(producto);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		repository.actualizarProducto(producto);
	}

	@Override
	public void eliminarProducto(Integer id) {
		repository.eliminarProducto(id);
	}

	@Override
	public List<Producto> listarProducto() {
		return repository.listarProducto();
	}

	@Override
	public Producto obtenerProductoId(Integer id) {
		return repository.obtenerProductoId(id);
	}

}
