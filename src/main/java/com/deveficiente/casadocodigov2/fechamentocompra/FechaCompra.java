package com.deveficiente.casadocodigov2.fechamentocompra;

import com.deveficiente.casadocodigov2.cadastrolivro.BuscadorDeEntidades;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
public class FechaCompra {

    private EstadoPertenceAPaisWebValidator estadoPertenceAPaisValidator;

    private BuscadorDeEntidades buscadorDeEntidades;
    private CompraRepository compraRepository;
    private CupomRepository cupomRepository;
    private ValidaCupom validaCupom;
    private ValidaEstadoPertenceAPais validaEstadoPertenceAPais;

    public FechaCompra(EstadoPertenceAPaisWebValidator estadoPertenceAPaisValidator,
                       BuscadorDeEntidades buscadorDeEntidades,
                       CompraRepository compraRepository,
                       CupomRepository cupomRepository,
                       ValidaCupom validaCupom,
                       ValidaEstadoPertenceAPais validaEstadoPertenceAPais) {
        this.estadoPertenceAPaisValidator = estadoPertenceAPaisValidator;
        this.buscadorDeEntidades = buscadorDeEntidades;
        this.compraRepository = compraRepository;
        this.cupomRepository = cupomRepository;
        this.validaCupom = validaCupom;
        this.validaEstadoPertenceAPais = validaEstadoPertenceAPais;

    }

    @Transactional
    public Compra executa(@Valid DadosNovaCompra dados) {

        validaCupom.valida(dados, () -> {
            throw new IllegalArgumentException("Neste ponto do fluxo o cupom devia estar válido");
        });

        validaEstadoPertenceAPais.valida(dados, () -> {
            throw new IllegalArgumentException("Neste ponto do fluxo a validacao do estado pertencente ao pais deveria estar feita");
        });

        Compra novaCompra = dados.toModel(buscadorDeEntidades,cupomRepository);
        compraRepository.save(novaCompra);
        return novaCompra;
    }

}
