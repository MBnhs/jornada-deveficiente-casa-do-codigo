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

	public LivrosController(AutorRepository autorRepository,
							CategoriaRepository categoriaRepository, LivroRepository livroRepository) {
		this.autorRepository = autorRepository;
		this.categoriaRepository = categoriaRepository;
		this.livroRepository = livroRepository;
	}

	@PostMapping(value = "/livros")
	@Transactional
	//1
	public String cria(@RequestBody @Valid NovoLivroRequest request) {
		//1

		Livro novoLivro = request.toModel(
				id -> autorRepository.findById(id).get(),
				id -> categoriaRepository.findById(id).get()
				);
		livroRepository.save(novoLivro);
		return novoLivro.toString();
	}

}
