package Aplicacao;


public class Passageiro extends Usuario {
	private Viagem viagemAtual;
	
	public Passageiro(String nome, String cpf, int diaNasc, int mesNasc, int anoNasc, int cartao) {
		super(nome, cpf, diaNasc, mesNasc, anoNasc, cartao);
		viagemAtual = null;
	}
	
//	public void solicitaViagem(int distancia) {
//		Uber.geraViagem(this, distancia);
//	}
	
}
