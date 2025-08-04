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
            int totalChutesTime1 = primeiroTempoTime1.getChutes() + segundoTempoTime1.getChutes();
            int totalChutesTime2 = primeiroTempoTime2.getChutes() + segundoTempoTime2.getChutes();

            int totalChutesGolTime1 = primeiroTempoTime1.getChutesGol() + segundoTempoTime1.getChutesGol();
            int totalChutesGolTime2 = primeiroTempoTime2.getChutesGol() + segundoTempoTime2.getChutesGol();

            int totalEscanteiosTime1 = primeiroTempoTime1.getEscanteios() + segundoTempoTime1.getEscanteios();
            int totalEscanteiosTime2 = primeiroTempoTime2.getEscanteios() + segundoTempoTime2.getEscanteios();

            int totalGolsTime1 = primeiroTempoTime1.getGols() + segundoTempoTime1.getGols();
            int totalGolsTime2 = primeiroTempoTime2.getGols() + segundoTempoTime2.getGols();

            String ambosMarcamStatus = (totalGolsTime1 > 0 && totalGolsTime2 > 0) ? "Sim" : "Não";

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

    public void analisarPartida() {
        System.out.println("\n--- Análise Detalhada da Partida ---");
        if (primeiroTempoTime1 == null || segundoTempoTime1 == null) {
            System.out.println("Dados insuficientes para análise.");
            return;
        }

        // Análise de Gols e Escanteios... (código anterior não alterado)
        System.out.println("\nAnálise de Gols:");
        String vencedor1Tempo = (primeiroTempoTime1.getGols() > primeiroTempoTime2.getGols()) ? time1.getNome() : time2.getNome();
        if (primeiroTempoTime1.getGols().equals(primeiroTempoTime2.getGols())) {
            System.out.println("Primeiro tempo: Empate em gols.");
        } else {
            System.out.println("Primeiro tempo: " + vencedor1Tempo + " teve mais gols.");
        }

        String vencedor2Tempo = (segundoTempoTime1.getGols() > segundoTempoTime2.getGols()) ? time1.getNome() : time2.getNome();
        if (segundoTempoTime1.getGols().equals(segundoTempoTime2.getGols())) {
            System.out.println("Segundo tempo: Empate em gols.");
        } else {
            System.out.println("Segundo tempo: " + vencedor2Tempo + " teve mais gols.");
        }

        System.out.println("\nAnálise de Escanteios:");
        String vencedorEscanteios1T = (primeiroTempoTime1.getEscanteios() > primeiroTempoTime2.getEscanteios()) ? time1.getNome() : time2.getNome();
        if (primeiroTempoTime1.getEscanteios().equals(primeiroTempoTime2.getEscanteios())) {
            System.out.println("Primeiro tempo: Empate em escanteios.");
        } else {
            System.out.println("Primeiro tempo: " + vencedorEscanteios1T + " teve mais escanteios.");
        }

        String vencedorEscanteios2T = (segundoTempoTime1.getEscanteios() > segundoTempoTime2.getEscanteios()) ? time1.getNome() : time2.getNome();
        if (segundoTempoTime1.getEscanteios().equals(segundoTempoTime2.getEscanteios())) {
            System.out.println("Segundo tempo: Empate em escanteios.");
        } else {
            System.out.println("Segundo tempo: " + vencedorEscanteios2T + " teve mais escanteios.");
        }

        int totalEscanteios1 = primeiroTempoTime1.getEscanteios() + segundoTempoTime1.getEscanteios();
        int totalEscanteios2 = primeiroTempoTime2.getEscanteios() + segundoTempoTime2.getEscanteios();
        String vencedorEscanteiosTotal = (totalEscanteios1 > totalEscanteios2) ? time1.getNome() : time2.getNome();
        if (totalEscanteios1 == totalEscanteios2) {
            System.out.println("Na partida: Empate em escanteios.");
        } else {
            System.out.println("Na partida: " + vencedorEscanteiosTotal + " teve mais escanteios.");
        }


        // NOVO CÓDIGO PARA COMPARAÇÃO DE EFICÁCIA E CONVERSÃO
        System.out.println("\n--- Comparativo de Eficácia de Ataque ---");
        // Análise para o Time 1
        double eficacia1T_T1 = calcularEficacia(primeiroTempoTime1.getChutes(), primeiroTempoTime1.getChutesGol());
        double eficacia2T_T1 = calcularEficacia(segundoTempoTime1.getChutes(), segundoTempoTime1.getChutesGol());
        if (eficacia1T_T1 > eficacia2T_T1) {
            System.out.printf("%s teve um ataque mais eficaz no primeiro tempo (%.2f%%) do que no segundo (%.2f%%).\n", time1.getNome(), eficacia1T_T1, eficacia2T_T1);
        } else if (eficacia2T_T1 > eficacia1T_T1) {
            System.out.printf("%s teve um ataque mais eficaz no segundo tempo (%.2f%%) do que no primeiro (%.2f%%).\n", time1.getNome(), eficacia2T_T1, eficacia1T_T1);
        } else {
            System.out.printf("%s teve a mesma eficácia de ataque em ambos os tempos (%.2f%%).\n", time1.getNome(), eficacia1T_T1);
        }

        // Análise para o Time 2
        double eficacia1T_T2 = calcularEficacia(primeiroTempoTime2.getChutes(), primeiroTempoTime2.getChutesGol());
        double eficacia2T_T2 = calcularEficacia(segundoTempoTime2.getChutes(), segundoTempoTime2.getChutesGol());
        if (eficacia1T_T2 > eficacia2T_T2) {
            System.out.printf("%s teve um ataque mais eficaz no primeiro tempo (%.2f%%) do que no segundo (%.2f%%).\n", time2.getNome(), eficacia1T_T2, eficacia2T_T2);
        } else if (eficacia2T_T2 > eficacia1T_T2) {
            System.out.printf("%s teve um ataque mais eficaz no segundo tempo (%.2f%%) do que no primeiro (%.2f%%).\n", time2.getNome(), eficacia2T_T2, eficacia1T_T2);
        } else {
            System.out.printf("%s teve a mesma eficácia de ataque em ambos os tempos (%.2f%%).\n", time2.getNome(), eficacia1T_T2);
        }

        System.out.println("\n--- Análise de Conversão de Chutes a Gol ---");
        // Análise para o Time 1
        double conversao1T_T1 = calcularConversao(primeiroTempoTime1.getChutesGol(), primeiroTempoTime1.getGols());
        double conversao2T_T1 = calcularConversao(segundoTempoTime1.getChutesGol(), segundoTempoTime1.getGols());
        if (conversao1T_T1 > conversao2T_T1) {
            System.out.printf("%s converteu mais chutes a gol no primeiro tempo (%.2f%%) do que no segundo (%.2f%%).\n", time1.getNome(), conversao1T_T1, conversao2T_T1);
        } else if (conversao2T_T1 > conversao1T_T1) {
            System.out.printf("%s converteu mais chutes a gol no segundo tempo (%.2f%%) do que no primeiro (%.2f%%).\n", time1.getNome(), conversao2T_T1, conversao1T_T1);
        } else {
            System.out.printf("%s teve a mesma conversão de chutes a gol em ambos os tempos (%.2f%%).\n", time1.getNome(), conversao1T_T1);
        }

        // Análise para o Time 2
        double conversao1T_T2 = calcularConversao(primeiroTempoTime2.getChutesGol(), primeiroTempoTime2.getGols());
        double conversao2T_T2 = calcularConversao(segundoTempoTime2.getChutesGol(), segundoTempoTime2.getGols());
        if (conversao1T_T2 > conversao2T_T2) {
            System.out.printf("%s converteu mais chutes a gol no primeiro tempo (%.2f%%) do que no segundo (%.2f%%).\n", time2.getNome(), conversao1T_T2, conversao2T_T2);
        } else if (conversao2T_T2 > conversao1T_T2) {
            System.out.printf("%s converteu mais chutes a gol no segundo tempo (%.2f%%) do que no primeiro (%.2f%%).\n", time2.getNome(), conversao2T_T2, conversao1T_T2);
        } else {
            System.out.printf("%s teve a mesma conversão de chutes a gol em ambos os tempos (%.2f%%).\n", time2.getNome(), conversao1T_T2);
        }
    }

    private double calcularEficacia(int totalChutes, int chutesGol) {
        if (totalChutes > 0) {
            return (double) chutesGol / totalChutes * 100;
        }
        return 0.0;
    }

    private double calcularConversao(int chutesGol, int gols) {
        if (chutesGol > 0) {
            return (double) gols / chutesGol * 100;
        }
        return 0.0;
    }
}