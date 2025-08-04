import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Coleta de informações iniciais da partida ---
        System.out.println("--- Configuração da Partida ---");

        System.out.print("Digite o nome do Time 1: ");
        String nomeTime1 = scanner.nextLine();
        System.out.print("Digite o nome do Time 2: ");
        String nomeTime2 = scanner.nextLine();

        System.out.printf("O %s joga em casa? (true/false): ", nomeTime1);
        boolean time1JogaEmCasa = scanner.nextBoolean();

        System.out.printf("O %s é o favorito? (true/false): ", nomeTime1);
        boolean time1Favorito = scanner.nextBoolean();

        // Limpar o buffer do scanner
        scanner.nextLine();

        // Criação dos times com base na entrada do usuário
        Time timeA = new Time(nomeTime1, time1JogaEmCasa, time1Favorito);

        // As propriedades do Time 2 são o oposto do Time 1
        Time timeB = new Time(nomeTime2, !time1JogaEmCasa, !time1Favorito);

        // Criação da partida
        Partida jogo = new Partida(timeA, timeB);

        System.out.println("\n--- Inserindo dados da partida ---");

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
        jogo.analisarPartida();
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