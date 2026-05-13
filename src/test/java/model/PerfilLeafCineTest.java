package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import exception.*;
import enums.Genero;

class PerfilLeafCineTest {

    @Test
    @DisplayName("Deve lançar PesoInvalidoException quando o peso for maior que 1.0")
    void deve_LancarExcecao_Quando_PesoForaDoIntervalo() {
        PerfilLeafCine perfil = new PerfilLeafCine();
        assertThrows(PesoInvalidoException.class, () -> perfil.setPesoGenero(Genero.ACAO, 1.5)); //
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.1, 1.1, 5.0})
    @DisplayName("Deve falhar com diversos pesos inválidos")
    void deve_Falhar_ComPesosInvalidos(double pesoInvalido) {
        PerfilLeafCine perfil = new PerfilLeafCine();
        assertThrows(PesoInvalidoException.class, () -> perfil.setPesoGenero(Genero.DRAMA, pesoInvalido));
    }

    @Test
    @DisplayName("Deve lançar DuracaoInvalidaException quando min > max")
    void deve_LancarExcecao_Quando_DuracaoMinimaMaiorQueMaxima() {
        PerfilLeafCine perfil = new PerfilLeafCine();
        assertThrows(DuracaoInvalidaException.class, () -> perfil.setIntervaloDuracao(120, 90)); //
    }
}