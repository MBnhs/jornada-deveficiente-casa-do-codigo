package com.deveficiente.casadocodigov2.fechamentocompra;

import com.deveficiente.casadocodigov2.cadastrocupom.Cupom;
import com.deveficiente.casadocodigov2.cadastrocupom.DadosNovoCupom;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.Optional;

@Component
public class ValidaCupom {

    private CupomRepository cupomRepository;

    public ValidaCupom(CupomRepository cupomRepository) {
        super();
        this.cupomRepository = cupomRepository;
    }


    public void valida(DadosNovaCompra dados, Runnable handlerErro) {
        Optional<String> possivelCodigo = dados.getCodigoCupom();
        if (possivelCodigo.isPresent()) {
            Cupom cupom = cupomRepository.getByCodigo(possivelCodigo.get());
            Assert.state(Objects.nonNull(cupom),
                    "O código do cupom precisa existir neste ponto da validacao");

            if (!cupom.valido()) {
                handlerErro.run();
            }
        }
    }
}
