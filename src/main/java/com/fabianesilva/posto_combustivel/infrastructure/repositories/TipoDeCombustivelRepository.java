package com.fabianesilva.posto_combustivel.infrastructure.repositories;

import com.fabianesilva.posto_combustivel.infrastructure.entities.TiposDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDeCombustivelRepository extends JpaRepository<TiposDeCombustivel, Integer> {
}
