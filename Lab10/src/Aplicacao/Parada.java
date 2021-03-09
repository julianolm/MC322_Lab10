package Aplicacao;

public class Parada {
	private Passageiro entrando[];
//	private int quantosEntraram;
	private Passageiro saindo[];
//	private int quantosSairam;
	private Posicao posicao;
	
	public Parada(Posicao pos, Passageiro[] passageirosEntrando, Passageiro[] passageirosSaindo) {
		posicao = pos;
		entrando = passageirosEntrando;//assumindo que os carros utilizados sao carros de 5 lugares
		saindo = passageirosSaindo;
	}

	
//	public void entraPassageiro(Passageiro pessoaEntrando) {
//		entrando[quantosEntraram] = pessoaEntrando;
//	}
//	
//	public void saiPassageiro(Passageiro pessoaSaindo) {
//		saindo[quantosSairam] = pessoaSaindo;
//	}
	
	public Posicao getPos() {
		return posicao;
	}
	
}