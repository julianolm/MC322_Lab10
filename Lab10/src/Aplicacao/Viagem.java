package Aplicacao;

import java.util.Scanner;

public class Viagem {
	private Motorista motorista;
	private Passageiro passageiros[];
	private Veiculo veiculo;
	private Posicao origem;
	private Posicao destino;
	private int distancia;
	private Parada paradas[];
	private int numPassageiros;
	private int numParadas;
	private int precoViagem;
	Scanner input = new Scanner(System.in);

	public Viagem(Passageiro[] passageirosViagem, Motorista motorista, Veiculo carro, Posicao origem, Posicao destino) {
		passageiros = passageirosViagem;
		numPassageiros = passageirosViagem.length;
		this.motorista = motorista;
		veiculo = carro;
		this.origem = origem;
		this.destino = destino;
		this.distancia = Posicao.calculaDistancia(origem, destino);
		paradas = new Parada[100]; // assumindo que nao averao mais de 100 paradas em uma viagem
		numParadas = 0;
	}

//	public void acrescentaPassageiro(Passageiro passageiro) {
//		passageiros[numPassageiros++] = passageiro;
//	}

	public void acrescentaParada(Parada parada) {
		paradas[numParadas++] = parada;
//		Impressora.imprime("Quantos passageiros entraram nessa parada? ");
//		int quantosEntraram = input.nextInt();
//		Impressora.imprime("Quantos passageiros sairam nessa parada? ");
//		int quantosSairam = input.nextInt();
//		int c = 0;
//		while (c < quantosEntraram) {
//			Impressora.imprime(c + "o passageiro a entrar: ");
//			String nome = input.nextLine();
//			for (Passageiro passageiro : )
//		}
	}

	public void start() {
		Impressora.imprime(resumoViagem());
	}

	public float calculaPrecoViagem() {
		float preco = veiculo.getPrecoFixo();
		preco += veiculo.getPrecoAdicional() * (distancia / 100);
		preco += veiculo.getPrecoParada() * numParadas;
		return preco;
	}

	public String resumoViagem() {
		String resumo = "Resumo da viagem:\n" + "Motorista: " + motorista + "\n" + "Passageiros: ";
		for (Passageiro passageiro : passageiros) {
			resumo += String.format("%s ", passageiro);
		}
		resumo += "\n";
		resumo += String.format("Origem: %s\n", origem);
		for (int i = 0; i < numParadas; i++) {
			resumo += String.format("Parada %d: %s\n", i + 1, paradas[i].getPos());
		}
		resumo += String.format("Destino: %s\n", destino);
		resumo += String.format("Distancia percorrida: %sm\n", distancia);
		resumo += String.format("Preco da viagem: R$:%.2f", calculaPrecoViagem());

		resumo += "\n\n";
		return resumo;
	}

}
