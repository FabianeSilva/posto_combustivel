package com.fabianesilva.posto_combustivel.cotroller;

import com.fabianesilva.posto_combustivel.infrastructure.entities.Abastecimento;
import com.fabianesilva.posto_combustivel.infrastructure.entities.TiposDeCombustivel;
import com.fabianesilva.posto_combustivel.service.AbastecimentoService;
import com.fabianesilva.posto_combustivel.service.TiposDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //porque estamos trabalhando com uma API REST
@RequiredArgsConstructor
@RequestMapping("/tiposDeCombustivelController")
public class TiposDeCombustivelController {

    private final TiposDeCombustivelService tiposDeCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody TiposDeCombustivel tiposDeCombustivel) {
        tiposDeCombustivelService.criar(tiposDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<TiposDeCombustivel>> buscarTiposDeCombustivel(){
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiposDeCombustivel> buscarTiposdeCombustivelPorId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivelPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTiposDeCombustivelPorId(@PathVariable(name = "id") Integer id){
        tiposDeCombustivelService.deletarTipoDeCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> alterarTipoDeCombustivel(@RequestParam(name = "id") Integer id,
                                                         @RequestBody TiposDeCombustivel tiposDeCombustivel){
        tiposDeCombustivelService.alterarTipoDeCombustivel(id, tiposDeCombustivel);
        return ResponseEntity.ok().build();
    }

}
