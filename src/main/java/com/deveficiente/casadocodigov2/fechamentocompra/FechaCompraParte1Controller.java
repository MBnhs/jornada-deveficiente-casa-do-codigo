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
	private CupomValidoValidator cupomValidoValidator;
	private FechaCompra fechaCompra;

	public FechaCompraParte1Controller(EstadoPertenceAPaisValidator estadoPertenceAPaisValidator,
									   CupomValidoValidator cupomValidoValidator,
									   FechaCompra fechaCompra) {
		this.estadoPertenceAPaisValidator = estadoPertenceAPaisValidator;
		this.cupomValidoValidator = cupomValidoValidator;
		this.fechaCompra = fechaCompra;
	}


	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoPertenceAPaisValidator,cupomValidoValidator);
	}

	@PostMapping(value = "/compras")
	public String cria(@RequestBody @Valid NovaCompraRequest request) {
		Compra novaCompra = fechaCompra.executa(request);
		return novaCompra.toString();
	}
	
}
