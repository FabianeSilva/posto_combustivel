package com.fabianesilva.posto_combustivel.service;


import com.fabianesilva.posto_combustivel.infrastructure.entities.TiposDeCombustivel;
import com.fabianesilva.posto_combustivel.infrastructure.repositories.TipoDeCombustivelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //para indicar para o Spring que é uma service
@RequiredArgsConstructor //para que não precisemos fazer o construtor na mão para a nossa injeção de dependências
public class TiposDeCombustivelService {

    private final TipoDeCombustivelRepository tipoDeCombustivelRepository;

    public void criar(TiposDeCombustivel tiposDeCombustivel){
        tipoDeCombustivelRepository.save(tiposDeCombustivel);
    }

    private TiposDeCombustivel buscarTiposDeCombustivelPorId(Integer id){
        return tipoDeCombustivelRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Tipo de combustível não encontrada pelo id" + id));
    }

    private List<TiposDeCombustivel> buscarTiposDeCombustivel(){
        return tipoDeCombustivelRepository.findAll();
    }

    @Transactional //para garantir que não seja deletado caso aconteça qualquer erro aconteça
    private void deletarTipoDeCombustivel(Integer id){
        tipoDeCombustivelRepository.deleteById(id);
    }

    private void alterarTipoDeCombustivel(Integer id, TiposDeCombustivel tiposDeCombustivel){
        TiposDeCombustivel bomba = buscarTiposDeCombustivelPorId(id); //forma de validar que essa bomba de combustivel que estamos alterando existe
        tiposDeCombustivel.setId(bomba.getId());
        tipoDeCombustivelRepository.save(tiposDeCombustivel);
    }
}
