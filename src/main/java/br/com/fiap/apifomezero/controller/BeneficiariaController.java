
package br.com.fiap.apifomezero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.apifomezero.model.Beneficiaria;
import br.com.fiap.apifomezero.repository.BeneficiariaRepository;

@RestController
@RequestMapping("/api/beneficiaria")
public class BeneficiariaController {

	@Autowired
	BeneficiariaRepository beneficiariaRepository;

	@GetMapping
	public List<Beneficiaria> lista() {
		return beneficiariaRepository.findAll();
	}

	@PostMapping
	@ResponseBody
	public Beneficiaria novo(@RequestBody Beneficiaria beneficiaria) {
		return beneficiariaRepository.save(beneficiaria);
	}

}
