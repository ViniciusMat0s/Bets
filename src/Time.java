// Time.java
public class Time {
    private String nome;
    private Boolean timeCasa;
    private Boolean timeFavorito;

    // Construtor
    public Time(String nome, Boolean timeCasa, Boolean timeFavorito) {
        this.nome = nome;
        this.timeCasa = timeCasa;
        this.timeFavorito = timeFavorito;
    }

    // Getters para acessar os atributos
    public String getNome() {
        return nome;
    }

    public Boolean isTimeCasa() {
        return timeCasa;
    }

    public Boolean isTimeFavorito() {
        return timeFavorito;
    }

    // Setters para modificar os atributos (opcional, mas útil)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTimeCasa(Boolean timeCasa) {
        this.timeCasa = timeCasa;
    }

    public void setTimeFavorito(Boolean timeFavorito) {
        this.timeFavorito = timeFavorito;
    }
}