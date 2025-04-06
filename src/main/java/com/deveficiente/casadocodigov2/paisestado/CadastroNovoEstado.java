package com.deveficiente.casadocodigov2.paisestado;

import com.deveficiente.casadocodigov2.cadastrolivro.BuscadorDeEntidades;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
public class CadastroNovoEstado {

    private EstadoRepository estadoRepository;
    private BuscadorDeEntidades buscadorDeEntidades;

    public CadastroNovoEstado(EstadoRepository estadoRepository, BuscadorDeEntidades buscadorDeEntidades) {
        super();
        this.estadoRepository = estadoRepository;
        this.buscadorDeEntidades = buscadorDeEntidades;
    }

    @Transactional
    public Estado executa(@Valid DadosNovoEstado dados) {
        return estadoRepository.save(dados.toModel(buscadorDeEntidades));
    }
}
