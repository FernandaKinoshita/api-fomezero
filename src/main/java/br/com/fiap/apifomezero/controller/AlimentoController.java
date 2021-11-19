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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.apifomezero.model.Alimento;
import br.com.fiap.apifomezero.repository.AlimentoRepository;

@RestController
@RequestMapping("/api/alimentos")
public class AlimentoController {

	@Autowired
	private AlimentoRepository alimentoRepository;

	@GetMapping
	public List<Alimento> lista() {
		return alimentoRepository.findAll();
	}

	@GetMapping("/doadora/{id}")
	public List<Alimento> listaPorIdDoadora(@PathVariable Long id) {
		return alimentoRepository.findByIdDoadora(id);
	}

	@GetMapping("/{id}")
	public Optional<Alimento> listaPorIdAlimento(@PathVariable Long id) {
		return alimentoRepository.findById(id);
	}

	@PostMapping
	public Alimento novo(@RequestBody Alimento alimento) {
		return alimentoRepository.save(alimento);
	}

	@DeleteMapping
	public void deletaAlimento(@RequestBody Alimento alimento) {
		alimentoRepository.delete(alimento);
	}

	@PutMapping
	public Alimento atualizaAlimento(@RequestBody Alimento alimento) {
		return alimentoRepository.save(alimento);
	}

}
