package com.deveficiente.casadocodigov2.cadastrolivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.deveficiente.casadocodigov2.cadastrocategoria.CategoriaRepository;
import com.deveficiente.casadocodigov2.novoautor.AutorRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.casadocodigov2.cadastrocategoria.Categoria;
import com.deveficiente.casadocodigov2.novoautor.Autor;

@RestController
public class LivrosController {
	
	private AutorRepository autorRepository;
	private CategoriaRepository categoriaRepository;
	private LivroRepository livroRepository;
	private CadastroNovoLivro cadastroNovoLivro;

	public LivrosController(AutorRepository autorRepository,
							CategoriaRepository categoriaRepository, LivroRepository livroRepository,
							CadastroNovoLivro cadastroNovoLivro) {
		super();
		this.autorRepository = autorRepository;
		this.categoriaRepository = categoriaRepository;
		this.livroRepository = livroRepository;
		this.cadastroNovoLivro = cadastroNovoLivro;
	}

	@PostMapping(value = "/livros")
	@Transactional
	//1
	public String cria(@RequestBody @Valid NovoLivroRequest request) {
		return cadastroNovoLivro.executa(request).toString();
	}

}
