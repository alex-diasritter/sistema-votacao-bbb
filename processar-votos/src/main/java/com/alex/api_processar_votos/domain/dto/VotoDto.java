package com.alex.api_processar_votos.domain.dto;

public class VotoDto {

    private int voto;

    public VotoDto() {
    }

    public VotoDto(int voto) {
        this.voto = voto;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
}
