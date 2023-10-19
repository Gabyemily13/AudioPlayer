package br.com.sesi.model;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Midia {
    private String titulo;
    private double avaliacao;

    public Midia(String titulo) {
        this.titulo = titulo;
        this.avaliacao = 0.0; // Inicializa a avaliação com 0
    }

    public String getTitulo() {
        return titulo;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
        System.out.println("Avaliação definida para: " + avaliacao);
    }
}
class Musica extends Midia {
    private int duracao;
    private int curtidas;

    public Musica(String titulo, int duracao) {
        super(titulo);
        this.duracao = duracao;
        this.curtidas = 0;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void curtir() {
        curtidas++; // Incrementa o contador de curtidas
        System.out.println("Curtida em " + getTitulo() + " - Total de curtidas: " + curtidas);
    }
    
    public void reproduzir() {
        System.out.println("Reproduzindo " + getTitulo() + " - Duração: " + duracao + " minutos");
    }

    @Override
    public String toString() {
        return "Título: " + getTitulo() + ", Duração: " + duracao + " minutos, Avaliação: " + getAvaliacao() + ", Curtidas: " + curtidas;
    }
}

public class AudioPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Musica> musicas = new ArrayList<>();
        musicas.add(new Musica("Roses", 3));
        musicas.add(new Musica("Stay With Me", 4));
        musicas.add(new Musica("Havana", 5));

        System.out.println("Bem-vindo ao AudioPlayer!");
        int opcao;
        do {
            System.out.println("\nOpções:");
            System.out.println("1 - Músicas");
            System.out.println("2 - Curtir");
            System.out.println("3 - Avaliação");
            System.out.println("4 - Reproduzir");
            System.out.println("5 - Sair");

            System.out.print("\nEscolha uma opção (1|2|3|4|5): ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nMúsicas Disponíveis:");
                    for (int i = 0; i < musicas.size(); i++) {
                        System.out.println((i + 1) + " - " + musicas.get(i).toString());
                    }
                    break;
                case 2:
                    System.out.print("Digite o número da música para curtir: ");
                    int musicaParaCurtir = scanner.nextInt();
                    if (musicaParaCurtir >= 1 && musicaParaCurtir <= musicas.size()) {
                        musicas.get(musicaParaCurtir - 1).curtir();
                    } else {
                        System.out.println("Número de música inválido.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o número da música para definir a avaliação: ");
                    int musicaParaAvaliar = scanner.nextInt();
                    if (musicaParaAvaliar >= 1 && musicaParaAvaliar <= musicas.size()) {
                        System.out.print("Digite a avaliação: ");
                        double avaliacao = scanner.nextDouble();
                        musicas.get(musicaParaAvaliar - 1).setAvaliacao(avaliacao);
                    } else {
                        System.out.println("Número de música inválido.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o número da música para reproduzir: ");
                    int musicaParaReproduzir = scanner.nextInt();
                    if (musicaParaReproduzir >= 1 && musicaParaReproduzir <= musicas.size()) {
                        musicas.get(musicaParaReproduzir - 1).reproduzir();
                    } else {
                        System.out.println("Número de música inválido.");
                    }
                    break;

                case 5:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}