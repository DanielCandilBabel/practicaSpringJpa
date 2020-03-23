package com.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.model.Libro;
import com.curso.model.Tema;

@Repository
public class LibrosDaoImpl implements LibrosDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public void save(Libro libro) {
		em.persist(libro);
	}

	@Override
	public Libro find(int isbn) {
		return em.find(Libro.class, isbn);
	}

	@Override
	public List<Libro> findAll() {
		//TypedQuery<Libro> query=em.createNamedQuery("Libro.findAll", Libro.class);
		TypedQuery<Libro> query=em.createNamedQuery("Libro.findAll", Libro.class);
		return query.getResultList();
	}
	
	@Transactional
	@Override
	public void delete(Libro contacto) {
		em.remove(contacto);
	}

	@Transactional
	@Override
	public List<Libro> findByThemas(int tema) {
		// TODO Auto-generated method stub
		String jpql="Select l from Libro l where l.idTema=?1";
		TypedQuery<Libro> query=em.createQuery(jpql,Libro.class);
		query.setParameter(1, tema);
		return query.getResultList();
		
	}

}
