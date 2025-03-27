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
	Using dependency injection to make Categorias Controller more testable.
	This way it's possible to use the Constructor to inject EntityManager and
	mock it in a automated test.

	After:
	begin
	 */
	private EntityManager manager;

	public CategoriasController(EntityManager manager) {
		this.manager = manager;
	}
	/*
	end
	 */

	@PostMapping(value = "/categorias")
	@Transactional
	public String cria(@RequestBody @Valid NovaCategoriaRequest request) {

		Categoria novaCategoria = new Categoria(request.getNome());
		manager.persist(novaCategoria);
		
		return novaCategoria.toString();
	}
		
	

}
