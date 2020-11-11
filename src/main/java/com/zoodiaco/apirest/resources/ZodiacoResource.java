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
	
	@GetMapping("/zodiacos/{id}&{premium}")
	@ApiOperation(value="Parametros codSigno e premium. Retorna os dados do signo de acordo com perfil do usuario")
	public Zodiaco listaUmZodiaco(@PathVariable(value="codSigno") long id, @PathVariable(value="premium") int premium){
		
		if(premium == 1) {
			return zodiacoRepository.findById(id);
		}
		else {
			
			Zodiaco zodiaco = new Zodiaco();
			zodiaco.setSigno(zodiacoRepository.findById(id).getSigno());
			zodiaco.setDescricao(zodiacoRepository.findById(id).getDescricao());
			return zodiaco;
		}
		
	}
	
	@GetMapping("/validarUsuario/{nome}")
	@ApiOperation(value="Retorna um usuario cadastrado pelo nome")
	public Zodiaco validarUsuario(@PathVariable(value="nome") String nome){
		Zodiaco zodiaco = new Zodiaco();
		Usuario usuario = usuarioRepository.findByNome(nome);	
		
		if(usuario.getPremium() == 1) {
			zodiaco = zodiacoRepository.findById(usuario.codZodiaco);
			return zodiaco;
		}
		else {
			zodiaco.setSigno(zodiacoRepository.findById(usuario.codZodiaco).getSigno());
			zodiaco.setDescricao(zodiacoRepository.findById(usuario.codZodiaco).getDescricao());
			return zodiaco;
		}
		
		
		
	}
	
	@GetMapping("/listarUsuarios")
	@ApiOperation(value="Retorna todos os usuários cadastrados")
	public List<Usuario> listarUsuarios(){
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
