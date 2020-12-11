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

import br.com.LocadoraVeiculo.noca.model.Funcionario;
import br.com.LocadoraVeiculo.noca.repository.FuncionarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value ="/funcionario")
@Api(value = "Responsavel por realizar o Crud dos Funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	

	
	@GetMapping(value ="/", produces = "application/json")
	@ApiOperation(value = "Esse metodo retorna uma lista de funcionarios cadastrado no BD")
	public ResponseEntity<List<Funcionario>> inicio(){
		
		List<Funcionario> list = (List<Funcionario>)funcionarioRepository.findAll();
		
		return new ResponseEntity<List<Funcionario>>(list,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = "application/json")
	@ApiOperation(value = "Esse metodo retorna um funcionario atraves do ID ")
	public ResponseEntity<Funcionario> buscarPorId(@PathVariable (value = "id")Long id){
		
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return new ResponseEntity<Funcionario>(funcionario.get(),HttpStatus.OK);
	}
	
	@PostMapping(value="/", produces = "application/json")
	@ApiOperation(value = "Esse metodo cadastra novos funcionario no banco de Dados")
	public ResponseEntity<Funcionario> cadastrar(@RequestBody Funcionario funcionario){
		Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
		return new ResponseEntity<Funcionario>(funcionarioSalvo,HttpStatus.OK);
	}
	
	@PutMapping(value ="/", produces = "application/json")
	@ApiOperation(value = "Esse metodo atualiza os funcionarios no banco de Dados")
	public ResponseEntity<Funcionario> atualizar(@RequestBody Funcionario funcionario){
		
		 
		Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);
		return new ResponseEntity<Funcionario>(funcionarioAtualizado,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", produces= "application/text")
	@ApiOperation(value = "Esse metodo exclui um Funcionario A partir do seu ID ")
	public String delete(@PathVariable("id") Long id){
		
		funcionarioRepository.deleteById(id);
		
		return "ok";
	}
	
}
