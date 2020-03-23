package com.curso.dao;

import java.util.List;


import com.curso.model.Tema;

public interface TemasDao {
	void save(Tema tema);
	Tema find(int idTema);
	List<Tema> findAll();
	void delete(Tema tema);
	Tema findByName(String idTema);
	int getIdByName(String id);
}
