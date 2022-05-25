package com.idat.MayoServicioPrueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioPrueba.model.Producto;
import com.idat.MayoServicioPrueba.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository repository;
	
	@Override
	public void guardarProducto(Producto producto) {
		repository.save(producto);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		repository.saveAndFlush(producto);
	}

	@Override
	public void eliminarProducto(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Producto> listarProducto() {
		return repository.findAll();
	}

	@Override
	public Optional<Producto> obtenerProductoId(Integer id) {
		return repository.findById(id);/*.orElse(null)*/
	}

}
