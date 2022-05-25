package com.idat.MayoServicioPrueba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.MayoServicioPrueba.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
}
