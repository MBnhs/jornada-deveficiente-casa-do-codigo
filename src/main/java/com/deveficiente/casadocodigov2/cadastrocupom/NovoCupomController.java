package com.deveficiente.casadocodigov2.cadastrocupom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.deveficiente.casadocodigov2.fechamentocompra.CupomRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoCupomController {

	@PersistenceContext
	private EntityManager manager;

	private CadastroNovoCupom cadastroNovoCupom;

	public NovoCupomController(CadastroNovoCupom cadastroNovoCupom) {
		this.cadastroNovoCupom = cadastroNovoCupom;
	}

	@PostMapping(value = "/cupons")
	public String cria(@RequestBody @Valid NovoCupomRequest request) {
		return cadastroNovoCupom.executa(request).toString();
	}

}
