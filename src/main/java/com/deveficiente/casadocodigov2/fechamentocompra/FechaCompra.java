package com.deveficiente.casadocodigov2.fechamentocompra;

import com.deveficiente.casadocodigov2.cadastrolivro.BuscadorDeEntidades;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
public class FechaCompra {

    private EstadoPertenceAPaisWebValidator estadoPertenceAPaisValidator;

    private BuscadorDeEntidades buscadorDeEntidades;
    private CupomValidoWebValidator cupomValidoValidator;
    private CompraRepository compraRepository;
    private CupomRepository cupomRepository;

    public FechaCompra(EstadoPertenceAPaisWebValidator estadoPertenceAPaisValidator,
                       BuscadorDeEntidades buscadorDeEntidades,
                       CupomValidoWebValidator cupomValidoValidator,
                       CompraRepository compraRepository,
                       CupomRepository cupomRepository) {
        this.estadoPertenceAPaisValidator = estadoPertenceAPaisValidator;
        this.buscadorDeEntidades = buscadorDeEntidades;
        this.cupomValidoValidator = cupomValidoValidator;
        this.compraRepository = compraRepository;
        this.cupomRepository = cupomRepository;
    }

    @Transactional
    public Compra executa(@Valid DadosNovaCompra dados) {
        Compra novaCompra = dados.toModel(buscadorDeEntidades,cupomRepository);
        compraRepository.save(novaCompra);
        return novaCompra;
    }

}
