package model;

import enums.*;
import exception.PesoInvalidoException;
import exception.DuracaoInvalidaException;
import java.util.*;

public class PerfilLeafCine {
    private Map<Genero, Double> pesosGenero = new HashMap<>();
    private Map<String, Integer> notasFilmes = new HashMap<>(); 
    private int duracaoMinima;
    private int duracaoMaxima;
    private ClassificacaoEtaria classificacaoetaria;
    private List<Idioma> idiomasAceitos = new ArrayList<>();
    private List<Filme> historico = new ArrayList<>();

 
    public void setPesoGenero(Genero genero, double peso) {
        if (peso < 0 || peso > 1.0) {
            throw new PesoInvalidoException("O peso do gênero deve estar entre 0.0 e 1.0.");
        }
        this.pesosGenero.put(genero, peso);
    }

    
    public void setIntervaloDuracao(int minima, int maxima) {
        if (minima > maxima) {
            throw new DuracaoInvalidaException("A duração mínima não pode ser maior que a máxima.");
        }
        this.duracaoMinima = minima;
        this.duracaoMaxima = maxima;
    }

    
    public void adicionarNota(String filmeId, int nota) {
        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("A nota deve ser entre 1 e 5.");
        }
        this.notasFilmes.put(filmeId, nota);
    }

    
    public void setClassificacaoetaria(ClassificacaoEtaria classificacaoetaria) {
        this.classificacaoetaria = classificacaoetaria;
    }

    
    public void setIdiomasAceitos(List<Idioma> idiomasAceitos) {
        this.idiomasAceitos = idiomasAceitos;
    }

    
    public void adicionarAoHistorico(Filme filme) {
        this.historico.add(filme);
    }


    public int getDuracaoMinima() {
    	return duracaoMinima; 
    	}
    public int getDuracaoMaxima() { 
    	return duracaoMaxima; 
    	}
    public ClassificacaoEtaria getClassificacaoetaria() { 
    	return classificacaoetaria; 
    	}
    public List<Idioma> getIdiomasAceitos() { 
    	return idiomasAceitos;
    	}
    public List<Filme> getHistorico() { 
    	return historico;
    	}
    public Map<Genero, Double> getPesosGenero() { 
    	return pesosGenero;
    	}
    public Map<String, Integer> getNotasFilmes() { 
    	return notasFilmes;
    	}
}