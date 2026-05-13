package model;

import java.util.List;

public interface HistoricoUsuarioRepository {
    void registrarRecomendacao(Usuario usuario, List<Recomendacao> recomendacoes);
}