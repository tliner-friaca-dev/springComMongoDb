package br.com.projeto.springComMongoDb.service.impl;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projeto.springComMongoDb.model.Colaborador;

@SpringBootTest
public class ColaboradorServiceImplTest {

    @Autowired
    private ColaboradorServiceImpl colaboradorServiceImpl;

    private Colaborador colaborador;

    @BeforeEach
    public void setUp() {

        colaborador = new Colaborador();

    }

    @Test
    void testCriar() {

        colaborador = new Colaborador.ColaboradorBuilder()
                            .comDataNascimento(LocalDate.of(1990, 10, 05))
                            .comNome("Colaborador - teste - criação")
                            .comSalario(new BigDecimal("2000"))
                            .construir();

        colaborador = colaboradorServiceImpl.criar(colaborador);

        assertNotNull(colaborador.getCodigo());
        
    }

    @Test
    void testObterColaboradorPorNome() {

        colaborador = new Colaborador.ColaboradorBuilder()
                            .comDataNascimento(LocalDate.of(1990, 10, 05))
                            .comNome("Colaborador - obter por nome")
                            .comSalario(new BigDecimal("1000"))
                            .construir();

        colaborador = colaboradorServiceImpl.criar(colaborador);
        
        Colaborador colabordorePorNome = colaboradorServiceImpl.obterColaboradorPorNome(colaborador.getNome()).get(0);

		assertAll("funcionario", () -> assertEquals(LocalDate.of(1990, 10, 05), colabordorePorNome.getDataNascimento()),
                                            () -> assertEquals("Colaborador - buscar por nome", colabordorePorNome.getNome()),
                                            () -> assertEquals(new BigDecimal("1000"), colabordorePorNome.getSalario()));

    }

    @Test
    void testObterColaboradorPorRangeDeSalario() {

        List<Colaborador> colaboradoresDeletar = colaboradorServiceImpl.obterColaboradorPorRangeDeSalario(new BigDecimal("987654321"), new BigDecimal("987654321"));

        colaboradoresDeletar.stream().forEach(c -> { colaboradorServiceImpl.deletarColaboradorPorCodigo(c.getCodigo()); });
 
        colaborador = new Colaborador.ColaboradorBuilder()
                            .comDataNascimento(LocalDate.of(1980, 02, 23))
                            .comNome("Colaborador - ober por ranger de salário - 1")
                            .comSalario(new BigDecimal("987654321"))
                            .construir();
        colaborador = colaboradorServiceImpl.criar(colaborador);

        colaborador = new Colaborador.ColaboradorBuilder()
                            .comDataNascimento(LocalDate.of(1990, 10, 05))
                            .comNome("Colaborador - ober por ranger de salário - 2")
                            .comSalario(new BigDecimal("987654321"))
                            .construir();
        colaborador = colaboradorServiceImpl.criar(colaborador);

        colaborador = colaboradorServiceImpl.criar(colaborador);
        
        List<Colaborador> colaboradoresRetorno = colaboradorServiceImpl.obterColaboradorPorRangeDeSalario(new BigDecimal("987654321"), new BigDecimal("987654321"));

		assertEquals(2, colaboradoresRetorno.size());

    }

    @Test
    void testObterPorCodigo() {
        
        colaborador = new Colaborador.ColaboradorBuilder()
                            .comDataNascimento(LocalDate.of(1980, 02, 23))
                            .comNome("Colaborador - ober por código")
                            .comSalario(new BigDecimal("7000"))
                            .construir();
        colaborador = colaboradorServiceImpl.criar(colaborador);

        Colaborador colaboradorRetorno = colaboradorServiceImpl.obterPorCodigo(colaborador.getCodigo());

        assertEquals(colaborador.getCodigo(), colaboradorRetorno.getCodigo());

    }

    @Test
    void testObterTodos() {

    }
}
