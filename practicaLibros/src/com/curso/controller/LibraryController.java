package com.curso.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.model.Cliente;
import com.curso.model.Libro;
import com.curso.model.Tema;
import com.curso.service.ClientesService;
import com.curso.service.LibrosService;
import com.curso.service.TemasService;

@Controller
public class LibraryController {
	@Autowired
	LibrosService service;
	@Autowired
	ClientesService clientesService;
	@Autowired
	TemasService temasService;
	
	@GetMapping(value="/listado")
	public String verLibros(@RequestParam("tema") String tema,
									HttpServletRequest request) {
		if(tema.equals(tema)) {
			List<Libro> lista=service.recuperarLibros();
			request.setAttribute("libros", lista);
			return "libros";
		}
		else {
			int idTema = temasService.idTema(tema);
			List<Libro> lista=service.recuperarLibros(idTema);
			request.setAttribute("libros", lista);
			return "libros";
		}
	}
	
	@GetMapping(value="/altaCliente")
	public String altaCliente(
							@RequestParam("email") String email,
							@RequestParam("password") String password,
							@RequestParam("telefono")  int telefono,
							@RequestParam("usuario") String usuario
							) {
		Cliente cliente=new Cliente(email, password, telefono, usuario);
		clientesService.altaCliente(cliente);
		return "login";
	}
	
	@GetMapping(value="/loguear")
	public String loginCliente(
							@RequestParam("usuario") String usuario,
							@RequestParam("password") String password,
							HttpServletRequest request
							) {
		Cliente cliente = clientesService.obtenerCliente(usuario);
		List<Tema> lista=temasService.recuperarTemas();
		request.setAttribute("temas", lista);
		return cliente!=null?"menu":"login";
	}
	
	@GetMapping(value="/irMenu")
	public String irMenu(HttpServletRequest request
							) {
		List<Tema> lista=temasService.recuperarTemas();
		request.setAttribute("temas", lista);
		return "menu";
	}
	
}
