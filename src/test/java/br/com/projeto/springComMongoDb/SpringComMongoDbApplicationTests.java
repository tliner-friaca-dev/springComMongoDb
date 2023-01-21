package br.com.projeto.springComMongoDb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projeto.springComMongoDb.model.Colaborador;
import br.com.projeto.springComMongoDb.service.impl.ColaboradorServiceImpl;

@SpringBootTest
class SpringComMongoDbApplicationTests {
/* 
	@Autowired
	ColaboradorService colaboradorService;
 */
	@Autowired
	ColaboradorServiceImpl colaboradorServiceImpl;
	
    @Test
    void testCriar_retornaObjetoPreenchido_quandoCriaColaborador() {

        
        Colaborador colaborador = new Colaborador.ColaboradorBuilder()
                            .comDataNascimento(LocalDate.of(1990, 10, 05))
                            .comNome("Colaborador - Teste - criação")
                            .comSalario(new BigDecimal("2000"))
                            .construir();

        //colaborador = colaboradorService.criar(colaborador);
        colaborador = colaboradorServiceImpl.criar(colaborador);


        assertEquals(colaborador.getNome(), "Colaborador - Teste - criação");


    }

    @Test
    void testObterColaboradorPorNome() {

    }

    @Test
    void testObterColaboradorPorRangeDeSalario() {

    }

    @Test
    void testObterPorCodigo() {

    }

    @Test
    void testObterTodos() {

    }

}
