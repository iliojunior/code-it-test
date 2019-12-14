import com.ilioadriano.Domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CodeItTest {

    Piloto piloto = new Piloto("Piloto");
    ChefeServico chefeServico = new ChefeServico("Chefe de Serviço");

    Oficial oficial1 = new Oficial("Oficial 1");
    Oficial oficial2 = new Oficial("Oficial 2");

    Comissaria comissaria1 = new Comissaria("Comissaria 1");
    Comissaria comissaria2 = new Comissaria("Comissaria 2");

    Policial policial = new Policial("Policial");
    Presidiario presidiario = new Presidiario("Presidiário");

    @Test
    public void shouldThrowExceptionByPresidiarioSemPolicial() {
        Terminal terminal = new Terminal(presidiario, oficial1, policial, chefeServico);
        Aviao aviao = new Aviao();

        Exception exception = assertThrows(RuntimeException.class, () -> new Viagem.ViagemBuilder()
                .setPiloto(policial)
                .setLocalPartida(terminal)
                .setLocalChegada(aviao)
                .build()
                .viajar());

        assertEquals(exception.getMessage(), "Presidiário ficou sozinho com outros tripulantes sem o policial");
    }

    @Test
    public void shouldThrowExceptionByOficialSozinhoComChefeServico() {
        Terminal terminal = new Terminal(chefeServico, oficial1, policial);
        Aviao aviao = new Aviao();

        Exception exception = assertThrows(RuntimeException.class, () -> new Viagem.ViagemBuilder()
                .setPiloto(policial)
                .setLocalPartida(terminal)
                .setLocalChegada(aviao)
                .build()
                .viajar());

        assertEquals(exception.getMessage(), "Ao menos um oficial ficou sozinho com o chefe de serviço");
    }

    @Test
    public void shouldThrowExceptionByComissariaSozinhaComPiloto() {
        Terminal terminal = new Terminal(piloto, comissaria1, policial);
        Aviao aviao = new Aviao();

        Exception exception = assertThrows(RuntimeException.class, () -> new Viagem.ViagemBuilder()
                .setPiloto(policial)
                .setLocalPartida(terminal)
                .setLocalChegada(aviao)
                .build()
                .viajar());

        assertEquals(exception.getMessage(), "Ao menos 1 comissária ficou sozinha com o piloto");
    }
}
