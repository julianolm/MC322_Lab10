package Aplicacao;

import java.util.Calendar;

/* ALTERACOES A FAZER:
 *  
 * 1 - Adicionar a funcionalidade de escolher o tipo de carro (luxo ou comum).
 * 2 - Retirar a instanciacao das paradas e seus atributos dessa classe e passa-los para a classe viagem.
 * 3 - Retirar outras coisas desnecessarias daqui e colocar nos devidos lugares.
 * 4 - Acrescentar a mensagem de quem entrou ou saiu em cada parada no resumo.*/

public class Execucao {

	public static void execute() {
		Uber app = Uber.getInstance();

		// Criacao de usuarios
		
		Passageiro user1 = new Passageiro("Marcos", "145678798", 15, Calendar.JULY + 1, 1998, 369874);
		app.adicionaPassageiro(user1);

		Motorista user2 = new Motorista("Maria", "248679108", 12, Calendar.FEBRUARY + 1, 1997, 483530, 987654);
		VeiculoLuxo carro1User2 = new VeiculoLuxo("ABC-1234", 2009, user2);
		VeiculoComum carro2User2 = new VeiculoComum("OOP-2020", 2013, user2);
		app.adicionaMotorista(user2);
		user2.adicionaVeiculo(carro1User2);
		user2.adicionaVeiculo(carro2User2);

		Passageiro user3 = new Passageiro("Joao", "654973652", 03, Calendar.JANUARY + 1, 2002, 785632);
		app.adicionaPassageiro(user3);

		// Viagem 1
		
		Passageiro[] passageirosViagem1 = {user1};
		Viagem viagem1 = app.geraViagem(passageirosViagem1, user1.getPosicao(), 500);
		
		Passageiro[] passageirosEntrandoParada1 = {};
		Passageiro[] passageirosSaindoParada1 = {};
		Posicao posParada = new Posicao(0, 200);
		Parada parada = new Parada(posParada, passageirosEntrandoParada1, passageirosSaindoParada1);
		viagem1.acrescentaParada(parada);
		
		posParada = new Posicao(0, 300);
		parada = new Parada(posParada, passageirosEntrandoParada1, passageirosSaindoParada1);
		viagem1.acrescentaParada(parada);
		
		viagem1.start();
		
		// Viagem 2
		
		Passageiro[] passageirosViagem2 = {user1, user3};
		Viagem viagem2 = app.geraViagem(passageirosViagem2, user1.getPosicao(), 2000);
		
		Passageiro[] passageirosEntrandoParada2 = {};
		Passageiro[] passageirosSaindoParada2 = {};
		posParada = new Posicao(0, 400);
		parada = new Parada(posParada, passageirosEntrandoParada2, passageirosSaindoParada2);
		viagem2.acrescentaParada(parada);

		posParada = new Posicao(0, 800);
		parada = new Parada(posParada, passageirosEntrandoParada2, passageirosSaindoParada2);
		viagem2.acrescentaParada(parada);
		
		Passageiro[] passageirosSaindoParada3 = {user1};
		posParada = new Posicao(0, 1200);
		parada = new Parada(posParada, passageirosEntrandoParada2, passageirosSaindoParada2);
		viagem2.acrescentaParada(parada);
		
		posParada = new Posicao(0, 1600);
		parada = new Parada(posParada, passageirosEntrandoParada2, passageirosSaindoParada2);
		viagem2.acrescentaParada(parada);
		
		posParada = new Posicao(0, 1900);
		parada = new Parada(posParada, passageirosEntrandoParada2, passageirosSaindoParada2);
		viagem2.acrescentaParada(parada);
		
		viagem2.start();

	}	

//  Viagem 3
//	• Fa ̧ca uma viagem de Jo ̃ao com Maria em seu carro de luxo, distˆancia de
//	700m, 3 paradas.
	
	public static void main(String args[]) {
		execute();
	}
}