package br.com.fiap.apifomezero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.apifomezero.model.Doadora;
import br.com.fiap.apifomezero.repository.DoadoraRepository;

@Controller
public class LoginController {

	@Autowired
	DoadoraRepository doadoraRepository;

	@RequestMapping("/login")
	public ResponseEntity<Doadora> login(@RequestBody Doadora login) {

		Doadora doadora = doadoraRepository.findByCnpj(login.getCnpj());

		if (doadora.getSenha().equals(login.getSenha())) {
			return ResponseEntity.ok(doadora);
		}

		return ResponseEntity.badRequest().build();
	}

}
