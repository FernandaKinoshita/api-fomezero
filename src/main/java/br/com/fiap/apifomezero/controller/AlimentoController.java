
package br.com.fiap.apifomezero.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.apifomezero.model.Alimento;
import br.com.fiap.apifomezero.repository.AlimentoRepository;

//anotação informando que é uma aplicação Rest
//essa classe receberá as requisições HTTP
@RestController
@RequestMapping("/api/alimento") // uri padrao para nossa api
public class AlimentoController {

	// @ Autowired fornece controle sobre onde e como a ligação entre os beans deve
	// ser realizada
	@Autowired
	AlimentoRepository alimentoRepository;

	// Lista o terapeuta no banco de dados
	@GetMapping
	public List<Alimento> lista() {
		return alimentoRepository.findAll();
	}

	// Lista um paciente pelo id do terapeuta
	@GetMapping("/alimento/{id}")
	public List<Alimento> listaPorIdDoadora(@PathVariable Long id) {
		return alimentoRepository.findByIdDoadora(id);
	}

	// Lista um paciente pelo id dele mesmo
	@GetMapping("/{id}")
	public Optional<Alimento> listaPorIdAlimento(@PathVariable Long id) {
		return alimentoRepository.findById(id);
	}

	// Salva o paciente no banco de dados
	@PostMapping
	@ResponseBody
	public Alimento novo(@RequestBody Alimento alimento) {
		return alimentoRepository.save(alimento);
	}

	// Exclui um paciente
	@DeleteMapping
	public void deletaAlimento(@RequestBody Alimento alimento) {
		alimentoRepository.delete(alimento);
	}

	// Atualiza um terapeuta
	@PutMapping
	public Alimento atualizaAlimento(@RequestBody Alimento alimento) {
		return alimentoRepository.save(alimento);
	}

}
