 package br.com.LocadoraVeiculo.noca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.LocadoraVeiculo.noca.model.Agencia;
import br.com.LocadoraVeiculo.noca.repository.AgenciaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/agencia")
@Api(value = "Responsavel por realizar o Crud da Agencia")
@CrossOrigin(origins = "*")
public class AgenciaController {
	
	
	@Autowired
	AgenciaRepository agenciaRepository;
	
	
	@GetMapping(value ="/", produces = "application/json")
	public ResponseEntity<List<Agencia>> inicio(){
		
		List<Agencia> list = (List<Agencia>)agenciaRepository.findAll();
		
		return new ResponseEntity<List<Agencia>>(list,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = "application/json")
	@ApiOperation(value = "Esse metodo retorna uma disciplinas atraves do ID ")
	public ResponseEntity<Agencia> buscarPorId(@PathVariable (value = "id")Long id){
		
		Optional<Agencia> disciplina = agenciaRepository.findById(id);
		return new ResponseEntity<Agencia>(disciplina.get(),HttpStatus.OK);
	}
	
	@PostMapping(value="/", produces = "application/json")
	@ApiOperation(value = "Esse metodo cadastra novas disciplinas no banco de Dados")
	public ResponseEntity<Agencia> cadastrar(@RequestBody Agencia agencia){
		Agencia agenciasalvo = agenciaRepository.save(agencia);
		return new ResponseEntity<Agencia>(agenciasalvo,HttpStatus.OK);
	}
	
	@PutMapping(value ="/", produces = "application/json")
	@ApiOperation(value = "Esse metodo atualiza as disciplinas no banco de Dados")
	public ResponseEntity<Agencia> atualizar(@RequestBody Agencia agencia){
		
		 
		Agencia agenciaAtualizado = agenciaRepository.save(agencia);
		return new ResponseEntity<Agencia>(agenciaAtualizado,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", produces= "application/text")
	@ApiOperation(value = "Esse metodo exclui uma disciplina A partir do seu ID ")
	public String delete(@PathVariable("id") Long id){
		
		agenciaRepository.deleteById(id);
		
		return "ok";
	}
	
}
