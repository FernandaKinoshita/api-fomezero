package br.com.fiap.apifomezero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.apifomezero.model.Doadora;



//JpaRepository=> possui metodos prontos para fazer persistencia no BD
public interface DoadoraRepository extends JpaRepository<Doadora, Long> {

	// faz uma query especifica no bd
	@Query(value = "SELECT d FROM Doadora d WHERE d.email=?1 or d.cnpj=?1 ")
	Doadora buscaPorCnpjOuEmail(String CnpjOuEmail);

	Doadora findByCnpj(String cnpj);
}
