package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.dao.ClientesDao;
import com.curso.model.Cliente;


@Service
public class ClientesServiceImpl implements ClientesService {
	
	@Autowired
	ClientesDao dao;
	
	
	@Override
	public void altaCliente(Cliente cliente) {
		if(dao.findByUsuario(cliente.getUsuario())==null) {
			dao.save(cliente);
		}
		
	}

	@Override
	public List<Cliente> recuperarClientes() {
		return dao.findAll();
	}
	
	@Transactional
	@Override
	public void eliminarClientes(int idCliente) {
		Cliente cliente=dao.find(idCliente);
		if(cliente!=null) {
			dao.delete(cliente);
		}
	}

	@Override
	public Cliente obtenerCliente(String usuario) {
		// TODO Auto-generated method stub
		Cliente cliente=dao.findByUsuario(usuario);
		if(cliente!=null) {
			return cliente;
		}
		return null;
	}

	
}
