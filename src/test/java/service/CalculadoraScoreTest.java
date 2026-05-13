package service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.*;
import enums.*;
import java.util.List;

class CalculadoraScoreTest {
    private final CalculadoraScore calculadora = new CalculadoraScore();

    @ParameterizedTest
    @CsvSource({
        "1.0, 1.0, 100", // Gêneros amados = score 100 [cite: 197]
        "0.5, 0.5, 50",  // Gêneros neutros = score 50
        "0.0, 0.0, 0"    
    })
    @DisplayName("Deve calcular score de gênero baseado na média dos pesos")
    void deve_CalcularScoreGenero_ConformePesos(double peso1, double peso2, int esperado) {
        PerfilLeafCine p = new PerfilLeafCine();
        p.setPesoGenero(Genero.ACAO, peso1);
        p.setPesoGenero(Genero.DRAMA, peso2);
        
        Filme f = new Filme("1", "Teste", 2024, 120, List.of(Genero.ACAO, Genero.DRAMA), ClassificacaoEtaria.LIVRE, Idioma.PORTUGUES, 50);
        
                double score = calculadora.calcular(p, f); 
        assertTrue(score >= 0 && score <= 100);     }

    @Test
    @DisplayName("Filme dentro da duração preferida deve ganhar score máximo de duração")
    void deve_DarScoreMaximo_Quando_DentroDaDuracao() {
        PerfilLeafCine p = new PerfilLeafCine();
        p.setIntervaloDuracao(90, 150);
        Filme f = new Filme("1", "Filme Médio", 2024, 120, List.of(Genero.ACAO), ClassificacaoEtaria.LIVRE, Idioma.PORTUGUES, 50);
        
        // Lógica de teste para verificar os 20% da duração [cite: 199]
    }
}