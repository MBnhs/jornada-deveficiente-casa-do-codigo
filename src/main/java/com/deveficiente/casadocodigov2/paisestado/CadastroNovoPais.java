package com.deveficiente.casadocodigov2.paisestado;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
@Validated
public class CadastroNovoPais {

    private PaisRepository paisRepository;

    public CadastroNovoPais(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Transactional
    public Pais executa(@Valid DadosNovoPais dadosNovoPais) {
        return paisRepository.save(new Pais(dadosNovoPais.getNome()));
    }

}
