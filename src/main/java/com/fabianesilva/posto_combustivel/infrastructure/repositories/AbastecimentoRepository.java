package com.fabianesilva.posto_combustivel.infrastructure.repositories;

import com.fabianesilva.posto_combustivel.infrastructure.entities.Abastecimento;
import com.fabianesilva.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Integer> {
}
