import java.util.Scanner;

public class Partida {
    private Time time1;
    private Time time2;
    private EstatisticaTempo primeiroTempoTime1;
    private EstatisticaTempo primeiroTempoTime2;
    private EstatisticaTempo segundoTempoTime1;
    private EstatisticaTempo segundoTempoTime2;

    public Partida(Time time1, Time time2) {
        this.time1 = time1;
        this.time2 = time2;
    }

    public void setEstatisticas(EstatisticaTempo stats1T_T1, EstatisticaTempo stats1T_T2,
                                EstatisticaTempo stats2T_T1, EstatisticaTempo stats2T_T2) {
        this.primeiroTempoTime1 = stats1T_T1;
        this.primeiroTempoTime2 = stats1T_T2;
        this.segundoTempoTime1 = stats2T_T1;
        this.segundoTempoTime2 = stats2T_T2;
    }

    public void exibirResumo() {
        System.out.println("\n--- Resumo da Partida ---");
        System.out.println("Time da Casa: " + (time1.isTimeCasa() ? time1.getNome() : time2.getNome()));
        System.out.println("Time Visitante: " + (time1.isTimeCasa() ? time2.getNome() : time1.getNome()));
        System.out.println("Time Favorito: " + (time1.isTimeFavorito() ? time1.getNome() : time2.getNome()));
        System.out.println("-------------------------");

        System.out.println("Primeiro Tempo:");
        if (primeiroTempoTime1 != null) {
            System.out.printf("%s: Posse: %d%% | Gols: %d | Chutes: %d | Chutes a Gol: %d | Escanteios: %d\n",
                    time1.getNome(), primeiroTempoTime1.getPosse(), primeiroTempoTime1.getGols(),
                    primeiroTempoTime1.getChutes(), primeiroTempoTime1.getChutesGol(), primeiroTempoTime1.getEscanteios());
        }
        if (primeiroTempoTime2 != null) {
            System.out.printf("%s: Posse: %d%% | Gols: %d | Chutes: %d | Chutes a Gol: %d | Escanteios: %d\n",
                    time2.getNome(), primeiroTempoTime2.getPosse(), primeiroTempoTime2.getGols(),
                    primeiroTempoTime2.getChutes(), primeiroTempoTime2.getChutesGol(), primeiroTempoTime2.getEscanteios());
        }
        System.out.println("-------------------------");

        System.out.println("Segundo Tempo:");
        if (segundoTempoTime1 != null) {
            System.out.printf("%s: Posse: %d%% | Gols: %d | Chutes: %d | Chutes a Gol: %d | Escanteios: %d\n",
                    time1.getNome(), segundoTempoTime1.getPosse(), segundoTempoTime1.getGols(),
                    segundoTempoTime1.getChutes(), segundoTempoTime1.getChutesGol(), segundoTempoTime1.getEscanteios());
        }
        if (segundoTempoTime2 != null) {
            System.out.printf("%s: Posse: %d%% | Gols: %d | Chutes: %d | Chutes a Gol: %d | Escanteios: %d\n",
                    time2.getNome(), segundoTempoTime2.getPosse(), segundoTempoTime2.getGols(),
                    segundoTempoTime2.getChutes(), segundoTempoTime2.getChutesGol(), segundoTempoTime2.getEscanteios());
        }
        System.out.println("-------------------------");
    }

    public void exibirEstatisticasCompletas() {
        System.out.println("\n--- Estatísticas Completas do Jogo ---");
        if (primeiroTempoTime1 != null && segundoTempoTime1 != null) {
            // Soma de Chutes, Gols, Escanteios
            int totalChutesTime1 = primeiroTempoTime1.getChutes() + segundoTempoTime1.getChutes();
            int totalChutesTime2 = primeiroTempoTime2.getChutes() + segundoTempoTime2.getChutes();

            int totalChutesGolTime1 = primeiroTempoTime1.getChutesGol() + segundoTempoTime1.getChutesGol();
            int totalChutesGolTime2 = primeiroTempoTime2.getChutesGol() + segundoTempoTime2.getChutesGol();

            int totalEscanteiosTime1 = primeiroTempoTime1.getEscanteios() + segundoTempoTime1.getEscanteios();
            int totalEscanteiosTime2 = primeiroTempoTime2.getEscanteios() + segundoTempoTime2.getEscanteios();

            int totalGolsTime1 = primeiroTempoTime1.getGols() + segundoTempoTime1.getGols();
            int totalGolsTime2 = primeiroTempoTime2.getGols() + segundoTempoTime2.getGols();

            // Lógica para "Ambos Marcam"
            String ambosMarcamStatus = (totalGolsTime1 > 0 && totalGolsTime2 > 0) ? "Sim" : "Não";

            // Posse de Bola Média
            double posseMediaTime1 = (primeiroTempoTime1.getPosse() + segundoTempoTime1.getPosse()) / 2.0;
            double posseMediaTime2 = (primeiroTempoTime2.getPosse() + segundoTempoTime2.getPosse()) / 2.0;

            System.out.printf("%s x %s\n", time1.getNome(), time2.getNome());
            System.out.println("-------------------------");
            System.out.printf("Placar Final: %d x %d\n", totalGolsTime1, totalGolsTime2);
            System.out.printf("Posse de Bola Média: %.2f%% x %.2f%%\n", posseMediaTime1, posseMediaTime2);
            System.out.printf("Chutes: %d x %d\n", totalChutesTime1, totalChutesTime2);
            System.out.printf("Chutes a Gol: %d x %d\n", totalChutesGolTime1, totalChutesGolTime2);
            System.out.printf("Escanteios: %d x %d\n", totalEscanteiosTime1, totalEscanteiosTime2);
            System.out.printf("Ambos Marcam: %s\n", ambosMarcamStatus);
            System.out.println("-----------------------------------");
        } else {
            System.out.println("Não foi possível exibir as estatísticas completas. Dados insuficientes.");
        }
    }
}