package com.fabianesilva.posto_combustivel.service;

import com.fabianesilva.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.fabianesilva.posto_combustivel.infrastructure.repositories.BombaDeCombustivelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //para indicar para o Spring que é uma service
@RequiredArgsConstructor //para que não precisemos fazer o construtor na mão para a nossa injeção de dependências
public class BombaDeCombustivelService {

    private final BombaDeCombustivelRepository bombaDeCombustivelRepository;

    public void criar(BombasDeCombustivel bombasDeCombustivel){
        bombaDeCombustivelRepository.save(bombasDeCombustivel);
    }

    public BombasDeCombustivel buscarBombaCombustivelPorId(Integer id){
        return bombaDeCombustivelRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Bomba de combustível não encontrada pelo id" + id));
    }

    public List<BombasDeCombustivel> buscarBombasDeCombustivel(){
        return bombaDeCombustivelRepository.findAll();
    }

    @Transactional //para garantir que não seja deletado caso aconteça qualquer erro aconteça
    public void deletarBombaCombustivel(Integer id){
        bombaDeCombustivelRepository.deleteById(id);
    }

    public void alterarBombaCombustivel(Integer id, BombasDeCombustivel bombasDeCombustivel){
        BombasDeCombustivel bomba = buscarBombaCombustivelPorId(id); //forma de validar que essa bomba de combustivel que estamos alterando existe
        bombasDeCombustivel.setId(bomba.getId());
        bombaDeCombustivelRepository.save(bombasDeCombustivel);
    }
}
