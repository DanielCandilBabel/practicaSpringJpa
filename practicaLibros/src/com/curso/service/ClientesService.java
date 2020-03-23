package com.curso.service;

import java.util.List;

import com.curso.model.Cliente;

public interface ClientesService {
	void altaCliente(Cliente contacto);
	List<Cliente> recuperarClientes();
	Cliente obtenerCliente(String usuario);
	void eliminarClientes(int idContacto);
	
	
}
