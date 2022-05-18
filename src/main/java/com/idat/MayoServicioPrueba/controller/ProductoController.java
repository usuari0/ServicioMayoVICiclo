package com.idat.MayoServicioPrueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public @ResponseBody void guardarProducto(Producto producto) {
		service.guardarProducto(producto);
	}
	
	@GetMapping("/listar")
	public @ResponseBody List<Producto> listarProductos(){
		return service.listarProducto();
	}
}
