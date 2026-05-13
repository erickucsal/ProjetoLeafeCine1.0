package service;

import model.Filme;
import model.PerfilLeafCine;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroFilmes {

    public List<Filme> filtrar(List<Filme> catalogo, PerfilLeafCine perfil) {

    	return catalogo.stream()
            .filter(f -> !perfil.getHistorico().contains(f)) 
            .filter(f -> f.getClassificacao().getIdadeMinima() <= perfil.getClassificacaoetaria().getIdadeMinima())
            .filter(f -> perfil.getIdiomasAceitos().contains(f.getIdioma())) 
            .filter(f -> !possuiGeneroOdiado(f, perfil)) 
            .collect(Collectors.toList()); 
    }

    private boolean possuiGeneroOdiado(Filme filme, PerfilLeafCine perfil) {
        return filme.getGeneros().stream()
            .anyMatch(g -> perfil.getPesosGenero().getOrDefault(g, 0.5) == 0.0);
    }
}