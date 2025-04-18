package com.deveficiente.casadocodigov2.fechamentocompra;

import javax.validation.Valid;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FechaCompraParte1Controller {

	private EstadoPertenceAPaisWebValidator estadoPertenceAPaisValidator;
	private CupomValidoWebValidator cupomValidoValidator;
	private FechaCompra fechaCompra;

	public FechaCompraParte1Controller(EstadoPertenceAPaisWebValidator estadoPertenceAPaisValidator,
									   CupomValidoWebValidator cupomValidoValidator,
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
