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

import br.com.LocadoraVeiculo.noca.model.Automovel;
import br.com.LocadoraVeiculo.noca.model.Contrato;
import br.com.LocadoraVeiculo.noca.repository.AgenciaRepository;
import br.com.LocadoraVeiculo.noca.repository.ClienteRepository;
import br.com.LocadoraVeiculo.noca.repository.ContratoRepository;
import br.com.LocadoraVeiculo.noca.repository.VeiculoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/veiculo")
@Api(value = "Responsavel por realizar o Crud de Veiculo")
@CrossOrigin(origins = "*")
public class VeiculoController {
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Autowired
	AgenciaRepository agenciaRepository;
	
	@Autowired
	ContratoRepository contratoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;

	
	@GetMapping(value ="/", produces = "application/json")
	@ApiOperation(value = "Esse metodo retorna todos os veiculos cadastrados ")
	public ResponseEntity<List<Automovel>> inicio(){
		
		List<Automovel> list = (List<Automovel>)veiculoRepository.findAll();
		
		return new ResponseEntity<List<Automovel>>(list,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = "application/json")
	@ApiOperation(value = "Esse metodo retorna um veiculo pelo seu ID ")
	public ResponseEntity<Automovel> buscarPorId(@PathVariable (value = "id")Long id){
		
		Optional<Automovel> automovel = veiculoRepository.findById(id);
		return new ResponseEntity<Automovel>(automovel.get(),HttpStatus.OK);
	}
	
	@PostMapping(value="/", produces = "application/json")
	@ApiOperation(value = "Esse metodo cadastra novos veiculos no banco de Dados")
	public ResponseEntity<Automovel> cadastrar(@RequestBody Automovel automovel){
		Automovel automovelsalvo = veiculoRepository.save(automovel);
		return new ResponseEntity<Automovel>(automovelsalvo,HttpStatus.OK);
	}
	
	@PutMapping(value ="/", produces = "application/json")
	@ApiOperation(value = "Esse metodo atualiza os veiculos no banco de Dados")
	public ResponseEntity<Automovel> atualizar(@RequestBody Automovel automovel){
		
		 
		Automovel automovelAtualizado = veiculoRepository.save(automovel);
		return new ResponseEntity<Automovel>(automovelAtualizado,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", produces= "application/text")
	@ApiOperation(value = "Esse metodo exclui um veiculo A partir do seu ID ")
	public String delete(@PathVariable("id") Long id){
		
		veiculoRepository.deleteById(id);
		
		return "ok";
	}
	
	@GetMapping(value="/disponiveis", produces = "application/json")
	@ApiOperation(value = "Esse metodo retorna um veiculo pelo seu ID ")
	public ResponseEntity<List<Automovel>>buscarPorStatus(){
		
		List<Automovel> list = veiculoRepository.listaVeiculosStatus(true);
		
		return new ResponseEntity<List<Automovel>>(list,HttpStatus.OK); 
		
		
		
	}
	
	@GetMapping(value="/locados", produces = "application/json")
	@ApiOperation(value = "Esse metodo retorna um veiculo pelo seu ID ")
	public ResponseEntity<List<Automovel>>buscarPorLocados(){
		
		List<Automovel> list = veiculoRepository.listaVeiculosStatus(false);
		
		return new ResponseEntity<List<Automovel>>(list,HttpStatus.OK); 
	}
	
	
	@PutMapping(value ="/locar/{id}/cliente/{idcliente}/agencia/{agenciaid}/dias/{qtdedias}", produces = "application/json")
	@ApiOperation(value = "Esse metodo atualiza o status do veiculo, gera um novo contrato")
	public ResponseEntity<Automovel> locarVeiculo(@PathVariable("id") Long id, @PathVariable("idcliente") Long idcliente,
			@PathVariable("agenciaid") Long agenciaid, @PathVariable("qtdedias") Long qtdedias){
		
		Optional<Automovel> veiculo =veiculoRepository.findById(id);
		veiculo.get().setDisponivel(false);
		
		veiculoRepository.save(veiculo.get());
		
		Contrato contrato = new Contrato();
		contrato.setAgenciaId((agenciaRepository.findById(agenciaid)).get());
		contrato.setClienteid(clienteRepository.findById(idcliente).get());
		contrato.setQtdedias(qtdedias);
		contrato.setVeiculoId(veiculoRepository.findById(id).get());
		contrato.setValortotal(contrato.getValortotal());
		contrato.setNumeroContrato((idcliente+agenciaid+id)*100+1);
		contratoRepository.save(contrato);
		
		//Automovel automovelAtualizado = veiculoRepository.save(automovel);
		return new ResponseEntity<Automovel>(HttpStatus.OK);
	}
	

}
