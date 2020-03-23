package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.dao.LibrosDao;
import com.curso.model.Libro;
import com.curso.model.Tema;

@Service
public class LibrosServiceImpl implements LibrosService {
	
	@Autowired
	LibrosDao dao;
	
	
	@Override
	public void altaContacto(Libro libro) {
		/*if(dao.findByEmail(libro.getEmail())==null) {
			dao.save(libro);
		}else {
			dao.update(libro);
		}*/
		
	}

	@Override
	public List<Libro> recuperarLibros() {
		return dao.findAll();
	}
	
	@Transactional
	@Override
	public void eliminarLibros(int idLibro) {
		Libro contacto=dao.find(idLibro);
		if(contacto!=null) {
			dao.delete(contacto);
		}
	}

	@Override
	public List<Libro> recuperarLibros(int idTema) {
		// TODO Auto-generated method stub
		 List<Libro> libros=dao.findByThemas(idTema);
		return libros!=null?libros:null;
	}

	
}
