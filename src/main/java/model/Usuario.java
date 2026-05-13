package model;


public class Usuario {
    private String nome;
    private int idade;
    private PerfilLeafCine perfil;


    public Usuario(String nome, int idade, PerfilLeafCine perfil) {
        this.nome = nome;
        this.idade = idade;
        this.perfil = perfil;
    }

    public String getNome() { 
        return nome; 
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public int getIdade() { 
        return idade; 
    }

    public void setIdade(int idade) { 
        this.idade = idade; 
    }

    public PerfilLeafCine getPerfil() { 
        return perfil; 
    }

    public void setPerfil(PerfilLeafCine perfil) { 
        this.perfil = perfil; 
    }
}