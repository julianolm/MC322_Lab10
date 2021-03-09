package Aplicacao;

public class Motorista extends Usuario {
	private int numHabilitacao;
	private Veiculo veiculos[];
	private int numVeiculos;

	public Motorista(String nome, String cpf, int diaNasc, int mesNasc, int anoNasc, int cartao, int habilitacao) {
		super(nome, cpf, diaNasc, mesNasc, anoNasc, cartao);
		numHabilitacao = habilitacao;
		veiculos = new Veiculo[5]; // cada motorista pode ter ate 5 carros cadastrados
		numVeiculos = 0;
	}

	public void adicionaVeiculo(Veiculo veiculo) {
		if (numVeiculos <= 5)
			veiculos[numVeiculos] = veiculo;
		else
			Impressora.imprime("Numero maximo de veiculos excedido\n");
	}

	// Por simplicidade, assume que existem pelo menos um veiculo e retorna o primeiro da lista
	public Veiculo getCarro() {
		return veiculos[0];
	}

}
