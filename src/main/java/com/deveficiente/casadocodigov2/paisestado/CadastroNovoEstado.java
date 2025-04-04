package com.deveficiente.casadocodigov2.paisestado;

import com.deveficiente.casadocodigov2.cadastrolivro.BuscadorDeEntidades;
import org.springframework.stereotype.Service;

@Service
public class CadastroNovoEstado {

    private EstadoRepository estadoRepository;
    private BuscadorDeEntidades buscadorDeEntidades;

    public CadastroNovoEstado(EstadoRepository estadoRepository, BuscadorDeEntidades buscadorDeEntidades) {
        super();
        this.estadoRepository = estadoRepository;
        this.buscadorDeEntidades = buscadorDeEntidades;
    }

    public Estado executa(DadosNovoEstado dados) {

        return estadoRepository.save(dados.toModel(buscadorDeEntidades));
    }
}
