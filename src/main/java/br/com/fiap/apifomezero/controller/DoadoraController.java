
package br.com.fiap.apifomezero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.apifomezero.model.Doadora;
import br.com.fiap.apifomezero.repository.DoadoraRepository;

//import static br.com.fiap.apismilerec.filter.TerapeutaFilter.validaSeTerapeutaExiste;

//anotação informando que é uma aplicação Rest
//essa classe receberá as requisições HTTP
@RestController
@RequestMapping("/api/doadora") // uri padrao para nossa api
public class DoadoraController {

	// @ Autowired fornece controle sobre onde e como a ligação entre os beans deve
	// ser realizada
	@Autowired
	DoadoraRepository doadoraRepository;

	// Lista uma empresa doadora no banco de dados
	@GetMapping
	public List<Doadora> lista() {
		return doadoraRepository.findAll();
	}

	// Salva uma empresa doadora no banco de dados
	@PostMapping
	@ResponseBody
	public Doadora novo(@RequestBody Doadora doadora) {
		return doadoraRepository.save(doadora);
	}

	// Exclui uma empresa doadora
	@DeleteMapping
	public void deletaDoadora(@RequestBody Doadora doadora) {
		doadoraRepository.delete(doadora);
	}

	// Atualiza uma empresa doadora
	@PutMapping
	public Doadora atualizaDoadora(@RequestBody Doadora doadora) {
		return doadoraRepository.save(doadora);
	}

}
