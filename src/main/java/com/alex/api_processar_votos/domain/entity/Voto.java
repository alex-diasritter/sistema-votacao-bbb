package com.alex.api_processar_votos.domain.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_votos")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voto")
    private Long id;

    // A anotação @ManyToOne indica que muitos Votos podem pertencer a um Candidato.
    // Esta é a anotação que efetivamente cria a coluna da chave estrangeira.
    @ManyToOne
    @JoinColumn(name = "id_candidato", nullable = false)
    private Candidato candidato;

    public Voto() {
    }

    public Voto(Candidato candidato) {
        this.candidato = candidato;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
}
