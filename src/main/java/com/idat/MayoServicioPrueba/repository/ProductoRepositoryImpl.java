package com.idat.MayoServicioPrueba.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.idat.MayoServicioPrueba.model.Producto;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository{

	private List<Producto> listar = new ArrayList<Producto>();

	@Override
	public void guardarProducto(Producto producto) {
		listar.add(producto);
		
	}

	@Override
	public void actualizarProducto(Producto producto) {
		listar.remove(producto);
		listar.add(producto);
	}

	@Override
	public void eliminarProducto(Integer id) {
		/*for(Producto p : listar) {
			if(p.getIdProducto() ==  id)
				listar.remove(p); break;
		}*/
		listar.removeIf(p -> p.getIdProducto() == id);
	}

	@Override
	public List<Producto> listarProducto() {
		return listar;
	}

	@Override
	public Producto obtenerProductoId(Integer id) {
		/*for(Producto p : listar) {
			if(p.getIdProducto()==id)
				return p;
		} return null;*/
		return listar.stream().filter(p -> p.getIdProducto() == id).findFirst().orElse(null);
	}
	
}
