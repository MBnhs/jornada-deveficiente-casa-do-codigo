package com.deveficiente.casadocodigov2.cadastrolivro;

import com.deveficiente.casadocodigov2.cadastrocategoria.Categoria;
import com.deveficiente.casadocodigov2.novoautor.Autor;

import java.util.function.Function;

public interface DadosNovoLivro {

    Livro toModel(Function<Long, Autor> carregaAutor,
                  Function<Long, Categoria> carregaCategoria);
}
