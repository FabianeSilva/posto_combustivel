package com.fabianesilva.posto_combustivel.service;

import com.fabianesilva.posto_combustivel.infrastructure.entities.Abastecimento;
import com.fabianesilva.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.fabianesilva.posto_combustivel.infrastructure.repositories.AbastecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service //para indicar para o Spring que é uma service
@RequiredArgsConstructor //para que não precisemos fazer o construtor na mão para a nossa injeção de dependências
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;
    private final BombaDeCombustivelService bombaDeCombustivelService;

    public void abastecer(Integer idBomba, Long litros){
        BombasDeCombustivel bomba = bombaDeCombustivelService.buscarBombaCombustivelPorId(idBomba);
        BigDecimal valorTotal = bomba.getTiposDeCombustivel()
                .getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));

        Abastecimento abastecimento = Abastecimento.builder()
                .dataAbastecimento(LocalDate.now())
                .bombasDeCombustivel(bomba)
                .valorTotal(valorTotal)
                .quantidadeLitros(litros)
                .build();

        abastecimentoRepository.save(abastecimento);
    }

    public List<Abastecimento> buscarAbastecimentos(){
        return abastecimentoRepository.findAll();
    }
}
