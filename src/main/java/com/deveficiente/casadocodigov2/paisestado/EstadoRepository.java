package com.deveficiente.casadocodigov2.paisestado;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {
}
