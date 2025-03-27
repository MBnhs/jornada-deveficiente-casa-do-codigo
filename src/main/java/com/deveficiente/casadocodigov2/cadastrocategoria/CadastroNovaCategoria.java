package com.deveficiente.casadocodigov2.cadastrocategoria;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
public class CadastroNovaCategoria {

    private CategoriaRepository categoriaRepository;

    public CadastroNovaCategoria(CategoriaRepository categoriaRepository) {
        super();
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public Categoria executa(@Valid DadosNovaCategoria dados) {
        return categoriaRepository.save(dados.toModel());
    }

}
