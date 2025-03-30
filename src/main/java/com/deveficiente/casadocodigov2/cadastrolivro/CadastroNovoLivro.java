package com.deveficiente.casadocodigov2.cadastrolivro;

import com.deveficiente.casadocodigov2.cadastrocategoria.CategoriaRepository;
import com.deveficiente.casadocodigov2.novoautor.AutorRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CadastroNovoLivro {

    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;
    private LivroRepository livroRepository;

    public CadastroNovoLivro(AutorRepository autorRepository, CategoriaRepository categoriaRepository,
                             LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
        this.livroRepository = livroRepository;
    }

    public Livro executa(@Valid NovoLivroRequest request) {
        Livro novoLivro = request.toModel(
                id -> autorRepository.findById(id).get(),
                id -> categoriaRepository.findById(id).get()
        );
        livroRepository.save(novoLivro);

        return novoLivro;
    }
}
