package br.com.projeto.springComMongoDb.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.projeto.springComMongoDb.model.Colaborador;

public interface ColaboradorRepository extends MongoRepository<Colaborador, String> {

    @Query("{ $and: [ { 'salario': { $gte: ?0 } }, { 'salario': { $lte: ?1 } } ] }")
    public List<Colaborador> obterColaboradorPorRangeDeSalario(BigDecimal de, BigDecimal ate);
    
    public List<Colaborador> findByNome(String nome);

    public Long deleteColaboradorByCodigo(String codigo);
}
