package com.curso.dao;

import java.util.List;

import com.curso.model.Libro;
import com.curso.model.Tema;

public interface LibrosDao {
	void save(Libro libro);
	Libro find(int idLibro);
	List<Libro> findAll();
	void delete(Libro libro);
	List<Libro> findByThemas(int idTema);
}
