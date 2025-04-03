package com.deveficiente.casadocodigov2.cadastrocupom;

import com.deveficiente.casadocodigov2.fechamentocompra.CupomRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
public class CadastroNovoCupom {

    private CupomRepository cupomRepository;

    public CadastroNovoCupom(CupomRepository cupomRepository) {
        super();
        this.cupomRepository = cupomRepository;
    }

    @Transactional
    public Cupom executa(@Valid DadosNovoCupom dados) {
        Cupom novoCupom = dados.toModel();
        cupomRepository.save(novoCupom);
        return novoCupom;
    }

}
