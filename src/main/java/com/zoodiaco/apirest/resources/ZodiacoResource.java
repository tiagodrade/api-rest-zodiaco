package com.zoodiaco.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoodiaco.apirest.models.Usuario;
import com.zoodiaco.apirest.models.Zodiaco;
import com.zoodiaco.apirest.repository.UsuarioRepository;
import com.zoodiaco.apirest.repository.ZodiacoRepository;

import io.swagger.annotations.Api;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST - ZODIACO")
@CrossOrigin(origins = "*") //Liberar os dominios para acessar a api
public class ZodiacoResource {

	//import repository
	@Autowired
	ZodiacoRepository zodiacoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	//Listar zodiacos salvos
	@GetMapping("/zodiacos")
	public List<Zodiaco> listaZodiacos(){
		return zodiacoRepository.findAll();
	}
	
	
	@GetMapping("/zodiacos/{id}")
	public Zodiaco listaUmZodiaco(@PathVariable(value="id") long id){
		return zodiacoRepository.findById(id);
	}
		
	@PostMapping("/cadastrar")
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}
