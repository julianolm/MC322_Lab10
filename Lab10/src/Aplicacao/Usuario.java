package Aplicacao;

public class Usuario {
	private String nome;
	private String cpf;
	private Data dtNascimento;
	private int numCartao;
	private Posicao posicaoAtual;
	
	
	public Usuario(String nome, String cpf, int diaNasc, int mesNasc, int anoNasc, int cartao) {
		this.nome = nome;
		this.cpf = cpf;
		dtNascimento = new Data(diaNasc, mesNasc, anoNasc);
		numCartao = cartao;
		posicaoAtual = new Posicao(0,0);
	}
	
	public Posicao getPosicao() {
		return posicaoAtual;
	}
	
	public String toString() {
		return nome;
	}
	
	
}