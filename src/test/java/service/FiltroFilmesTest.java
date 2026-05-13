package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import model.*;
import util.GeradorAleatorio;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FiltroFilmesTest {

    @Mock private CatalogoFilmesAPI api;
    @Mock private HistoricoUsuarioRepository historicoRepo;
    @Mock private NotificadorPush notificador;
    @Mock private GeradorAleatorio gerador;
    
    @Mock private FiltroFilmes filtro;
    @Mock private CalculadoraScore calculadora;
    
    @InjectMocks 
    private RecomendadorService service;

    @Test
    @DisplayName("Deve registrar a recomendação no repositório após gerar a lista")
    void deve_ChamarRepositor_Quando_RecomendacaoEhGerada() {
      
        Usuario u = new Usuario("Erick", 21, new PerfilLeafCine());
       
        when(api.buscarTodos()).thenReturn(List.of());
        when(filtro.filtrar(anyList(), any())).thenReturn(List.of());

        
        service.recomendar(u, 5);

        verify(historicoRepo, times(1)).registrarRecomendacao(eq(u), anyList());
    }
}