package com.deveficiente.casadocodigov2.fechamentocompra;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.deveficiente.casadocodigov2.cadastrocupom.Cupom;

@Component
public class CupomValidoWebValidator implements Validator {

	private ValidaCupom validaCupom;

	public CupomValidoWebValidator(ValidaCupom validaCupom) {
		super();
		this.validaCupom = validaCupom;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCompraRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		DadosNovaCompra request = (DadosNovaCompra) target;

		validaCupom.valida(request, () -> {
			errors.rejectValue("codigoCupom", null,
					"Este cupom não é mais válido");
		});

	}

}
