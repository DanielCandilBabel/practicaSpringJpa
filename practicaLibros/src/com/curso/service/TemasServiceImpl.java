package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.dao.TemasDao;
import com.curso.model.Tema;

@Service
public class TemasServiceImpl implements TemasService {
	
	@Autowired
	TemasDao dao;
	
	
	@Override
	public List<Tema> recuperarTemas() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public int idTema(String tema) {
		// TODO Auto-generated method stub
		return dao.getIdByName(tema);
	}

	
}
