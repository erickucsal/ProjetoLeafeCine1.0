package service;

import model.*;
import util.GeradorAleatorio;
import java.util.*;

public class RecomendadorService {
    private final CatalogoFilmesAPI api;
    private final HistoricoUsuarioRepository historicoRepo; 
    private final NotificadorPush notificador; 
    private final FiltroFilmes filtro;
    private final GeradorAleatorio gerador; 
    private final CalculadoraScore calculadora;

    public RecomendadorService(CatalogoFilmesAPI api, HistoricoUsuarioRepository repo, 
                                NotificadorPush notificador, GeradorAleatorio gerador,
                                FiltroFilmes filtro, CalculadoraScore calculadora) {
        this.api = api;
        this.historicoRepo = repo;
        this.notificador = notificador;
        this.gerador = gerador;
        this.filtro = filtro;
        this.calculadora = calculadora;
    }

    public List<Recomendacao> recomendar(Usuario u, int limite) {
        List<Filme> todos = api.buscarTodos();
        List<Filme> filtrados = filtro.filtrar(todos, u.getPerfil());

        List<Recomendacao> recomendacoes = new ArrayList<>();

        for (Filme f : filtrados) {
            
            double score = calculadora.calcular(u.getPerfil(), f); 
            
            recomendacoes.add(new Recomendacao(f, score, "Baseado nos seus gostos"));
        }

        recomendacoes.sort((r1, r2) -> Double.compare(r2.getScore(), r1.getScore()));

        List<Recomendacao> resultado = recomendacoes.stream()
                                            .limit(limite)
                                            .toList();

        historicoRepo.registrarRecomendacao(u, resultado);
        
       
        notificador.enviar("Preparamos uma lista especial para você!");

        return resultado;
    }

    public Recomendacao recomendarAleatorio(Usuario u) {
        List<Filme> filtrados = filtro.filtrar(api.buscarTodos(), u.getPerfil());
        if (filtrados.isEmpty()) return null;
        
        int indice = gerador.sortearInteiro(0, filtrados.size() - 1);
        Filme sorteado = filtrados.get(indice);
        return new Recomendacao(sorteado, 100, "Sorteio do modo Surpreenda-me!");
    }
}