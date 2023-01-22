package br.com.projeto.springComMongoDb.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.springComMongoDb.model.Colaborador;
import br.com.projeto.springComMongoDb.repository.ColaboradorRepository;
import br.com.projeto.springComMongoDb.service.ColaboradorService;

@Service
public class ColaboradorServiceImpl implements ColaboradorService{

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Override
    public List<Colaborador> obterTodos() {
        return this.colaboradorRepository.findAll();
    }

    @Override
    public Colaborador obterPorCodigo(String codigo) {
        return this.colaboradorRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Colaborador não existe."));
    }

    @Override
    public Colaborador criar(Colaborador colaborador) {

        if (colaborador.getSupervisor() != null && colaborador.getSupervisor().getCodigo() != null ) {
            
            Colaborador supervisor = this.colaboradorRepository
                                        .findById(colaborador.getSupervisor().getCodigo())
                                        .orElseThrow(() -> new IllegalArgumentException("Supervisor inexistente."));
            
            colaborador.setSupervisor(supervisor);
        }

        return this.colaboradorRepository.save(colaborador);
    }

    @Override
    public List<Colaborador> obterColaboradorPorRangeDeSalario(BigDecimal de, BigDecimal ate) {
        return this.colaboradorRepository.obterColaboradorPorRangeDeSalario(de, ate);
    }

    @Override
    public List<Colaborador> obterColaboradorPorNome(String nome) {
        return this.colaboradorRepository.findByNome(nome) ;
    }

    @Override
    public Long deletarColaboradorPorCodigo(String codigo) {
        return this.colaboradorRepository.deleteColaboradorByCodigo(codigo);
    }

    @Override
    public void deletarTodos() {
        this.colaboradorRepository.deleteAll();

    }
    
}
