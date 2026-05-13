package service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import enums.ClassificacaoEtaria;
import enums.Genero;
import enums.Idioma;
import model.Filme;
import model.HistoricoUsuarioRepository;
import model.PerfilLeafCine;
import model.Usuario;
import util.GeradorAleatorio;

@ExtendWith(MockitoExtension.class)
class RecomendadorServiceTest {

    @Mock private CatalogoFilmesAPI api;
    @Mock private HistoricoUsuarioRepository historicoRepo;
    @Mock private NotificadorPush notificador;
    @Mock private GeradorAleatorio gerador;
    @Mock private CalculadoraScore calculadora; 
    @Mock private FiltroFilmes filtro;

    @InjectMocks
    private RecomendadorService service;

    private Usuario maria;
    private Filme filme1;

    @BeforeEach
    void setup() {
        PerfilLeafCine perfil = new PerfilLeafCine();
        perfil.setClassificacaoetaria(ClassificacaoEtaria.DEZESSEIS);
        perfil.setIdiomasAceitos(List.of(Idioma.PORTUGUES));
        perfil.setIntervaloDuracao(90, 150);
        
        maria = new Usuario("Maria", 28, perfil);
        filme1 = new Filme("F01", "Filme A", 2024, 120, List.of(Genero.ACAO), ClassificacaoEtaria.LIVRE, Idioma.PORTUGUES, 90);
    }

    @Test
    @DisplayName("Deve registrar a recomendação no histórico e enviar notificação")
    void deve_FuncionarFluxoCompleto() {
        List<Filme> listaMock = List.of(filme1);
        when(api.buscarTodos()).thenReturn(listaMock);
        when(filtro.filtrar(anyList(), any())).thenReturn(listaMock);
        when(calculadora.calcular(any(), any())).thenReturn(80.0);

        service.recomendar(maria, 1);

        verify(historicoRepo).registrarRecomendacao(eq(maria), anyList());
        verify(notificador).enviar(anyString());
    }
}