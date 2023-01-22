package br.com.projeto.springComMongoDb.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.springComMongoDb.model.Colaborador;
import br.com.projeto.springComMongoDb.service.ColaboradorService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;
    
    @GetMapping
    public List<Colaborador> obterTodos() {
        return this.colaboradorService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Colaborador obterPorCodigo(@PathVariable String codigo) {
        return this.colaboradorService.obterPorCodigo(codigo);
    }

    @GetMapping("/range-salario")
    public List<Colaborador> obterColaboradorPorRangeDeSalario(
            @RequestParam("de") BigDecimal de, 
            @RequestParam("ate") BigDecimal ate) {

        return this.colaboradorService.obterColaboradorPorRangeDeSalario(de, ate);
    }

    @GetMapping("/por-nome")
    public List<Colaborador> obterColaboradorPorNome(@RequestParam("nome") String nome) {
        return this.colaboradorService.obterColaboradorPorNome(nome);
    }

    @PostMapping
    public Colaborador criar(@RequestBody Colaborador colaborador) {
        return this.colaboradorService.criar(colaborador);
    }

    @DeleteMapping("/por-codigo")
    public Long deletarColaboradorPorCodigo(@RequestParam("codigo") String codigo) {
        return this.colaboradorService.deletarColaboradorPorCodigo(codigo);
    }

    @DeleteMapping
    public void deletarTodos() {
        this.colaboradorService.deletarTodos();
    }
}
