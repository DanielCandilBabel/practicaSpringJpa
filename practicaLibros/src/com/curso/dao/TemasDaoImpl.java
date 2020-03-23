package com.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.model.Tema;

@Repository
public class TemasDaoImpl implements TemasDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public void save(Tema tema) {
		em.persist(tema);
	}

	@Override
	public Tema find(int tema) {
		return em.find(Tema.class, tema);
	}

	@Override
	public List<Tema> findAll() {
		TypedQuery<Tema> query=em.createNamedQuery("Tema.findAll", Tema.class);
		return query.getResultList();
	}
	
	@Transactional
	@Override
	public void delete(Tema tema) {
		em.remove(tema);
	}

	@Override
	public Tema findByName(String nombre) {
		// TODO Auto-generated method stub
		String jpql="Select l From Tema l Where l.tema=?1";
		TypedQuery<Tema> query=em.createQuery(jpql,Tema.class);
		query.setParameter(1, nombre);
		return query!=null?query.getResultList().get(0):null;
		
	}

	@Override
	public int getIdByName(String id) {
		// TODO Auto-generated method stub
		String jpql="Select l From Tema l Where l.tema=?1";
		TypedQuery<Tema> query=em.createQuery(jpql,Tema.class);
		query.setParameter(1, id);
		return query!=null?query.getResultList().get(0).getIdTema():null;
	}

}
