package br.com.projeto.springComMongoDb.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.projeto.springComMongoDb.model.Colaborador;

public interface ColaboradorService {

    public List<Colaborador> obterTodos();
    public Colaborador obterPorCodigo(String codigo);
    public Colaborador criar(Colaborador colaborador);
    public List<Colaborador>  obterColaboradorPorRangeDeSalario(BigDecimal de, BigDecimal ate);
    public List<Colaborador> obterColaboradorPorNome(String nome);
    public Long deletarColaboradorPorCodigo(String codigo);
    
}
