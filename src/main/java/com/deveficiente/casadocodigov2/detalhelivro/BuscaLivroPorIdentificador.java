package com.deveficiente.casadocodigov2.detalhelivro;

import com.deveficiente.casadocodigov2.cadastrolivro.BuscadorDeEntidades;
import com.deveficiente.casadocodigov2.cadastrolivro.Livro;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscaLivroPorIdentificador {

    private BuscadorDeEntidades buscadorDeEntidades;

    public BuscaLivroPorIdentificador(BuscadorDeEntidades buscadorDeEntidades) {
        this.buscadorDeEntidades = buscadorDeEntidades;
    }

    public Optional<Livro> executa(Long id) {
        return buscadorDeEntidades.buscaPorId(Livro.class, id);
    }

}
