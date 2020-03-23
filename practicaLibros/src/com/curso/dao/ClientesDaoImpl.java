package com.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.model.Cliente;

@Repository
public class ClientesDaoImpl implements ClientesDao {
	@PersistenceContext
	EntityManager em;
	@Transactional
	@Override
	public void save(Cliente contacto) {
		em.persist(contacto);

	}

	@Override
	public Cliente find(int idContacto) {
		return em.find(Cliente.class, idContacto);
	}
	@Transactional
	@Override
	public void update(Cliente contacto) {
		em.merge(contacto);

	}

	@Override
	public List<Cliente> findAll() {
		TypedQuery<Cliente> query=em.createNamedQuery("Contacto.findAll", Cliente.class);
		return query.getResultList();
	}
	@Transactional
	@Override
	public void delete(Cliente contacto) {
		em.remove(contacto);

	}

	@Override
	public Cliente findByUsuario(String usuario) {
		String jpql="Select c From Cliente c Where c.usuario=?1";
		TypedQuery<Cliente> query=em.createQuery(jpql,Cliente.class);
		query.setParameter(1, usuario);
		List<Cliente> resultado=query.getResultList();
		return resultado.size()>0?resultado.get(0):null;
	}

}
