package br.com.fiap.apifomezero.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.apifomezero.model.Alimento;

//JpaRepository=> possui metodos prontos para fazer persistencia no BD
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

	Optional<Alimento> findById(Long id);

	// JPQL=Query dentro do Java.
	// Seleciona lista de pacientes por id do terapeuta
	// Inner Join pelo id do terapeuta buscando uma lista de pacientes
	@Query(value = "SELECT a FROM Alimento d JOIN FETCH a.doadora WHERE a.doadora.id = ?1")
	List<Alimento> findByIdDoadora(Long idDoadora);

}
