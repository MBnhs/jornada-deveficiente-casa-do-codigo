package com.deveficiente.casadocodigov2.fechamentocompra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.deveficiente.casadocodigov2.cadastrolivro.BuscadorDeEntidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomMapEditor;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FechaCompraParte1Controller {
	
	private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;
	@PersistenceContext
	private EntityManager manager;

	private BuscadorDeEntidades buscadorDeEntidades;
	private CupomValidoValidator cupomValidoValidator;
	private CompraRepository compraRepository;
	private CupomRepository cupomRepository;

	public FechaCompraParte1Controller(EstadoPertenceAPaisValidator estadoPertenceAPaisValidator,
									   BuscadorDeEntidades buscadorDeEntidades,
									   CupomValidoValidator cupomValidoValidator,
									   CompraRepository compraRepository,
									   CupomRepository cupomRepository) {
		this.estadoPertenceAPaisValidator = estadoPertenceAPaisValidator;
		this.buscadorDeEntidades = buscadorDeEntidades;
		this.cupomValidoValidator = cupomValidoValidator;
		this.compraRepository = compraRepository;
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoPertenceAPaisValidator,cupomValidoValidator);
	}

	@PostMapping(value = "/compras")
	@Transactional
	public String cria(@RequestBody @Valid NovaCompraRequest request) {
		
		Compra novaCompra = request.toModel(manager,cupomRepository);
		compraRepository.save(novaCompra);
		return novaCompra.toString();
	}
	
}
