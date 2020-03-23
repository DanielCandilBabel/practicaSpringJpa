package com.curso.service;

import java.util.List;

import com.curso.model.Libro;
import com.curso.model.Tema;

public interface TemasService {
	List<Tema> recuperarTemas();
	int idTema(String tema);
}
