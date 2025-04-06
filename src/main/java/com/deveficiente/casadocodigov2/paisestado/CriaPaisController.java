package com.deveficiente.casadocodigov2.paisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriaPaisController {

	private CadastroNovoPais cadastroNovoPais;

	public CriaPaisController(CadastroNovoPais cadastroNovoPais) {
		super();
		this.cadastroNovoPais = cadastroNovoPais;
	}

	@PostMapping(value = "/paises")
	public String criaPais(@RequestBody @Valid NovoPaisRequest request) {
		return cadastroNovoPais.executa(request).toString();
	}

}
