package com.alex.api_processar_votos.service;
import com.alex.api_processar_votos.domain.dto.VotoDto;
import com.alex.api_processar_votos.domain.entity.Candidato;
import com.alex.api_processar_votos.domain.entity.Voto;
import com.alex.api_processar_votos.repository.CandidatoRepository;
import com.alex.api_processar_votos.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private CandidatoRepository candidatoRepository;
    public void processar(VotoDto votoDto) {
        Long idCandidato = mapVotoToCandidatoId(votoDto.getVoto());
        Candidato candidatoEncontrado = candidatoRepository.findById(idCandidato)
                .orElseThrow(() -> new RuntimeException("Candidato com ID " + idCandidato + " não configurado no sistema."));
        Voto novoVoto = new Voto();
        novoVoto.setCandidato(candidatoEncontrado);
        votoRepository.save(novoVoto);
    }

    private Long mapVotoToCandidatoId(int numeroVoto) {
        switch (numeroVoto) {
            case 1:
                return 1L; // Voto '1' corresponde ao candidato com ID 1 no banco
            case 2:
                return 2L;
            case 3:
                return 3L;
            case 4:
                return 4L;
            default:
                throw new IllegalArgumentException("Número de voto inválido: " + numeroVoto);
        }
    }
}