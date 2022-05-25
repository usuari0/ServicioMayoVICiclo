package com.idat.MayoServicioPrueba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.MayoServicioPrueba.model.Producto;
import com.idat.MayoServicioPrueba.service.ProductoServiceImpl;

@RestController
@RequestMapping("/producto/v1")
public class ProductoController {
	
	@Autowired
	ProductoServiceImpl service;
	
	@PostMapping("/guardar")
	public @ResponseBody ResponseEntity<Void> guardarProducto(@RequestBody Producto producto) {
		try {
			service.guardarProducto(producto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e){
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody ResponseEntity<Void> actualizarProducto(@RequestBody Producto producto) {
		Optional<Producto> p = service.obtenerProductoId(producto.getIdProducto());
		if(p.isPresent()) {
			service.actualizarProducto(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
}
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity<List<Producto>> listarProductos(){
		return new ResponseEntity<List<Producto>>(service.listarProducto(), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody ResponseEntity<Void> eliminarProducto(@PathVariable Integer id){
		try {
			service.eliminarProducto(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody ResponseEntity<Producto> encontrarProducto(@PathVariable Integer id){
		Optional<Producto> p = service.obtenerProductoId(id);
		if(p.isPresent()) {
			return new ResponseEntity<Producto>(p.get(), HttpStatus.OK);
		}   return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
	}
}
