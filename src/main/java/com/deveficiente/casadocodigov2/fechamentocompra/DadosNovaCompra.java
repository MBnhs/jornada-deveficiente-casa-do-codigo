package com.deveficiente.casadocodigov2.fechamentocompra;

import com.deveficiente.casadocodigov2.cadastrolivro.BuscadorDeEntidades;

import java.util.Optional;

public interface DadosNovaCompra {

    public Compra toModel(BuscadorDeEntidades buscadorDeEntidades, CupomRepository cupomRepository);

    boolean temEstado();

    Long getIdPais();

    Long getIdEstado();

    Optional<String> getCodigoCupom();
}
