package Aplicacao;

public class VeiculoComum extends Veiculo {
	
	public VeiculoComum(String placa, int ano, Motorista proprietario) {
		super(placa, ano, proprietario, 3f, 2f, 1.5f);
//		precoFixo = 3;
//		precoAdicional = 2;
//		precoParada = 1.5;
	}
}
