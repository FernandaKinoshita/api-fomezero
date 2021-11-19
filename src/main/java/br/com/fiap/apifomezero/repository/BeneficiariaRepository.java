package br.com.fiap.apifomezero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.apifomezero.model.Beneficiaria;

public interface BeneficiariaRepository extends JpaRepository<Beneficiaria, Long> {

}
