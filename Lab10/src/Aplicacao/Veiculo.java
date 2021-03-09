package Aplicacao;

public class Veiculo {
	private String placa;
	private int ano;
	private Motorista proprietario;
	private float precoFixo;
	private float precoAdicional;
	private float precoParada;

	public Veiculo(String placa, int ano, Motorista proprietario, float precoFixo, float precoAdicional,
			float precoParada) {
		this.placa = placa;
		this.ano = ano;
		this.proprietario = proprietario;
		this.precoFixo = precoFixo;
		this.precoAdicional = precoAdicional;
		this.precoParada = precoParada;
	}

	public float getPrecoFixo() {
		return precoFixo;
	}

	public float getPrecoAdicional() {
		return precoAdicional;
	}

	public float getPrecoParada() {
		return precoParada;
	}

}
