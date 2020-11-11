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
import io.swagger.annotations.ApiOperation;


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
	@ApiOperation(value="Retorna uma lista de todos os zodiacos")
	public List<Zodiaco> listaZodiacos(){
		return zodiacoRepository.findAll();
	}
	
	@GetMapping("/zodiacos/{id}")
	@ApiOperation(value="Retorna um zodiaco pelo parâmetro id")
	public Zodiaco listaUmZodiaco(@PathVariable(value="id") long id){
		return zodiacoRepository.findById(id);
	}
	
	@GetMapping("/validarUsuario/{nome}")
	@ApiOperation(value="Retorna um usuario cadastrado pelo nome")
	public Usuario validaUsuario(@PathVariable(value="nome") String nome){
		return usuarioRepository.findByNome(nome);
	}
	
	@GetMapping("/validarUsuario/{nome}")
	@ApiOperation(value="Retorna um usuario cadastrado pelo nome")
	public List<Usuario> validaUsuario(){
		return usuarioRepository.findAll();
	}
	
	@PostMapping("/cadastrarZodiaco")
	@ApiOperation(value="Cadastra um novo zodiaco")
	public Zodiaco salvaZodiaco(@RequestBody Zodiaco zodiaco) {
		return zodiacoRepository.save(zodiaco);
	}
		
	@PostMapping("/cadastrarUsuario")
	@ApiOperation(value="Cadastra um novo usuario")
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}
