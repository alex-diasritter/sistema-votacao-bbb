package com.alex.api_processar_votos.repository;
import com.alex.api_processar_votos.domain.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {}
