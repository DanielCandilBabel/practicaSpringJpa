package com.curso.service;

import java.util.List;

import com.curso.model.Libro;
import com.curso.model.Tema;

public interface LibrosService {
	void altaContacto(Libro contacto);
	List<Libro> recuperarLibros();
	List<Libro> recuperarLibros(int idTema);
	void eliminarLibros(int idContacto);
	
	
}
