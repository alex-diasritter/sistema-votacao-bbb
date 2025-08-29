package com.alex.api_processar_votos.repository;
import com.alex.api_processar_votos.domain.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {}
