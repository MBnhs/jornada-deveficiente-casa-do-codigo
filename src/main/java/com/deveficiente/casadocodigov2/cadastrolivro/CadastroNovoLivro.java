package com.deveficiente.casadocodigov2.cadastrolivro;

import com.deveficiente.casadocodigov2.cadastrocategoria.Categoria;
import com.deveficiente.casadocodigov2.cadastrocategoria.CategoriaRepository;
import com.deveficiente.casadocodigov2.novoautor.Autor;
import com.deveficiente.casadocodigov2.novoautor.AutorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
public class CadastroNovoLivro {

    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;
    private LivroRepository livroRepository;
    private BuscadorDeEntidades buscadorDeEntidades;

    public CadastroNovoLivro(AutorRepository autorRepository, CategoriaRepository categoriaRepository,
                             LivroRepository livroRepository, BuscadorDeEntidades buscadorDeEntidades) {
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
        this.livroRepository = livroRepository;
        this.buscadorDeEntidades = buscadorDeEntidades;
    }

    @Transactional
    public Livro executa(@Valid DadosNovoLivro dados) {
        Livro novoLivro = dados.toModel(
                id -> buscadorDeEntidades.buscaPorId(Autor.class, id),
                id -> buscadorDeEntidades.buscaPorId(Categoria.class, id)
        );
        livroRepository.save(novoLivro);

        return novoLivro;
    }
}
