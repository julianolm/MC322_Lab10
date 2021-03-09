package Aplicacao;

import EstruturasDeDados.Lista;

// ESSA CLASSE EH IMPLEMENTADO UTILIZANDO O DESIGN PATERN SINGLETON.
// Isso foi feito pois a classe representa o sistema geral do aplicativo, que retem
// uma listagem geral de todos os usuarios e, portanto, deve ter uma unica instancia.
public class Uber {
	private Lista passageiros;
	private Lista motoristas;
	private static Uber app;

	private Uber() {
		passageiros = new Lista();
		motoristas = new Lista();
	}
	
	public static Uber getInstance() {
		if (app == null) {
			app = new Uber();
		}
		return app;
	}

	public void adicionaPassageiro(Passageiro passageiro) {
		passageiros.adicionarFim(passageiro);
	}

	public void adicionaMotorista(Motorista motorista) {
		motoristas.adicionarFim(motorista);
	}
	
	public Viagem geraViagem(Passageiro[] passageirosViagem, Posicao origem, int distancia) {
		Motorista motorista = encontraMelhorMotorista(origem);
		if (motorista == null)
			return null;
		Veiculo carroUtilizado = motorista.getCarro();
		Posicao destino = new Posicao(origem.getX(), origem.getY()+distancia); //soh estao se locomovento na direcao Y
		Viagem viagem = new Viagem(passageirosViagem, motorista, carroUtilizado, origem, destino);
		return viagem;
	}
	
//	public void acrescentaPassageiro(Viagem viagem, Passageiro passageiro) {
//		viagem.acrescentaPassageiro(passageiro);
//	}
//	
//	public void acrescentaParada(Viagem viagem, Parada parada) {
//		viagem.acrescentaParada(parada);
//	}
//	
	public void realizaViagem(Viagem viagem) {
		viagem.start();
	}
	
	private Motorista encontraMelhorMotorista(Posicao posicaoPassageiro){
		// Este metodo eh um prototipo de um algoritmo que encontra o melhor motorista 
		// disponivel para realizar a tarefa.
		// Como nao eh o foco do projeto, a implementacao aqui so retornara o primeiro 
		// motorista da lista como simplificacao.
		return (Motorista) motoristas.getFirst();
	}

}
