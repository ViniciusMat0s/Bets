import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação dos times
        Time timeA = new Time("Real Madrid", true, true);
        Time timeB = new Time("Barcelona", false, false);

        // Criação da partida
        Partida jogo = new Partida(timeA, timeB);

        System.out.println("--- Inserindo dados da partida ---");

        // Obter estatísticas do PRIMEIRO TEMPO
        System.out.println("\nEstatísticas do PRIMEIRO TEMPO:");
        EstatisticaTempo stats1TempoTimeA = obterEstatisticasDoTempo(scanner, timeA.getNome());
        EstatisticaTempo stats1TempoTimeB = obterEstatisticasDoTempo(scanner, timeB.getNome(), stats1TempoTimeA.getPosse());

        // Obter estatísticas do SEGUNDO TEMPO
        System.out.println("\nEstatísticas do SEGUNDO TEMPO:");
        EstatisticaTempo stats2TempoTimeA = obterEstatisticasDoTempo(scanner, timeA.getNome());
        EstatisticaTempo stats2TempoTimeB = obterEstatisticasDoTempo(scanner, timeB.getNome(), stats2TempoTimeA.getPosse());

        // Define as estatísticas de cada tempo na partida
        jogo.setEstatisticas(stats1TempoTimeA, stats1TempoTimeB, stats2TempoTimeA, stats2TempoTimeB);

        // Fechar o scanner
        scanner.close();

        // Exibe os resumos da partida
        jogo.exibirResumo();
        jogo.exibirEstatisticasCompletas();
    }

    private static EstatisticaTempo obterEstatisticasDoTempo(Scanner scanner, String nomeTime) {
        System.out.println("\nEstatísticas para " + nomeTime + ":");
        System.out.print("Posse de bola (%): ");
        Integer posse = scanner.nextInt();
        System.out.print("Chutes: ");
        Integer chutes = scanner.nextInt();
        System.out.print("Chutes a gol: ");
        Integer chutesGol = scanner.nextInt();
        System.out.print("Escanteios: ");
        Integer escanteios = scanner.nextInt();
        System.out.print("Gols: ");
        Integer gols = scanner.nextInt();

        return new EstatisticaTempo(posse, chutes, chutesGol, escanteios, gols, false);
    }

    // Novo método para o segundo time, que calcula a posse de bola automaticamente
    private static EstatisticaTempo obterEstatisticasDoTempo(Scanner scanner, String nomeTime, Integer posseOutroTime) {
        Integer posse = 100 - posseOutroTime;
        System.out.println("\nEstatísticas para " + nomeTime + ":");
        System.out.println("Posse de bola (%): " + posse + " (Calculada automaticamente)");
        System.out.print("Chutes: ");
        Integer chutes = scanner.nextInt();
        System.out.print("Chutes a gol: ");
        Integer chutesGol = scanner.nextInt();
        System.out.print("Escanteios: ");
        Integer escanteios = scanner.nextInt();
        System.out.print("Gols: ");
        Integer gols = scanner.nextInt();

        return new EstatisticaTempo(posse, chutes, chutesGol, escanteios, gols, false);
    }
}