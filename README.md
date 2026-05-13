🎬 Projeto LeafeCine 1.0

O LeafeCine é um sistema de recomendação de filmes desenvolvido em Java 21, focado em oferecer sugestões personalizadas baseadas no perfil do usuário, preferências de gênero, idiomas e histórico de visualização.

Este projeto foi desenvolvido como parte de um trabalho acadêmico de Engenharia de Software, aplicando conceitos de SOLID, Testes Unitários e Mocks.
🚀 Funcionalidades

    Perfil Personalizado: O usuário pode definir pesos para seus gêneros favoritos, idiomas aceitos e intervalo de duração preferido.

    Cálculo de Score Inteligente: Algoritmo que pontua filmes com base na afinidade de gênero, popularidade e tempo de duração.

    Filtros Avançados: Sistema que impede recomendações de filmes já assistidos, gêneros "odiados" ou fora da classificação etária do usuário.

    Modo Surpreenda-me: Sorteio aleatório de filmes que respeitam os critérios de filtragem do usuário.

    Notificações: Sistema desacoplado para envio de alertas após novas recomendações.

🛠️ Tecnologias Utilizadas

    Linguagem: Java 21

    Gerenciador de Dependências: Maven

    Testes: JUnit 5 (Jupiter)

    Mocks: Mockito

    Ambiente: Fedora Linux / Eclipse IDE

📁 Estrutura do Projeto

O projeto segue uma arquitetura organizada por responsabilidades:

    model: Classes de domínio (Filme, Usuario, PerfilLeafCine, Recomendacao).

    service: Lógica de negócio e motores de cálculo/filtro.

    enums: Definições imutáveis (Genero, Idioma, ClassificacaoEtaria).

    exception: Tratamento de erros customizados.

    util: Interfaces auxiliares (GeradorAleatorio).

🧪 Como Rodar os Testes

O projeto conta com uma suíte de testes unitários cobrindo a lógica principal. Para rodar via terminal:
Bash

# Limpar e compilar o projeto
mvn clean compile

# Executar todos os testes unitários
mvn test

Para rodar via Eclipse:

    Clique com o botão direito na pasta src/test/java.

    Selecione Run As > JUnit Test.
