package com.deveficiente.casadocodigov2.cadastrocategoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriasController {

	/*
	Before:
	@PersistenceContext
	private EntityManager manager;

	 */

	/*
	1. Using dependency injection to make Categorias Controller more testable.
	This way it's possible to use the Constructor to inject EntityManager and
	mock it in a automated test.

	2. Creating a Repository class to make the project less dependent of a kind of database.
	So, instead of using a EntityManager class, we are using a CategoriaRepository class and
	injecting it via constructor.
	The CrudRepository class from SpringData is being used.
	This way, we can use any implementation as wished (SpringDataJPA, SpringMongoDB etc.),
	depending more of interfaces and less of libraries and frameworks.

	After:
	begin
	 */
	private CategoriaRepository categoriaRepository;

	public CategoriasController(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}
	/*
	end
	 */

	@PostMapping(value = "/categorias")
	@Transactional
	public String cria(@RequestBody @Valid NovaCategoriaRequest request) {

		Categoria novaCategoria = new Categoria(request.getNome());
		categoriaRepository.save(novaCategoria);
		
		return novaCategoria.toString();
	}
		
	

}
