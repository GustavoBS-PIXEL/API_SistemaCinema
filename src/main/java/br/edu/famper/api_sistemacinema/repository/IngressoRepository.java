package br.edu.famper.api_sistemacinema.repository;

import br.edu.famper.api_sistemacinema.model.Ingresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Long> {
}
