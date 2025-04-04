package com.deveficiente.casadocodigov2.paisestado;

import com.deveficiente.casadocodigov2.cadastrolivro.BuscadorDeEntidades;

import javax.persistence.EntityManager;

public interface DadosNovoEstado {

    public Estado toModel(BuscadorDeEntidades buscadorDeEntidades);

}
