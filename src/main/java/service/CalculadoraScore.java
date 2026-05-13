package service;

import model.*;
import enums.Genero;

public class CalculadoraScore {
    private static final double PESO_GENERO = 0.50;
    private static final double PESO_DURACAO = 0.20;
    private static final double PESO_POPULARIDADE = 0.30; 

    public double calcular(PerfilLeafCine p, Filme f) {
        double scoreGenero = calcularScoreGenero(p, f);
        
                double scoreDuracao = (f.getDuracao() >= p.getDuracaoMinima() && 
                               f.getDuracao() <= p.getDuracaoMaxima()) ? 100 : 0;
        
        return (scoreGenero * PESO_GENERO) + 
               (scoreDuracao * PESO_DURACAO) + 
               (f.getPopularidade() * PESO_POPULARIDADE);
    }

    private double calcularScoreGenero(PerfilLeafCine p, Filme f) {
        return f.getGeneros().stream()
                .mapToDouble(g -> p.getPesosGenero().getOrDefault(g, 0.5))
                .average()
                .orElse(0.0) * 100;
    }
}