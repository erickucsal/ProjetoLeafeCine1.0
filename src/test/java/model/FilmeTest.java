package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import enums.*;
import java.util.List;

class FilmeTest {
    @Test
    @DisplayName("Deve considerar dois filmes iguais se tiverem o mesmo ID")
    void deve_ConsiderarFilmesIguais_Quando_IdEhMesmo() {
        Filme f1 = new Filme("F01", "Duna", 2024, 150, List.of(Genero.ACAO), ClassificacaoEtaria.DOZE, Idioma.PORTUGUES, 90);
        Filme f2 = new Filme("F01", "Outro Nome", 2024, 100, List.of(Genero.DRAMA), ClassificacaoEtaria.LIVRE, Idioma.INGLES, 50);

        assertEquals(f1, f2); 
    }
}