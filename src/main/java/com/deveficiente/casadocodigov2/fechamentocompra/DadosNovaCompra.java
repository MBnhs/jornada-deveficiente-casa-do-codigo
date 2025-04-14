package com.deveficiente.casadocodigov2.fechamentocompra;

import com.deveficiente.casadocodigov2.cadastrolivro.BuscadorDeEntidades;

public interface DadosNovaCompra {

    public Compra toModel(BuscadorDeEntidades buscadorDeEntidades, CupomRepository cupomRepository);
}
