// EstatisticaTempo.java
public class EstatisticaTempo {
    private Integer posse;
    private Integer chutes;
    private Integer chutesGol;
    private Integer escanteios;
    private Integer gols;
    private Boolean ambosMarcam;

    // Construtor
    public EstatisticaTempo(Integer posse, Integer chutes, Integer chutesGol, Integer escanteios, Integer gols, Boolean ambosMarcam) {
        this.posse = posse;
        this.chutes = chutes;
        this.chutesGol = chutesGol;
        this.escanteios = escanteios;
        this.gols = gols;
        this.ambosMarcam = ambosMarcam;
    }

    // Getters
    public Integer getPosse() {
        return posse;
    }

    public Integer getChutes() {
        return chutes;
    }

    public Integer getChutesGol() {
        return chutesGol;
    }

    public Integer getEscanteios() {
        return escanteios;
    }

    public Integer getGols() {
        return gols;
    }

    public Boolean isAmbosMarcam() {
        return ambosMarcam;
    }

    // Setters
    public void setPosse(Integer posse) {
        this.posse = posse;
    }

    public void setChutes(Integer chutes) {
        this.chutes = chutes;
    }

    public void setChutesGol(Integer chutesGol) {
        this.chutesGol = chutesGol;
    }

    public void setEscanteios(Integer escanteios) {
        this.escanteios = escanteios;
    }

    public void setGols(Integer gols) {
        this.gols = gols;
    }

    public void setAmbosMarcam(Boolean ambosMarcam) {
        this.ambosMarcam = ambosMarcam;
    }
}