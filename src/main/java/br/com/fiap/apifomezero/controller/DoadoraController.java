
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

@RestController
@RequestMapping("/api/doadora")
public class DoadoraController {

	@Autowired
	DoadoraRepository doadoraRepository;

	@GetMapping
	public List<Doadora> lista() {
		return doadoraRepository.findAll();
	}

	@PostMapping
	@ResponseBody
	public Doadora novo(@RequestBody Doadora doadora) {
		return doadoraRepository.save(doadora);
	}

	@DeleteMapping
	public void deletaDoadora(@RequestBody Doadora doadora) {
		doadoraRepository.delete(doadora);
	}

	@PutMapping
	public Doadora atualizaDoadora(@RequestBody Doadora doadora) {
		return doadoraRepository.save(doadora);
	}

}
