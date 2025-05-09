package com.deveficiente.casadocodigov2.paisestado;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriaEstadoController {
	
	private CadastroNovoEstado cadastroNovoEstado;

	public CriaEstadoController(CadastroNovoEstado cadastroNovoEstado) {
		super();
		this.cadastroNovoEstado = cadastroNovoEstado;
	}

	@PostMapping(value = "/estados")
	public String cria(@RequestBody @Valid NovoEstadoRequest request) {
		return cadastroNovoEstado.executa(request).toString();
	}

}
