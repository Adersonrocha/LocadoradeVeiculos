package br.com.LocadoraVeiculo.noca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.LocadoraVeiculo.noca.model.Contrato;
import br.com.LocadoraVeiculo.noca.repository.ContratoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/contrato")
@Api(value = "Responsavel por realizar o Crud da Agencia")
@CrossOrigin(origins = "*")
public class ContratoController {

	
	@Autowired
	ContratoRepository contratoRepository;
	
	
	@GetMapping(value ="/", produces = "application/json")
	public ResponseEntity<List<Contrato>> inicio(){
		
		List<Contrato> list = (List<Contrato>) contratoRepository.findAll();
		
		return new ResponseEntity<List<Contrato>>(list,HttpStatus.OK);
	}
	
	@PutMapping(value ="/", produces = "application/json")
	@ApiOperation(value = "Esse metodo atualiza um contrato a partir de um objeto COntrato ")
	public ResponseEntity<Contrato> atualizar(@RequestBody Contrato contrato){
		
		 
		Contrato contratoAtualizado = contratoRepository.save(contrato);
		return new ResponseEntity<Contrato>(contratoAtualizado,HttpStatus.OK);
	}
	@DeleteMapping(value="/{id}", produces= "application/text")
	@ApiOperation(value = "Esse metodo exclui um contrato A partir do seu ID ")
	public String delete(@PathVariable("id") Long id){
		
		contratoRepository.deleteById(id);
		
		return "ok";
	}
}
