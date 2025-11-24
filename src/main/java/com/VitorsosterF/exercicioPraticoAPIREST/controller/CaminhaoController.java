package com.VitorsosterF.exercicioPraticoAPIREST.controller;

import com.VitorsosterF.exercicioPraticoAPIREST.model.Caminhao;
import com.VitorsosterF.exercicioPraticoAPIREST.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/caminhao")
public class CaminhaoController {

    @Autowired
    private CaminhaoRepository caminhoRepository;

    @GetMapping
    public List<Caminhao> listar() {
        return caminhoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caminhao> buscarPorId(@PathVariable Long id) {
        Optional<Caminhao> caminhao = caminhoRepository.findById(id);
        if (caminhao.isPresent()) {
            return ResponseEntity.ok(caminhao.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Caminhao criar(@RequestBody Caminhao caminhao) {
        return caminhoRepository.save(caminhao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Caminhao> atualizar(@PathVariable Long id, @RequestBody Caminhao dadosCaminhao) {
        return caminhoRepository.findById(id)
                .map(c -> {
                    c.setModelo(dadosCaminhao.getModelo());
                    c.setMarca(dadosCaminhao.getMarca());
                    c.setAno(dadosCaminhao.getAno());
                    c.setPreco(dadosCaminhao.getPreco());
                    c.setCapacidadeCarga(dadosCaminhao.getCapacidadeCarga());
                    Caminhao atualizado = caminhoRepository.save(c);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (caminhoRepository.existsById(id)) {
            caminhoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}