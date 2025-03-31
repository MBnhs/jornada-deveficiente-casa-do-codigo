package com.deveficiente.casadocodigov2.cadastrolivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.util.Objects;
import java.util.Optional;

@Component
public class BuscadorDeEntidadesJPA implements BuscadorDeEntidades {

    @Autowired
    private EntityManager manager;

    @Override
    public <T> T retornaPorId(Class<T> klass, Long id) {
        T entidade = manager.find(klass, id);
        Assert.state(Objects.nonNull(entidade),
                "A busca pela entidade do tipo " + klass
                        + " retornou nulo para o id " + id
                        + ". Isso não deveria acontecer");
        return entidade;
    }

    @Override
    public <T> Optional<T> buscaPorId(Class<T> klass, Long id) {
        return Optional.ofNullable(manager.find(klass, id));
    }
}
