package com.curso.dao;

import java.util.List;

import com.curso.model.Cliente;

public interface ClientesDao {
	void save(Cliente cliente);
	Cliente find(int idCliente);
	void update(Cliente cliente);
	List<Cliente> findAll();
	void delete(Cliente cliente);
	Cliente findByUsuario(String usuario);
}
