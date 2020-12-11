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

import br.com.LocadoraVeiculo.noca.model.Cliente;
import br.com.LocadoraVeiculo.noca.repository.ClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/cliente")
@Api(value = "Responsavel por realizar o Crud dos clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;
	
	
	@GetMapping(value ="/", produces = "application/json")
	public ResponseEntity<List<Cliente>> inicio(){
		
		List<Cliente> list = (List<Cliente>)clienteRepository.findAll();
		
		return new ResponseEntity<List<Cliente>>(list,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = "application/json")
	@ApiOperation(value = "Esse metodo retorna um cliente atraves do ID ")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable (value = "id")Long id){
		
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return new ResponseEntity<Cliente>(cliente.get(),HttpStatus.OK);
	}
	
	@PostMapping(value="/", produces = "application/json")
	@ApiOperation(value = "Esse metodo cadastra novos clientes no banco de Dados")
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){
		Cliente clientesalvo = clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(clientesalvo,HttpStatus.OK);
	}
	
	@PutMapping(value ="/", produces = "application/json")
	@ApiOperation(value = "Esse metodo atualiza os clientes no banco de Dados")
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){
		
		 
		Cliente clienteAtualizado = clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(clienteAtualizado,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", produces= "application/text")
	@ApiOperation(value = "Esse metodo exclui um cliente A partir do seu ID ")
	public String delete(@PathVariable("id") Long id){
		
		clienteRepository.deleteById(id);
		
		return "ok";
	}
	
}
