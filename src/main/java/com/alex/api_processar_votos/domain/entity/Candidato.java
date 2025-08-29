package com.alex.api_processar_votos.domain.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_candidatos")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_candidato", nullable = false)
    private String nome;

    // "mappedBy = "candidato"" informa ao JPA que a entidade Voto é a dona do relacionamento
    // e que a ligação é feita pelo campo "candidato" na classe Voto.
    @OneToMany(mappedBy = "candidato")
    private List<Voto> votos;

    public Candidato() {
    }

    public Candidato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }
}


