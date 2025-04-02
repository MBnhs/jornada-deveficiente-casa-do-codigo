package com.deveficiente.casadocodigov2.cadastrocupom;

import com.deveficiente.casadocodigov2.fechamentocompra.CupomRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CadastroNovoCupom {

    private CupomRepository cupomRepository;

    public CadastroNovoCupom(CupomRepository cupomRepository) {
        super();
        this.cupomRepository = cupomRepository;
    }

    @Transactional
    public Cupom executa(DadosNovoCupom dados) {
        Cupom novoCupom = dados.toModel();
        cupomRepository.save(novoCupom);
        return novoCupom;
    }

}
