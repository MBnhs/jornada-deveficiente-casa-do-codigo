package com.deveficiente.casadocodigov2.cadastrocategoria;

import javax.validation.constraints.NotBlank;

import com.deveficiente.casadocodigov2.compartilhado.Documento;
import com.deveficiente.casadocodigov2.compartilhado.UniqueValue;

public class NovaCategoriaRequest implements DadosNovaCategoria {

	@NotBlank
	//@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public Categoria toModel() {
		return new Categoria(nome);
	}
}
