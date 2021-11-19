package br.com.fiap.apifomezero.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.apifomezero.model.Alimento;
import br.com.fiap.apifomezero.model.Doadora;


public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

	Optional<Alimento> findById(Long id);

	
	@Query(value = "SELECT a FROM Alimento a JOIN FETCH a.doadora WHERE a.doadora.id = ?1")
	List<Alimento> findByIdDoadora(Long idDoadora);

}
